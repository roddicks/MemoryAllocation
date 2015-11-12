package com.company;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class FirstFitAlgorithm implements AllocationAlgorithm {
    @Override
    public int allocateMemory(Process process, Memory memory) {
        int headOfFragment = 0, tailOfFragment = 0, nodesTraversed = 0;
        boolean inFragment = false;

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
                else {
                    inFragment = false;
                }
            }

            if(tailOfFragment - headOfFragment >= process.getSize()) {
                for(int j = headOfFragment; j < tailOfFragment; j++) {
                    memory.processes.get(j).setProcess(process);
                }
                break;
            }
            nodesTraversed++;
        }
        return nodesTraversed;
    }
}
