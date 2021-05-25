package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] data = new int[]{};
        System.out.println("排序前" + Arrays.toString(data));
        solution.quickSort(data, 0, data.length - 1);
        System.out.println("排序后" + Arrays.toString(data));
    }

    void quickSort(int[] data, int start, int end) {
        if (start <= end || data.length == 0) {
            return;
        }
        int index = partition(data, start, end);
        if (index > start) {
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }
    }

    int partition(int[] data, int start, int end) {
        int length = data.length;
        if (data == null || length <= 0 || start < 0 || end >= length) {
            System.out.println("数组为空或查询范围错误");
        }
        //生成[start,end)范围内的随机数，取该位置上的值作为基准元素pivot（分割点）
        int index = (int) Math.random() * (end - start) + start;
        // 将pivot交换到位置end上
        int tmp = data[index];
        data[index] = data[end];
        data[end] = tmp;

        // 保存小于pivot的最后一个元素的位置
        int small = start - 1;

        for (index = start; index < end; index++) {
            int cur = data[index];
            if (cur < data[end]) {
                small++;
                if (small != index) {
                    data[index] = data[small];
                    data[small] = cur;
                }
            }
        }

        // 此时small指向小于pivot的最后一个元素的下一个位置，即该元素的值大于pivot。
        small++;
        tmp = data[small];
        data[small] = data[end];
        data[end] = tmp;
        return small;
    }
}

