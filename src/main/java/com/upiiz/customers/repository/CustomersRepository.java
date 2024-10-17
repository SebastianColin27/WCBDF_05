package com.upiiz.customers.repository;

import com.upiiz.customers.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomersRepository {

    private List<Customer> customers= new ArrayList<Customer>();
    private AtomicLong id= new AtomicLong();

    //POST
    public Customer guardar(@org.jetbrains.annotations.NotNull Customer customer){
        customer.setId(id.incrementAndGet());
        customers.add(customer);
        return customer;
    }

    //GET - Todas los customers
    public List<Customer> obtenerTodas() {

        return customers;
    }

    //GET - Sólo un customer
    public  Customer obtenerPorId(Long id){
      /*  for (Categoria categoria:categorias){
            if (categoria.getId().equals(id)){
                return categoria;
            }
        }
        return null; */
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null)  ;
    }

    //PUT
    public Customer actualizar(Customer customer){
        eliminar(customer.getId());
        customers.add(customer);
        return customer;
    }

    //DELETE
    public  void eliminar(Long id){
        customers.removeIf(customer -> customer.getId().equals(id));
    }


}
