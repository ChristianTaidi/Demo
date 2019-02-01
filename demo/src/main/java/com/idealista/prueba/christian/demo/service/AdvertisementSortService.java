package com.idealista.prueba.christian.demo.service;

import com.idealista.prueba.christian.demo.entity.Advertisement;

import java.util.List;

public interface AdvertisementSortService {
    List<Advertisement> getScoresLessThan(int superiorLimit);
    List<Advertisement> getScoresGreaterThan(int inferiorLimit);
}
