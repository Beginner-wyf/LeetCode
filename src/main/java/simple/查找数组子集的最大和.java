package simple;

/**
 * @author wangyifan
 * @create 2021/4/7 16:12
 */
public class 查找数组子集的最大和 {
    /**
     *  给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *  示例 1：
     *  输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     *  输出：6
     *  解释：连续子数组[4,-1,2,1] 的和最大，为6 。
     *
     *  示例 2：
     *  输入：nums = [1]
     *  输出：1
     *
     *  示例 3：
     *  输入：nums = [0]
     *  输出：0
     *
     *  示例 4：
     *  输入：nums = [-1]
     *  输出：-1
     *
     *  示例 5：
     *  输入：nums = [-100000]
     *  输出：-100000
     *
     *  提示：
     *  1 <= nums.length <= 3 * 104
     *  -105 <= nums[i] <= 105
     */
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(nums));
        System.out.println(solution2(nums));
    }

    /**
     * 
     * @param nums
     * @return
     */
    public static int solution(int[] nums){
        int max = nums[0];
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = 0;
            for (int j = i;j < nums.length;j++){
                temp += nums[j];
                if (max < temp){
                    max = temp;
                }
            }
        }
        return max;
    }

    public static int solution2(int[] nums){
        int pre = 0,maxAns = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num,num);
            maxAns = Math.max(maxAns,pre);
        }

        return maxAns;
    }
}
