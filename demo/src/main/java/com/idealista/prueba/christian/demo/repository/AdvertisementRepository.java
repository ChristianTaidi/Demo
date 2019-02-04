package com.idealista.prueba.christian.demo.repository;

import com.idealista.prueba.christian.demo.HouseType;
import com.idealista.prueba.christian.demo.entity.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdvertisementRepository extends CrudRepository <Advertisement,Long> {

    List<Advertisement> findAll();

    List<Advertisement> findByRelevantTrue();

    List<Advertisement> findByRelevantFalse();
}
