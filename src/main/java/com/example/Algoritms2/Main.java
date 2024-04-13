package com.example.Algoritms2;

public class Main {

    public static void main(String[] args) {


        int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100_000)).limit(300_000).toArray();

        sortSelection(randomIntsArray);

        sortBubble(randomIntsArray);

        sortInsertion(randomIntsArray);


        quickSortOptimize(randomIntsArray);


        long start = System.currentTimeMillis();

        sortSelection(randomIntsArray);

        sortBubble(randomIntsArray);

        sortInsertion(randomIntsArray);

        quickSortOptimize(randomIntsArray);

        System.out.println(System.currentTimeMillis() - start);
    }


    private static void quickSortOptimize(int[] randomIntsArray) {

        boolean sorted = true;

        int temp;

        while (!sorted) {

            sorted = true;

            for (int i = 0; i < randomIntsArray.length - 1; i++) {

                if (randomIntsArray[i] > randomIntsArray[i + 1]) {

                    temp = randomIntsArray[i];

                    randomIntsArray[i] = randomIntsArray[i + 1];

                    randomIntsArray[i + 1] = temp;

                    sorted = false;
                }
            }
        }
    }




    private static void sortInsertion2(int[] randomIntsArray) {

        for (int i = 1; i < randomIntsArray.length; i++) {

            int current = randomIntsArray[i];

            int j = i - 1;

            while (j >= 0 && current < randomIntsArray[j]) {

                randomIntsArray[j + 1] = randomIntsArray[j];

                j--;
            }


            randomIntsArray[j + 1] = current;
        }
    }

    public static void sortInsertion(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];

            int j = i;

            while (j > 0 && arr[j - 1] >= temp) {

                arr[j] = arr[j - 1];

                j--;
            }
            arr[j] = temp;
        }
    }


    private static void sortBubble2(int[] randomIntsArray) {

        boolean sorted = false;

        int temp;

        while (!sorted) {

            sorted = true;

            for (int i = 0; i < randomIntsArray.length - 1; i++) {

                if (randomIntsArray[i] > randomIntsArray[i + 1]) {

                    temp = randomIntsArray[i];

                    randomIntsArray[i] = randomIntsArray[i + 1];

                    randomIntsArray[i + 1] = temp;

                    sorted = false;
                }
            }
        }
    }


    public static void sortBubble(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    swapElements(arr, j, j + 1);
                }
            }
        }
    }


    private static void swapElements(int[] arr, int j, int i) {
    }


    private static void sortSelection2(int[] randomIntsArray) {

        for (int i = 0; i < randomIntsArray.length; i++) {

            int min = randomIntsArray[i];

            int minId = i;

            for (int j = i + 1; j < randomIntsArray.length; j++) {

                if (randomIntsArray[j] < min) {

                    min = randomIntsArray[j];

                    minId = j;
                }
            }


            int temp = randomIntsArray[i];

            randomIntsArray[i] = min;

            randomIntsArray[minId] = temp;
        }
    }





    public  void sortInsertion_(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];

            int j = i;

            while (j > 0 && arr[j - 1] >= temp) {

                arr[j] = arr[j - 1];

                j--;
            }

            arr[j] = temp;
        }
    }
}
