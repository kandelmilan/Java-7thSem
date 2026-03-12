/*
 Write a Java progrma using swing component to demonstrate the concept of folllowing layout manager:
a.Flow Layout
b.Border Layout
c.Grid Layout
d.GridBag Layout
 */
package Lab3;
import javax.swing.*;
import java.awt.*;

public class lab3005 {

    public lab3005() {
        JFrame f = new JFrame("Layout Manager Demo");
        f.setSize(600, 400);
        f.setDefaultCloseOperation(3);

        JTabbedPane tabs = new JTabbedPane();

        // --------- Flow Layout ---------
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JButton("Button 1"));
        flowPanel.add(new JButton("Button 2"));
        flowPanel.add(new JButton("Button 3"));
        flowPanel.add(new JButton("Button 4"));
        tabs.add("Flow Layout", flowPanel);

        // --------- Border Layout ---------
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);
        tabs.add("Border Layout", borderPanel);

        // --------- Grid Layout ---------
        JPanel gridPanel = new JPanel(new GridLayout(2, 3, 10, 10)); // 2 rows, 3 cols, gap=10
        gridPanel.add(new JButton("1"));
        gridPanel.add(new JButton("2"));
        gridPanel.add(new JButton("3"));
        gridPanel.add(new JButton("4"));
        gridPanel.add(new JButton("5"));
        gridPanel.add(new JButton("6"));
        tabs.add("Grid Layout", gridPanel);

        // --------- GridBag Layout ---------
        JPanel gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);

        c.gridx = 0; c.gridy = 0;
        gridBagPanel.add(new JButton("Button 1"), c);

        c.gridx = 1; c.gridy = 0;
        gridBagPanel.add(new JButton("Button 2"), c);

        c.gridx = 0; c.gridy = 1; c.gridwidth = 2;
        gridBagPanel.add(new JButton("Button 3 (span 2 columns)"), c);

        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        gridBagPanel.add(new JButton("Button 4"), c);

        c.gridx = 1; c.gridy = 2;
        gridBagPanel.add(new JButton("Button 5"), c);

        tabs.add("GridBag Layout", gridBagPanel);

        f.add(tabs);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        
        new lab3005();
    }
}
