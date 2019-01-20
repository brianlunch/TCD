// -------------------------------------------------------------------------

import java.util.Stack;

/**
 * Utility class containing validation/evaluation/conversion operations
 * for prefix and postfix arithmetic expressions.
 *
 * @author  Brian Lynch
 * @version 1/12/15 13:03:48
 */

public class Arith {

    /*

    IMPORTANT:  throughout this assignment i use a worst-case asymptotic runtime because
                I beleive it shows the true effeciency of the code and must be known
                especially for such a simple program the worst case should still be relatively
                low and almost always is the same as the average running time for this assignment.

     */
    //~ Validation methods ..........................................................


    /**
     * Validation method for prefix notation.
     *
     * @param prefixLiterals : an array containing the string literals hopefully in prefix order.
     *                       The method assumes that each of these literals can be one of:
     *                       - "+", "-", "*", or "/"
     *                       - or a valid string representation of an integer.
     * @return true if the parameter is indeed in prefix notation, and false otherwise.
     **/

    /*
        Worst- case running time is O(n), I think this is optimal because in order to decide if an equation is valid
        You must check all n number of prefix literals.It also doesnt use any unecessary memory
     */
    public static boolean validatePrefixOrder(String prefixLiterals[]) {
        int count = 1;

        for (int i = 0; i < prefixLiterals.length; i++) {
            if (count <= 0)
                return false;
            if (isOperator(prefixLiterals[i]))
                count++;
            else if (isInt(prefixLiterals[i]))
                count--;
        }
        if (count == 0)
            return true;
        else
            return false;
    }

    //This function has a worst case runtime of O(1).
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    // This function has a worst case runtime of O(1).
    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))
            return true;
        else
            return false;
    }

    /**
     * Validation method for postfix notation.
     *
     * @param postfixLiterals : an array containing the string literals hopefully in postfix order.
     *                        The method assumes that each of these literals can be one of:
     *                        - "+", "-", "*", or "/"
     *                        - or a valid string representation of an integer.
     * @return true if the parameter is indeed in postfix notation, and false otherwise.
     **/
    /* Worst- case running time is O(n), I think this is optimal because in order to decide if an equation is valid
        You must check all n number of postfix literals. It also doesnt use any unecessary memory
     */
    public static boolean validatePostfixOrder(String postfixLiterals[]) {
        //TODO
        int count = 0;
        boolean isOp =false;

        for (int i = 0; i < postfixLiterals.length; i++) {

            if (isOperator(postfixLiterals[i])) {
                count--;
                count--;
                if (count < 0)
                    return false;
                count++;
            }
            else if (isInt(postfixLiterals[i]))
                count++;
        }
        if (count == 1)
            return true;

        return false;
    }


    //~ Evaluation  methods ..........................................................


    /**
     * Evaluation method for prefix notation.
     *
     * @param prefixLiterals : an array containing the string literals in prefix order.
     *                       The method assumes that each of these literals can be one of:
     *                       - "+", "-", "*", or "/"
     *                       - or a valid string representation of an integer.
     * @return the integer result of evaluating the expression
     **/
    /*
        The worst case run time is O(n), this is optimal because in order to evaluate a sum one must go through
        all operands and operators in the sum. It uses the function evaluate(String [], Stack, int) which has
        a worst-case of O(1). It also doesnt use any unecessary memory
     */
    public static int evaluatePrefixOrder(String prefixLiterals[]) {
        //TODO
        Stack<Integer> stack = new Stack<Integer>();
        //TODO
        for (int i = prefixLiterals.length-1; i >= 0; i--) {
            if (isInt(prefixLiterals[i]))
                stack.push(Integer.parseInt(prefixLiterals[i]));

            else if (isOperator(prefixLiterals[i])) {
                int a = stack.pop();
                int b = stack.pop();
                int result = 0;

                if (prefixLiterals[i].equals("*"))
                    result = b * a;
                else if (prefixLiterals[i].equals("-"))
                    result = a - b;
                else if (prefixLiterals[i].equals("+"))
                    result = a + b;
                else if (prefixLiterals[i].equals("/"))
                    result = a / b;

                stack.push(result);
            }

        }
        return stack.pop();
    }





    /**
     * Evaluation method for postfix notation.
     *
     * @param postfixLiterals : an array containing the string literals in postfix order.
     *                        The method assumes that each of these literals can be one of:
     *                        - "+", "-", "*", or "/"
     *                        - or a valid string representation of an integer.
     * @return the integer result of evaluating the expression
     **/
    /*
        The worst case run time is O(n), this is optimal because in order to evaluate a sum one must go through
        all operands and operators in the sum. It uses the function evaluate(String [], Stack, int) which has
        a worst-case of O(1). It also doesnt use any unecessary memory
     */
    public static int evaluatePostfixOrder(String postfixLiterals[]) {
        Stack<Integer> stack = new Stack<Integer>();
        //TODO
        for (int i = 0; i < postfixLiterals.length; i++) {
            if (isInt(postfixLiterals[i]))
                stack.push(Integer.parseInt(postfixLiterals[i]));

            else if (isOperator(postfixLiterals[i])) {
                int a = stack.pop();
                int b = stack.pop();
                int result = 0;

                if (postfixLiterals[i].equals("*"))
                    result = a * b;
                else if (postfixLiterals[i].equals("-"))
                    result = b - a;
                else if (postfixLiterals[i].equals("+"))
                    result = a + b;
                else if (postfixLiterals[i].equals("/"))
                    result = b / a;

                stack.push(result);
            }

        }
        return stack.pop();
    }


    //~ Conversion  methods ..........................................................


    /**
     * Converts prefix to postfix.
     *
     * @param prefixLiterals : an array containing the string literals in prefix order.
     *                       The method assumes that each of these literals can be one of:
     *                       - "+", "-", "*", or "/"
     *                       - or a valid string representation of an integer.
     * @return the expression in postfix order.
     **/
    /*
        Worst- case running time is O(n), I think this is optimal because in order to convert an equation from one
        type to another all n number of prefix literals must be converted. It also doesnt use any unecessary memory
     */
    public static String[] convertPrefixToPostfix(String prefixLiterals[]) {
        //TODO
        Stack<String> stack = new Stack<String>();
        for (int i = prefixLiterals.length-1; i >=0; i--) {
           if(isInt(prefixLiterals[i]))
               stack.push(prefixLiterals[i]);
           if(isOperator(prefixLiterals[i]))
           {
               String a = stack.pop();
               String b = stack.pop();
               String s =  a+ " " + b+ " "+prefixLiterals[i];
               stack.push(s);
           }
        }
        return stringToArray(stack.pop());
    }


    /**
     * Converts postfix to prefix.
     *
     * @param postfixLiterals : an array containing the string literals in postfix order.
     *                        The method assumes that each of these literals can be one of:
     *                        - "+", "-", "*", or "/"
     *                        - or a valid string representation of an integer.
     * @return the expression in prefix order.
     **/
    /*
        Worst- case running time is O(n), I think this is optimal because in order to convert an equation from one
        type to another all n number of prefix literals must be converted. It also doesnt use any unecessary memory
     */
    public static String[] convertPostfixToPrefix(String postfixLiterals[]) {
        //TODO
        //TODO
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < postfixLiterals.length; i++) {
            if(isInt(postfixLiterals[i]))
                stack.push(postfixLiterals[i]);
            if(isOperator(postfixLiterals[i]))
            {
                String a = stack.pop();
                String b = stack.pop();
            String s = postfixLiterals[i]+ " " + b+ " " + a;
            stack.push(s);
            }
        }

        return stringToArray(stack.pop());
    }
    // The worst case runtime is O(n)
    public static String[] stringToArray(String s){
        String[] array = s.split("\\s+");
        return array;
    }

    /**
     * Converts prefix to infix.
     *
     * @param prefixLiterals : an array containing the string literals in prefix order.
     *                       The method assumes that each of these literals can be one of:
     *                       - "+", "-", "*", or "/"
     *                       - or a valid string representation of an integer.
     * @return the expression in infix order.
     **/
    /*
        Worst- case running time is O(n), I think this is optimal because in order to convert an equation from one
        type to another all n number of prefix literals must be converted. It also doesnt use any unecessary memory
     */
    public static String[] convertPrefixToInfix(String prefixLiterals[]) {
        //TODO
        Stack<String> stack = new Stack<String>();
        for (int i = prefixLiterals.length-1; i >=0; i--) {
            if(isInt(prefixLiterals[i]))
                stack.push(prefixLiterals[i]);
            if(isOperator(prefixLiterals[i]))
            {
                String a = stack.pop();
                String b = stack.pop();
                String s =  "(" + " "+ a+ " " +prefixLiterals[i]+" "+ b+ " "+ ")";
                stack.push(s);
            }
        }
        //System.out.println(stack.pop());

        return stringToArray(stack.pop());
    }

    /**
     * Converts postfix to infix.
     *
     * @param postfixLiterals : an array containing the string literals in postfix order.
     *                        The method assumes that each of these literals can be one of:
     *                        - "+", "-", "*", or "/"
     *                        - or a valid string representation of an integer.
     * @return the expression in infix order.
     **/
    /*
        Worst- case running time is O(n), I think this is optimal because in order to convert an equation from one
        type to another all n number of prefix literals must be converted.
     */
    public static String[] convertPostfixToInfix(String postfixLiterals[]) {
        //TODO
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < postfixLiterals.length; i++) {
            if(isInt(postfixLiterals[i]))
                stack.push(postfixLiterals[i]);
            if(isOperator(postfixLiterals[i]))
            {
                String a = stack.pop();
                String b = stack.pop();
                String s =  "(" + " "+ b+ " " +postfixLiterals[i]+" "+ a+ " "+ ")";
                stack.push(s);
            }
        }
        //System.out.println(stack.pop());
        return stringToArray(stack.pop());
    }
}
/*
Data structures used:

Stack - In the Java Util library. I used the following methods:

           - push(): This has a worst-case run-time O(1)
           - pop(): This has a worst-case run-time of O(1)

String.Split(regex) - Worst Case run-time is O(n), n being the number of characters in the String.
 */