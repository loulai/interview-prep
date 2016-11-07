import java.util.Scanner;

/**
 * Created on : September 23rd 2014
 * Description: Program allows user to play a simplified game of blackjack with the computer.
 * @author Lou Lai
 */

public class Blackjack {
	public static void main(String[] args) {
		
		/* over arching concept, basic rules aside: two 'while' loops run under different conditions, 
		 * one addressing the user and one addressing the dealer  */
		
		/* useful definitions:
		 * 'cardNumber' = randomly generated number (integer from 0 - 51)
		 * 'cardName'   = name of card so humans understand e.g. 5 of hearts, Ace of spades (String)
		 * 'cardScore'  = the actual worth of the card e.g. 5 of hearts is has a score of 5 (integer from 1 - 11)
		 */
		
		//USER: generating two random numbers and printing their names.
		int userCardNumber1 = generateNumber();
		int userCardNumber2 = generateNumber();
		System.out.println("You drew     : " + cardNumberToName(userCardNumber1));
		System.out.println("You drew     : " + cardNumberToName(userCardNumber2));
		
		//USER: tallying and printing score
		int userScore = cardNumberToScore(userCardNumber1) + cardNumberToScore(userCardNumber2);
		System.out.println("Your score   : " + userScore);
		
		//DEALER: generating two cards, tallying score. Not showing values because want to keep it hidden.
		int dealerCardNumber1 = generateNumber();
		int dealerCardNumber2 = generateNumber();
		int dealerScore = cardNumberToScore(dealerCardNumber1) + cardNumberToScore(dealerCardNumber1);
		System.out.println("Dealer score : XX");
		System.out.println("(Dealer also drew two cards)");
		
		//Accounting for rare condition where someone wins straight up
		if(userScore == 21) {
			System.out.println("The force is strong. You straight up won! \n===YOU WIN===");
		} else if (dealerScore == 21) {
			System.out.println("Wow it's not your day. Dealer hit 21. \n===DEALER WINS===");
		} else if (dealerScore > 21){
			System.out.println("you lucky mole dealer bust\n===YOU WIN===");
		} else if (userScore > 21){
			System.out.println("YOU SUCK YOU HAHAHHA YOU BUST\n===DEALER WINS===");
		}
		
		//boolean is used as a condition for 'while' loop to run.
		// It's true here because our first move is to ask the user if they want another card. It changes to false later on in the loop.
		boolean isItUsersTurn = true;
		
		//if it's the users turn AND everyone's scores are below 21, code runs. Scroll to bottom for 'areScoresUnder21()' explanation.
		while(isItUsersTurn == true && areScoresUnder21(userScore,dealerScore)) {
			
			//asks the user to choose: to take a card or not?
			System.out.println("\n--- Want another card? Type (y) or (n), then hit return. ---");
			Scanner response = new Scanner(System.in);
			String yesOrNo = response.next();
			
			
			if (!yesOrNo.equalsIgnoreCase("n") && !yesOrNo.equalsIgnoreCase("y")) { //set up to catch invalid inputs
				System.out.println(">>> You shall not pass. I asked (y) or (n). Try again!");
			} else if(yesOrNo.equalsIgnoreCase("n")) { 
				System.out.println("\n--- Dealer's turn --- ");
				isItUsersTurn = false; //because user doesn't want a card, it's not the user's turn. Changing to false
				                       //changes the condition so this 'while' loop won't repeat.
			} else { //the only other option is (y), meaning the user wants a card. We now proceed to deal it.
				
				//creating random card, and printing
				int newCardNumber = generateNumber();
				System.out.println("You drew    : " + cardNumberToName(newCardNumber));
				
				//tallying up score, and printing
				userScore = userScore + cardNumberToScore(newCardNumber);
				System.out.println("New score   : " + userScore);
				
				//if user at this point gets 21 or greater, the user wins or busts. Both will display message and break loop.
				//if user wins/busts, no other 'while' loop in entire program will run, because the condition (must have score < 21) isn't met.
				if(userScore > 21){
					System.out.println("Whoopsie, you bust! \n===DEALER WINS===");
					break;
				} else if (userScore == 21) {
					System.out.println("You hit 21! \n===YOU WIN===");
					break;
				}
				
			}
			
		}
		
		// now we're out of the first 'while' loop. Now going into the next one.
		int dealerRound = 1; //set up to count how many rounds the dealer has had, because we've decided to only ever have 2 rounds.
		while(isItUsersTurn == false && areScoresUnder21(userScore,dealerScore) && dealerRound <= 2) {
			int dealerNewCardNumber1 = generateNumber();
			dealerScore = dealerScore + cardNumberToScore(dealerNewCardNumber1);
			
			//DEALER: generating random number and new card, and printing it
			String dealerNewCardName1 = cardNumberToName(dealerNewCardNumber1);
			System.out.println("Dealer draws: " + dealerNewCardName1); // we don't hide this card, we show it
			
			//checking for possible win/bust, like in the first while loop.
			if (dealerScore > 21) {
				System.out.println("Dealer bust! \n===YOU WIN===");
				break;
			} else if (dealerScore == 21) {
				System.out.println("Dealer hit 21! \n===DEALER WINS===");
				break;
			} else {
				dealerRound = dealerRound + 1; //increments dealerRound, so we can count (and keep a cap on) how many times dealer has drawn a card
			}
		}
		
		// at this point, user and dealer both have scores < 21. So the score closes to 21 wins.
		if ( userScore > dealerScore && areScoresUnder21(userScore,dealerScore)) { // checks if user has a greater score than dealer (but still under 21)
			System.out.printf("Your score (%d) is closer than dealer (%d) to 21. \n===YOU WIN===", userScore, dealerScore);
		} else if ( userScore < dealerScore && areScoresUnder21(userScore,dealerScore)) { //vice versa
			System.out.printf("Dealers score (%d) is closer than yours (%d) to 21. \n===DEALER WINS===", dealerScore, userScore);
		} else if (userScore == dealerScore && areScoresUnder21(userScore,dealerScore)) { //accounting for draw
			System.out.println("Ermegawd it's a draw! \n===BATTLE IT OUT===");
		}
	}
	
	
	
	
	/* End of main section. Let the methods begin. */
	
 	/**
 	 * @return     a random integer between 0 and 51 (inclusive)
 	 */
 	public static int generateNumber(){
 		int cardNumber = (int) (Math.random() * 52);
 		return cardNumber;
 	}
 	
 	/**
 	 * @param generatedNumber random integer between 0 and 51 (inclusive)
 	 * @return	              'score' of the card, as an integer
 	 */
 	public static int cardNumberToScore(int generatedNumber){
 		generatedNumber = generatedNumber + 1; // as mentioned in GetCard.java, must plus one for logic to work
 		int cardScore; //initializing return value
 		
 		if (generatedNumber % 13 == 1){ //logic similar as in GetCard.java. Mod determines position within suit, and its 'score'
 			                            // is derived from that position.
			cardScore = 11;             // for example, here the ace has a 'score' of 11.
		} else if (generatedNumber % 13 == 11){
			cardScore = 10;             // kings, queens and jacks all have a 'score' of 10
		} else if (generatedNumber % 13 == 12) {
			cardScore = 10;
		} else if (generatedNumber % 13 == 0) {
			cardScore = 10;
		} else {
			cardScore = generatedNumber - (((generatedNumber - 1)/13) * 13); //explanation of this funky equation is in GetCard.java
		}                                                                    // i.e. 2 of spades will have a 'score' of 2
 		return cardScore;
 	}
 	
 	/**
 	 * @param generatedNumber random integer between 0 and 51 (inclusive)
 	 * @return                string name of card so that humans understand
 	 */
 	public static String cardNumberToName(int generatedNumber) { //logic identical to GetCard.java
 		String card;
 		generatedNumber = generatedNumber + 1;
			
		if (generatedNumber % 13 == 1){
				card = "Ace";
			} else if (generatedNumber % 13 == 11){
				card = "King";
			} else if (generatedNumber % 13 == 12) {
				card = "Queen";
			} else if (generatedNumber % 13 == 0) {
				card = "Jack";
			} else {
				int cardNumber = generatedNumber - ((generatedNumber - 1)/13) * 13;
				card = Integer.toString(cardNumber);
			}
			
			generatedNumber = generatedNumber - 1;
			
			if (generatedNumber / 13 == 0) {
				card = card + " of hearts";
			} else if (generatedNumber / 13 == 1) {
				card = card + " of spades";
			} else if (generatedNumber / 13 == 2) {
				card = card + " of clubs";
			} else {
				card = card + " of diamonds";
			}
			
		return card;		
 	}
 	
 	
 	/** This comparison of 'score' was used so many times that it was worth extracting into a method
 	 * @param userScore   integer score of the user
 	 * @param dealerScore integer score of the dealer
 	 * @return            boolean if both scores are under 21, return true, else return false
 	 */
 	public static boolean areScoresUnder21(int userScore, int dealerScore) {
 		if(userScore < 21 && dealerScore < 21) {
 			return true;
 		} else {
 			return false;
 		}
 	}
 	
}