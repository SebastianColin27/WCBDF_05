package com.upiiz.customers.services;

import com.upiiz.customers.models.Customer;
import com.upiiz.customers.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServices {

    CustomersRepository customersRepository;

    public CustomersServices(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    //GET - todas las customer
    public List<Customer> getAllCustomer(){
        return customersRepository.obtenerTodas();
    }

    //GET - Customer por id
    public Customer getCustomerById(Long id){
        return customersRepository.obtenerPorId(id);
    }

    //POST - crear la customer
    public Customer createCustomer(Customer customer){
        return customersRepository.guardar(customer);
    }

    //PUT - actualizar customer
    public Customer updateCustomer(Customer customer){
        return customersRepository.actualizar(customer);
    }

    //DELETE - eliminar customer
    public void deleteCustomer(Long id){
        customersRepository.eliminar(id);
    }
}
