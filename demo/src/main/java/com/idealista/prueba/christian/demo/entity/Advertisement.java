package com.idealista.prueba.christian.demo.entity;

import com.idealista.prueba.christian.demo.HouseType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "advertisement")
public class Advertisement{

    /**
     * Constants used to represent how may points are added depending on the pictures of the ad
     */



    @Id
    @Column(name = "ad_id")
    @GeneratedValue
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "houseType")
    private HouseType type;

    @Column(name = "houseSize")
    private Long houseSize;

    @Column(name = "gardenSize")
    private Long gardenSize;

    @Transient
    private List<Picture> pictures;

    @Column(name = "dateNotRelevant")
    private Date dateNotRelevant;


    private int score;

    public Advertisement(){
        //JPA needs this default constructor also used for advertisements without pictures or descriptions

    }

    public Advertisement(String description){
        if(description!=null)
            this.description=description;

    }

    public Advertisement(String description, HouseType type, Long houseSize, Long gardenSize){
        this.description=description;
        this.type=type;
        this.houseSize=houseSize;
        this.gardenSize=gardenSize;
    }

    public Long getId() {
        return this.id;
    }

    public void addScore(int addToScore) {
        this.score+=addToScore;
    }


    public int getScore() {
        return this.score;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHouse() {
        return this.type.equals(HouseType.Chalet);
    }

    public boolean isGarage() {
        return this.type.equals(HouseType.Garage);
    }

    public boolean hasHouseSize() {
        return this.houseSize!=0;
    }

    public void setPics(List<Picture> pics){
        this.pictures=pics;
    }



    private boolean hasGardenSize() {
        return this.gardenSize!=0;
    }

    public boolean isComplete() {
        if(this.isHouse()){
            return this.hasHouseSize()&&this.hasGardenSize();
        }else{
            return this.hasHouseSize();
        }
    }

    public void balanceScore() {
        if(this.score>100){
            this.score=100;
        }
        if(this.score<40){
            dateNotRelevant= new Date();
        }
    }
}
