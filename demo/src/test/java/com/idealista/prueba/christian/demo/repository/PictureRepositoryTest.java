package com.idealista.prueba.christian.demo.repository;

import com.idealista.prueba.christian.demo.Quality;
import com.idealista.prueba.christian.demo.entity.Advertisement;
import com.idealista.prueba.christian.demo.entity.Picture;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureRepositoryTest {

    @Autowired
    PictureRepository picturesTest;

    @Autowired
    AdvertisementRepository adsTest;


    @Test
    public void test_save_pic(){
        Advertisement newAdd = new Advertisement("DescriptionTest");
        adsTest.save(newAdd);
        Picture pic = new Picture(Quality.SD,"http:example.uri",newAdd);
        picturesTest.save(pic);

        Assertions.assertThat(picturesTest.findAll().contains(pic));
    }
    @Test
    public void test_Find_By_Advertisement(){

        Advertisement newAdd= new Advertisement("DescriptionTest");
        adsTest.save(newAdd);
        Picture pic = new Picture(Quality.HD,"http:example.uri",newAdd);
        pic = picturesTest.save(pic);

        Assertions.assertThat(picturesTest.findByAdvertisement(newAdd).contains(pic));
    }

    @Test
    public void test_Find_By_Advertisement_Not_Found(){

        Advertisement newAdd = new Advertisement("DescriptionTest");
        adsTest.save(newAdd);
        Picture pic = new Picture(Quality.SD,"http:example.uri",newAdd);
        pic=picturesTest.save(pic);
        newAdd= new Advertisement("Another description");
        adsTest.save(newAdd);
        Assertions.assertThat(!picturesTest.findByAdvertisement(newAdd).contains(pic));
    }
}

