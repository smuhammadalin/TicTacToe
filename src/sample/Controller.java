package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

public class Controller implements ActionListener{
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        for (JButton button : view.buttons) {
            button.addActionListener(this);
        }
    }

    private boolean result(Integer field, String value) {
        model.choice(field, value);
        if(model.moves >= 5) {
            if(model.checkBoard()) {
                view.win();
                return true;
            }
            if(model.moves >= 9) {
                view.draw();
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentPlayer = view.getCurrentPlayer();
        Integer index = Arrays.asList(view.buttons).indexOf((JButton)e.getSource());
        ((JButton) e.getSource()).setText(view.getCurrentPlayer());
        ((JButton) e.getSource()).setEnabled(false);
        if(!result(index, currentPlayer)) view.changePlayer();
    }
}