package com.example.updadtednotebook;

import java.util.ArrayList;


public class Data {
    final ArrayList<String> notes = new ArrayList<>();
    final ArrayList<Note> noteObjects = new ArrayList<>();

    private Data(){}
    static Data getInstance(){
        if(instance == null){
            instance = new Data();
        }
        return instance;
    }
    private static Data instance;
}
