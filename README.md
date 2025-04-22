# Flash Card System

**Purpose**: This program is supposed to be a flashcard system that allows users to add decks of flashcards that can be used for study anything that uses only *normal* characters. This project uses OOP programing, abstraction, a basic data structure.

## Algorithm

### Card.java
**Purpose**: This file is meant to set up each individual "card" that contains a question and an answer. The card is an object that can be replecated and will eventaully have lots stored in ArrayLists. This file also prints the cards and allows for the most basic part of this program which is actaully seeing the cards in order to quiz yourself.

#### main()
```
Create a new instance and start it for testing purposes
```

#### Card() and Card(q, a)
```
consntructors for default values and user set values
```

#### start()
```
Goes through the question and the answer with a break between
```

#### printQuestion()
```
print break
print Q: question
print break
```

#### printAnswer()
```
print break
print A: answer
print break
```

#### gets and sets for answer and question
```
gets and sets the answers and questions
```
---
### Deck.java
**Purpose**: This file is meant to create Deck objects that hold a deck name and an ArrayList of cards. These are what really make up the program while the cards make up these. It will allow you to view all the cards in a certain deck so you are able to study them.

#### Main
```
Create a new instance and start it for testing purposes
```

#### Deck() and Deck(dn, c)
```
consntructors for default values and user set values
```

#### loadSampleDeck()
```
creates sample cards and adds them to a sample ArrayList
```

#### getCards()
```
returns cards
```

#### start()
```
while keepGoing:
  response = menu()
  if 0:
    quit
  if 1:
    startFlashCards()
  if 2:
    showAllCards()
```

#### menu()
```
0) Quit
1) Start
2) View

Enter option:
return option
```

#### showAllCards
```
for Cards in cards:
  printQuestion()
  printAnswer()
```

#### startFlashCards
```
for Cards in cards:
  start card
  press enter to continue
```
---
### Flashcards.java
**Purpose**: This file is meant to put everything together, it will contain an ArrayList of decks, which are ArrayLists of cards. It will allow you to choose which deck you would like to use, add new decks, remove decks you don't want, and view all decks just for viewing pleasure.

#### main()
```
Create a new instance and start it so the program runs
```

#### Flashcards()
```
calls loadDecks()
```

#### loadSampleDecks()
```
creates new deck instances for testing purposes
```

#### loadDecks()
```
loads the decks/data from a file. "Stolen" code from an example
```

#### saveDecks()
```
saves the decks created to a file. "Stolen" code from an example
```

#### start()
```
while keepGoing:
  response = menu()
  if 0:
    quit
  if 1:
    pickDeck()
  if 2:
    addDeck()
  if 3:
    deleteDeck()
  if 4:
    showAllDecks()
```

#### menu()
```
0) Quit
1) Pick deck
2) Add deck
3) Delete deck
4) View decks

Enter option:
return option
```

#### pickDeck()
```
showAllDecks()

print("Enter deck number: ")
deck = deck[chosen deck number]
start deck
```

#### addDeck()
```
print("Enter deck name")
print("Enter number of cards")

new ArrayList

for i in range(number of cards):
  print("Enter question: ")
  print("Enter answer: ")

  add new Card(question, answer) to ArrayList

add new Deck(deck name, Card arrayList)
saveDecks():
```

#### deleteDeck()
```
showAllDecks()

print("Enter deck number: ")

print(confirm delete?)

if yes:
  deleteDeck()
if no:
  don't delete deck
else:
  don't delete deck
```

#### showAllDecks()
```
for Decks in decks:
  print(deckName)
```
---
### HasMenu.java
```
interface
  menu()
  start()
```
