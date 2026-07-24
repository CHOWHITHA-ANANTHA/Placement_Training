//Check If N and Its Double Exist
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        System.out.println(found);

        sc.close();
    }
}
//Special Array With X Elements Greater Than or Equal X
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = -1;

        for (int x = 0; x <= n; x++) {
            int count = 0;

            for (int num : arr) {
                if (num >= x) {
                    count++;
                }
            }

            if (count == x) {
                answer = x;
                break;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}

//Frequency of the Most Frequent Element
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int maxFreq = 1;
        int freq = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                freq++;
            } else {
                maxFreq = Math.max(maxFreq, freq);
                freq = 1;
            }
        }

        maxFreq = Math.max(maxFreq, freq);

        System.out.println(maxFreq);

        sc.close();
    }
}
//Find the Duplicate Number
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int duplicate = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = arr[i];
                    break;
                }
            }
            if (duplicate != -1) {
                break;
            }
        }

        System.out.println(duplicate);

        sc.close();
    }
}
  //Median of Two Sorted Arrays
import java.util.Arrays;
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

        int[] merged = new int[n1 + n2];

        for (int i = 0; i < n1; i++) {
            merged[i] = arr1[i];
        }

        for (int i = 0; i < n2; i++) {
            merged[n1 + i] = arr2[i];
        }

        Arrays.sort(merged);

        int len = merged.length;

        if (len % 2 == 0) {
            double median = (merged[len / 2] + merged[len / 2 - 1]) / 2.0;
            System.out.println(median);
        } else {
            System.out.println(merged[len / 2]);
        }

        sc.close();
    }
}
