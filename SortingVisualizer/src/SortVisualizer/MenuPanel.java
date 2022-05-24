package SortVisualizer;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private String[] sortingAlgorithms = {"Bubble Sort, Heap Sort, Insertion Sort, Merge Sort"};
    private JComboBox comboBox = new JComboBox(sortingAlgorithms);

    public MenuPanel() {
        this.setPreferredSize(new Dimension(1200, 50));
        this.setBackground(new Color(152, 156, 149));
        this.add(new JButton("Knapp Ett"));
        this.add(comboBox);
        this.add(new JSlider());
        this.add(new JButton("Start"));
        this.setVisible(true);
    }

}
