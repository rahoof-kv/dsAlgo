package study.algo.easy;

public class ThreeLargestNumbers {

    public static void main(String[] args) {

        int[] result = findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] findThreeLargestNumbers(int[] array) {

        int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i =0; i<array.length; i++) {

            if(array[i] >= result[2]) {
                if(array[i] >= array[0]) {
                    result[0]  = array[i];
                } else if (array[i] >= array[0]) {
                    result[1]  = array[i];
                } else {
                    result[2]  = array[i];
                }

            } else if(array[i] >= result[1]) {
                if(array[i] >= array[0]) {
                    result[0]  = array[i];
                } else if (array[i] >= array[2]) {
                    result[2]  = array[i];
                } else {
                    result[1]  = array[i];
                }
            } else if(array[i] >= result[0]) {
                if(array[i] >= array[1]) {
                    result[1]  = array[i];
                } else if (array[i] >= array[2]) {
                    result[2]  = array[i];
                } else {
                    result[0]  = array[i];
                }
                result[0]  = array[i];
            }

        }
        return result;
    }

}
