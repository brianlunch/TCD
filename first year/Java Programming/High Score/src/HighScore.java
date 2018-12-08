import java.util.Scanner;

public class HighScore {



	public static void main (String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("How many high scores would you like displayed? >>  ");
			int numberOfScoresWanted = input.nextInt();

			int[] highScores =  new int [numberOfScoresWanted];
			boolean finished = false;


			
			do
			{
				System.out.println("Enter a score to add to the high scores (enter 'done' to display the high scores) >>  ");

				if(input.hasNextInt())
				{
					int newScore = input.nextInt();
					insertScore(newScore, highScores);
					System.out.println(printHighScores(numberOfScoresWanted, highScores));
				}

				else if (input.hasNext("done"))
					finished = true;
				
				else
				{
					System.out.println("Please enter digits and the word 'done' only. Please re-start the program.");
					finished = true;
				}
					
			}
			while(!finished);

			input.close();
	}
			catch(java.util.InputMismatchException exception)
			{
				System.out.println("Please enter digits and the word 'done' only. Please re-start the program.");	
			}
	}

	public static void initialiseHighScores(int[] highScores)
	{
		for (int count = 0; count < highScores.length; count++)
			highScores[count] = 0;
	}


	public static String printHighScores(int numberOfScoresWanted, int[] highScores )
	{
		String topHighScores = "";
		numberOfScoresWanted = numberOfScoresWanted - 1;
		for(int arrayPosition = 0; numberOfScoresWanted >= arrayPosition; arrayPosition++)
		{
			if (numberOfScoresWanted == arrayPosition && highScores[arrayPosition] != 0)
				topHighScores += highScores[arrayPosition] + ".";
			else if (highScores[arrayPosition] != 0)
				topHighScores += highScores[arrayPosition] + ", ";
		}

		String printHighScores = "The high scores are " + topHighScores;
		return printHighScores;
	}

	public static boolean higherThan (int newScore, int[] highScores)
	{
		for (int count = 0; count < highScores.length; count++)
		{
			if (newScore > highScores[count])
				return true;
		}
		return false;		
	}
	public static void insertScore(int newScore, int[] highScores)
	{
		int positionOfNewScore= 0;

		if(higherThan(newScore, highScores))
		{
			int PositionCount = 0;
			boolean finished = false;

			while(!finished && PositionCount < highScores.length)
			{
				if(newScore > highScores[PositionCount])
				{
					positionOfNewScore = PositionCount;
					finished = true;
				}

				PositionCount++;
			}

			for(int count = highScores.length - 2; count >= positionOfNewScore; count--)
			{
				highScores[count+1] = highScores[count];	
			}

			highScores[positionOfNewScore] = newScore;

		}
	}

}

	
