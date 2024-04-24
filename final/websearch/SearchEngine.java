package websearch;

import java.util.Arrays;
import java.util.HashMap;
import jsjf.ArrayUnorderedList;
import jsjf.PrioritizedObject;
import jsjf.PriorityQueue;

public class SearchEngine 
{
	//A private data field (class variable) of type ArrayUnorderedList<URLWords> to store the web crawl result that the search results will be based on.
	private ArrayUnorderedList<URLWords> array = new ArrayUnorderedList<URLWords>();
	
	//A private constant that specifies the maximum number of search results to be returned (I chose 10).
	private int limit = 10;

	//Hashmap for caching
	HashMap<String, String> cache = new HashMap<String, String>();
	
	//A constructor that takes an argument of type ArrayUnorderedList<URLWords> and sets the class data member
	public SearchEngine(ArrayUnorderedList<URLWords> arrayIn)
	{
		array = arrayIn;
	}
	
	//A search method. This method should take a String argument (the search terms) and return a String (the search result)
	public String search(String theterm)
	{
		String[] terms = theterm.split("\\s+");
		Arrays.sort(terms);

		//Check if the search has been done before
		if(cache.containsKey(Arrays.toString(terms)))
		{
			System.out.println("Cache hit!");
			return cache.get(Arrays.toString(terms));
		}

		PriorityQueue<String> results = new PriorityQueue<String>();
		//For every provided site, what is the sum of freq of every term, add every url and sum to results queue
		for (URLWords site : array)
		{
			int sum = 0;
			for (String term : terms)
			{
				sum += site.getFrequency(term);
			}
			if(sum > 0)
			{
				results.addElement(site.getURL(), sum);
			}
		}
		//Remove all but the 10 highest prio elements
		while(results.size() > limit)
		{
			results.removeNext();
		}
		
		//Get around the minheap problem in a safe way
		String[] top10 = new String[limit];
		int temp = limit - 1;
		while(!results.isEmpty())
		{
			top10[temp] = results.removeNext();
			temp--;
		}

		//Make it into a string with newlines
		String out = "";
		for (int i = 0; i < limit; i++)
		{
			if(!(top10[i] == null))
			{
				out += top10[i] + "\n";
			}
		}
		
		cache.put(Arrays.toString(terms), out);
		return out;
	}
	
}
