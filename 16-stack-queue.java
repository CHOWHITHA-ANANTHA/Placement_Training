
//Remove Outermost Parentheses leetcode
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    ans.append(ch);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    ans.append(ch);
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
//Remove All Adjacent Duplicates In String leetcode
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        System.out.println(ans);

        sc.close();
    }
}
//Find the Most Competitive Subsequence leetcode
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                    stack.peek() > nums[i] &&
                    stack.size() - 1 + (n - i) >= k) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        for (int x : stack) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}

//Design Front Middle Back Queue leetcode
import java.util.LinkedList;

class FrontMiddleBackQueue {

    LinkedList<Integer> list = new LinkedList<>();

    public void pushFront(int val) {
        list.addFirst(val);
    }

    public void pushMiddle(int val) {
        list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        list.addLast(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.removeFirst();
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove((list.size() - 1) / 2);
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.removeLast();
    }
}

public class Main {
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();

        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);

        System.out.println(q.popMiddle());
        System.out.println(q.popFront());
        System.out.println(q.popBack());
    }
}
//Minimum steps to reach target by a Knight GFG
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
    int x;
    int y;
    int dist;

    Cell(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int sx = sc.nextInt() - 1;
        int sy = sc.nextInt() - 1;

        int tx = sc.nextInt() - 1;
        int ty = sc.nextInt() - 1;

        boolean[][] visited = new boolean[N][N];
        Queue<Cell> queue = new LinkedList<>();

        queue.offer(new Cell(sx, sy, 0));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            if (curr.x == tx && curr.y == ty) {
                System.out.println(curr.dist);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Cell(nx, ny, curr.dist + 1));
                }
            }
        }

        System.out.println(-1);

        sc.close();
    }
}
