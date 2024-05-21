package org.example;
import java.util.*;





public class Main {
    public static void main(String[] args) {
        // Tworzymy problem z 5 przedmiotami, ziarnem losowania 123,
        // dolnym zakresem losowania 1 i górnym zakresem losowania 10

        // Wyświetlamy problem

        // while not pressed q

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give 0 to exit");
        while (scanner.nextInt() != 0) {
            System.out.println("Give number of items: ");
            int numberOfItems = scanner.nextInt();
            System.out.println("Give seed: ");
            long seed = scanner.nextLong();
            System.out.println("Give knapsack capacity: ");
            int capacity = scanner.nextInt();

            Problem problem = new Problem(numberOfItems, seed, 1, 10);

            System.out.println(problem);

            // Rozwiązujemy problem algorytmem zachłannym
            System.out.println(problem.Solve(capacity));
        }

    }
}
