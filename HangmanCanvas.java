/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		makeSaffold();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		wordList = word;
		GLabel glabel = new GLabel(wordList, 55, SCAFFOLD_HEIGHT + 150);
		//glabel.setFont("Helvetica-24");
		add(glabel);
	}
	
	public void displayAnswer(String word) {
		answerList += word;
		GLabel glabel = new GLabel(answerList, 55, SCAFFOLD_HEIGHT + 200);
		glabel.setFont("Helvetica-24");
		add(glabel);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String guess, int guessCount) {
		guessList += guess;
		GLabel glabel = new GLabel(guessList, 55, SCAFFOLD_HEIGHT + 100);
		glabel.setFont("Helvetica-24");
		add(glabel);
		
		switch(guessCount){
		case 7:
			makeHead();
			break;
		case 6:
			makeBody();
			break;
		case 5:
			makeLeftArm();
			break;
		case 4:
			makeRightArm();
			break;
		case 3:
			makeLeftLeg();
			break;
		case 2:
			makeRightLeg();
			break;
		case 1:
			makeLeftFoot();
			break;
		case 0:
			makeRightFoot();
		
		}
		
	}
	
	public void makeSaffold(){
		GLine scaffoldPole = new GLine(55,SCAFFOLD_HEIGHT+40,55,40);
		add(scaffoldPole);
		GLine beam = new GLine(55,40,55+BEAM_LENGTH,40);
		add(beam);
		GLine roap = new GLine(55+BEAM_LENGTH,40,55+BEAM_LENGTH,40+ROPE_LENGTH);
		add(roap);
	}
	
	public void makeHead(){
		GOval head = new GOval (55+BEAM_LENGTH-HEAD_RADIUS, 40+ROPE_LENGTH, HEAD_RADIUS*2, HEAD_RADIUS*2);
		add(head);
	}
	
	public void makeBody(){
		int x1 = 55+BEAM_LENGTH;
		int y1 = 40+ROPE_LENGTH + (HEAD_RADIUS * 2);
		GLine body = new GLine(x1,y1,x1,y1 + BODY_LENGTH);
		add(body);
	}
	
	public void makeLeftArm(){
		int x1 = 55+BEAM_LENGTH;
		int y1 = 40+ROPE_LENGTH + (HEAD_RADIUS * 2) + ARM_OFFSET_FROM_HEAD;
		GLine arm = new GLine(x1, y1, x1 - UPPER_ARM_LENGTH, y1);
		add(arm);
		GLine hand = new GLine(x1 - UPPER_ARM_LENGTH,y1, x1 - UPPER_ARM_LENGTH, y1 + LOWER_ARM_LENGTH);
		add(hand);
		
	}
	
	public void makeRightArm(){
		int x1 = 55+BEAM_LENGTH;
		int y1 = 40+ROPE_LENGTH + (HEAD_RADIUS * 2) + ARM_OFFSET_FROM_HEAD;
		GLine arm = new GLine(x1, y1, x1 + UPPER_ARM_LENGTH, y1);
		add(arm);
		GLine hand = new GLine(x1 + UPPER_ARM_LENGTH, y1, x1 + UPPER_ARM_LENGTH, y1 + LOWER_ARM_LENGTH);
		add(hand);
	}
	
	public void makeLeftLeg(){
		int x1 = 55+BEAM_LENGTH;
		int y1 = 40+ROPE_LENGTH + (HEAD_RADIUS * 2) + BODY_LENGTH;
		GLine hip = new GLine(x1, y1, x1 - HIP_WIDTH, y1);
		add(hip);
		GLine leg = new GLine(x1 - HIP_WIDTH, y1, x1 - HIP_WIDTH, y1 + LEG_LENGTH);
		add(leg);
	}
	
	public void makeRightLeg(){
		int x1 = 55+BEAM_LENGTH;
		int y1 = 40+ROPE_LENGTH + (HEAD_RADIUS * 2) + BODY_LENGTH;
		GLine hip = new GLine(x1, y1, x1 + HIP_WIDTH, y1);
		add(hip);
		GLine leg = new GLine(x1 + HIP_WIDTH, y1, x1 + HIP_WIDTH, y1 + LEG_LENGTH);
		add(leg);
	}
	
	public void makeLeftFoot(){
		int x1 = 55+BEAM_LENGTH - HIP_WIDTH;
		int y1 = 40+ROPE_LENGTH + (HEAD_RADIUS * 2) + BODY_LENGTH + LEG_LENGTH;
		GLine foot = new GLine(x1, y1, x1 - FOOT_LENGTH, y1);
		add(foot);
	}
	
	public void makeRightFoot(){
		int x1 = 55+BEAM_LENGTH + HIP_WIDTH;
		int y1 = 40+ROPE_LENGTH + (HEAD_RADIUS * 2) + BODY_LENGTH + LEG_LENGTH;
		GLine foot = new GLine(x1, y1, x1 + FOOT_LENGTH, y1);
		add(foot);
	}
	
	private String guessList = "Letters Guessed: ";
	private String answerList = "The word: ";
	private String wordList = "";

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
