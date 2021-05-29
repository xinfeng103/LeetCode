### 解题思路
![image.png](https://pic.leetcode-cn.com/1621065183-RWQmin-image.png)
定义一个是否已经走过的boolean数组，dfs进去后，不满足题意的直接返回，满足的并且没走过就把boolean数组更新为走过了，然后再去dfs上下左右四个位置

### 代码

```java
class Solution {
    int result = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        dfs(used, 0, 0, m, n, k);
        return result;
    }
    public void dfs(boolean[][] used, int x, int y, int m, int n, int k){
        if(x < 0 || y < 0 || x >= m || y >= n || x / 10 + x % 10 + y / 10 + y % 10 > k) return;
        else if(!used[x][y]){
            result++;
            used[x][y] = true;
            dfs(used, x + 1, y, m, n, k);
            dfs(used, x - 1, y, m, n, k);
            dfs(used, x , y + 1, m, n, k);
            dfs(used, x , y - 1, m, n, k); 
 
        }
    }
}
```