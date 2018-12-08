
public class SieveOfErathosthenes {
	
	
	public static void main(String[] args) {
		
		int numberArray[] = {1, 2, 3, 4, 5, 6, 7};
		int number = 7;
		//createSequence(number, numberArray);
		
		crossOutHigherMultiples(numberArray,number);
		for(int count = 0; count < numberArray.length;count++)
		{
			if(numberArray[count] == number)
				System.out.print(numberArray[count]);
			else	
				System.out.print(numberArray[count] + ", ");
		}
	}

	public static void createSequence(int number, int[] numberArray)
	{
		numberArray = new int [number-1];
		int arrayNumber = 2;
		for(int count = 0; count < numberArray.length;count++)
		{
			numberArray[count]= arrayNumber;
			arrayNumber++;
			if(numberArray[count] == number)
				System.out.print(numberArray[count]);
			else	
				System.out.print(numberArray[count] + ", ");
		}
		
	}

	public static void crossOutHigherMultiples( int[] numberArray, int number)
	{
		int divisor = 2;
		boolean finished = false;
		int index= 0;

		while(divisor < Math.sqrt(number))
		{
			
			for(int count = 0; count < numberArray.length;count++)
			{
				if(numberArray[count] % divisor == 0)
				{
					numberArray[count] = 0;
				}
			}
			while(!finished)
			{
				if(numberArray[index] > 0)
				{
					divisor = numberArray[index];
					finished = true;
				}
			}
		}
		
	}
			
}

