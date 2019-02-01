package com.idealista.prueba.christian.demo.entity;

import com.idealista.prueba.christian.demo.Quality;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @Column(unique = true, name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "Quality")
    private Quality quality;

    @Column(name = "Uri")
    private String uri;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "ad_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Advertisement advertisement;

    public Picture(){
        //JPA NEEDS DEFAULT CONSTRUCTOR
    }

    public Picture(Quality qualityType, String uri,Advertisement addRelated) {
        this.quality=qualityType;
        this.uri=uri;
        this.advertisement=addRelated;
    }

    public boolean isHd(){
        return this.quality.equals(Quality.HD);
    }




}
