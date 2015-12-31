package poke;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RemoveCardListener implements ActionListener {
    Deck deck;
    MainView mainView;
    int cardIndex;


    RemoveCardListener(Deck deck, MainView mainView, int cardIndex) {
        this.deck = deck;
        this.mainView = mainView;
        this.cardIndex = cardIndex;
    }

    public void actionPerformed(ActionEvent e) {
        this.deck.removeCard(this.cardIndex);

        this.mainView.getContentPane().removeAll();
        this.mainView.add(new ViewCards(this.deck, this.mainView));
        this.mainView.revalidate();
        this.mainView.repaint();
    }
}
