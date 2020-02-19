package com.summer.algorithms.test;


import com.summer.algorithms.Sort;

public class SortTest {

    private static int[] test = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};

    public static void main() {
//        bubblingSortTest();
//        selectSortTest();
//        insertSortTest();
//        shellSortTest();
//        mergeSortTest();
//        quickSortTest();
//        heapSortTest();
//        countSortTest();
//        bucketSortTest();
        radixSortTest();
    }

    private static void bubblingSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.bubblingSort(test);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void selectSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.selectSort(test);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void insertSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.insertSort(test);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void shellSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.shellSort(test);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void mergeSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.mergeSort(test, new int[test.length]);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void quickSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.quickSort(test, 0, test.length -1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void heapSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.heapSort(test);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void countSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.countSort(test);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void bucketSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.bucketSort(test,4);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

    private static void radixSortTest() {
        long start = System.currentTimeMillis();
        test = Sort.radixSort(test,0);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0,len = test.length; i < len; i++ ){
            System.out.print(test[i] + ",");
        }
        System.out.println();
    }

}
