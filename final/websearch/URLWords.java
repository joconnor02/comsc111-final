package websearch;

import jsjf.LinkedBinarySearchTree;

public class URLWords 
{
	
//	• Two class variables. One will be type String and will store the URL (for example
//	“http://www.acm.org”). One will be a LinkedBinarySearchTree that can hold Word objects.
	private String url = new String();
	private LinkedBinarySearchTree<Word> urlWordTree = new LinkedBinarySearchTree<Word>();
	
//	• A constructor that takes a String argument and sets the class variable.
	public URLWords(String URL)
	{
		url = URL;
	}
	
//	• A getter method that returns the URL string.
	public String getURL()
	{
		return url;
	}
	
//	• A method named addWord. This method should take a String argument, create a new Word
//	object from it, and add the Word object to the binary search tree (one of the class variables
//	created in step 1). There are two cases: either the word is already in the tree or it is not. Be sure to handle both cases!
	public void addWord(String newWord)
	{
		Word theWord = new Word(newWord);
		if(!urlWordTree.contains(theWord))
		{
			urlWordTree.addElement(theWord);
		}else
		{
			urlWordTree.find(theWord).incrementCount();
		}
	}
	
//	• An overloaded addWord method that takes a Word input argument (Note: do not delete the
//	existing addWord method, overload it). Be sure to handle the case where the tree already
//	contains a Word with the same String!
	public void addWord(Word theWord)
	{
		if(!urlWordTree.contains(theWord))
		{
			urlWordTree.addElement(theWord);
		}else
		{
			urlWordTree.find(theWord).incrementCount();
		}
	}
	
//	• A method named contains. This method should take a String argument, create a new Word
//	object from it, and return a boolean corresponding to whether or not the new word is in the tree.
	public boolean contains(String newWord)
	{
		Word theWord = new Word(newWord);
		if(urlWordTree.contains(theWord))
		{
			return true;
		}
		return false;
	}
	
//	• A method named getFrequency. This method should take a String argument, create a new
//	Word object from it, and return an int that is the number of times the word has been added to the tree.
	public int getFrequency(String newWord)
	{
		Word theWord = new Word(newWord);
		if(urlWordTree.contains(theWord))
		{
			return urlWordTree.find(theWord).getCount();
		}
		return 0;
	}
	
//	• A toString method. This method should return a String representation of a URLWords
//	object, including the URL itself and each Word in the tree (Hint 1: use your
//	Word.toString() method. Hint 2: LinkedBinarySearchTree is iterable so you can use a for each loop)
	//TODO
	
}
