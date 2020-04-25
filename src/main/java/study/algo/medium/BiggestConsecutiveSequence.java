package study.algo.medium;

public class BiggestConsecutiveSequence {

    /*
    Example:
    [1,2,3,5,-1,-2,-4] then answer will be 3
    [4,3,2,1] then 4
[   [4,5,6,-2,-1,0,1,2,7,8,9] then 5

    * */
    public static void main(String[] args) {
        int[] array = new int[]{8, 7, 6, -2, -1, 0, 1, 2, 5, 4, 3};
        System.out.println(solution(array));

    }

    public static int solution(int[] array) {

        boolean isIncreasing = false;
        boolean isDecreasing = false;
        int i = 0;
        int increasingMaxCount = 0;
        int decreasingMaxCount = 0;
        int increasingCount = 0;
        int decreasingCount = 0;

        while (i < array.length -1 ) {
            if (array[i] < array[i + 1]) {
                isIncreasing = true;
                if (isDecreasing) {
                    ++decreasingCount;
                    decreasingMaxCount = Math.max(decreasingMaxCount, decreasingCount);
                    decreasingCount = 0;
                    isDecreasing = false;
                }
                ++increasingCount;
            } else {
                isDecreasing = true;
                if (isIncreasing) {
                    ++increasingCount;
                    increasingMaxCount = Math.max(increasingMaxCount, increasingCount);
                    increasingCount = 0;
                    isIncreasing = false;
                }
                ++decreasingCount;
            }
            i++;
        }
        decreasingMaxCount = Math.max(decreasingMaxCount, decreasingCount);
        increasingMaxCount = Math.max(increasingMaxCount, increasingCount);

        return Math.max(increasingMaxCount, decreasingMaxCount) -1;
    }
}
