package com.idealista.prueba.christian.demo.controller;

import com.idealista.prueba.christian.demo.service.AdvertisementOrderService;
import com.idealista.prueba.christian.demo.service.ScoreComputingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebUserController {

    @Autowired
    ScoreComputingService computingService;

    @Autowired
    AdvertisementOrderService advertisementOrderService;

    @RequestMapping("/advertisements/relevant")
    public String orderByRelevant(){

    }
}
