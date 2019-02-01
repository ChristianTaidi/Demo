package com.idealista.prueba.christian.demo.controller;

import com.idealista.prueba.christian.demo.AdvertisementComparator;
import com.idealista.prueba.christian.demo.entity.Advertisement;
import com.idealista.prueba.christian.demo.service.AdvertisementSortService;
import com.idealista.prueba.christian.demo.service.ScoreComputingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QualityManagerController {

    private static final int ADVERTISEMENT_NOT_RELEVANT=40;

    @Autowired
    ScoreComputingService computingService;

    @Autowired
    AdvertisementSortService sortService;

    @Autowired
    AdvertisementComparator comparator;
    @RequestMapping(value = "/advertisements/quality", method = RequestMethod.GET)
    public @ResponseBody List<Advertisement> getNotRelevant(){
        computingService.computeAll();
        List<Advertisement> ads=sortService.getScoresLessThan(ADVERTISEMENT_NOT_RELEVANT);
        ads.sort(comparator);
        return ads;
    }



}
