/*
Write a Java program to illustrate the following Swing component 
a.JfileChoose
b.Internal frames 
c.Jtable
d.JTree
 */
package lab4;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;

public class Q40004 implements ActionListener {

    JFrame f;
    JDesktopPane desktop;
    JMenuBar mb;
    JMenu menu;
    JMenuItem fileChooserItem;

    // Constructor
    Q40004() {
        f = new JFrame("Swing Components Demo");

        // Desktop Pane (for Internal Frames)
        desktop = new JDesktopPane();

        // Menu Bar
        mb = new JMenuBar();
        menu = new JMenu("File");
        fileChooserItem = new JMenuItem("Open File");

        fileChooserItem.addActionListener(this);

        menu.add(fileChooserItem);
        mb.add(menu);

        f.setJMenuBar(mb);

        // -------- Internal Frame 1: JTable --------
        JInternalFrame tableFrame = new JInternalFrame("Table", true, true, true, true);

        String data[][] = {
                {"1", "Ram", "Kathmandu"},
                {"2", "Sita", "Pokhara"},
                {"3", "Hari", "Lalitpur"}
        };

        String column[] = {"ID", "Name", "Address"};

        JTable table = new JTable(data, column);
        JScrollPane tableScroll = new JScrollPane(table);

        tableFrame.add(tableScroll);
        tableFrame.setSize(300, 150);
        tableFrame.setVisible(true);

        // -------- Internal Frame 2: JTree --------
        JInternalFrame treeFrame = new JInternalFrame("Tree", true, true, true, true);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Country");
        DefaultMutableTreeNode nepal = new DefaultMutableTreeNode("Nepal");
        DefaultMutableTreeNode india = new DefaultMutableTreeNode("India");

        root.add(nepal);
        root.add(india);

        nepal.add(new DefaultMutableTreeNode("Kathmandu"));
        nepal.add(new DefaultMutableTreeNode("Pokhara"));

        india.add(new DefaultMutableTreeNode("Delhi"));
        india.add(new DefaultMutableTreeNode("Mumbai"));

        JTree tree = new JTree(root);
        JScrollPane treeScroll = new JScrollPane(tree);

        treeFrame.add(treeScroll);
        treeFrame.setSize(200, 200);
        treeFrame.setVisible(true);

        // Add internal frames to desktop
        desktop.add(tableFrame);
        desktop.add(treeFrame);

        // Frame settings
        f.add(desktop);
        f.setSize(600, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFileChooser Event
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(f);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(f, "Selected File: " + file.getAbsolutePath());
        }
    }

    // Main Method
    public static void main(String[] args) {
        new Q40004();
    }
}