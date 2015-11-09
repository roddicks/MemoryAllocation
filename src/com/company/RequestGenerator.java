package com.company;

import sun.misc.Queue;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class RequestGenerator {

    //TODO: For each request, invoke appropriate function of Memory
    public static int allocatedProcessIDs = 1;

    public Request generateRequest(){
        Request request = new Request();

        System.out.println("Type: " + request.getType() + ", pid: " + request.getProcess().getPid());
        return request;
    }
}
