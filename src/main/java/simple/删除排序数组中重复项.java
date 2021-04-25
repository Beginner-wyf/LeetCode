package simple;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangyifan
 * @create 2021/2/25 15:30
 */
public class 删除排序数组中重复项 {
    public static void main(String[] args) {
        int[] nums ={-3,-1,0,0,0,3,3};
        System.out.println(solve(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int solve(int[] nums){

        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < integers.size(); i++) {
            nums[i] = collect.get(i);
        }

        return collect.size();
    }
}
