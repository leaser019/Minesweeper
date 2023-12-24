package view.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import view.GameFrame;
import view.GamePanel;

import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Font;

public class MenuView extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private ComingSoon comingSoon;
    private GameFrame gameWindow;
    private GamePanel gamePanel;

    public MenuView() {


        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\icon.png"));
        setTitle("Plants Vs Zombie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(805, 605);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
    }
}
