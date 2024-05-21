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
            knapsack(problem, capacity);
        }

    }

    public static void knapsack(Problem problem, int capacity) {
        List<Item> items = problem.getItems();
        items.sort((item1, item2) -> {
            double ratio1 = (double) item1.getValue() / item1.getWeight();
            double ratio2 = (double) item2.getValue() / item2.getWeight();
            return Double.compare(ratio2, ratio1);
        });
        // items can be used infinitely

        int value = 0;

        while (capacity > 0) {
            Item item = items.get(0);
            if (item.getWeight() <= capacity) {
                capacity -= item.getWeight();
                value += item.getValue();
                System.out.println("Added item: " + item + " empty space: " + capacity);
            } else {
                items.remove(0);
                if (items.isEmpty()) {
                    break;
                }
            }
        }

        System.out.println("Total value: " + value + "\nEmpty space: " + capacity);


    }
}
