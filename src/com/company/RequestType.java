package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by SheldonCOMP4980 on 11/9/2015.
 */
public enum RequestType {
    ALLOCATE, DEALLOCATE;


    //Generates random type
    private static final List<RequestType> TYPES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = TYPES.size();
    private static final Random rand = new Random();

    public static RequestType randomType() {
        return TYPES.get(rand.nextInt(SIZE));
    }
}
