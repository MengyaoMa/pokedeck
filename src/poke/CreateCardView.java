package poke;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class CreateCardView extends JPanel {
    Deck deck;
    MainView mainView;
    int cardTypeIndex;

    ArrayList<JComponent> components = new ArrayList<>();
    ArrayList<JLabel> labels = new ArrayList<>();

    JLabel labelCardType = new JLabel("Card type");
    JLabel labelCardName = new JLabel("Card name");
    JLabel labelHealthPoints = new JLabel("Health points");
    JLabel labelEnergy = new JLabel("Energy");
    JLabel labelStage = new JLabel("Stage");
    JLabel labelEvolvedFrom = new JLabel("Evolved from");
    JLabel labelTrainerType = new JLabel("Trainer type");
    JLabel labelTrainerRules = new JLabel("Trainer rules");
    JLabel labelEnergySymbol = new JLabel("Symbol");

    JComboBox<String> cardTypeList = new JComboBox<>();
    JTextField cardName = new JTextField(10);
    JSpinner pokemonHealthPoints = new JSpinner(new SpinnerNumberModel(100, 0, 200, 1));
    JTextField pokemonEnergy = new JTextField(10);
    JTextField pokemonStage = new JTextField(10);
    JTextField pokemonEvolvedFrom = new JTextField(10);
    JTextField trainerType = new JTextField(10);
    JTextField trainerRules = new JTextField(10);
    JTextField energySymbol = new JTextField(10);

    JButton buttonCreateCard = new JButton("Create Card");

    Hashtable<String, String> dataCreateCard = new Hashtable<>();

    ActionListener createCardListener;

    public CreateCardView(Deck deck, MainView mainView, int cardTypeIndex) {
        super(new BorderLayout(60, 40));
        this.deck = deck;
        this.mainView = mainView;
        this.cardTypeIndex = cardTypeIndex;
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(new JLabel("Add a new card to the pokédeck", SwingConstants.CENTER), BorderLayout.PAGE_START);

        // List of cards types
        createCardListener = new CreateCardListener(this.deck, this, this.mainView);
        cardTypeList.addItem("Pokémon");
        cardTypeList.addItem("Trainer");
        cardTypeList.addItem("Energy");
        cardTypeList.setSelectedIndex(cardTypeIndex);
        cardTypeList.addActionListener(createCardListener);

        buttonCreateCard.addActionListener(createCardListener);

        JComponent addCardPanel = new JPanel();
        addCardPanel.setLayout(new BoxLayout(addCardPanel, BoxLayout.PAGE_AXIS));

        components.add(cardTypeList);
        components.add(cardName);
        labels.add(labelCardType);
        labels.add(labelCardName);

        JComponent layoutDefaultFields = new layout(labels, components).render();
        addCardPanel.add(layoutDefaultFields);

        switch (cardTypeIndex) {
            case (0):
                components.add(pokemonHealthPoints);
                components.add(pokemonEnergy);
                components.add(pokemonStage);
                components.add(pokemonEvolvedFrom);

                labels.add(labelHealthPoints);
                labels.add(labelEnergy);
                labels.add(labelStage);
                labels.add(labelEvolvedFrom);

                break;

            case (1):
                components.add(trainerType);
                components.add(trainerRules);

                labels.add(labelTrainerType);
                labels.add(labelTrainerRules);

                break;

            case (2):
                components.add(energySymbol);

                labels.add(labelEnergySymbol);

                break;

            default:
                break;
        }

        JComponent layoutCardsTypesFields = new layout(labels, components).render();
        addCardPanel.add(layoutCardsTypesFields);

        this.add(addCardPanel);

        JPanel panelButtonCreateCard = new JPanel(new FlowLayout());
        panelButtonCreateCard.add(buttonCreateCard);
        panelButtonCreateCard.setBorder(new EmptyBorder(15, 0, 0, 0));
        addCardPanel.add(panelButtonCreateCard);

        this.mainView.getContentPane().removeAll();
        this.mainView.add(this);
        this.mainView.revalidate();
        this.mainView.repaint();
    }

    public Hashtable getDataCreateCard(){
        dataCreateCard.put("cardName", cardName.getText());

        switch (this.cardTypeIndex) {
            case (0):
                dataCreateCard.put("cardType", "Pokemon");
                dataCreateCard.put("pokemonHealthPoints", Integer.toString((Integer) pokemonHealthPoints.getValue()));
                dataCreateCard.put("pokemonEnergy", pokemonEnergy.getText());
                dataCreateCard.put("pokemonStage", pokemonStage.getText());
                dataCreateCard.put("pokemonEvolvedFrom", pokemonEvolvedFrom.getText());

                break;

            case (1):
                dataCreateCard.put("cardType", "Trainer");
                dataCreateCard.put("trainerRules", trainerRules.getText());
                dataCreateCard.put("trainerType", trainerType.getText());

                break;

            case (2):
                dataCreateCard.put("cardType", "Energy");
                dataCreateCard.put("energySymbol", energySymbol.getText());

                break;

            default:
                break;
        }

        return dataCreateCard;
    }
}