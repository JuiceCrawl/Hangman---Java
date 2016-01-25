/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {
	
	public HangmanLexicon() {
        wordList = new ArrayList<String>();
        try {
            BufferedReader rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
            while(true) {
                String line = rd.readLine();           
                if (line == null) {
                    rd.close();
                    break;
                }
                wordList.add(line);
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
//	
//	public BufferedReader openFile(String prompt){
//		BufferedReader rd = null;
//		
//		while(rd == null){
//			try{
//				rd = new BufferedReader(new FileReader(prompt));
//			}catch(IOException ex){
//				println("caught an exception");	
//			}
//			
//		}
//		return rd;
//	}
//	
//	public void run() {
//		BufferedReader rd = openFile("HangmanLexicon.txt");
//		
//		try{
//			while(true){
//				String line = rd.readLine();
//				if (line == null) break;
//				println("reading lines: " + line);
//			}
//			rd.close();
//		}catch(IOException ex) {
//			throw new ErrorException(ex);
//		}
//	}
	

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return  wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordList.get(index);
	}
	
	 private ArrayList<String> wordList;
}
