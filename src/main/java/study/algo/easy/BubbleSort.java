package study.algo.easy;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {3, 1, 2};
        int[] output = bubbleSort(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static int[] bubbleSort(int[] array) {

        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter ; i++) {
                if(array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
            counter++;
        }

        return array;
    }

    private static void swap(int[] array, int posa, int posb) {
        int temp = array[posa];
        array[posa] = array[posb];
        array[posb] = temp;
    }
}
