package com.geoblink;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.geoblink.persistence.entities.Store;
import com.geoblink.persistence.repositories.StoreRepository;

@Configuration
@EnableAutoConfiguration
public class GeoblinkApplication {

    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(GeoblinkApplication.class);
    
    	StoreRepository repository = context.getBean(StoreRepository.class);

        // save a couple of customers
        repository.save(new Store("Zara Alcala", "Alcala", -0.32, 42.23423,"919876543"));
        repository.save(new Store("Mercadona Madrid","Madrid",-0.328, 42.25, "911110000"));
        repository.save(new Store("Mercadona Alicante","Alicante", -0.01, 42.6,"936876543"));
        repository.save(new Store("Amichi LaCoruña", "A Coruña", -1.32, 38.23423, "989765543"));


        // fetch all stores
        Iterable<Store> stores = repository.findAll();
        System.out.println("Stores found with findAllStores():");
        System.out.println("-------------------------------");
        for (Store store : stores) {
            System.out.println(store);
        }
        System.out.println();

        // fetch an individual store by ID
        Store store = repository.findOne(3L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(store);
        System.out.println();

        // fetch customers by last name
        List<Store> madStores = repository.findByCity("Madrid");
        System.out.println("Stores found with findByCity('Madrid'):");
        System.out.println("--------------------------------------------");
        for (Store madStore : madStores) {
            System.out.println(madStore);
        }

        context.close();
    
    
    }
    

}
