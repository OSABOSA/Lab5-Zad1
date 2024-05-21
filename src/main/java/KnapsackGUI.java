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
    private JTextField seedField;
    private JTextField upperBoundField;
    private JTextField capacityField;
    private JButton solveButton;
    private JTextArea resultArea;

    private JTextArea resultArea2;

    public KnapsackGUI() {
        // Tworzenie głównej ramki
        frame = new JFrame("Knapsack Problem Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));

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
        panel.add(new JLabel("Seed:"), c);

        c.gridx = 1;
        seedField = new JTextField(10);
        panel.add(seedField, c);

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
        frame.getRootPane().setDefaultButton(solveButton);
        solveButton.setFocusable(false);
        panel.add(solveButton, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, c);


        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 6;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        resultArea2 = new JTextArea();
        resultArea2.setEditable(false);
        resultArea2.setFocusable(false);
        JScrollPane scrollPane2 = new JScrollPane(resultArea2);
        panel.add(scrollPane2, c);

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
        int capacity = Integer.parseInt(capacityField.getText());
        int seed = Integer.parseInt(seedField.getText());

        Problem problem = new Problem(numberOfItems, seed, 1, 10);
        var out = problem.Solve(capacity);
        resultArea.setText(out);
        resultArea2.setText(problem.toString());
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
