/*
Write a java program to create Menu and menu item with Accelerator and mnemonics.
And handle appropriate event when menu item is clicked.
 */
package lab4;

import javax.swing.*;
import java.awt.event.*;

public class Q40002 implements ActionListener {

    JFrame f;
    JMenuBar mb;
    JMenu fileMenu;
    JMenuItem openItem, saveItem, exitItem;

    // Constructor
    Q40002() {
        f = new JFrame("Menu Example");

        // Menu Bar
        mb = new JMenuBar();

        // Menu
        fileMenu = new JMenu("File");

        // Mnemonic (Alt + F)
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // Menu Items
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        // Mnemonics (Alt + O, S, E)
        openItem.setMnemonic(KeyEvent.VK_O);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        // Accelerators (Ctrl + O, S, E)
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));

        // Add Action Listener
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        // Add items to menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Add menu to menu bar
        mb.add(fileMenu);

        // Set menu bar to frame
        f.setJMenuBar(mb);

        // Frame settings
        f.setSize(400, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            JOptionPane.showMessageDialog(f, "Open clicked");
        } else if (e.getSource() == saveItem) {
            JOptionPane.showMessageDialog(f, "Save clicked");
        } else if (e.getSource() == exitItem) {
            JOptionPane.showMessageDialog(f, "Exiting...");
            System.exit(0);
        }
    }

    // Main Method
    public static void main(String[] args) {
        new Q40002();
    }
}