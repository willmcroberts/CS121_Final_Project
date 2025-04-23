// Flashcards.java
import java.io.*;
import java.util.*;

public class Flashcards implements HasMenu, Serializable {
	ArrayList<Deck> decks = new ArrayList<Deck>();
	Deck deck;
	Card card;

	public static void main(String[] args) {
		Flashcards fc = new Flashcards();
		fc.start();
	} // End main

	public Flashcards() {
		//loadSampleDecks();
		loadDecks();
		//saveDecks();
	} // End Flashcards()

	public void loadSampleDecks() {
		Deck deck1 = new Deck();

		Deck deck2 = new Deck();

		decks.add(deck1);
		decks.add(deck2);
	} // End loadSampleDecks()

	public void saveDecks() {
		try {
      		FileOutputStream fo = new FileOutputStream("Decks.dat");
      		ObjectOutputStream obOut = new ObjectOutputStream(fo);
      		obOut.writeObject(decks);
      		obOut.close();
      		fo.close();
    	} catch (Exception e)	{
      		System.out.println(e.getMessage());
    	} // end try
	} // End saveDecks()

	public void loadDecks() {
		try {
      		FileInputStream fIn = new FileInputStream("Decks.dat");
      		ObjectInputStream obIn = new ObjectInputStream(fIn);
      		decks = (ArrayList<Deck>)obIn.readObject();
      		obIn.close();
      		fIn.close();
    	} catch (Exception e) {
      		System.out.println(e.getMessage());
   		} // end try
	} // End loadDecks()

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
			} else if (response.equals("3")) {
				deleteDeck();
			} else if (response.equals("4")) {
				showAllDecks();
			} else {
				System.out.println();
				System.out.println("Invalid input.");
			} // End elif statements
		} // End while loop
	} // End start()

	public String menu() {
		Scanner input = new Scanner(System.in);

		System.out.println();
		System.out.println("Main Menu");
		System.out.println("---------------");
		System.out.println("0) Exit");
		System.out.println("1) Pick a deck");
		System.out.println("2) Add a deck");
		System.out.println("3) Remove a deck");
		System.out.println("4) View all decks");
		System.out.println("---------------");
		System.out.println("");
		System.out.print("Enter option: ");

		return input.nextLine();
	} // End menu()

	public void pickDeck() {
		Scanner input = new Scanner(System.in);
		
		showAllDecks();

		System.out.println();
		System.out.print("Enter deck number: ");
		int choice = input.nextInt();
		input.nextLine();

		this.deck = decks.get(choice);
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
		saveDecks();
	} // End addDeck()

	public void deleteDeck() {
		Scanner input = new Scanner(System.in);

		showAllDecks();

		System.out.println();
		System.out.print("Enter deck number: ");
		int choice = input.nextInt();
		input.nextLine();

		System.out.println();
		System.out.print("Confirm delete (y/n): ");
		String confirmation = input.nextLine();

		if (confirmation.equals("y")) {
			System.out.println("Deck deleted.");
			this.deck = decks.get(choice);
			decks.remove(this.deck);
		} else if (confirmation.equals("n")) {
			System.out.println("Deck not deleted.");
		} else {
			System.out.println("Invalid input. Deck not deleted.");
		} // End elif statement

		saveDecks();
	} // End deleteDeck()

	public void showAllDecks() {
		int counter = 0;
		
		System.out.println();
		System.out.println("---------------");

		for (Deck deck: decks) {
			System.out.println(counter + ") " + deck.deckName);
			counter++;
		} // End for loop
		System.out.println("---------------");
	} // End showAllDecks()
} // End Flashcards class
