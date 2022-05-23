package SortVisualizer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VisualFrame extends JFrame {

    Logic l;

    public VisualFrame() throws IOException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1200, 500));
        this.setLayout(new BorderLayout());
        this.add(new MenuPanel(), BorderLayout.PAGE_START);
        this.add(new VisualizerPanel(this), BorderLayout.CENTER);
        //this.setResizable(false);
        this.setVisible(true);
    }

}
