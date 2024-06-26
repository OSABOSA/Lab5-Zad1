package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    private int numberOfItems;
    private Random randomGenerator;
    private int lowerBound;
    private int upperBound;
    private List<Item> items;

    public Problem(int numberOfItems, long seed, int lowerBound, int upperBound) {
        this.numberOfItems = numberOfItems;
        this.randomGenerator = new Random(seed);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.items = generateItems();
    }

    public List<Item> getItems() {
        return items;
    }

    private List<Item> generateItems() {
        List<Item> generatedItems = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            int weight = randomGenerator.nextInt(upperBound - lowerBound) + lowerBound;
            int value = randomGenerator.nextInt(upperBound - lowerBound) + lowerBound;
            Item item = new Item(weight, value, i);
            generatedItems.add(item);
        }
        return generatedItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item);
        }
        return sb.toString();
    }

    public String Solve(int capacity) {
        var out = "";
        //i want _ items to be a copy of items
        List<Item> _items = new ArrayList<>(items);
        _items.sort((item1, item2) -> {
            double ratio1 = (double) item1.getValue() / item1.getWeight();
            double ratio2 = (double) item2.getValue() / item2.getWeight();
            return Double.compare(ratio2, ratio1);
        });

        int value = 0;

        while (capacity > 0) {
            Item item = _items.get(0);
            if (item.getWeight() <= capacity) {
                capacity -= item.getWeight();
                value += item.getValue();
                out += item;
            } else {
                _items.remove(0);
                if (_items.isEmpty()) {
                    break;
                }
            }
        }
        System.out.println("Total value: " + value + "\nEmpty space: " + capacity);
        return out;
    }
}
