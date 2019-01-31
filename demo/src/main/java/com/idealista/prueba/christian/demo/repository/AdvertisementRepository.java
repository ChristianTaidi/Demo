package com.idealista.prueba.christian.demo.repository;

import com.idealista.prueba.christian.demo.HouseType;
import com.idealista.prueba.christian.demo.entity.Advertisement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertisementRepository extends CrudRepository <Advertisement,Long> {

    List<Advertisement> findAll();

    List<Advertisement> findByScoreGreaterThanEqual(int inferiorLimit);

    List<Advertisement> findAdvertisementByScoreIsLessThanEqual(int superiorLimit);
}
