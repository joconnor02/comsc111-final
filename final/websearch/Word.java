package websearch;

public class Word implements Comparable<Word>
{
	private String word = new String();
	private int count = 0;
	
	public Word(String start)
	{
		word = start;
		count = 1;
	}
	
	public Word(String start, int Count)
	{
		word = start;
		count = Count;
	}

	public int getCount()
	{
		return count;
	}
	
	public void setCount(int Count)
	{
		count = Count;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void setWord(String Word)
	{
		word = Word;
	}

	public void incrementCount()
	{
		count++;
	}

	public String toString()
	{
		return word + " " + Integer.toString(count);
	}
	
//	• Override the equals methods of the Object class. Words are equal if their Strings are equal.
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null || obj.getClass()!= this.getClass())
		{
			return false; 
		}
		Word theWord = (Word) obj;
		if(word.equals(theWord.getWord()))
		{
			return true;
		}
		return false;
	}
	
	
//	• Implement the Comparable interface. This means adding a method that overrides compareTo.
//	(Words are ordered according to their Strings, so as with equals, you can use the String
//	compareTo method).
	@Override
	public int compareTo(Word obj)
	{
		return word.compareTo(obj.getWord());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
