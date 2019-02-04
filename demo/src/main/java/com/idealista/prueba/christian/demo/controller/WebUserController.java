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
public class WebUserController {



    @Autowired
    ScoreComputingService computingService;

    @Autowired
    AdvertisementSortService advertisementSortService;

    @Autowired
    AdvertisementComparator comparator;

    @RequestMapping(value="/advertisements/relevant", method = RequestMethod.GET)
    public @ResponseBody List<Advertisement> orderByRelevant(){
        computingService.computeAll();
        List<Advertisement> ads= advertisementSortService.getRelevantAds();
        ads.sort(comparator);
        return ads;
    }
}
