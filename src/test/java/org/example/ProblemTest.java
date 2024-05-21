package org.example;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ProblemTest {

    @Test
    public void NumberCountTest() {
        Problem problem = new Problem(5, 1, 1, 10);
        assertEquals(5, problem.getItems().size());
    }

    @Test
    public void atLeastOneItemMeetsConstraints() {
        Problem problem = new Problem(5, 1, 1, 10);
        boolean found = problem.getItems().stream()
                .anyMatch(item -> item.getWeight() >= 1 && item.getWeight() <= 10 &&
                        item.getValue() >= 1 && item.getValue() <= 10);
        assertTrue(found);
    }

    @Test
    public void noItemMeetsConstraints() {
        Problem problem = new Problem(5, 1, 20, 30); // Items out of bounds
        boolean found = problem.getItems().stream()
                .noneMatch(item -> item.getWeight() >= 1 && item.getWeight() <= 10 &&
                        item.getValue() >= 1 && item.getValue() <= 10);
        assertTrue(found);
    }

    @Test
    public void itemsWithinBounds() {
        int lowerBound = 1;
        int upperBound = 10;
        Problem problem = new Problem(5, 1, lowerBound, upperBound);
        List<Item> items = problem.getItems();
        for (Item item : items) {
            assertTrue(item.getWeight() >= lowerBound && item.getWeight() <= upperBound);
            assertTrue(item.getValue() >= lowerBound && item.getValue() <= upperBound);
        }
    }

    @Test
    public void isSolveCorrect() {
        Problem problem = new Problem(4, 34, 1, 10);
        var ret = problem.Solve(44);
        var out = """
                No: 0 v: 6 w: 5
                No: 0 v: 6 w: 5
                No: 0 v: 6 w: 5
                No: 0 v: 6 w: 5
                No: 0 v: 6 w: 5
                No: 0 v: 6 w: 5
                No: 0 v: 6 w: 5
                No: 0 v: 6 w: 5
                No: 2 v: 3 w: 3
                """;
        assertEquals(ret, out);
    }
}
