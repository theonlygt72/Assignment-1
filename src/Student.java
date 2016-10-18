import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Student {
	
	/**
	 * A randomly generated student id
	 */
	private int id;
	
	public Student()
	{
		id = generateId();
	}
	
	/**
	 * Chooses one or multiple answers depending on the question type
	 * 
	 * @param type the type of question that is being answered
	 * @return the answer or list of answers that were chosen
	 */
	public  ArrayList<String> vote(Question type)
	{
		final String choices = "ABCDE";
		ArrayList<String> decision = new ArrayList<String>();
		//Selects multiple answers
		if (type instanceof MultipleChoiceQuestion)
		{
			//generates multiple random answers, no duplicates
			 Set<String> all = new HashSet<String>();
			 for(int i = 0; i < (int)(Math.random() * 4); i++)
			 {
				 int pos = (int)(Math.random() * choices.length());
				 all.add(choices.substring(pos, pos +1));
			 }
			 decision.addAll(all);
		}
		//Selects a single answer
		else
		{
			String answer = "";
			if(Math.random() < .5)
			{
				answer = "1. Right";
			}
			else
			{
				answer = "2. Wrong";
			}
			decision.add(answer);
		}
		return decision;
	}
	
	/**
	 * Randomly generates an ID
	 * 
	 * @return a unique id for the student
	 */
	private int generateId()
	{
		return (int)(Math.random() * 100000000);
	}
	
	/**
	 * Gets the student's ID
	 * 
	 * @return the student's ID
	 */
	public int getId()
	{
		return id;
	}

}
