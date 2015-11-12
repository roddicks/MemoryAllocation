package com.company;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class BestFitAlgorithm implements AllocationAlgorithm {
    @Override
    public int allocateMemory(Process process, Memory memory) {
        int headOfFragment = 0, tailOfFragment = 0, nodesTraversed = 0, smallestFragSize = 0, smallestFragIndex = 0;
        boolean inFragment = false, allocated = false;

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

                    if((tailOfFragment - headOfFragment) > process.getSize()) {
                        smallestFragSize = process.getSize();
                        smallestFragIndex = headOfFragment;
                    }

                    if((tailOfFragment - headOfFragment) + 1 <= smallestFragSize) {
                        smallestFragSize = (tailOfFragment - headOfFragment) + 1;
                        smallestFragIndex = headOfFragment;

                        if(smallestFragSize == process.getSize())
                            break;
                    }
                    inFragment = false;
                }
            }
            nodesTraversed++;
        }

        //Check if we've found a fragment of sufficient size
        if(smallestFragSize >= process.getSize()) {
            for(int i = smallestFragIndex; i < smallestFragIndex + process.getSize(); i++) {
                memory.processes.get(i).setProcess(process);
            }
            allocated = true;
        }


        return allocated ? nodesTraversed : -1;
    }

}
