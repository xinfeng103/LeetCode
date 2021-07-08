package sortAndSearch.sortPractice_1;

import java.util.Arrays;

// 小根堆
public class Heap {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1};
        System.out.println(Arrays.toString(heapSort(arr)));
    }

    public static int[] heapSort(int[] arr) {
        int n = arr.length;
        // 保存排序的结果
        int[] res = new int[n];
        // 构建堆
        arr = buildHead(arr);
        // 每次取堆顶元素，即最小值；将堆顶元素删除（交换到最后面）；调整堆（下沉）
        for (int i = 0; i < n; i++) {
            res[i] = arr[0];
            arr[0] = arr[n - 1 - i];
            downAdjust(arr, 0, n - i - 1);
        }
        return res;
    }

    /**
     * 下沉操作，执行删除操作相当于把最后一个元素赋值给根元素，然后对根元素执行下沉操作
     *
     * @param arr
     * @param parent：要下沉的元素的下标
     * @return
     */
    public static int[] downAdjust(int[] arr, int parent, int length) {
        // 临时保存要下沉的元素
        int tmp = arr[parent];
        // 定位左孩子节点位置
        int child = 2 * parent + 1;
        // 开始下沉
        while (child < length) {
            //左右孩子比较
            if (child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }
            if (tmp <= arr[child])
                break;
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = tmp;
        return arr;
    }

    public static int[] buildHead(int[] arr) {
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            arr = downAdjust(arr, i, length);
        }
        return arr;
    }

    /**
     * 上浮操作，对插入的节点进行上浮，堆排序中没用到这个
     *
     * @param arr：保存二叉堆（二叉树一般用链表存储，二叉堆用数组存储）
     * @param length：表示二叉堆的长度
     * @return
     */
    public static int[] upAdjust(int[] arr, int length, int insertVal) {
        int[] newArr;
        newArr = Arrays.copyOf(arr, length + 1);
        newArr[length] = insertVal;
        //标记插入的节点,新插入元素的位置永远是最后一个位置
        int child = length;
        //其父节点
        int parent = (child - 1) / 2;
        // 进行上浮
        while (child > 0 && insertVal < arr[parent]) {
            newArr[child] = newArr[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        newArr[child] = insertVal;
        return newArr;
    }

}
