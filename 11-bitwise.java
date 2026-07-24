//Binary Number with Alternating Bits
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int prev = n & 1;
        n >>= 1;

        boolean alternating = true;

        while (n > 0) {
            int curr = n & 1;
            if (curr == prev) {
                alternating = false;
                break;
            }
            prev = curr;
            n >>= 1;
        }

        System.out.println(alternating);

        sc.close();
    }
}
//Prime Number of Set Bits in Binary Representation
import java.util.Scanner;

public class Main {

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int left = sc.nextInt();
        int right = sc.nextInt();

        int count = 0;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);

            if (isPrime(bits)) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}

//Minimum Number of Flips to onvert Binary Matrix to zero matrix
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] dir = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int start = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    start |= (1 << (i * n + j));
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[1 << (m * n)];

        q.offer(start);
        visited[start] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int state = q.poll();

                if (state == 0) {
                    System.out.println(steps);
                    sc.close();
                    return;
                }

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int next = state;

                        for (int[] d : dir) {
                            int r = i + d[0];
                            int c = j + d[1];

                            if (r >= 0 && r < m && c >= 0 && c < n) {
                                next ^= (1 << (r * n + c));
                            }
                        }

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }

            steps++;
        }

        System.out.println(-1);

        sc.close();
    }
}
//Minimum cost to connect two group of points
import java.util.Scanner;

public class Main {

    static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] cost = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int size = 1 << n;
        int[][] dp = new int[m + 1][size];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = INF;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int mask = 0; mask < size; mask++) {
                if (dp[i][mask] == INF) {
                    continue;
                }

                for (int j = 0; j < n; j++) {
                    int newMask = mask | (1 << j);
                    dp[i + 1][newMask] = Math.min(dp[i + 1][newMask], dp[i][mask] + cost[i][j]);
                }
            }
        }

        int ans = INF;

        for (int mask = 0; mask < size; mask++) {
            ans = Math.min(ans, dp[m][mask]);
        }

        System.out.println(ans);

        sc.close();
    }
}
//Find XOR Sum of All Pairs Bitwise AND
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        int xor1 = 0;
        int xor2 = 0;

        for (int x : arr1) {
            xor1 ^= x;
        }

        for (int x : arr2) {
            xor2 ^= x;
        }

        System.out.println(xor1 & xor2);

        sc.close();
    }
}
