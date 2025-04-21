// Deck.java
import java.util.*;

public class Deck implements HasMenu {

	String deckName;
	ArrayList<Card> cards = new ArrayList<Card>();
	Card card;

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.start();
	} // End main

	public Deck() {
		deckName = "Sample Deck";
		loadSampleDeck();
	} // End Deck()

	public Deck(String deckName, ArrayList<Card> cards) {
			this.deckName = deckName;
			this.cards = cards;
	} // End Deck()

	public void loadSampleDeck() {
		cards.add(new Card("What Card is this?", "Card 1"));
		cards.add(new Card("What Card is this?", "Card 2"));
		cards.add(new Card("What Card is this?", "Card 3"));
	} // End loadSampleDeck()

	public ArrayList<Card> getCards() {
		return cards;
	} // End getList()

	public void start() {
		boolean keepGoing = true;
		while(keepGoing) {
			String response = menu();
			if (response.equals("0")) {
				keepGoing = false;
			} else if (response.equals("1")) {
				startFlashCards();
			} else if (response.equals("2")) {
				showAllCards();
			} else {
				System.out.println();
				System.out.println("Invalid input.");
			} // End elif statements
		} // End while loop	
	} // End start()

	public String menu() {
		Scanner input = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Deck menu");
		System.out.println("---------------");
		System.out.println("0) Back");
		System.out.println("1) Start");
		System.out.println("2) View");
		System.out.println("---------------");
		System.out.println();
		System.out.print("Enter option: ");

		return input.nextLine();
	} // End menu()

	public String showAllCards() {
		for (Card card: cards) {
			System.out.println();
			card.printQuestion();
			card.printAnswer();
		} // End for loop

		return "";
	} // End showAllCards()

	public void startFlashCards() {
		Scanner enter = new Scanner(System.in);

		for (Card card: cards) {
			System.out.println();
			card.start();
			System.out.println();
			System.out.print("Press ENTER to continue.");
			enter.nextLine();
		} // End for lopp

		System.out.println();
		System.out.print("This is the end. Press ENTER to continue.");
		enter.nextLine();
	} // End startFlashCards
} // End Deck class
