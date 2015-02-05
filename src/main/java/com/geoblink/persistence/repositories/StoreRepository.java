package com.geoblink.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.geoblink.persistence.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {


    List<Store> findByCity(String storeCity);

}
