package poke;

public class PokemonCard extends Card {
    String pokemonHealthPoints;
    String pokemonEnergy;
    String pokemonStage;
    String pokemonEvolvedFrom;

    public PokemonCard(String cardName, String pokemonHealthPoints, String pokemonEnergy, String pokemonStage, String pokemonEvolvedFrom) {
        super(CardTypes.POKEMON, cardName);

        this.pokemonHealthPoints = pokemonHealthPoints;
        this.pokemonEnergy = pokemonEnergy;
        this.pokemonStage = pokemonStage;
        this.pokemonEvolvedFrom = pokemonEvolvedFrom;
    }

    public String getPokemonHealthPoints() {
        return this.pokemonHealthPoints;
    }

    public String getPokemonEnergy() {
        return this.pokemonEnergy;
    }

    public String getPokemonStage() {
        return this.pokemonStage;
    }

    public String getPokemonEvolvedFrom() {
        return this.pokemonEvolvedFrom;
    }
}