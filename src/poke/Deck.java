package poke;
import java.util.ArrayList;
import java.io.*;

public class Deck {
    ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getDeck() {
        return this.cards;
    }

    public int deckSize() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void editCard(int index, Card card) {
        this.cards.set(index, card);
    }

    public void removeCard(int index) {
        this.cards.remove(index);
    }

    public void serializeDeck() {
        try {
            FileOutputStream pokedeckSerialized = new FileOutputStream("pokedeck.ser");
            ObjectOutputStream pokedeckSaved = new ObjectOutputStream(pokedeckSerialized);
            pokedeckSaved.writeObject(getDeck());
            pokedeckSaved.flush();
            pokedeckSaved.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeDeck() {
        try {
            FileInputStream pokedeckSerialized = new FileInputStream("pokedeck.ser");
            ObjectInputStream pokedeckSaved = new ObjectInputStream(pokedeckSerialized);
            this.cards = (ArrayList<Card>) pokedeckSaved.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}