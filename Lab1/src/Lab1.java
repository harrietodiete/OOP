/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author harrietodiete
 */
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scannerInput;
        scannerInput = new Scanner(System.in);
        int choice = 0;
        int i;
        int length;
        int numbers;
        int spaces;
        int vowels;
        int consonants;
        char ch;
        String userInput = "";
        String reversedString = "";
        do
        {
            System.out.println("1. Input String");
            System.out.println("2. Print String");
            System.out.println("3. Reverse the String");
            System.out.println("4. Tokenize String");
            System.out.println("5. Count spaces in the string");
            System.out.println("6. Check for a number in the string");
            System.out.println("7. Count Vowels");
            System.out.println("8. Count Consonants");
            System.out.println("9. Exit Program");
            boolean done = false;
            while(!done)
            {
                try
                {
                    System.out.print("Please enter a choice: ");
                    choice = scannerInput.nextInt();
                    scannerInput.nextLine();
                    done = true; //This will end the loop.
                }
                catch(InputMismatchException e)
                {
                    scannerInput.nextLine();
                    System.out.println("Invalid entry.");
                    System.out.println("Please Try again, Available options: 1 - 9");
                }
            }
            switch(choice)
            {
                case 1:
                    System.out.print("Please enter a string: ");
                    userInput = scannerInput.nextLine(); 
                    break;
                case 2:
                    if(userInput.equals(""))
                    {
                        System.out.println("Operation cannot occur.");
                        System.out.println("No string has been entered into the program.");
                    }
                    else
                    {
                        System.out.println("You entered: \"" + userInput + "\" as your string");
                    }
                    break;
                case 3:
                    if(userInput.equals(""))
                    {
                        System.out.println("Operation cannot occur.");
                        System.out.println("No string has been entered into the program.");
                    }
                    else
                    {
                        length = userInput.length();
                        for(i=length - 1; i>=0; i--)
                        {
                            reversedString = reversedString + userInput.charAt(i);
                        }
                        System.out.println("The string \"" + userInput + "\" reversed is: " + reversedString + "");
                    }
                    break;
                case 4:
                    if(userInput.equals(""))
                    {
                        System.out.println("Operation cannot occur.");
                        System.out.println("No string has been entered into the program.");
                    }
                    else
                    {
                        StringTokenizer str = new StringTokenizer(userInput);
                        System.out.println("The tokenized string is:");
                        while(str.hasMoreTokens())
                        {
                            System.out.println(str.nextToken());
                        }
                    }
                    break;
                case 5:
                    if(userInput.equals(""))
                    {
                        System.out.println("Operation cannot occur.");
                        System.out.println("No string has been entered into the program.");
                    }
                    else
                    {
                        spaces = 0;
                        length = userInput.length();
                        for(i=0; i<length; i++)
                        {
                            ch = userInput.charAt(i);
                            if(Character.isWhitespace(ch))
                            {
                                spaces++;
                            }
                        }
                        System.out.println("The number of spaces in the string \"" + userInput + "\" is: " + spaces + "");
                    }
                    break;
                case 6:
                    if(userInput.equals(""))
                    {
                        System.out.println("Operation cannot occur.");
                        System.out.println("No string has been entered into the program.");
                    }
                    else
                    {
                        numbers = 0;
                        length = userInput.length();
                        for(i=0; i<length; i++)
                        {
                            ch = userInput.charAt(i);
                            if(Character.isDigit(ch))
                            {
                                numbers++;
                            }
                        }
                        System.out.print("The string contains numbers? ");
                        if(numbers == 0)
                        {
                            System.out.println("false");
                        }
                        else
                        {
                            System.out.println("true");
                        }
                    }
                    break;
                case 7:
                    if(userInput.equals(""))
                    {
                        System.out.println("Operation cannot occur.");
                        System.out.println("No string has been entered into the program");
                    }
                    else
                    {
                        vowels = 0;
                        length = userInput.length();
                        for(i=0; i<length; i++)
                        {
                            ch = userInput.charAt(i);
                            if((ch == 'a') || (ch == 'A') || (ch == 'e') || (ch == 'E') || (ch == 'i') || (ch == 'I') || (ch == 'o') || (ch == 'O') || (ch == 'u') || (ch == 'U'))
                            {
                                vowels++;
                            }
                        }
                        System.out.println("The number of vowels in the string \"" + userInput + "\" is: " + vowels + "");
                    }
                    break;
                case 8:
                    if(userInput.equals(""))
                    {
                        System.out.println("Operation cannot occur.");
                        System.out.println("No string has been entered into the program.");
                    }
                    else
                    {
                        consonants = 0;
                        length = userInput.length();
                        for(i=0; i<length; i++)
                        {
                            ch = userInput.charAt(i);
                            if((ch != 'a') && (ch != 'A') && (ch != 'e') && (ch != 'E') && (ch != 'i') && (ch != 'I') && (ch != 'o') && (ch != 'O') && (ch != 'u') && (ch != 'U') && !Character.isWhitespace(ch) && !Character.isDigit(ch) && Character.isLetter(ch))
                            {
                                consonants++;
                            }
                        }
                        System.out.println("The number of consonants in the string \""+ userInput +"\" is: " + consonants + "");
                    }
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    System.out.println("Good-bye!");
                    break;
                default:
                    System.out.println("Invalid entry.");
                    System.out.println("Please Try again, Available options: 1 - 9");
                    break;
            } 
        }
        while(choice != 9);
    }
}
