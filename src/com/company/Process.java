package com.company;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class Process {

    private int pid;
    private int size;


    /**
     * Creates a process with a process ID (pid) and required memory allocation (size)
     * @param pid   - Process ID
     * @param size  - Memory required to allocate
     */
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
