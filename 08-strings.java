
//Decrypt String from Alphabet to Integer Mapping
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length();) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                result.append((char) ('a' + num - 1));
                i += 3;
            } else {
                int num = s.charAt(i) - '0';
                result.append((char) ('a' + num - 1));
                i++;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
//Number of Strings That Appear as Substrings in Word
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] patterns = new String[n];

        for (int i = 0; i < n; i++) {
            patterns[i] = sc.next();
        }

        String word = sc.next();

        int count = 0;

        for (String s : patterns) {
            if (word.contains(s)) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}

  
//Number of Substrings With Only 1s
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        long count = 0;
        long ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
                count += ones;
            } else {
                ones = 0;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
//Count Number of Homogenous Substrings
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        long count = 0;
        long len = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                count += len * (len + 1) / 2;
                len = 1;
            }
        }

        count += len * (len + 1) / 2;

        System.out.println(count);

        sc.close();
    }
}
  
//Minimum Number of Operations to Make String Sorted
import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        long operations = 0;

        for (int i = 0; i < s.length(); i++) {
            int smaller = 0;

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) < s.charAt(i)) {
                    smaller++;
                }
            }

            operations = (operations + smaller * factorial(s.length() - i - 1)) % MOD;
        }

        System.out.println(operations);

        sc.close();
    }
}
