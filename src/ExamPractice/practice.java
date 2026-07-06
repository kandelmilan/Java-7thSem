import javax.swing.*;
import java.awt.*;

public class practice {

    JFrame f;

    practice() {

        f = new JFrame("GridBagLayout Example");

        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");

        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Button 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(b1, gbc);

        // Button 2
        gbc.gridx = 1;
        gbc.gridy = 0;
        f.add(b2, gbc);

        // Button 3 (spans 2 columns)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        f.add(b3, gbc);

        // Button 4
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        f.add(b4, gbc);

        f.setSize(400, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new practice();
    }
}
//import javax.swing.*;
//
//public class practice {
//
//    JFrame f;
//    JTable table;
//
//    practice() {
//
//        f = new JFrame("JTable Example");
//
//        // Data (rows)
//        String[][] data = {
//            {"1", "Rajan", "A"},
//            {"2", "Sita", "A-"},
//            {"3", "Hari", "B+"}
//        };
//
//        // Column names
//        String[] columns = {"ID", "Name", "Grade"};
//
//        // JTable creation
//        table = new JTable(data, columns);
//
//        // Add table inside scroll pane
//        f.add(new JScrollPane(table));
//
//        f.setSize(400, 300);
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    public static void main(String[] args) {
//        new practice();
//    }
//}
//
////import javax.swing.*;
////import javax.swing.tree.*;
////
////public class practice {
////
////    JFrame f;
////    JTree tr;
////
////    DefaultMutableTreeNode root, fruit, food, apple, banana, momo, chowmin;
////
////    practice() {
////
////        f = new JFrame("JTree Improved");
////
////        // ROOT
////        root = new DefaultMutableTreeNode("Items");
////
////        // FRUIT branch
////        fruit = new DefaultMutableTreeNode("Fruit");
////        apple = new DefaultMutableTreeNode("Apple");
////        banana = new DefaultMutableTreeNode("Banana");
////
////        fruit.add(apple);
////        fruit.add(banana);
////
////        // FOOD branch
////        food = new DefaultMutableTreeNode("Food");
////        momo = new DefaultMutableTreeNode("MOMO");
////        chowmin = new DefaultMutableTreeNode("Chowmin");
////
////        food.add(momo);
////        food.add(chowmin);
////
////        // Attach to root
////        root.add(fruit);
////        root.add(food);
////
////        // CREATE TREE (IMPORTANT FIX)
////        tr = new JTree(root);
////
////        // ADD SCROLLABLE TREE
////        f.add(new JScrollPane(tr));
////
////        f.setSize(300, 300);
////        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        f.setVisible(true);
////    }
////
////    public static void main(String[] args) {
////        new practice();
////    }
////}
