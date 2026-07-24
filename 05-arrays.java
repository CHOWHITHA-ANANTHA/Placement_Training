//15. Matrix Diagonal Sum
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            if (i != n - 1 - i) {
                sum += matrix[i][n - 1 - i];
            }
        }

        System.out.println(sum);

        sc.close();
    }
}
//16. Find Numbers with Even Number of Digits
import java.util.Scanner;

public class Main {

    static int countDigits(int n) {
        n = Math.abs(n);

        if (n == 0) {
            return 1;
        }

        int count = 0;

        while (n > 0) {
            count++;
            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        for (int num : arr) {
            if (countDigits(num) % 2 == 0) {
                result++;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
//Find First and Last Position of Element in Sorted Array
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int first = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        System.out.println(first + " " + last);

        sc.close();
    }
}
//Rotate Array
import java.util.Scanner;

public class Main {

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
// Max Value of Equation
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int max = Math.max(
                Math.max(x + y + z, x * y * z),
                Math.max(
                        Math.max((x + y) * z, x * (y + z)),
                        Math.max(x + y * z, x * y + z)
                )
        );

        System.out.println(max);

        sc.close();
    }
}
