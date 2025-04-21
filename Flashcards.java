// Flashcards.java
import java.util.*;

public class Flashcards implements HasMenu {
	ArrayList<Deck> decks = new ArrayList<Deck>();
	Deck deck;
	Card card;

	public static void main(String[] args) {
		Flashcards fc = new Flashcards();
		fc.start();
	} // End main

	public Flashcards() {
		loadSampleDecks();
	} // End Flashcards()

	public void loadSampleDecks() {
		Deck deck1 = new Deck();

		Deck deck2 = new Deck();

		decks.add(deck1);
		decks.add(deck2);
	} // End loadSampleDecks()

	public void start() {
		boolean keepGoing = true;
		while(keepGoing) {
			String response = menu();
			if (response.equals("0")) {
				keepGoing = false;
			} else if (response.equals("1")) {
				pickDeck();
			} else if (response.equals("2")) {
				addDeck();
			} else {
				System.out.println();
				System.out.println("Invalid input.");
			} // End elif statements
		} // End while loop
	} // End start()

	public String menu() {
		Scanner input = new Scanner(System.in);

		System.out.println();
		System.out.println("0) Exit");
		System.out.println("1) Pick a deck");
		System.out.println("2) Add a deck");
		System.out.println("");
		System.out.print("Enter option: ");

		return input.nextLine();
	} // End menu()

	public void pickDeck() {
		Scanner input = new Scanner(System.in);
		int counter = 0;
		
		System.out.println();

		for (Deck deck: decks) {
			System.out.println(counter + ") " + deck.deckName);
			counter++;
		} // End for loop
		System.out.println();
		System.out.print("Enter deck number: ");
		int choice = input.nextInt();

		this.deck = new Deck();
		Deck deckChoice = decks.get(choice);
		
		deck.start();
	} // End pickDeck()

	public void addDeck() {
		Scanner input = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Name this deck: ");
		String tempDeckName = input.nextLine();

		System.out.println();
		System.out.print("How many cards would you like to add to this deck? ");
		int numCards = input.nextInt();
		input.nextLine();

		ArrayList<Card> tempCards = new ArrayList<Card>();
		
		for (int i = 0; i < numCards; i++) {
			System.out.println();

			System.out.print("Enter Question " + i + ": ");
			String cardQuestion = input.nextLine();

			System.out.print("Enter Answer " + i + ": ");
			String cardAnswer = input.nextLine();

			tempCards.add(new Card(cardQuestion, cardAnswer));
		} // End for loop
		
		decks.add(new Deck(tempDeckName, tempCards));
	} // End addDeck()
} // End Flashcards class
