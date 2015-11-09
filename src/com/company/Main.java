package com.company;

public class Main {

    public static void main(String[] args) {
        FirstFitAlgorithm firstFit = new FirstFitAlgorithm();
        BestFitAlgorithm bestFit = new BestFitAlgorithm();
        WorstFitAlgorithm worstFit = new WorstFitAlgorithm();

        Memory firstFitMemory = new Memory(firstFit);
        Memory bestFitMemory = new Memory(bestFit);
        Memory worstFitMemory = new Memory(worstFit);

        RequestGenerator requestGenerator = new RequestGenerator();

        for(int i = 0; i < 10000; i++){
            Request r = requestGenerator.generateRequest();
            firstFitMemory.handleRequest(r);
            bestFitMemory.handleRequest(r);
            worstFitMemory.handleRequest(r);
        }

    }
}
