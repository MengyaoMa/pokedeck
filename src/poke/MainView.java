package poke;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainView extends JFrame {
	
    Deck deck = new Deck();
    ActionListener MenuListener;

    public MainView(String frameTitle) {
        super(frameTitle);

        File pokedeckSerialized = new File("pokedeck.ser");

        if (pokedeckSerialized.exists() && !pokedeckSerialized.isDirectory()) {
          
        	deck.deserializeDeck();
        }

        this.setSize(400, 500);
        this.setLayout(new FlowLayout());

        new ViewCards(deck, this);
        this.setJMenuBar(renderMenuBar());

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar renderMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Add "File" menu
        JMenu menuFile = new JMenu("File");
        MenuListener = new MenuListener(deck, this);

        JMenuItem itemNewCard = new JMenuItem("New Card");
        JMenuItem itemAllCards = new JMenuItem("Show All Cards");
        JMenuItem itemSave = new JMenuItem("Save");

        itemNewCard.addActionListener(MenuListener);
        itemAllCards.addActionListener(MenuListener);
        itemSave.addActionListener(MenuListener);

        // Display keyboard shortcuts
        itemNewCard.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        itemAllCards.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        itemSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        menuFile.add(itemNewCard);
        menuFile.add(itemAllCards);
        menuFile.addSeparator();
        menuFile.add(itemSave);
        menuBar.add(menuFile);

        return menuBar;
    }
}