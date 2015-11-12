package com.company;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class FirstFitAlgorithm implements AllocationAlgorithm {

    /**
     * Assigns the process to the first available open memory segment of sufficient size
     * @param process   - The process to be allocated
     * @param memory    - A reference to the Memory instance the Algorithm is instantiated in
     * @return          - No. of nodes traversed to find proper location (-1 if allocation failed)
     */
    @Override
    public int allocateMemory(Process process, Memory memory) {
        int headOfFragment = 0, tailOfFragment = 0, nodesTraversed = 0;
        boolean inFragment = false, allocated = false;

        for(int i = 0; i < memory.processes.size(); i++) {
            if(!inFragment) {       //Not currently in fragment
                if(memory.processes.get(i).getProcess() == null) {  //Now in fragment
                    headOfFragment = tailOfFragment = i;
                    inFragment = true;
                }
            }
            else {      //Currently in fragment
                if(memory.processes.get(i).getProcess() == null) {  //Still in fragment
                    tailOfFragment = i;
                }
                else {  //Reached end of fragment
                    inFragment = false;
                }
            }

            //If the fragment is of adequate size, assign process and break out of loop
            if(tailOfFragment - headOfFragment >= process.getSize()) {
                for(int j = headOfFragment; j < tailOfFragment; j++) {
                    memory.processes.get(j).setProcess(process);
                }
                allocated = true;
                break;
            }
            nodesTraversed++;
        }
        return allocated ? nodesTraversed : -1;
    }
}
