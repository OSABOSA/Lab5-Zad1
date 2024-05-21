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
        sb.append("Problem with ").append(numberOfItems).append(" items:\n");
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
