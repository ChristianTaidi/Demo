package com.idealista.prueba.christian.demo.controller;

import com.idealista.prueba.christian.demo.HouseType;
import com.idealista.prueba.christian.demo.Quality;
import com.idealista.prueba.christian.demo.entity.Advertisement;
import com.idealista.prueba.christian.demo.entity.Picture;
import com.idealista.prueba.christian.demo.repository.AdvertisementRepository;
import com.idealista.prueba.christian.demo.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InitializerController {

    @Autowired
    AdvertisementRepository ads;

    @Autowired
    PictureRepository pics;

    @Autowired
    public void initDatabase(){
        Advertisement ad1= new Advertisement("Este piso es una ganga, compra, compra, COMPRA!!!!", HouseType.Chalet,300L,0L);
        Advertisement ad2= new Advertisement("Nuevo ático céntrico, recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo",HouseType.Flat,0L,0L);
        Advertisement ad3 = new Advertisement("",HouseType.Chalet,210L,25L);
        Advertisement ad4 = new Advertisement("Ático céntrico muy luminoso y recién reformado, parece nuevo",HouseType.Flat,130L,0L);
        Advertisement ad5 = new Advertisement("Pisazo",HouseType.Flat,0L,0L);
        Advertisement ad6 = new Advertisement("",HouseType.Garage,0L,0L);
        Advertisement ad7= new Advertisement("Garaje en el centro de Albacete",HouseType.Garage,0L,0L);
        Advertisement ad8 = new Advertisement("Maravilloso chalet situado en las afueras de un pequeño pueblo rural. El entorno es espectacular, las vistas magníficas, ¡Cómprelo ahora!",HouseType.Chalet,150L,20L);


        Picture pic1 = new Picture(Quality.SD,"http://www.idealista.com/pictures/1",ad8);
        Picture pic2 = new Picture(Quality.HD,"http://www.idealista.com/pictures/2",ad3);
        Picture pic3 = new Picture(Quality.SD,"http://www.idealista.com/pictures/3",ad5);
        Picture pic4 = new Picture(Quality.HD,"http://www.idealista.com/pictures/4",ad5);//Esta imagen está tanto en el anuncio 2 como en el 5 según el ejemplo, esto no deberia ser posible
        Picture pic5 = new Picture(Quality.SD,"http://www.idealista.com/pictures/5",ad4);
        Picture pic6 = new Picture(Quality.SD,"http://www.idealista.com/pictures/6",ad6);
        Picture pic7 = new Picture(Quality.SD,"http://www.idealista.com/pictures/7",ad8);
        Picture pic8 = new Picture(Quality.HD,"https://www.idealista.com/pictures/4",ad2);//Copia de pic4 para el anuncio 2

        ads.save(ad1);
        ads.save(ad2);
        ads.save(ad3);
        ads.save(ad4);
        ads.save(ad5);
        ads.save(ad6);
        ads.save(ad7);
        ads.save(ad8);

        pics.save(pic1);
        pics.save(pic2);
        pics.save(pic3);
        pics.save(pic4);
        pics.save(pic5);
        pics.save(pic6);
        pics.save(pic7);
        pics.save(pic8);


    }
}
