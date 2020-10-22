package ru.netcracker.tasks;
import java.util.*;


public class Main {
    public static void main(String[] args){
        double[][] m1 = {{1,1,0},{ 2,-1,2}};
        double[][] m2 = {{2,1},{0,3},{1,2}};

        IMatrixWorker matrixWorker = new IMatrixWorkerImpl();
        matrixWorker.print(m1);
        System.out.println(matrixWorker.haveSameDimension(m1,m2));
        matrixWorker.print(matrixWorker.multiply(m1,m2));

    }
}
