package com.upiiz.customers.controllers;

import com.upiiz.customers.models.Customer;
import com.upiiz.customers.repository.CustomersRepository;
import com.upiiz.customers.services.CustomersServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersController {
    CustomersServices customersServices ;

    public CustomersController(CustomersServices customersServices) {
        this.customersServices = customersServices;
    }

    //GET - todas los customers
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customersServices.getAllCustomer());
    }

    // GET - solo una categoria por id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustumer(@PathVariable Long id){
        return ResponseEntity.ok(customersServices.getCustomerById(id));
    }

    // POST - crear categoria
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customersServices.createCustomer(customer));
    }

    //PUT - actualizar categoria
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCategoria(@RequestBody Customer customer, @PathVariable Long id){
        customer.setId(id);
        return ResponseEntity.ok(customersServices.updateCustomer(customer));
    }

    //DELETE - eliminar categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customersServices.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
