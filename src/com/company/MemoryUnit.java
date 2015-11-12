package com.company;

/**
 * Created by SheldonCOMP4980 on 11/9/2015.
 */
public class MemoryUnit {
    private Process process;

    MemoryUnit(Process p) {
        this.process = p;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public String toString() {
        if(process != null) {
            return "" + process.getPid();
        }
        else {
            return "x";
        }
    }
}
