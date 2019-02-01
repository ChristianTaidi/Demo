package com.idealista.prueba.christian.demo.repository;

import com.idealista.prueba.christian.demo.entity.Advertisement;
import com.idealista.prueba.christian.demo.entity.Picture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PictureRepository extends CrudRepository<Picture,Long> {
    List<Picture> findAll();
    List<Picture> findByAdvertisement(Advertisement add);
}
