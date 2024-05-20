package TicTacToe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe_GUI extends JPanel {

    String player_1Mark = "X";
    JButton[] buttons = new JButton[9];

    public TicTacToe_GUI(){
        setLayout(new GridLayout(3,3));
        initializeButtons();

    }

    //method creating the buttons and activating their attributes

    public void initializeButtons(){

        for(int i = 0; i <=8; i++){

            buttons[i] = new JButton();
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent y){
                    JButton pressedButton = (JButton) y.getSource();
                    pressedButton.setText(String.valueOf(player_1Mark));

                    if(player_1Mark == "X"){
                        player_1Mark = "O";
                        pressedButton.setBackground(Color.MAGENTA);
                    }
                    else{
                        player_1Mark = "X";
                        pressedButton.setBackground(Color.GREEN);
                    }

                    displayWinner();
                }
            });
            add(buttons[i]);
        }
    }

    public void displayWinner(){

        if(winnerChecker() == true){
            //reverse the marks of the players as when x wins, the computer will display o so this needs to be rectified
            if(player_1Mark == "X") player_1Mark = "O";
            else player_1Mark = "X";

            JOptionPane pane = new JOptionPane();
            int WinnerPopUp = JOptionPane.showConfirmDialog(pane, "Game Over: "+ player_1Mark +" wins. Would you like to play again ?", "Game Over.", JOptionPane.YES_NO_OPTION);

            if(WinnerPopUp == JOptionPane.YES_OPTION) buttonReset();
            else System.exit(0);

        }

        else if(drawCheck()){
            JOptionPane pane2 = new JOptionPane();
            int drawPopUp = JOptionPane.showConfirmDialog(pane2, "Draw. Would you like another shot ?", "Game over.", JOptionPane.YES_NO_OPTION);

            if(drawPopUp == JOptionPane.YES_OPTION) buttonReset();
            else System.exit(0);
        }
    }

    private void buttonReset(){
        for(int i = 0; i <9; i++){
            player_1Mark = "X";
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
        }

    }

    public boolean drawCheck(){
        boolean complete = true;
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText().charAt(0) == '-'){
                complete = false;
            }
        }
        return complete;
    }

    public boolean winnerChecker(){

        if(rowCheck() == true || columnCheck() == true || diagonalCheck() == true){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean rowCheck(){
        int i = 0;
        for(int j = 0; j < 3; j++){
            if(buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && buttons[i].getText() != "-"){
                return true;
            }
            i+=3;
        }
        return false;
    }

    public boolean columnCheck() {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) && buttons[i].getText().equals(buttons[i + 6].getText()) && buttons[i].getText() != "-") {
                return true;
            }
        }

        return false;
    }

    public boolean diagonalCheck() {
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && buttons[0].getText() == "-") {
            return true;
        } else if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && buttons[0].getText() != "-") {
            return false;
        } else {
            return false;
        }
    }


}
