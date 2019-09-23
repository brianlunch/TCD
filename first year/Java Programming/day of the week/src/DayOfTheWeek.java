import java.util.Scanner;
import javax.swing.JOptionPane;

/* SELF ASSESSMENT
1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5 - yes i think i used understandable names in uppercase 
2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5: 5 - i think my variable names make sense and are formatted correct
3. Did I indent the code appropriately?
       Mark out of 5: 5 - it is indented using ctrl + i
4. Did I define the required function correctly (names, parameters & return type) and invoke them correctly?
      Mark out of 20: 20 - yes theyre defined correct and called correct
5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
      Mark out of 20:  20 - it didnt using the given formula, it had an error of -2 so i simply added -2 to the result before mod 7 to correct this
6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
      Mark out of 20:  20 - i did, and i used functions from my own tutorial mid-week and from validDate.java
7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?       
	Mark out of 10: 10 - i did and it dealt with errors
8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
      Mark out of 10:  10 - it does
9. How well did I complete this self-assessment?
       Mark out of 5: 5 - i was honest
Total Mark out of 100 (Add all the previous marks): 100
*/ 

public class DayOfTheWeek {
	
	public static final int DAYS_IN_SEP_APR_JUN_NOV = 30;
	public static final int DAYS_IN_FEB = 28;
	public static final int DAYS_IN_FEB_LEAP_YEAR = 29;
	public static final int DAYS_IN_JAN_MAR_MAY_JUL_AUG_OCT_DEC = 31;
	
	public static void main(String[] args) {

		try {
			String input = JOptionPane.showInputDialog("Enter a date in the form dd/mm/yyyy");
			Scanner inputScanner = new Scanner(input);
			inputScanner.useDelimiter("/");
			int day = inputScanner.nextInt();
			int month = inputScanner.nextInt();
			int year =  inputScanner.nextInt();
			inputScanner.close();

			if (validDate(day, month, year))
				JOptionPane.showMessageDialog(null, dayOfTheWeek(day, month, year) + ", " + day + numberEnding(day) 
				+ monthName(month)+ year + ".");
			
			else
				JOptionPane.showMessageDialog(null, "This is not a valid date.");
		}

		catch(java.util.InputMismatchException exception)
		{
			JOptionPane.showMessageDialog(null, "Incorrect format used, please use the format dd/mm/yyyy and use numbers and ' / ' only.");	
		}

		catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "No date entered");	 
		}

	}









	
	
	
	
	
	

	// FUNCTIONS


	public static String numberEnding(int day)
	{
		int lastDigitOfDay = day % 10; 
		String ordinalIndicator = ""; 

		if(day >= 11 && day <= 19)
			ordinalIndicator = "th";
		else 
		{
			switch(lastDigitOfDay)
			{
			case 1: 
				ordinalIndicator = "st";
				break;
			case 2:
				ordinalIndicator = "nd";
				break;
			case 3:
				ordinalIndicator = "rd";
				break;
			default:
				ordinalIndicator = "th";
				break;
			}
		}
		return ordinalIndicator;
	}


	public static String monthName(int monthNumber)
	{
		String monthName = "";
		switch(monthNumber)
		{
		case 1:
			monthName = " January ";
			break;
		case 2 :
			monthName = " February ";
			break;
		case 3:
			monthName = " March ";
			break;
		case 4:
			monthName = " April ";
			break;
		case  5:
			monthName = " May ";
			break;
		case 6:
			monthName = " June ";
			break;
		case 7:
			monthName = " July ";
			break;
		case 8:
			monthName = " August ";
			break;
		case 9:
			monthName = " September ";
			break;
		case 10:
			monthName = " October ";
			break;
		case 11:
			monthName = " November ";
			break;
		case 12:
			monthName = " December ";
			break;
		}
		return monthName;
	}


	public static String dayOfTheWeek(int day, int month, int year)
	{
		String dayName = "";
		int dayNumber = 0;

		if (month == 1 || month == 2)
			year = year - 1;

		int y = year % 100;
		int c = year / 100;
		dayNumber = (int)(day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + Math.floor(y/4) + Math.floor(c/4) - 2*c);

		while(dayNumber < 0)
		{
			dayNumber +=  7; //Turns the result positive.
		}

		dayNumber = (dayNumber) % 7;
		
		


		switch (dayNumber)
		{
		case 0 :
			dayName = "Sunday";
			break;
		case 1:
			dayName = "Monday";
			break;
		case 2:
			dayName = "Tuesday";
			break;
		case 3:
			dayName = "Wednesday";
			break;
		case 4:
			dayName = "Thursday";
			break;
		case 5:
			dayName = "Friday";
			break;
		case 6:
			dayName = "Saturday";
			break;
		}
		return dayName;
	}


	// Here i used my own code from this weeks tutorial, i also used the validDate.java to ensure my code worked.
	public static boolean validDate(int days, int month, int year)
	{
		if ((year >= 1) &&  (month <= 12) && (month >= 1) && (days <= daysInMonth(month, year)))
			return true;
		else
			return false;
	}

	public static int daysInMonth(int month, int year)
	{
		switch(month)
		{
		case 9:
		case 4:
		case 6:
		case 11:
			int daysInMonth = DAYS_IN_SEP_APR_JUN_NOV;
			return daysInMonth;
		case 2:
			if(isLeapYear(year))
			{
				daysInMonth = DAYS_IN_FEB_LEAP_YEAR;
				return daysInMonth;
			}
			else
			{
				daysInMonth = DAYS_IN_FEB;
				return daysInMonth;
			}
		default:
		{
			daysInMonth =  DAYS_IN_JAN_MAR_MAY_JUL_AUG_OCT_DEC;
			return daysInMonth;
		}
		}

	}

	public static boolean isLeapYear(int year)
	{
		if ((year % 4 == 0) && (year % 100 == 0) || (year % 400 != 0))
			return true;

		else 
			return false;	
	}
}