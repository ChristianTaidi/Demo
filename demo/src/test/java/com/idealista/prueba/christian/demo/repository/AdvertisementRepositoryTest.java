package com.idealista.prueba.christian.demo.repository;

import com.idealista.prueba.christian.demo.entity.Advertisement;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvertisementRepositoryTest {

    @Autowired
    AdvertisementRepository adsTest;

    @Test
    public void test_save_add(){
        Advertisement newAdd = new Advertisement("DescriptionTest");
        adsTest.save(newAdd);
        Assertions.assertThat(adsTest.findAll().contains(newAdd));
    }

    @Test
    public void test_findByScoreLessThanEqual_found(){
        Advertisement newAdd= new Advertisement("DescriptionTEst");
        newAdd.addScore(40);
        adsTest.save(newAdd);

        Assertions.assertThat(adsTest.findAdvertisementByScoreIsLessThanEqual(50).contains(newAdd));
    }

    @Test
    public void test_findByScoreLessThan_not_found(){
        Advertisement newAdd= new Advertisement("DescriptionTest");
        newAdd.addScore(60);
        adsTest.save(newAdd);

        Assertions.assertThat(!(adsTest.findAdvertisementByScoreIsLessThanEqual(50).contains(newAdd)));

    }

    @Test
    public void test_findByScoreGreaterThan_found(){
        Advertisement newAdd = new Advertisement("DescriptionTest");
        newAdd.addScore(80);
        adsTest.save(newAdd);
        Assertions.assertThat(adsTest.findAdvertisementByScoreGreaterThanEqual(70).contains(newAdd));
    }

    @Test
    public void test_findByScoreGreaterThan_not_found(){
        Advertisement newAdd = new Advertisement("DescriptionTest");
        newAdd.addScore(60);
        adsTest.save(newAdd);
        Assertions.assertThat(!adsTest.findAdvertisementByScoreGreaterThanEqual(70).contains(newAdd));

    }



}
