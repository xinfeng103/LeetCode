package math._13;

//46. 计数质数

import java.util.HashMap;
import java.util.Map;

class Solution {

    /*
    把所有的可能组合都列出来，如果两个字符能组成一个有效数字，就不要拆开。
    比如"IV"，因为它能组成有效的数字，不能把它拆成I和V。

    然后截取字符串s，每两位截取，看看能不能构成有效的数字，如果能构成有效的数字，
    就把他们看做一个整体，如果不能构成有效的数字，就截取一位。
     */
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        //所有可能的都列出来
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int res = 0;
        for (int i = 0; i < s.length(); ) {
            //先截取两个字符，如果这两个字符存在于map中，就表示他们是一个整体。否则就截取一个
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.romanToInt("LVIII");
        System.out.println(ans);
    }
}
