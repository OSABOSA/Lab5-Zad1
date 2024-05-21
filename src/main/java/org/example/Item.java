package org.example;

public class Item {
    private int weight;
    private int value;

    private int index;

    public Item(int weight, int value, int i) {
        this.weight = weight;
        this.value = value;
        this.index = i;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() { return index; }

    @Override
    public String toString() {
        return "No: " + index + " v: " + value + " w: " + weight + "\n";
    }
}
