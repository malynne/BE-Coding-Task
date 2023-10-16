// Maria Lynne Camacho Padilla
// 15 - Oct - 2023

import java.util.Scanner;
import java.lang.Math;

/*
 * Constraints:
 * 3 <= X <= 10^7
 * 1 <= Y <= 2 * 10^5
 * 1 <= left <= right <= X
 * 0 <= k <= 10^9
 *
 * Sample Input:
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 *
 * Sample Output:
 * 200
 */

// Complexity: O(n^2)
// This solution is not optimal, but it works for small inputs

public class MaxValueInList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt(); // Size of the list
        int Y = scanner.nextInt(); // Number of operations

        if(X < 3 || X > Math.pow(10, 7)) {
            System.out.println("X is out of bounds");
            return;
        }

        if(Y < 1 || Y > 2 * Math.pow(10, 5)) {
            System.out.println("Y is out of bounds");
            return;
        }

        int[] list = new int[X]; // Initialize the list

        for (int i = 0; i < Y; i++) {
            int left = scanner.nextInt() - 1; // Adjust for 0-based indexing
            int right = scanner.nextInt() - 1; // Adjust for 0-based indexing
            int k = scanner.nextInt();

            if(left < 0 || left > X || right > X) {
                System.out.println("Left is out of bounds");
                return;
            }

            if(right < 0 ) {
                System.out.println("Right is out of bounds");
                return;
            }

            if(k < 0 || k > Math.pow(10, 9)) {
                System.out.println("K is out of bounds");
                return;
            }

            // Update the list
            for (int j = left; j <= right; j++) {
                list[j] += k;
            }
        }

        int max = Integer.MIN_VALUE;

        // Find the maximum value in the list
        for (int value : list) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println(max);
    }
}
