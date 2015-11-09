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
}
