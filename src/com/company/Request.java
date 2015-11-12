package com.company;

import java.util.Random;

/**
 * Created by SheldonCOMP4980 on 11/9/2015.
 */
public class Request {

    private final int MIN_SIZE = 3, MAX_SIZE = 10;
    private RequestType type;
    private Process process;


    /**
     * Constructor generates a random request
     */
    public Request(){
        type = RequestType.randomType();

        Random rand = new Random();
        //Generates random integer from 0-7, then adds 3 to put it in correct range.
        int size = rand.nextInt(MAX_SIZE - (MIN_SIZE - 1)) + 3;

        if(type == RequestType.ALLOCATE){
            process = new Process(RequestGenerator.allocatedProcessIDs + 1, size);
            RequestGenerator.allocatedProcessIDs++;
        }
        else if (type == RequestType.DEALLOCATE){
            //Random pid in the range 0 to the current highest pid
            int pid = rand.nextInt(RequestGenerator.allocatedProcessIDs);

            process = new Process(pid, size);
        }
    }


    /**
     * Explicit Request creation, used for testing purposes
     * @param type      - The RequestType to be assigned
     * @param process   - The Process to be allocated/deallocated
     */
    public Request(RequestType type, Process process){
        this.type = type;
        this.process = process;
    }

    public RequestType getType() {
        return type;
    }

    public Process getProcess() {
        return process;
    }
}
