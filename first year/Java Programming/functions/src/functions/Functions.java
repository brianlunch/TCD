package functions;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Functions {
public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in );
		System.out.println("This program computes the average and standard deviation of a list of highScores.");
		double[] highScores = null;
		double total = 0.0;
		boolean finished = false;
		do {
			System.out.print("Enter a number to add to the list (enter quit to finish) >>  ");
			if (input.hasNextDouble())
			{
				// Extend array and store new number.
				double[] newhighScores = new double[(highScores==null)?1:highScores.length+1];
				if (highScores!= null)
					System.arraycopy( highScores, 0, newhighScores, 0, highScores.length );
				newhighScores[newhighScores.length-1] = input.nextDouble();;
				highScores = newhighScores;
				total += highScores[highScores.length-1];
			}
			else finished = true;
		} while (!finished);
		
		if (highScores != null)
		{
			double average = total/((double) highScores.length);
			double sumOfSquaredDifferences = 0.0;
			for (int index=0; index < highScores.length; index++)
			{
				sumOfSquaredDifferences += Math.pow(highScores[index]-average,2.0);
			}
			double standardDeviation = Math.sqrt(sumOfSquaredDifferences/((double) highScores.length));
			System.out.println("The average is " + average + " and the standard deviation is " + standardDeviation);
		}
	}

}