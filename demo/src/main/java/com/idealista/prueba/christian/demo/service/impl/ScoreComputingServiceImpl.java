package com.idealista.prueba.christian.demo.service.impl;

import com.idealista.prueba.christian.demo.entity.Advertisement;
import com.idealista.prueba.christian.demo.entity.Picture;
import com.idealista.prueba.christian.demo.repository.AdvertisementRepository;
import com.idealista.prueba.christian.demo.repository.PictureRepository;
import com.idealista.prueba.christian.demo.service.DescriptionParser;
import com.idealista.prueba.christian.demo.service.ScoreComputingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreComputingServiceImpl implements ScoreComputingService {

    private static final int SCORE_HD_PIC=20;
    private static final int SCORE_NOT_HD_PIC=10;
    private static final int SCORE_HAS_NO_PIC=-10;
    private static final int SCORE_HAS_KEYWORD=5;
    private static final int SCORE_HAS_DESCRIPTION=5;
    private static final int SCORE_HOUSE_50=20;
    private static final int SCORE_FLAT_50=30;
    private static final int SCORE_FLAT_20=10;
    private static final int SCORE_COMPLETE_ADD=40;



    private List<Advertisement> ads;

    @Autowired
    private DescriptionParser parser;

    @Autowired
    private AdvertisementRepository advertisements;

    @Autowired
    private PictureRepository pictures;


    public void computeAll(){
        ads=advertisements.findAll();
        for(Advertisement currentAd:ads){
            boolean hasPic= computePics(currentAd);
            boolean hasDesc= computeDesc(currentAd);
            if(hasPic && hasDesc){
                if (currentAd.isComplete()){
                    currentAd.addScore(SCORE_COMPLETE_ADD);
                }
            }

            currentAd.balanceScore();
        }
    }

    /**
     * Method that computes and adds score to a certain advertisement depending on its description
     * It counts the keywords it has and the number of words, then adds the required points to the score
     * @param advertisement
     * @return true if the add has description or if its a garage
     * false if not, used to determine whether the ad is complete or not
     */
    public boolean computeDesc(Advertisement advertisement) {
        String desc = advertisement.getDescription();

        if (desc.isEmpty()) {//If the advertisement has no description, false is returned to notify its not complete
            return advertisement.isGarage();
        }

        advertisement.addScore(SCORE_HAS_KEYWORD * parser.parseDescription(desc));
        advertisement.addScore(SCORE_HAS_DESCRIPTION);

        int nWords= parser.wordCount(desc);
        if(nWords>=50){
            if(advertisement.isHouse()){
                advertisement.addScore(SCORE_HOUSE_50);
            }else {
                advertisement.addScore(SCORE_FLAT_50);
            }
        }else if(nWords>=20){
            if(!advertisement.isHouse()){
                advertisement.addScore(SCORE_FLAT_20);
            }
        }
        return true;

    }

    /**
     * Method that computes and adds score to a certain advertisement depending on its pictures
     * It checks the number of pictures that are related to the advertisement and add the required quantity if they are
     * Hd pics or not
     * @param advertisement
     * @return true if it has picture, false if not used to determine whether the ad is complete or not
     */
    public boolean computePics(Advertisement advertisement){


            List<Picture> relatedPics = pictures.findByAdvertisement(advertisement);
            if(relatedPics.isEmpty()){//If the ad has no pictures adds the score realted to not having picture
                advertisement.addScore(SCORE_HAS_NO_PIC);
                return false;
            }

            for (Picture pic : relatedPics) {
                if (pic.isHd()) {
                    advertisement.addScore(SCORE_HD_PIC);
                } else {
                    advertisement.addScore(SCORE_NOT_HD_PIC);
                }
            }
            return true;



    }
}
