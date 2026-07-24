//3. Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double p = sc.nextDouble();
        double t = sc.nextDouble();
        double r = sc.nextDouble();

        double si = (p * t * r) / 100;

        System.out.println(si);

        sc.close();
    }
}



//4.Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        char op = sc.next().charAt(0);

        if (op == '+') {
            System.out.println(a + b);
        } else if (op == '-') {
            System.out.println(a - b);
        } else if (op == '*') {
            System.out.println(a * b);
        } else if (op == '/') {
            if (b != 0) {
                System.out.println(a / b);
            } else {
                System.out.println("Division by zero not possible");
            }
        } else {
            System.out.println("Invalid Operator");
        }

        sc.close();
    }
}




//5. Take 2 numbers as input and print the largest number.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }

        sc.close();
    }
}






//6. Input currency in rupees and output in USD.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double rupees = sc.nextDouble();

        double usd = rupees / 83.5;

        System.out.println(usd);

        sc.close();
    }
}

