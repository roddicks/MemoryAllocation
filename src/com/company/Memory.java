package com.company;

import java.util.LinkedList;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class Memory {

    final private LinkedList<MemoryUnit> processes = new LinkedList<>();
    final private int TOTAL_MEMORY = 256;   //256KB
    final private int UNIT_SIZE = 2;        //2KB

    private AllocationAlgorithm algorithm;

    public Memory(AllocationAlgorithm algorithm) {
        this.algorithm = algorithm;
        for(int i = 0; i < TOTAL_MEMORY; i += UNIT_SIZE){
            processes.add(new MemoryUnit(null));
        }
    }

    int allocateMemory(Process p) {
        //TODO: Define allocateMemory methods
        int i = algorithm.allocateMemory(processes);

        return i >= 0 ? i : -1;
    }

    int deallocateMemory(int processId) {
        for(MemoryUnit m : processes) {
            if(m.getProcess().getPid() == processId) {
                processes.remove(m);
                return 1;
            }
        }
        return -1;
    }

    int fragmentCount(){
        //TODO: Count holes
        return -1;
    }
}
