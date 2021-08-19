package nowcoder.小易的考试成绩;

import java.util.*;
public class Main {
    //小易的考试成绩
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] dp = new int[20001];
        dp[0]=1;
//        int[] scores = {40, 15, 5 ,45, 70, 10, 75, 15, 65, 75, 15, 25, 60, 45, 60, 60, 15, 45, 55, 55};
        int[] scores = new int[n];
        for(int i = 0; i < n; i++){
            scores[i]=sc.nextInt();
            sum += scores[i];
            dp[scores[i]]=1;
            dp[sum]=1;
            for (int j = 0; j < i; j++) {
                dp[sum-scores[j]]=1;
            }
        }

        for(int score = sum; score >= 0; score--){
            if(dp[score] == 1 && !String.valueOf(score).contains("5")){
                System.out.println(score);
                break;
            }
        }
    }
}