
//Minimum Depth of Binary Tree leetcode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
//Sum of Left Leaves leetcode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}

//Logical OR of Two Binary Grids Represented as Quad-Trees leetcode
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }

        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        Node node = new Node();

        node.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        node.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        node.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        node.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (node.topLeft.isLeaf &&
            node.topRight.isLeaf &&
            node.bottomLeft.isLeaf &&
            node.bottomRight.isLeaf &&
            node.topLeft.val == node.topRight.val &&
            node.topLeft.val == node.bottomLeft.val &&
            node.topLeft.val == node.bottomRight.val) {

            return new Node(node.topLeft.val, true);
        }

        node.isLeaf = false;
        return node;
    }
}

//All Nodes Distance K in Binary Tree leetcode
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    Map<TreeNode, TreeNode> parent = new HashMap<>();

    void build(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }

        parent.put(node, par);
        build(node.left, node);
        build(node.right, node);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        build(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        while (!queue.isEmpty() && k-- > 0) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode curr = queue.poll();

                if (curr.left != null && visited.add(curr.left)) {
                    queue.offer(curr.left);
                }

                if (curr.right != null && visited.add(curr.right)) {
                    queue.offer(curr.right);
                }

                TreeNode p = parent.get(curr);

                if (p != null && visited.add(p)) {
                    queue.offer(p);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }

        return ans;
    }
}

//Count Number of Possible Root Nodes leetcode
import java.util.*;

class Solution {

    List<Integer>[] graph;
    Set<String> guessSet;
    int ans = 0;
    int k;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;

        this.k = k;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        guessSet = new HashSet<>();

        for (int[] g : guesses) {
            guessSet.add(g[0] + "," + g[1]);
        }

        int correct = dfs(0, -1);
        reroot(0, -1, correct);

        return ans;
    }

    int dfs(int node, int parent) {
        int count = 0;

        for (int next : graph[node]) {
            if (next != parent) {
                if (guessSet.contains(node + "," + next)) {
                    count++;
                }

                count += dfs(next, node);
            }
        }

        return count;
    }

    void reroot(int node, int parent, int count) {
        if (count >= k) {
            ans++;
        }

        for (int next : graph[node]) {
            if (next != parent) {
                int newCount = count;

                if (guessSet.contains(node + "," + next)) {
                    newCount--;
                }

                if (guessSet.contains(next + "," + node)) {
                    newCount++;
                }

                reroot(next, node, newCount);
            }
        }
    }
}

//Count Ways to Build Rooms in an Ant Colony leetcode
import java.util.*;

class Solution {

    static final int MOD = 1000000007;
    long[] fact;
    long[] invFact;
    List<Integer>[] tree;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[prevRoom[i]].add(i);
        }

        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        return (int) dfs(0)[1];
    }

    long[] dfs(int node) {
        int size = 1;
        long ways = 1;

        for (int child : tree[node]) {
            long[] res = dfs(child);

            int childSize = (int) res[0];

            ways = ways * res[1] % MOD;
            ways = ways * invFact[childSize] % MOD;

            size += childSize;
        }

        ways = ways * fact[size - 1] % MOD;

        return new long[]{size, ways};
    }

    long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }
}
