/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {
	/** Number of guesses allowed per turn */
	public static final int GUESS_NUMBER = 8;
	public static final int NUM_WORDS_LENGTH = new HangmanLexicon().getWordCount();

	public void init() {
		 canvas = new HangmanCanvas();
		 add(canvas);			
		}
	
    public void run() {
    	println("Welcome to Hangman!");
    	RandomizeWord();
    	createUnderscore();
    	canvas.reset();
    	
    	while (!gameOver){
        	playGame();
    	}
    	
	}
    
    private void RandomizeWord(){
    	lex = new HangmanLexicon();
    	int index = rgen.nextInt(0, NUM_WORDS_LENGTH - 1);
    	word = lex.getWord(index);
    }
    
    private void playGame() {
    	if(word.indexOf(guess) != -1){
    		int index = word.indexOf(guess);
    		underscore = underscore.substring(0, index) + guess + underscore.substring(index + guess.length());
    		checkRepeats(index);
    		canvas.displayWord(underscore);
    		checkForWin();
    	}else{
    		if(guess.matches("[A-Z]+")){
    			guessCount--;
    			canvas.noteIncorrectGuess(guess, guessCount);
    			checkForWin();
    		}else{
    			guess = readLine("That is an illegal answer. Please guess a letter.");
    			guess = guess.toUpperCase();
    			println("Your guess: " + guess);
    			
    		}
    		
    	}
		
	}
    
  private void checkRepeats(int newIndex){
	 int currentIndex  = newIndex;
	  while(newIndex < word.length()){
		  newIndex++;
		  String restOfString = word.substring(currentIndex);
		if(restOfString.indexOf(guess) != -1){
			int index = currentIndex+restOfString.indexOf(guess);
			underscore = underscore.substring(0, index) + guess + underscore.substring(index + guess.length());	
			currentIndex++;
		}
	}  	
}
    
    private void checkForWin(){
    	if(underscore.indexOf("-") == -1){
			gameOver = true;
    		println("You win!" + " " + underscore);
    		canvas.displayAnswer(word);
    	
    	}else if(guessCount == 0){
    		gameOver = true;
    		println("You lose!" + " The answer was: " + word);
    		canvas.displayAnswer(word);
    		
    	}else{
    		text();
    	}
    }
    
	private void text(){
    	println("The word looks like this:" + underscore);
    	println("You have "+ guessCount + " guess(es) left");
    	guess = readLine("What letter would you like to guess? ");
    	guess = guess.toUpperCase();
    	println("Your guess: " + guess);	
    }
	
    private void createUnderscore(){
    	String result = "";
    	for(int i = 0; i < word.length(); i++){
    		result += "-";
    	}
    	underscore = result;
    }
    
    private int guessCount = GUESS_NUMBER;
    private String underscore = "";
    private String guess ="";
    private boolean gameOver = false;
    private HangmanLexicon lex;
    private RandomGenerator rgen = new RandomGenerator();
 
    private String word;
    private HangmanCanvas canvas;
}


