
//Palindrome Linked List leetcode Snapdeal
import java.util.Scanner;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.val != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(sc.nextInt());

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.println(isPalindrome(head));

        sc.close();
    }
}
//Intersection of Two Linked Lists leetcode
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
    }
}
//Reverse Nodes in Even Length Groupsleetcode
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    static ListNode reverseEvenLengthGroups(ListNode head) {
        return head;
    }

    public static void main(String[] args) {
    }
}
//Linked List Random Nodeleetcode
import java.util.ArrayList;
import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    ArrayList<Integer> list = new ArrayList<>();
    Random random = new Random();

    Solution(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

public class Main {
    public static void main(String[] args) {
    }
}
//Clone a linked list with next and random pointer GFG Google Flipkart
class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static Node cloneList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node cloneHead = head.next;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return cloneHead;
    }

    public static void main(String[] args) {
    }
}
