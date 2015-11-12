package com.company;

/**
 * Created by SheldonCOMP4980 on 11/8/2015.
 */
public class StatReporter {

    private int allocationRequestCount, allocationAcceptedCount, totalNodesTraversed, totalFragCount;
    private double avgFragCount, avgNodeTraversal, requestDenialPercent;

    /**
     * Initializes all global variables to 0
     */
    public StatReporter() {
        allocationRequestCount = allocationAcceptedCount = totalNodesTraversed = totalFragCount = 0;
        avgFragCount = avgNodeTraversal = 0.0;
    }


    /**
     * Updates the statistics every time an allocation request is made
     * @param traversed - The number of nodes that the algorithm traversed to find a suitable fragment
     * @param fragCount - The number of current fragments (of size 1-2) currently in memory
     */
    public void updateCounts(int traversed, int fragCount) {
        allocationRequestCount++;
        if(traversed != -1) {
            allocationAcceptedCount++;
            totalNodesTraversed += traversed;
        }
        else {
            totalNodesTraversed += 128;
        }
        avgNodeTraversal = (double)totalNodesTraversed/allocationRequestCount;
        requestDenialPercent = 100 - ((double)allocationAcceptedCount/allocationRequestCount)*100;
        totalFragCount += fragCount;
        avgFragCount = (double)totalFragCount/allocationRequestCount;
    }


    /**
     * Used in toString to print the statistics
     * @return  - A human-readable list of statistics
     */
    private String printStatistics() {
        String str = "";
        str += "\nAverage number of external fragments: " + avgFragCount;
        str += "\nAverage number of nodes traversed: " + avgNodeTraversal;
        str += "\nAllocation request denial percentage: %" + requestDenialPercent;

        return str;
    }


    @Override
    public String toString() {
        return printStatistics();
    }
}
