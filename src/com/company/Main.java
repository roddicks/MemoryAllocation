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

//        fullTest(10000);

//        Request r1 = new Request(RequestType.ALLOCATE, new Process(2, 3));
//        Request r2 = new Request(RequestType.ALLOCATE, new Process(3, 3));
//        Request r3 = new Request(RequestType.ALLOCATE, new Process(4, 3));
//        Request r4 = new Request(RequestType.DEALLOCATE, new Process(3, 3));
//        Request r5 = new Request(RequestType.ALLOCATE, new Process(5, 3));
//
//
//        firstFitMemory.handleRequest(r1);
//        firstFitMemory.handleRequest(r2);
//        firstFitMemory.handleRequest(r3);
//        firstFitMemory.handleRequest(r4);
//        firstFitMemory.handleRequest(r5);
//
//
//        worstFitMemory.handleRequest(r1);
//        worstFitMemory.handleRequest(r2);
//        worstFitMemory.handleRequest(r3);
//        worstFitMemory.handleRequest(r4);
//        worstFitMemory.handleRequest(r5);
//
//
//        bestFitMemory.handleRequest(r1);
//        bestFitMemory.handleRequest(r2);
//        bestFitMemory.handleRequest(r3);
//        bestFitMemory.handleRequest(r4);
//        bestFitMemory.handleRequest(r5);
//
//
//        System.out.println(firstFitMemory);
//        System.out.println(worstFitMemory);
//        System.out.println(bestFitMemory);
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
