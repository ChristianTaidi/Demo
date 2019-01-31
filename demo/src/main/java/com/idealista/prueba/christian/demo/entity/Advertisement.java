package com.idealista.prueba.christian.demo.entity;

import com.idealista.prueba.christian.demo.HouseType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "advertisement")
public class Advertisement implements Comparable{

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




    private Date dateCreated;

    private int score;


    public Long getId() {
        return this.id;
    }

    public void addScore(int addToScore) {
        this.score+=addToScore;
    }

    @Override
    public int compareTo(Object o) {
        Advertisement ad = (Advertisement) o;
        if (this.getScore() > ad.getScore()){
            return 1;
        }else if(this.getScore()< ad.getScore()){
            return -1;
        }else{
            return 0;
        }
    }

    private int getScore() {
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
    }
}
