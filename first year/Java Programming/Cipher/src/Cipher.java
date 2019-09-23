import java.util.Random;
import java.util.Scanner;

public class Cipher {
	/* SELF ASSESSMENT
	 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
	        Mark out of 5: 2 - all formatted correctly
	 2. Did I indent the code appropriately?
	        Mark out of 5: 5 - i used ctrl + i
	 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?
	       Mark out of 20:  20 - it generated a random ordered alphabet
	 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?
	       Mark out of 20: 20 -  it worked perfect
	 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?
	       Mark out of 20: 20 -  it worked perfect
	 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?
	       Mark out of 25: 25 - it done as described
	 7. How well did I complete this self-assessment?
	        Mark out of 5: 5 - i was honest
	 Total Mark out of 100 (Add all the previous marks): 100
	*/ 
	
	public static void main(String[] args) {
		boolean finished = false;
		char [] cipherArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',' ' };
		char [] alphabetArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',' ' };
		createCipher(cipherArray);

		do
		{
			System.out.println("Enter a phrase to be converted to cipher text (or type 'exit') >> ");
			Scanner inputScanner = new Scanner(System.in);

			if(inputScanner.hasNextInt())
				System.out.println("Enter letters and spaces only.");

			else if(inputScanner.hasNext("exit"))
			{
				finished = true;
				inputScanner.close();
			}
			else
			{
				String phrase = inputScanner.next();
				System.out.println(encrypt(phrase, alphabetArray, cipherArray));
				decrypt(encrypt(phrase, alphabetArray, cipherArray), alphabetArray, cipherArray);
			}

		}
		while(!finished);
	}

	public static void createCipher(char cipherArray[]) {

		Random generator = new Random();

		for (int index=0; index<cipherArray.length; index++ )
		{
			int otherIndex = generator.nextInt(cipherArray.length);
			char temp = cipherArray[index];
			cipherArray[index] = cipherArray[otherIndex];
			cipherArray[otherIndex] = temp;
		}
	}


	public static String encrypt(String phrase, char alphabetArray[], char cipherArray[])
	{
		String cipheredPhrase = "";
		String lowerCasePhrase = phrase.toLowerCase();
		char[] phraseArray = lowerCasePhrase.toCharArray();
		int alphabetCount = 0;

		for(int phraseCount = 0; alphabetCount < alphabetArray.length && phraseCount < phraseArray.length; alphabetCount++)
		{
			if(phraseArray[phraseCount] == alphabetArray[alphabetCount])
			{
				cipheredPhrase += cipherArray[alphabetCount];
				phraseCount++;
				alphabetCount = -1;
			}

		}
		if (alphabetCount >= alphabetArray.length)
			cipheredPhrase = "Enter letters and spaces only.";

		return cipheredPhrase;
	}


	public static void decrypt(String cipheredPhrase, char alphabetArray[], char cipherArray[])
	{
		String phrase = "";
		char[] cipheredPhraseArray = cipheredPhrase.toCharArray();

		for(int cipheredPhraseCount = 0, cipherCount = 0 ; cipherCount < cipherArray.length && cipheredPhraseCount < cipheredPhraseArray.length; cipherCount++)
		{

			if(cipheredPhraseArray[cipheredPhraseCount] == cipherArray[cipherCount])
			{
				phrase += alphabetArray[cipherCount];
				cipheredPhraseCount++;
				cipherCount = -1;
			}
		}
		System.out.println(phrase);
	}

}
