package poke;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener<deck> implements ActionListener {
    public MainView mainView;
    public Deck deck;

    public MenuListener(Deck deck, MainView mainView) {
        this.deck = deck;
        this.mainView = mainView;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case ("New Card"):
                this.mainView.getContentPane().remove(0);
                new CreateCardView(this.deck, this.mainView, 0);

                break;

            case ("Show All Cards"):
                this.mainView.getContentPane().remove(0);
                new ViewCards(this.deck, this.mainView);

                break;

            case ("Save"):
                System.out.println("toto");
                this.deck.serializeDeck();

                break;

            default:
                this.deck.deserializeDeck();

                break;
        }
    }

}