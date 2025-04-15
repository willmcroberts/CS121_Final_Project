run: Flashcards.class
	java Flashcards

Flashcards.class: Flashcards.java Deck.class Card.class
	javac -g Flashcards.java

Deck.class: Deck.java Card.class
	javac -g Deck.java

Card.class: Card.java
	javac -g Card.java

clean: 
	rm *.class

debug: 
	jdb Flashcards
