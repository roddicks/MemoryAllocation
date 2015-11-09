package com.company;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class Process {
    private int pid;
    private int size;

    public Process(int pid, int size) {
        this.pid = pid;
        this.size = size;
    }

    public int getPid() {
        return pid;
    }

    public int getSize() {
        return size;
    }
}
