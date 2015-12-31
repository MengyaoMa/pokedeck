package poke;

public class Trainer extends Card {
	String trainerType;
    String trainerRules;

    public Trainer(String cardName, String trainerType, String trainerRules) {
        super(CardTypes.TRAINER, cardName);

        this.trainerType = trainerType;
        this.trainerRules = trainerRules;
    }

    public String getTrainerType() {
        return this.trainerType;
    }

    public String getTrainerRules() {
        return this.trainerRules;
    }
}
