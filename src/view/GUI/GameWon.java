package view.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class GameWon extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        GameWon gw = new GameWon();
    }

    public GameWon() {
        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "img\\icon.png"));
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(805, 605);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("lib\\image\\gameWinner.png"));
    }
}
