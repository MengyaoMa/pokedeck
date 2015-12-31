package poke;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;


public class ViewCards extends JPanel {
    Deck deck;
    MainView mainView;

    ActionListener removeCardListener;

    public ViewCards(Deck deck, MainView mainView) {
        super(new BorderLayout(60, 40));
        this.deck = deck;
        this.mainView = mainView;

        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(new JLabel("Listing of all cards in the pokédeck", SwingConstants.CENTER), BorderLayout.PAGE_START);

        JComponent panelShowAllCards = new JPanel();
        panelShowAllCards.setLayout(new BoxLayout(panelShowAllCards, BoxLayout.PAGE_AXIS));

        for (int i = 0; i < this.deck.deckSize(); i++) {
            Card card = this.deck.getDeck().get(i);

            JPanel panelShowCard = new JPanel(new GridLayout(9, 1));
            Border OSXBorder = UIManager.getBorder("InsetBorder.aquaVariant");
            panelShowCard.setBorder(OSXBorder);

            panelShowCard.add(new JLabel());
            panelShowCard.add(new JLabel(card.getCardTypeAsString(card.getCardType()), SwingConstants.CENTER));
            panelShowCard.add(new JLabel(card.getCardName(), SwingConstants.CENTER));

            switch (card.getCardType()) {
                case POKEMON:
                    PokemonCard pokemonCard = (PokemonCard) card;

                    panelShowCard.add(new JLabel(pokemonCard.getPokemonHealthPoints(), SwingConstants.CENTER));
                    panelShowCard.add(new JLabel(pokemonCard.getPokemonEnergy(), SwingConstants.CENTER));
                    panelShowCard.add(new JLabel(pokemonCard.getPokemonStage(), SwingConstants.CENTER));
                    panelShowCard.add(new JLabel(pokemonCard.getPokemonEvolvedFrom(), SwingConstants.CENTER));

                    break;

                case TRAINER:
                    Trainer trainerCard = (Trainer) card;

                    panelShowCard.add(new JLabel(trainerCard.getTrainerType(), SwingConstants.CENTER));
                    panelShowCard.add(new JLabel(trainerCard.getTrainerRules(), SwingConstants.CENTER));

                    break;

                case ENERGY:
                    energy energyCard = (energy) card;

                    panelShowCard.add(new JLabel(energyCard.getEnergySymbol(), SwingConstants.CENTER));

                    break;
            }

            panelShowCard.add(new JLabel());

            removeCardListener = new RemoveCardListener(this.deck, this.mainView, i);
            JButton buttonRemoveCard = new JButton("Remove Card");
            buttonRemoveCard.addActionListener(removeCardListener);
            panelShowCard.add(buttonRemoveCard);

            panelShowAllCards.add(panelShowCard);
        }

        this.add(panelShowAllCards);

        this.mainView.getContentPane().removeAll();
        this.mainView.add(this);
        this.mainView.revalidate();
        this.mainView.repaint();
    }
}
