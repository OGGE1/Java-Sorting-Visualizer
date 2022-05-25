package SortVisualizer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VisualFrame extends JFrame {

    private VisualizerPanel visualizerPanel;
    private MenuPanel menuPanel;

    public VisualFrame() throws IOException {
        this.visualizerPanel = new VisualizerPanel(this);
        this.menuPanel = new MenuPanel(this.visualizerPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1920, 1080));
        this.setLayout(new BorderLayout());
        this.add(visualizerPanel, BorderLayout.CENTER);
        this.add(menuPanel, BorderLayout.PAGE_START);
        //this.setResizable(false);
        this.setVisible(true);
    }

}
