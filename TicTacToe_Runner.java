package TicTacToe;

import javax.swing.*;

public class TicTacToe_Runner {

    public static void main(String[] args) {
	// write your code here
        JFrame window = new JFrame("TicTacToe with a UX");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe_GUI());
        window.setBounds(500,500,500,500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}
