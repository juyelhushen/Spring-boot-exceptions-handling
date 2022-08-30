package com.example.exceptionhandlingdemo.controller;

import com.example.exceptionhandlingdemo.model.Customer;
import com.example.exceptionhandlingdemo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService service;

    //Post Methode
    @RequestMapping(value = "customer",method = RequestMethod.POST)
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        Customer result = service.add(customer);
        return new ResponseEntity<Customer>(result,HttpStatus.CREATED);
    }



    @RequestMapping(value = "customer",method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> fetchAll(){
        List<Customer> getCustomer = service.getAll();
        return new ResponseEntity<List<Customer>>(getCustomer, HttpStatus.OK);
    }


    @RequestMapping(value = "customer/{id}",method = RequestMethod.GET)
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Integer id) {
        Optional<Customer> getById = service.findOne(id);
        return new ResponseEntity<Optional<Customer>>(getById, HttpStatus.OK);
    }

    @RequestMapping(value = "customer/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

}
