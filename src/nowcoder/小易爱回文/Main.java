package nowcoder.小易爱回文;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        String str = "hello";
        int n = str.length();
        char[] chars = str.toCharArray();
        for (int low = 0, high = n - 1; low < high; low++, high--) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
        }
        int i=0,j=0;
        while (i < n && j < n) {
            if(str.charAt(i)!=chars[j]){
                i++;
                if(j!=0) j=0;
            }else {
                i++;
                j++;
            }
        }

        System.out.println(j);
        char[] addChars = new char[n-j];
        int index = 0;
        while (j<n){
            addChars[index++] = chars[j++];
        }
        System.out.println(str+ new String(addChars));
    }
}
