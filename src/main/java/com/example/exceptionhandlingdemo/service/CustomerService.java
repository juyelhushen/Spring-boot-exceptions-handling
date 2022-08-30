package com.example.exceptionhandlingdemo.service;

import com.example.exceptionhandlingdemo.model.Customer;
import com.example.exceptionhandlingdemo.repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private static Logger log = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepo repository;


    //add record post request

    public Customer add(Customer customer){
        Customer addCustomer = repository.save(customer);
        return addCustomer;
    }

    //getall
    public List<Customer> getAll(){
        List<Customer> listAll = repository.findAll();
        return listAll;
    }

    //findbyid
    public Optional<Customer> findOne(int id) {
            return repository.findById(id); //.orElseThrow(()-> new ResourceNotFound("Record not found"));
    }

    //delete
    public void delete(Integer id){
        repository.deleteById(id);
    }
}
