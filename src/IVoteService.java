import java.util.ArrayList;
import java.util.Hashtable;


public class IVoteService {

	/**
	 * The hashTable prevents the student with the same ID to make multiple submissions
	 * Keeps track of student submissions
	 */
	private Hashtable<Integer, ArrayList<String>> results;
	/**
	 * Keeps track of the numerical amount of votes for each multiple choice question
	 */
	private int [] counter;
	/**
	 * Keeps track of the numerical amount of votes for each single choice question
	 */
	private int [] counter2;
	/**
	 * All candidate answers for a single choice question
	 */
	private String[] possibleSingleAnswers = {"1. Right", "2. Wrong"};
	/**
	 * The type of question that this service is handling 
	 */
	private Question quest;

	/**
	 * Constructor for the IVoteServices
	 * Initializes the results and counters
	 */
	public IVoteService()
	{
		results = new Hashtable<Integer, ArrayList<String>>();
		counter = new int[5];
		counter2 = new int[2];
		
	}

	/**
	 * Setter method for the question variable
	 * Tells the service what kind of question is being handled
	 * 
	 * @param ques the type of question
	 */
	public void setQuestion(Question ques)
	{
		quest = ques;
	}

	/**
	 * Stores the students answers.
	 * Only the last submission will count if the same student makes multiple submissions.
	 * 
	 * @param answer the answer or answers that the student submitted
	 * @param stud the student who submitted the answer
	 */
	public void getVote(ArrayList<String> answer, Student stud)
	{
		//results are stored in a hashTable
		results.put(stud.getId(), answer);
	}

	/**
	 * Counts the number of votes and displays the results
	 * 
	 * @param ques the type of question that is being handled
	 */
	public void calculateVotes(Question ques)
	{
		for(Integer key : results.keySet())
		{
			for(int i = 0; i < results.get(key).size(); i++)
			{
				checkAndIncrement(results.get(key).get(i));
			}
		}
		
		if(ques instanceof MultipleChoiceQuestion)
		{
			for(int i = 0; i < counter.length; i++)
			{
				char let = (char)(65 + i);
				System.out.println(let + ": " + counter[i] + " ");
			}
		}
		else
		{
			for(int i = 0; i < counter2.length; i++)
			{
				System.out.println(possibleSingleAnswers[i] + ": " + counter2[i] + " ");
			}
		}
		
	}

	/**
	 * checks which answers was chosen and increments the count by 1
	 * 
	 * @param letter the result that's being checked
	 */
	private void checkAndIncrement(String letter)
	{
		switch (letter) {
		case "A": counter[0]++;
			break;
		case "B": counter[1]++;
			break;
		case "C": counter[2]++;
			break;
		case"D": counter[3]++;
			break;
		case"E": counter[4]++;
			break;
		case "1. Right": counter2[0]++;
			break;
		case "2. Wrong": counter2[1]++;
			break;
		default:
			break;
		}
	}


}
