package com.company;

import java.util.LinkedList;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class Memory {

    final private static LinkedList<MemoryUnit> processes = new LinkedList<>();
    final private int TOTAL_MEMORY = 256;   //256KB
    final private int UNIT_SIZE = 2;        //2KB

    private AllocationAlgorithm algorithm;

    public Memory(AllocationAlgorithm algorithm) {
        this.algorithm = algorithm;
        for(int i = 0; i < TOTAL_MEMORY; i += UNIT_SIZE){
            processes.add(new MemoryUnit(null));
        }
    }

    int handleRequest(Request r) {

        if(r.getType() == RequestType.ALLOCATE){
            return allocateMemory(r.getProcess());
        }
        if(r.getType() == RequestType.DEALLOCATE){
            return deallocateMemory(r.getProcess());
        }

        return -1;
    }

    private int allocateMemory(Process p) {
        //TODO: Define allocateMemory methods
        int i = algorithm.allocateMemory(p);

        return i >= 0 ? i : -1;
    }

    private int deallocateMemory(Process p) {
        for(MemoryUnit m : processes) {
            if(m.getProcess() != null){
                if(m.getProcess().getPid() == p.getPid()) {
                    processes.remove(m);
                    return 1;
                }
            }
        }
        return -1;
    }

    int fragmentCount(){
        //TODO: Count holes
        return -1;
    }

    public LinkedList<MemoryUnit> getProcesses() {
        return processes;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < processes.size(); i++) {
            str += processes.get(i) + "|";
        }
        return str;
    }
}
