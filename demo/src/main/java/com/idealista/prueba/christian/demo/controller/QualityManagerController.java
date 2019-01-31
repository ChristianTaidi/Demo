package com.idealista.prueba.christian.demo.controller;

import com.idealista.prueba.christian.demo.service.ScoreComputingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QualityManagerController {

    @Autowired
    ScoreComputingService computingService;



}
