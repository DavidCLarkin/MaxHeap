package main;


public class DictionaryWord implements Comparable<DictionaryWord>
{
	private String spanish;
	private String english;
	
	public DictionaryWord(String spanish, String english)
	{
		this.spanish = spanish;
		this.english = english;
	}
	
	/**
	 * Get English word
	 * @return
	 */
	public String getEnglish()
	{
		return english;
	}
	
	/**
	 * Get Spanish word
	 * @return
	 */
	public String getSpanish()
	{
		return spanish;
	}
	
	/**
	 * Set English word
	 * @param english
	 */
	public void setEnglish(String english)
	{
		this.english = english;
	}
	
	/**
	 * Set Spanish word
	 * @param spanish
	 */
	public void setSpanish(String spanish)
	{
		this.spanish = spanish;
	}
	
	public String toString()
	{
		return "Spanish: "+ spanish + ", "+"English: "+ english+"\n";
	}

	@Override
	public int compareTo(DictionaryWord word) {
		return spanish.compareTo(word.getSpanish());
	}



}
