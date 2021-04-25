package middle;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wangyifan
 * @create 2021/4/6 14:14
 */
public class 删除有序数组中的重复项 {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 说明：
     * 为什么返回数值是整数，但输出的答案是数组呢？
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 示例 1：
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2：
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
     */
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2,2,2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 思路：
     * 根据此题的题意，我们可以想到的是双指针循环不变量来处理，设循环不变量index=2，循环变量i=2
     * 因为该有序数组，最多可以存在两个重复的数值，也就是说，若是数组长度小于2，则直接返回数组长度，数组长度大于2，则我们从数组中第三个数开始比较
     * 因此我们真实需要比较的数值是，从nums[i]开始与nums[index-2]进行比较，倘若该值相当这说明出现了需要覆盖掉的重复值，此时不变量下标的数值就不
     * 进行递增了，但正常的循环变量继续递增，然后继续与当前的nums[index-2]进行对比，直到出现不相等的情况，nums[index]=nums[i],且index在此次
     * 循环中数值也进行+1递增
     */
    public static int removeDuplicates(int[] nums) {
        //1、判断数组大小,小于等于2直接返回数组长度
        if (nums.length<=2){
            return nums.length;
        }
        //2、定义循环不变量
        int index = 2;
        //3、循环比对数组数值
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index-2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
