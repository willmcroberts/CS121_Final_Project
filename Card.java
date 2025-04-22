// Card.java
import java.io.*;
import java.util.*;

public class Card implements Serializable {
	String question;
	String answer;

	public static void main(String[] args) {
		Card card = new Card();
		card.start();
	} // End main

	public Card() {
		this.question = "What class is this?";
		this.answer = "Card.";
	} // End Card()

	public Card(String question, String answer) {
		this.question = question;
		this.answer = answer;
	} // End Card()

	public void start() {
		Scanner enter = new Scanner(System.in);
		printQuestion();
		System.out.println();
		System.out.println("Press ENTER to see the answer.");
		enter.nextLine();
		printAnswer();
	} // End Start()

	public String printQuestion() {
		System.out.println("---------------");
		System.out.println("Q: " + this.getQuestion());
		System.out.println("---------------");
		return "";
	} // End printQuestion()

	public String printAnswer() {
		System.out.println("---------------");
		System.out.println("A: " + this.getAnswer());
		System.out.println("---------------");
		return "";
	} // End print Answer()

	public String getQuestion() {
		return this.question;
	} // End getQuestion()

	public String getAnswer() {
		return this.answer;
	} // End getAnswer()

	public void setQuestion() {
		this.question = question;
	} // End setQuestion

	public void setAnswer() {
		this.answer = answer;
	} // End setAnswer()
} // End Card class