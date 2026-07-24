
//Sum of digit of a number using Recursion GFG
import java.util.Scanner;

public class Main {

    static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sumOfDigits(n));

        sc.close();
    }
}
//Product of two numbers using Recursion GFG
import java.util.Scanner;

public class Main {

    static int product(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a + product(a, b - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(product(a, b));

        sc.close();
    }
}
//N Digit numbers with digits in increasing order GFG
import java.util.Scanner;

public class Main {

    static void generate(int start, int n, String result) {
        if (result.length() == n) {
            System.out.println(result);
            return;
        }

        for (int i = start; i <= 9; i++) {
            generate(i + 1, n, result + i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        generate(1, n, "");

        sc.close();
    }
}
//Minimum Non-Zero Product of the Array Elements leetcode
import java.util.Scanner;

public class Main {

    static final long MOD = 1000000007;

    static long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        long max = (1L << p) - 1;
        long second = max - 1;
        long exp = (1L << (p - 1)) - 1;

        long ans = (power(second, exp) * (max % MOD)) % MOD;

        System.out.println(ans);

        sc.close();
    }
}

//Permutation Sequence leetcode
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i - 1];
        }

        System.out.println(result);

        sc.close();
    }
}
