package com.company;

import java.util.LinkedList;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class Memory {

    final protected LinkedList<MemoryUnit> processes = new LinkedList<>();
    final private int TOTAL_MEMORY = 256;   //256KB
    final private int UNIT_SIZE = 2;        //2KB

    private AllocationAlgorithm algorithm;

    private StatReporter statReporter;

    /**
     * Takes a memory allocation algorithm and instantiates it, instantiates memory units
     * @param algorithm     - Implementation of the AllocationAlgorithm interface
     * @param statReporter  - A StatReporter object that will keep track of Memory's statistics
     */
    public Memory(AllocationAlgorithm algorithm, StatReporter statReporter) {
        this.algorithm = algorithm;
        for(int i = 0; i < TOTAL_MEMORY; i += UNIT_SIZE){
            processes.add(new MemoryUnit(null));
        }
        this.statReporter = statReporter;
    }


    /**
     * Used to pass Request's Process on to the appropriate method
     * @param r - Request to be handled ALLOCATE/DEALLOCATE
     * @return  - Result of allocation/deallocation
     */
    int handleRequest(Request r) {

        if(r.getType() == RequestType.ALLOCATE){
            System.out.println("Allocating...");
            int i = allocateMemory(r.getProcess());
            statReporter.updateCounts(i, fragmentCount());
            return i;
        }
        if(r.getType() == RequestType.DEALLOCATE){
            return deallocateMemory(r.getProcess());
        }

        return -1;
    }


    /**
     * Handles the allocation of memory
     * @param p - Process to be allocated
     * @return  - No. of memory units traversed (-1 if p could not be allocated)
     */
    private int allocateMemory(Process p) {
        return algorithm.allocateMemory(p, this);
    }


    /**
     * Handles the deallocation of memory
     * @param p - The process (ID) to be deallocated
     * @return  - 1 if deallocation request completed, -1 if not
     */
    private int deallocateMemory(Process p) {
        boolean found = false;
        for(MemoryUnit m : processes) {
            if(m.getProcess() != null){
                if(m.getProcess().getPid() == p.getPid()) {
                    processes.set(processes.indexOf(m), new MemoryUnit(null));
                    found = true;
                }
            }
        }
        return found ? 1 : -1;
    }


    /**
     * Counts the number of fragments (size 1-2 holes) in the memory
     * @return  - No. of fragments
     */
    int fragmentCount(){
        int fragments = 0, currentFrag = 0;
        boolean inFrag = false;
        for(int i = 0; i < processes.size(); i++){
            if(!inFrag) {
                if(processes.get(i).getProcess() == null){
                    inFrag = true;
                    currentFrag++;
                }
            }
            else {
                if(processes.get(i).getProcess() == null){
                    currentFrag++;
                }
                else{ //We've reached the end of the current fragment
                    if(currentFrag < 3){
                        fragments++;
                    }
                    inFrag = false;
                    currentFrag = 0;
                }
            }
        }
        return fragments;
    }


    /**
     * Prints a human-readable list of statistics
     * @return  - The statistics stored in statReporter
     */
    public String printStatistics() {
        return statReporter.toString();
    }


    /**
     * Used in case a reference to processes list is needed
     * @return  - processes list
     */
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
