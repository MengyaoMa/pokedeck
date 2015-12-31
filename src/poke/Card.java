package poke;


	import java.io.Serializable;


	public abstract class Card implements Serializable {
	    private String cardName;

	    public enum CardTypes {
	        POKEMON, TRAINER, ENERGY
	    }

	    CardTypes cardType;

	    public Card(CardTypes cardType, String cardName) {
	        this.cardName = cardName;
	        this.cardType = cardType;
	    }

	    public String getCardName() {
	        return this.cardName;
	    }

	    public CardTypes getCardType() {
	        return this.cardType;
	    }

	    public String getCardTypeAsString(CardTypes cardType) {
	        String cardTypeAsString;

	        if (cardType == CardTypes.POKEMON) {
	            cardTypeAsString = "Pokémon";
	        }
	        else if (cardType == CardTypes.TRAINER) {
	            cardTypeAsString = "Trainer";
	        }
	        else {
	            cardTypeAsString = "Energy";
	        }

	        return cardTypeAsString;
	    }
	}

