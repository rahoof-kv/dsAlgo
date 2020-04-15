package study.algo.easy;

public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i: nums) {
            if(i != val){
                nums[index++] = i;
            }
        }

        return index;
    }

}
