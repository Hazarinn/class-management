package com.example.crudAluno.alunoController;


import com.example.crudAluno.entities.Address;

import com.example.crudAluno.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value ="/address")
public class AddressController {



    private AddressService addressService;

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") Long id){
        return addressService.searchById(id);

    }

    @GetMapping
    public List<Address> getAll(){

        return addressService.SearchAll();
    }

    @PostMapping
    public Address registerAddress(@RequestBody Address address){


        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address alterAddress(@PathVariable("id") Long id, @RequestBody Address address){
        return addressService.updateAddress(id,address);
    }


    @DeleteMapping
    public void deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
    }

}
