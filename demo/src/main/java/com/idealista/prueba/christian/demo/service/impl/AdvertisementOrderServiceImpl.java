package com.idealista.prueba.christian.demo.service.impl;

import com.idealista.prueba.christian.demo.entity.Advertisement;
import com.idealista.prueba.christian.demo.repository.AdvertisementRepository;
import com.idealista.prueba.christian.demo.service.AdvertisementOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementOrderServiceImpl implements AdvertisementOrderService {

    @Autowired
    AdvertisementRepository advertisements;

    public List<Advertisement> getScoresLessThan(int superiorLimit){
        return advertisements.findAdvertisementByScoreIsLessThanEqual(superiorLimit);
    }

    public List<Advertisement> getScoresGreaterThan(int inferiorLimit){
        return advertisements.findByScoreGreaterThanEqual(inferiorLimit);
    }
}
