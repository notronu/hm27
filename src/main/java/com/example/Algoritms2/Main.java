package com.example.Algoritms2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static com.example.Algoritms2.IntegerList.*;
import static com.example.Algoritms2.IntegerListImpl.sortInsertion;
import static com.example.Algoritms2.IntegerListImpl.swapElements;

public class Main {

    public static void main(String[] args) {


        int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100_000)).limit(300_000).toArray();

        sortSelection(randomIntsArray);

        sortBubble(randomIntsArray);

        sortInsertion(randomIntsArray);

        mergeSort(randomIntsArray);
        quickSort(randomIntsArray, 0, 299000);

        int[] copy = Arrays.copyOf(randomIntsArray, randomIntsArray.length);


        long start = System.currentTimeMillis();

        quickSort(randomIntsArray, 0, 299000);
        mergeSort(randomIntsArray);

        System.out.println("Быстрая сортировка quickSort для " + copy.length + " элементов составила: "
                + ((System.currentTimeMillis() - start) / 1000d / 60 + " минут "));
        System.out.println("сортировка слиянием (mergeSort) для " + copy.length + " элементов составила: "
                + ((System.currentTimeMillis() - start) / 1000d / 60 + " минут "));


    }



    private static void quickSort(int[] randomIntsArray, int begin, int end) {
        if (begin < end) {
            int[] copy = Arrays.copyOf(randomIntsArray, randomIntsArray.length);
            long start = System.currentTimeMillis();
            int partitionIndex = partition(copy, begin, end);

            quickSort(copy, begin, partitionIndex - 1);
            quickSort(copy, partitionIndex + 1, end);

        }
    }

    private static int partition(int[] copy, int begin, int end) {

        int pivot = copy[end];
        int i = (begin - 1);
        long start = System.currentTimeMillis();
        for (int j = begin; j < end; j++) {
            if (copy[j] <= pivot) {
                i++;

                swapElements(copy, i, j);
            }
        }
        swapElements(copy, i + 1, end);
        return i + 1;
    }


    public static void mergeSort(int[] randomIntsArray) {
        int[] copy = Arrays.copyOf(randomIntsArray, randomIntsArray.length);
        long start = System.currentTimeMillis();
        if (copy.length < 2) {
            return;
        }
        int mid = copy.length / 2;
        int[] left = new int[mid];
        int[] right = new int[copy.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = copy[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = copy[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(copy, left, right);

    }


    public static void merge(int[] copy, int[] left, int[] right) {

        long start = System.currentTimeMillis();


        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                copy[mainP++] = left[leftP++];
            } else {
                copy[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            copy[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            copy[mainP++] = right[rightP++];


        }
    }


    public static void sortBubble(int[] randomIntsArray) {

        int[] copy = Arrays.copyOf(randomIntsArray, randomIntsArray.length);
        long start = System.currentTimeMillis();

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - 1 - i; j++) {
                if (copy[j] > copy[j + 1]) {

                    swapElements(copy, j, j + 1);
                }
            }

            System.out.println(" Пузырьковая сортировка (bubbleSpeed) для " + copy.length + " элементов составила: "
                    + ((System.currentTimeMillis() - start) / 1000d / 60 + " минут "));
        }
    }


            public static void sortSelection (int[] randomIntsArray){
                int[] copy = Arrays.copyOf(randomIntsArray, randomIntsArray.length);
                long start = System.currentTimeMillis();

                for (int i = 0; i < copy.length - 1; i++) {
                    int minElementIndex = i;
                    for (int j = i + 1; j < copy.length; j++) {
                        if (copy[j] < copy[minElementIndex]) {
                            minElementIndex = j;
                        }
                    }

                    swapElements(copy, i, minElementIndex);
                }

                System.out.println("Сортировка выбором (sortSelection) для " + copy.length + " элементов составила: "
                        + ((System.currentTimeMillis() - start) / 1000d / 60 + " минут "));

            }


            public static void sortInsertion ( int[] randomIntsArray){


                int[] copy = Arrays.copyOf(randomIntsArray, randomIntsArray.length);

                long start = System.currentTimeMillis();

                for (int i = 1; i < copy.length; i++) {
                    int temp = copy[i];
                    int j = i;
                    while (j > 0 && copy[j - 1] >= temp) {
                        copy[j] = copy[j - 1];
                        j--;
                    }

                    copy[j] = temp;
                }

                System.out.println("Сортировка  вставкой (sortInsertion) для " + copy.length + " элементов составила: "
                        + ((System.currentTimeMillis() - start) / 1000d / 60 + " минут "));
            }

            public static void swapElements ( int[] copy, int indexA, int indexB){
                int tmp = copy[indexA];
                copy[indexA] = copy[indexB];
                copy[indexB] = tmp;


            }
        }



