package com.idealista.prueba.christian.demo;

import com.idealista.prueba.christian.demo.entity.Advertisement;
import org.springframework.stereotype.Service;

import java.util.Comparator;
@Service
public class AdvertisementComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Advertisement add1 = (Advertisement) o1;
        Advertisement add2 = (Advertisement) o2;

        if (add1.getScore() > add2.getScore()){
            return -1;
        }else if(add1.getScore()< add2.getScore()) {
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
