package SortVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private String[] sortingAlgorithms = {"Bubble Sort", "Heap Sort", "Insertion Sort", "Merge Sort"};

    private JComboBox comboBox = new JComboBox(sortingAlgorithms);
    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 150, 75);
    private JButton startButton = new JButton("Start");
    private VisualizerPanel panel;

    public MenuPanel(VisualizerPanel panel) {
        this.panel = panel;
        this.setPreferredSize(new Dimension(1200, 50));
        this.setBackground(new Color(152, 156, 149));
        this.add(new JButton("Knapp Ett"));
        this.slider.setPreferredSize(new Dimension(400, 50));
        this.slider.setMinimum(0);
        this.slider.setMaximum(150);
        this.slider.setPaintLabels(true);
        this.slider.setPaintTicks(true);
        this.slider.setMajorTickSpacing(15);
        this.add(comboBox);
        this.add(slider);
        this.add(startButton);
        this.setVisible(true);
        addActionListeners();
    }

    public void addActionListeners() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.run(sortingAlgorithms[comboBox.getSelectedIndex()], slider.getValue());
            }
        });
    }

}
