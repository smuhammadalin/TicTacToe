package sample;

import javax.swing.*;
import java.awt.*;

class View extends JFrame{
    JButton[] buttons;
    JLabel turn;

    public View(){
        this.turn = new JLabel("X");
        this.turn.setPreferredSize(new Dimension(500,50));
        this.turn.setFont(new Font("Arial", Font.PLAIN, 50));
        this.add(turn,BorderLayout.NORTH);
        this.turn.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        setVisible(true);
        setTitle("Tic Tac Toe");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.buttons = new JButton[9];
        for (int i = 0;i<this.buttons.length;i++) {
            this.buttons[i] = new JButton(" ");
            this.buttons[i].setPreferredSize(new Dimension(150,150));
            this.add(buttons[i]);
            this.buttons[i].setFont(new Font("Arial", Font.PLAIN, 100));
        }
    }

    public void changePlayer() {
        String newPlayer = null;
        if("X".equals(getCurrentPlayer())) {
            newPlayer = "O";
        } else if("O".equals(getCurrentPlayer())) {
            newPlayer = "X";
        }
        this.turn.setText(newPlayer);
    }

    public String getCurrentPlayer() {
        if("X".equals(this.turn.getText())) {
            return "X";
        } else if("O".equals(this.turn.getText())) {
            return "O";
        }
        return null;
    }

    public void win() {
        this.turn.setText(getCurrentPlayer() + " wins!");
        for(JButton button : this.buttons) {
            button.setEnabled(false);
        }
    }

    public void draw() {
        this.turn.setText("Draw");
    }
}