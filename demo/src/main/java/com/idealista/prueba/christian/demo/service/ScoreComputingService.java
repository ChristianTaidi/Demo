package com.idealista.prueba.christian.demo.service;

import com.idealista.prueba.christian.demo.entity.Advertisement;

public interface ScoreComputingService {

    void computeAll();
    boolean computeDesc(Advertisement advertisement);
    boolean computePics(Advertisement advertisement);
}
