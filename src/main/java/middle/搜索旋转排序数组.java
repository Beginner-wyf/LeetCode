package middle;

/**
 * @author wangyifan
 * @create 2021/4/7 10:59
 */
public class 搜索旋转排序数组 {
    /**
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转 ，
     * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     *
     * 给你旋转后的数组nums和一个整数target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums中存在这个目标值target ，则返回 true ，否则返回 false 。
     *
     * 示例1：
     * 输入：nums = [2,5,6,0,0,1,2], target = 0
     * 输出：true
     *
     * 示例2：
     * 输入：nums = [2,5,6,0,0,1,2], target = 3
     * 输出：false
     */
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {

        int len = nums.length;
        if (len == 0){
            return false;
        }
        if (len == 1){
            return nums[0] == target;
        }

        int low = 0;
        //找出反转位置
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i-1]){
                low = i;
            }
        }
        //获取二分查找高位
        int hi = len + low;
        int mid;
        while ( hi > low){
            //获取中位
            mid = (hi + low) / 2;
            if (nums[mid % len] == target){
                return true;
            }else if (nums[mid % len] < target){
                low = mid+1;
            }else if (nums[mid % len] >target){
                hi = mid-1;
            }
        }
        if (hi == low){
            return target == nums[hi%len];
        }
        return false;
    }
    public static boolean search2(int[] nums, int target) {
        for (int num : nums) {
            if (num == target){
                return true;
            }
        }
        return false;
    }
}
