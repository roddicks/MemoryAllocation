package com.company;

public class Main {

    static FirstFitAlgorithm firstFit = new FirstFitAlgorithm();
    static BestFitAlgorithm bestFit = new BestFitAlgorithm();
    static WorstFitAlgorithm worstFit = new WorstFitAlgorithm();

    static Memory firstFitMemory = new Memory(firstFit);
    static Memory bestFitMemory = new Memory(bestFit);
    static Memory worstFitMemory = new Memory(worstFit);

    static RequestGenerator requestGenerator = new RequestGenerator();

    public static void main(String[] args) {

        //fullTest(10000);

        Request r1 = new Request(RequestType.ALLOCATE, new Process(2, 4));
        Request r2 = new Request(RequestType.ALLOCATE, new Process(3, 3));
        Request r3 = new Request(RequestType.DEALLOCATE, new Process(2, 4));
        Request r4 = new Request(RequestType.ALLOCATE, new Process(4, 3));

        firstFitMemory.handleRequest(r1);
        firstFitMemory.handleRequest(r2);
        firstFitMemory.handleRequest(r3);
        firstFitMemory.handleRequest(r4);
        System.out.println(firstFitMemory);
        System.out.println("fragcount: " + firstFitMemory.fragmentCount());
    }

    static void fullTest(int requestCount){

        for(int i = 0; i < requestCount; i++){
            Request r = requestGenerator.generateRequest();
            firstFitMemory.handleRequest(r);
            bestFitMemory.handleRequest(r);
            worstFitMemory.handleRequest(r);
        }
    }
}
