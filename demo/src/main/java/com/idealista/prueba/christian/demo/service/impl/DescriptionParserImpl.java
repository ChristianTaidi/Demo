package com.idealista.prueba.christian.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class DescriptionParserImpl {

    private static final String KEYWORD_LUMINOSO="luminoso";
    private static final String KEYWORD_NUEVO="nuevo";
    private static final String KEYWORD_CENTRICO="céntrico";
    private static final String KEYWORD_REFORMADO="reformado";
    private static final String KEYWORD_ATICO="ático";


    public int parseDescription(String description){
        int count = 0;
        description=description.toLowerCase();
        if(description.indexOf(KEYWORD_ATICO)>0){
            count++;
        }
        if (description.indexOf(KEYWORD_LUMINOSO)>0){
            count++;
        }
        if(description.indexOf(KEYWORD_NUEVO)>0){
            count++;
        }
        if(description.indexOf(KEYWORD_CENTRICO)>0){
            count++;
        }
        if(description.indexOf(KEYWORD_REFORMADO)>0){
            count++;
        }
        return count;
    }

    public int wordCount(String description){
        String[] words = description.split("\\s+");
        return words.length;
    }
}
