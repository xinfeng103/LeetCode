### 📺 视频题解 
![面试题13. 机器人的运动范围.mp4](e6467d4b-26c4-4f19-b91d-26b0a342f3a1)

### 📖 文字题解

#### 方法一：广度优先搜索

**思路和算法**

我们将行坐标和列坐标数位之和大于 `k` 的格子看作障碍物，那么这道题就是一道很传统的搜索题目，我们可以使用广度优先搜索或者深度优先搜索来解决它，本文选择使用广度优先搜索的方法来讲解。

那么如何计算一个数的数位之和呢？我们只需要对数 `x` 每次对 `10` 取余，就能知道数 `x` 的个位数是多少，然后再将 `x` 除 `10`，这个操作等价于将 `x` 的十进制数向右移一位，删除个位数（类似于二进制中的 `>>` 右移运算符），不断重复直到 `x` 为 `0` 时结束。

同时这道题还有一个隐藏的优化：我们在搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索。如下图，我们展示了 `16 * 16` 的地图随着限制条件 `k` 的放大，可行方格的变化趋势，每个格子里的值为行坐标和列坐标的数位之和，蓝色方格代表非障碍方格，即其值小于等于当前的限制条件 `k`。我们可以发现随着限制条件 `k` 的增大，`(0, 0)` 所在的蓝色方格区域内新加入的非障碍方格都可以由上方或左方的格子移动一步得到。而其他不连通的蓝色方格区域会随着 `k` 的增大而连通，且连通的时候也是由上方或左方的格子移动一步得到，因此我们可以将我们的搜索方向缩减为向右或向下。

 ![1.JPG](https://pic.leetcode-cn.com/6c80ef7224efa9a8f3589afdc83681fa50b2b231ad5f188ff2e5a92d4a6db47c-%E5%B9%BB%E7%81%AF%E7%89%871.JPG) ![2.JPG](https://pic.leetcode-cn.com/a5addecac64254ee7f899819d5c4e65117b786c747975de1d2d9cd2f309aab92-%E5%B9%BB%E7%81%AF%E7%89%872.JPG) ![3.JPG](https://pic.leetcode-cn.com/7eab5519c96fef9d4b06a413d9ad4ab18dc47012c0db0b9b60947f60229bb8e1-%E5%B9%BB%E7%81%AF%E7%89%873.JPG) ![4.JPG](https://pic.leetcode-cn.com/103c2cc71fde196f82e8f4f57397a88775588b4b15d5e0179174a7cc82da2aea-%E5%B9%BB%E7%81%AF%E7%89%874.JPG) ![5.JPG](https://pic.leetcode-cn.com/137722bcc28f3f640597a427855e3760cd3d437a7a84f34578abb2c0bab6e331-%E5%B9%BB%E7%81%AF%E7%89%875.JPG) ![6.JPG](https://pic.leetcode-cn.com/e26b7cb04cea2dc00c0285008ef409bfdc6569e1c603340d065fc37b80e85bf0-%E5%B9%BB%E7%81%AF%E7%89%876.JPG) ![7.JPG](https://pic.leetcode-cn.com/eb360a76b26e583f23a5c8743c6f398f84be3d292d17179327f8c57ddab784b0-%E5%B9%BB%E7%81%AF%E7%89%877.JPG) ![8.JPG](https://pic.leetcode-cn.com/858d08887e25e9f3503e28ad5b3d2e0fafdf8b69c0b534f8e222662acc8eb00e-%E5%B9%BB%E7%81%AF%E7%89%878.JPG) ![9.JPG](https://pic.leetcode-cn.com/20e6c066e9e692646035d87cf1b11c415c6ac5940bbaf37a70d3470cbe3cd5f1-%E5%B9%BB%E7%81%AF%E7%89%879.JPG) ![10.JPG](https://pic.leetcode-cn.com/2019c08d97a5868606aa510808d9b1c147e484f95e3ee90819dd118387dcb4e4-%E5%B9%BB%E7%81%AF%E7%89%8710.JPG) ![11.JPG](https://pic.leetcode-cn.com/4bb1c245fa8fe7b198afcefb8810b8bed5f764ad67f5c7a54b05663854f765f1-%E5%B9%BB%E7%81%AF%E7%89%8711.JPG) ![12.JPG](https://pic.leetcode-cn.com/14979dd0f8fd3ec17534b40a045ab11bf1dd091b162f4e3a969b05a2e7e9ddd7-%E5%B9%BB%E7%81%AF%E7%89%8712.JPG) ![13.JPG](https://pic.leetcode-cn.com/b9bc2e2a3fa00e833af400d03e18e5943379ca83083712c30e4b7a1475980b22-%E5%B9%BB%E7%81%AF%E7%89%8713.JPG) ![14.JPG](https://pic.leetcode-cn.com/091ef7500dc339c58501425ef07e3f7aca4f3c94ef0db088b8fb70421ad7999f-%E5%B9%BB%E7%81%AF%E7%89%8714.JPG) ![15.JPG](https://pic.leetcode-cn.com/beecfe15fc0274544927c091f87960a8348279007a95afda7e4f2fdca0d5d41e-%E5%B9%BB%E7%81%AF%E7%89%8715.JPG) ![16.JPG](https://pic.leetcode-cn.com/a411d617481f8d07524856ce48be3e2313247b1b5d4d86048e365b2f1c28cd4b-%E5%B9%BB%E7%81%AF%E7%89%8716.JPG) ![17.JPG](https://pic.leetcode-cn.com/efe911f7e9485c4d47367344e9d4ffc36da6fff9975f6b7f4d6bda8cda723b5d-%E5%B9%BB%E7%81%AF%E7%89%8717.JPG) ![18.JPG](https://pic.leetcode-cn.com/75deefae1c4f7bbeb82c8ee1d61c3726ca18f26018d6e8ffdbcb24b20a79a2bf-%E5%B9%BB%E7%81%AF%E7%89%8718.JPG) ![19.JPG](https://pic.leetcode-cn.com/e2a18a98608616eb5ba81b853854a2e51267ef8f20a6ed1f6bf6e2bf4a259283-%E5%B9%BB%E7%81%AF%E7%89%8719.JPG) 

```C++ [sol1-C++]
class Solution {
    // 计算 x 的数位之和
    int get(int x) {
        int res=0;
        for (; x; x /= 10) {
            res += x % 10;
        }
        return res;
    }
public:
    int movingCount(int m, int n, int k) {
        if (!k) return 1;
        queue<pair<int,int> > Q;
        // 向右和向下的方向数组
        int dx[2] = {0, 1};
        int dy[2] = {1, 0};
        vector<vector<int> > vis(m, vector<int>(n, 0));
        Q.push(make_pair(0, 0));
        vis[0][0] = 1;
        int ans = 1;
        while (!Q.empty()) {
            auto [x, y] = Q.front();
            Q.pop();
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) continue;
                Q.push(make_pair(tx, ty));
                vis[tx][ty] = 1;
                ans++;
            }
        }
        return ans;
    }
};
```
```Java [sol1-Java]
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
```
```Python [sol1-Python3]
def digitsum(n):
    ans = 0
    while n:
        ans += n % 10
        n //= 10
    return ans

class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        from queue import Queue
        q = Queue()
        q.put((0, 0))
        s = set()
        while not q.empty():
            x, y = q.get()
            if (x, y) not in s and 0 <= x < m and 0 <= y < n and digitsum(x) + digitsum(y) <= k:
                s.add((x, y))
                for nx, ny in [(x + 1, y), (x, y + 1)]:
                    q.put((nx, ny))
        return len(s)
```

**复杂度分析**

- 时间复杂度：*O(mn)*，其中 `m` 为方格的行数，`n` 为方格的列数。考虑所有格子都能进入，那么搜索的时候一个格子最多会被访问的次数为常数，所以时间复杂度为 *O(2mn)=O(mn)*。

- 空间复杂度：*O(mn)*，其中 `m` 为方格的行数，`n` 为方格的列数。搜索的时候需要一个大小为 *O(mn)* 的标记结构用来标记每个格子是否被走过。

#### 方法二：递推

**思路**

考虑到方法一提到搜索的方向只需要朝下或朝右，我们可以得出一种递推的求解方法。

**算法**

定义 `vis[i][j]` 为 `(i, j)` 坐标是否可达，如果可达返回 `1`，否则返回 `0`。

首先 `(i, j)` 本身需要可以进入，因此需要先判断 `i` 和 `j` 的数位之和是否大于 `k` ，如果大于的话直接设置 `vis[i][j]` 为不可达即可。

否则，前面提到搜索方向只需朝下或朝右，因此 `(i, j)` 的格子只会从 `(i - 1, j)` 或者 `(i, j - 1)` 两个格子走过来（不考虑边界条件），那么 `vis[i][j]` 是否可达的状态则可由如下公式计算得到：
![\textit{vis}\[i\]\[j\]=\textit{vis}\[i-1\]\[j\]\\textrm{or}\\textit{vis}\[i\]\[j-1\] ](./p___textit{vis}_i__j_=textit{vis}_i-1__j__textrm{or}_textit{vis}_i__j-1___.png) 
即只要有一个格子可达，那么 `(i, j)` 这个格子就是可达的，因此我们只要遍历所有格子，递推计算出它们是否可达然后用变量 `ans` 记录可达的格子数量即可。

初始条件 `vis[i][j] = 1` ，递推计算的过程中注意边界的处理。

```C++ [sol2-C++]
class Solution {
    int get(int x) {
        int res=0;
        for (; x; x /= 10){
            res += x % 10;
        }
        return res;
    }
public:
    int movingCount(int m, int n, int k) {
        if (!k) return 1;
        vector<vector<int> > vis(m, vector<int>(n, 0));
        int ans = 1;
        vis[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) continue;
                // 边界判断
                if (i - 1 >= 0) vis[i][j] |= vis[i - 1][j];
                if (j - 1 >= 0) vis[i][j] |= vis[i][j - 1];
                ans += vis[i][j];
            }
        }
        return ans;
    }
};
```
```Java [sol2-Java]
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
```
```Python [sol2-Python3]
def digitsum(n):
    ans = 0
    while n:
        ans += n % 10
        n //= 10
    return ans

class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        vis = set([(0, 0)])
        for i in range(m):
            for j in range(n):
                if ((i - 1, j) in vis or (i, j - 1) in vis) and digitsum(i) + digitsum(j) <= k:
                    vis.add((i, j))
        return len(vis)
```

**复杂度分析**

- 时间复杂度：*O(mn)*，其中 `m` 为方格的行数， `n` 为方格的列数。一共有 *O(mn)* 个状态需要计算，每个状态递推计算的时间复杂度为 *O(1)*，所以总时间复杂度为 *O(mn)*。

- 空间复杂度：*O(mn)*，其中 `m`  为方格的行数，`n` 为方格的列数。我们需要 *O(mn)* 大小的结构来记录每个位置是否可达。