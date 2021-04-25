package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangyifan
 * @create 2021/2/25 15:58
 */
public class 拥有最多糖果的孩子 {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        Integer extraCandies = 3;
        List<Boolean> res = solve(candies, extraCandies);
        System.out.println(res);
    }



    public static List<Boolean> solve(int[] candies, int extraCandies){
        Integer max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> booleans = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            if (max - extraCandies > candies[i] ){
                booleans.add(false);
            }else {
                booleans.add(true);
            }
        }
        return booleans;
    }

}
