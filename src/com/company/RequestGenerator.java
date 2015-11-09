package com.company;

import sun.misc.Queue;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class RequestGenerator {

    //TODO: For each request, invoke appropriate function of Memory
    //After request, update three performance parameters
    Queue<Request> requestQueue = new Queue<>();

    public RequestGenerator(int requests) {
        for(int i = 0; i < requests; i++){
            requestQueue.enqueue(new Request());
        }
    }

    public Request getNextRequest() throws InterruptedException {
        return requestQueue.dequeue();
    }

    public boolean hasNext() {
        return !requestQueue.isEmpty();
    }
}
