
public class SimulationDriver {
	
	public static void main(String[] args)
	{
		int numStudents = 5 + (int)(Math.random() * 20);
		System.out.println("There are " + numStudents + " students.");
		for(int i = 0; i < 10; i++)
		{
			IVoteService system = new IVoteService();
			System.out.print("Question " + (i + 1) + " ");
			//Creates either a questions with multiple answers or a question with a single answer
			Question ques;
			if(Math.random() < .5)
			{
				ques = new MultipleChoiceQuestion();
				System.out.println("This is a question with multiple choices");
			}
			else
			{
				ques = new SingleChoiceQuestion();
				System.out.println("This is a question with a single choice");
			}
			system.setQuestion(ques);
			for(int x = 0; x < numStudents; x++)
			{
				Student stud = new Student();
				system.getVote(stud.vote(ques), stud);
			}
			system.calculateVotes(ques);
		}
		
		
	}

}
