//Armstrong Numbers
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int temp = n;
        int digits = 0;

        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = n;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        if (sum == n) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }

        sc.close();
    }
}
//Roman to Integer.
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));

            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
//Next Greater Element 
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
//Angle Between Hands of a Clock
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        double hourAngle = (hour % 12) * 30 + minute * 0.5;
        double minuteAngle = minute * 6;

        double angle = Math.abs(hourAngle - minuteAngle);

        angle = Math.min(angle, 360 - angle);

        System.out.println(angle);

        sc.close();
    }
}
//Number of Digit One
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long count = 0;

        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i;
            count += Math.min(Math.max(n % divider - i + 1, 0), i);
        }

        System.out.println(count);

        sc.close();
    }
}
