/* SELF ASSESSMENT

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: i think so
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: i think so, it goes until pointer at null
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: i think so, in an arrayList

2. readWordList
- I have the correct method definition [Mark out of 5:]5
- Comment: i think so
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: it does, saves to an arrayList

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: i think so
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: it does using a while loop
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: it does
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: it does i tested

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: i think so
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: it does
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: it does

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: i think so
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: it does by turning them to char arrays

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: i think so
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: it does

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:]
- Comment: it does using a function
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: it does

 Total Mark out of 100 (Add all the previous marks):100
*/




import java.io.*;
import java.util.*;
import  static java.util.Arrays.*;
import static java.util.Arrays.asList;

public class WordLink {


    public static void main(String[] args) throws IOException {

        boolean finished = false;
        Scanner inputScanner = new Scanner(System.in);
        inputScanner.useDelimiter(",");

        while(!finished) {
            FileReader textFile = new FileReader("C:\\Users\\yes\\words.txt");
            String input = " ";
            System.out.println("Enter a comma separated list of words (or an empty list to quit):");

            if (inputScanner.hasNext()) {
                input = inputScanner.nextLine();

                if (isWordChain(textFile, input))
                    System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
                else
                    System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
            }


        }
    }


    public static ArrayList readDictionary(FileReader textFile) throws IOException {
        ArrayList dictionary = new ArrayList(6589624);
        ArrayList wordArrayList = new ArrayList();

        BufferedReader bufferedReader = new BufferedReader(textFile);
        String word;
        while ((word = bufferedReader.readLine()) != null) {
            dictionary.add(word);
        }
        return dictionary;
    }


    public static ArrayList readWordList(String input) {
        ArrayList<String> wordArrayList = new ArrayList<>(asList(input.split("[,|, ]+")));
        return wordArrayList;
    }

    public static boolean isUniqueList(ArrayList<String> wordArrayList) {
        boolean unique = true;

        for (int count = 0; count < wordArrayList.size(); count++) {
            for (int secondCount = count + 1; secondCount < wordArrayList.size(); secondCount++) {
                String word1, word2;
                word1 = wordArrayList.get(count);
                word2 = wordArrayList.get(secondCount);
                if (word1.equals(word2)) {
                    unique = false;
                }
            }
        }
        return unique;
    }

    public static boolean isEnglishWord(ArrayList<String> dictionary, ArrayList<String> wordArrayList) {
        boolean isEnglish = true;
        for (int index = 0; index < wordArrayList.size() && isEnglish; index++) {
            if (Collections.binarySearch(dictionary, wordArrayList.get(index)) > 0) {
            }
            else
                isEnglish = false;
        }
        return isEnglish;

    }

    public static boolean isDifferentByOne(ArrayList<String> wordArrayList)
    {
     boolean isDifferentByOne = false;
     int difference=0;
     boolean finished = false;
     for(int count= 0; count + 1< wordArrayList.size() && !finished; count++) {
         char[] word0ne = wordArrayList.get(count).toCharArray();
         char[] wordTwo = wordArrayList.get(count + 1).toCharArray();

        if (word0ne.length != wordTwo.length)
            finished = true;
        else {
            for (int index = 0; index < word0ne.length; index++) {
                if (word0ne[index] != wordTwo[index])
                    difference++;
            }
        }
     }
     if(difference == (wordArrayList.size() -1))
         isDifferentByOne = true;

     return isDifferentByOne;
    }

    public static boolean isWordChain(FileReader textFile, String input) throws IOException {
        boolean isWordChain = false;
        if(     isUniqueList(readWordList(input)) &&
                isDifferentByOne(readWordList(input)) &&
                isEnglishWord(readDictionary(textFile), readWordList(input)) )
            isWordChain= true;

        return isWordChain;
    }
}




