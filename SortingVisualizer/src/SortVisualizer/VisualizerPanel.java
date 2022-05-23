package SortVisualizer;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.ArrayList;

public class VisualizerPanel extends JPanel {

    Logic l;
    ArrayList<JPanel> lines = new ArrayList<>();
    GridBagLayout gl = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    FlowLayout fl = new FlowLayout();
    JFrame frame;
    Thread t;

    public VisualizerPanel(JFrame frame) throws IOException {
        this.frame = frame;
        this.setPreferredSize(new Dimension(1200, 300));
        this.setBackground(new Color(176, 230, 135));
        gc.insets = new Insets(0, 1, 0, 1);
        gc.anchor = GridBagConstraints.LAST_LINE_START;
        this.setLayout(gl);
        l = new Logic(this);
        drawArray(l.getLineArray());

        t = new Thread(new BubbleSort(l.getLineArray(), this));
        t.start();
    }

    public void drawArray(int[] arr) {
        this.removeAll();

        for (int i = 0 ; i < arr.length; i++) {
            JPanel tmp = new JPanel();
            tmp.setPreferredSize(new Dimension(5, arr[i] * 4));
            tmp.setBackground(Color.blue);
            this.add(tmp, gc);
        }
        this.repaint();
        this.revalidate();
    }


}
