package com.company;

public class Main {

    public static void main(String[] args) {
        AllocationAlgorithm firstFit = new FirstFitAlgorithm();

        Memory firstFitMemory = new Memory(firstFit);

        Process test = new Process(1, 1);

        firstFitMemory.allocateMemory(test);
    }
}