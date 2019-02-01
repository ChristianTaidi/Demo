package com.idealista.prueba.christian.demo.service.impl;

import com.idealista.prueba.christian.demo.entity.Advertisement;
import com.idealista.prueba.christian.demo.repository.AdvertisementRepository;
import com.idealista.prueba.christian.demo.service.AdvertisementSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementSortServiceImpl implements AdvertisementSortService {

    @Autowired
    AdvertisementRepository advertisements;

    public List<Advertisement> getScoresLessThan(int superiorLimit){
        return advertisements.findAdvertisementByScoreIsLessThanEqual(superiorLimit);
    }

    public List<Advertisement> getScoresGreaterThan(int relevant){
        return advertisements.findAdvertisementByScoreGreaterThanEqual(relevant);
    }
}
