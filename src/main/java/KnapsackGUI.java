import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Problem;
import org.example.Item;

public class KnapsackGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField numberOfItemsField;
    private JTextField lowerBoundField;
    private JTextField upperBoundField;
    private JTextField capacityField;
    private JButton solveButton;
    private JTextArea resultArea;

    public KnapsackGUI() {
        // Tworzenie głównej ramki
        frame = new JFrame("Knapsack Problem Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));

        // Tworzenie panelu głównego z GridBagLayout
        panel = new JPanel(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);

        // Konfiguracja GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Dodawanie komponentów do panelu
        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Number of Items:"), c);

        c.gridx = 1;
        numberOfItemsField = new JTextField(10);
        panel.add(numberOfItemsField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Lower Bound:"), c);

        c.gridx = 1;
        lowerBoundField = new JTextField(10);
        panel.add(lowerBoundField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Upper Bound:"), c);

        c.gridx = 1;
        upperBoundField = new JTextField(10);
        panel.add(upperBoundField, c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(new JLabel("Capacity:"), c);

        c.gridx = 1;
        capacityField = new JTextField(10);
        panel.add(capacityField, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        solveButton = new JButton("Solve");
        panel.add(solveButton, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, c);

        // Dodawanie ActionListener do przycisku
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveKnapsackProblem();
            }
        });

        // Pakowanie i wyświetlanie ramki
        frame.pack();
        frame.setVisible(true);
    }

    private void solveKnapsackProblem() {
        int numberOfItems = Integer.parseInt(numberOfItemsField.getText());
        int lowerBound = Integer.parseInt(lowerBoundField.getText());
        int upperBound = Integer.parseInt(upperBoundField.getText());
        int capacity = Integer.parseInt(capacityField.getText());

        Problem problem = new Problem(numberOfItems, System.currentTimeMillis(), lowerBound, upperBound);
        var out = problem.Solve(capacity);
        resultArea.setText(out);

//        StringBuilder resultBuilder = new StringBuilder();
//        for (Item item : problem.getItems()) {
//            resultBuilder.append(item).append("\n");
//        }
////        resultBuilder.append("Total value: ").append(problem.getTotalValue()).append("\n");
////        resultBuilder.append("Remaining capacity: ").append(problem.getRemainingCapacity()).append("\n");
//
//        resultArea.setText(resultBuilder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KnapsackGUI();
            }
        });
    }
}
