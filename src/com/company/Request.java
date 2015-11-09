package com.company;

import java.util.Random;

/**
 * Created by SheldonCOMP4980 on 11/9/2015.
 */
public class Request {

    private final int MIN_SIZE = 3, MAX_SIZE = 10;
    private RequestType type;
    private int size;

    public Request(){
        type = RequestType.randomType();
        Random rand = new Random();

        //Generates random integer from 0-7, then adds 3 to put it in correct range.
        size = rand.nextInt(MAX_SIZE - (MIN_SIZE - 1)) + 3;
    }

    public int getSize() {
        return size;
    }

    public RequestType getType() {
        return type;
    }
}
