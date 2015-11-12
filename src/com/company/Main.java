package com.company;

public class Main {

    static FirstFitAlgorithm firstFit = new FirstFitAlgorithm();
    static BestFitAlgorithm bestFit = new BestFitAlgorithm();
    static WorstFitAlgorithm worstFit = new WorstFitAlgorithm();

    static Memory firstFitMemory = new Memory(firstFit, new StatReporter());
    static Memory bestFitMemory = new Memory(bestFit, new StatReporter());
    static Memory worstFitMemory = new Memory(worstFit, new StatReporter());

    static RequestGenerator requestGenerator = new RequestGenerator();

    public static void main(String[] args) {

        fullTest(10000);
    }

    static void fullTest(int requestCount){

        for(int i = 0; i < requestCount; i++){
            Request r = requestGenerator.generateRequest();
            firstFitMemory.handleRequest(r);
            bestFitMemory.handleRequest(r);
            worstFitMemory.handleRequest(r);
        }
        System.out.println("\n" + firstFitMemory);
        System.out.println(firstFitMemory.printStatistics());
    }
}
