package com.company;

import java.util.Random;

/**
 * Created by SheldonCOMP4980 on 11/9/2015.
 */
public class Request {

    private final int MIN_SIZE = 3, MAX_SIZE = 10;
    private RequestType type;
    private Process process;

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
            int pid = rand.nextInt(RequestGenerator.allocatedProcessIDs);

            process = new Process(pid, size);
        }
    }

    public RequestType getType() {
        return type;
    }

    public Process getProcess() {
        return process;
    }
}
