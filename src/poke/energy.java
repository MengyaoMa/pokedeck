package poke;

public class energy extends Card{
	String energySymbol;

    public energy(String cardName, String energySymbol) {
        super(CardTypes.ENERGY, cardName);

        this.energySymbol = energySymbol;
    }

    public String getEnergySymbol() {
        return this.energySymbol;
    }
}
