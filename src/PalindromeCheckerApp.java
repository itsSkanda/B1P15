import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    public static boolean checkUsingArray(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean checkUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkUsingDeque(String input) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   Palindrome Checker App");
        System.out.println("   Version 1.0");
        System.out.println("=================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        long start1 = System.nanoTime();
        boolean result1 = checkUsingArray(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = checkUsingStack(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = checkUsingDeque(input);
        long end3 = System.nanoTime();

        System.out.println("Array Method Result: " + result1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Stack Method Result: " + result2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Deque Method Result: " + result3 + " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}
