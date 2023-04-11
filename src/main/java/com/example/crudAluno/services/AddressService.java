package com.example.crudAluno.services;

import com.example.crudAluno.entities.Address;

import com.example.crudAluno.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> SearchAll(){
        return addressRepository.findAll();
    }

    public Address searchById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Endereço não encontrado para o id: %d", id)));

    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }


    public Address updateAddress(Long id, Address ad){


        Address addresstUpdate = searchById(id);
        addresstUpdate.setCity(ad.getCity());

        addresstUpdate.setState(ad.getState());
        addresstUpdate.setZipCode(ad.getZipCode());
        addresstUpdate.setCountry(ad.getCountry());


        return addressRepository.save(addresstUpdate);
    }

    public void deleteAddress(Long id){
        addressRepository.deleteAdress(id);
    }
}
