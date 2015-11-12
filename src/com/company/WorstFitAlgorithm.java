package com.company;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class WorstFitAlgorithm implements AllocationAlgorithm {

    /**
     * Assigns the process to the memory segment that leaves the most leftover space
     * @param process   - The process to be allocated
     * @param memory    - A reference to the Memory instance the Algorithm is instantiated in
     * @return          - No. of nodes traversed to find proper location (-1 if allocation failed)
     */
    @Override
    public int allocateMemory(Process process, Memory memory) {
        int headOfFragment = 0, tailOfFragment = 0, nodesTraversed = 0;
        boolean inFragment = false, allocated = false;
        int largestFragSize = 0, largestFragIndex = 0;

        for(int i = 0; i < memory.processes.size(); i++) {
            if(!inFragment) {       //Not currently in fragment
                if(memory.processes.get(i).getProcess() == null) {  //Now in fragment
                    headOfFragment = tailOfFragment = i;
                    inFragment = true;
                }
            }
            else {      //Currently in fragment
                if(memory.processes.get(i).getProcess() == null
                        && i < memory.processes.size() - 1) {  //Still in fragment, exclude end of memory case
                    tailOfFragment = i;
                }
                else {  //Reached end of fragment
                    if(i == memory.processes.size() - 1 && memory.processes.get(i) == null) {
                        tailOfFragment = i;
                    }
                    if((tailOfFragment - headOfFragment) + 1 > largestFragSize) {
                        largestFragSize = (tailOfFragment - headOfFragment) + 1;
                        largestFragIndex = headOfFragment;
                    }
                    inFragment = false;
                }
            }
            nodesTraversed++;
        }

        //Check if we've found a fragment of sufficient size
        if(largestFragSize >= process.getSize()) {
            for(int i = largestFragIndex; i < largestFragIndex + process.getSize(); i++) {
                memory.processes.get(i).setProcess(process);
            }
            allocated = true;
        }

        return allocated ? nodesTraversed : -1;
    }
}
