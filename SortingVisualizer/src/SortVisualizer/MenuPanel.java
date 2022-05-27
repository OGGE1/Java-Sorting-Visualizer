package SortVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class MenuPanel extends JPanel {

    private final String[] sortingAlgorithms = {"Bubble Sort", "Heap Sort", "Insertion Sort", "Merge Sort",
            "Quick Sort", "Radix Sort"};
    private final int[] sortingSpeed = {5, 10, 20, 50, 100, 200, 500, 1000};
    private final Hashtable<Integer, JLabel> sortingSpeedLabels = new Hashtable<>();

    private final JComboBox comboBox = new JComboBox(sortingAlgorithms);
    private final JSlider entrySlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 75);
    private final JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, sortingSpeed.length -1, 0);
    private final JButton startButton = new JButton("Start");
    private final JButton stopButton = new JButton("Stop/Clear");
    private final VisualizerPanel panel;

    public MenuPanel(VisualizerPanel panel) {
        this.panel = panel;
        this.setPreferredSize(new Dimension(1680, 100));
        this.setBackground(new Color(152, 156, 149));
        this.entrySlider.setPreferredSize(new Dimension(400, 50));
        this.entrySlider.setMinimum(0);
        this.entrySlider.setMaximum(200);
        this.entrySlider.setPaintLabels(true);
        this.entrySlider.setPaintTicks(true);
        this.entrySlider.setMajorTickSpacing(50);
        this.entrySlider.setMinorTickSpacing(10);

        this.sortingSpeedLabels.put(1, new JLabel("5"));
        this.sortingSpeedLabels.put(2, new JLabel("10"));
        this.sortingSpeedLabels.put(3, new JLabel("20"));
        this.sortingSpeedLabels.put(4, new JLabel("50"));
        this.sortingSpeedLabels.put(5, new JLabel("100"));
        this.sortingSpeedLabels.put(6, new JLabel("200"));
        this.sortingSpeedLabels.put(7, new JLabel("500"));
        this.sortingSpeedLabels.put(8, new JLabel("1000"));

        this.speedSlider.setPreferredSize(new Dimension(500, 50));
        this.speedSlider.setLabelTable(this.sortingSpeedLabels);
        this.speedSlider.setMinimum(1);
        this.speedSlider.setMaximum(8);
        this.speedSlider.setMajorTickSpacing(1);
        this.speedSlider.setPaintLabels(true);
        this.speedSlider.setPaintTicks(true);
        this.speedSlider.setSnapToTicks(true);
        this.add(comboBox);
        this.add(entrySlider);
        this.add(speedSlider);
        this.add(startButton);
        this.add(stopButton);
        this.setVisible(true);
        addActionListeners();
    }

    public void addActionListeners() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.run(sortingAlgorithms[comboBox.getSelectedIndex()], entrySlider.getValue(), getSpeed(speedSlider.getValue()));
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.stopThread();
                panel.clearScreen();
            }
        });
    }

    public int getSpeed(int value) {
        return switch (value) {
            case 1 -> 5;
            case 2 -> 10;
            case 3 -> 20;
            case 4 -> 50;
            case 5 -> 100;
            case 6 -> 200;
            case 7 -> 500;
            case 8 -> 1000;
            default -> 0;
        };

    }

}
