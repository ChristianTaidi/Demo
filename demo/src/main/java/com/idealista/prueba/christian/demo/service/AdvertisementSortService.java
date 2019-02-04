package com.idealista.prueba.christian.demo.service;

import com.idealista.prueba.christian.demo.entity.Advertisement;

import java.util.List;

public interface AdvertisementSortService {
    List<Advertisement> getNotRelevantAds();
    List<Advertisement> getRelevantAds();
}
