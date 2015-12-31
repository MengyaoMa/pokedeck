package poke;

import java.util.Hashtable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateCardListener implements ActionListener {
    CreateCardView createCardView;
    MainView mainView;
    Deck deck;

    public CreateCardListener(Deck deck, CreateCardView createCardView, MainView mainView) {
        this.createCardView = createCardView;
        this.mainView = mainView;
        this.deck = deck;
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src instanceof JComboBox) {
            mainView.getContentPane().removeAll();
            int selectedCardType = ((JComboBox) src).getSelectedIndex();
            new CreateCardView(this.deck, mainView, selectedCardType);
        }
        else {
            Hashtable<String, String> dataCreateCard = this.createCardView.getDataCreateCard();

            Card newCard = null;

            String cardType = dataCreateCard.get("cardType");
            String cardName = dataCreateCard.get("cardName");

            switch (cardType) {
                case ("Pokemon"):
                    String pokemonHealthPoints = dataCreateCard.get("pokemonHealthPoints");
                    String pokemonEnergy = dataCreateCard.get("pokemonEnergy");
                    String pokemonStage = dataCreateCard.get("pokemonStage");
                    String pokemonEvolvedFrom = dataCreateCard.get("pokemonEvolvedFrom");

                    newCard = new PokemonCard(cardName, pokemonHealthPoints, pokemonEnergy, pokemonStage, pokemonEvolvedFrom);

                    break;

                case ("Trainer"):
                    String TrainerRules = dataCreateCard.get("trainerRules");
                    String TrainerType = dataCreateCard.get("trainerType");

                    newCard = new Trainer(cardName, TrainerRules, TrainerType);

                    break;

                case ("Energy"):
                    String energySymbol = dataCreateCard.get("energySymbol");

                    newCard = new energy(cardName, energySymbol);

                    break;
            }
            deck.addCard(newCard);

        }
    }
}