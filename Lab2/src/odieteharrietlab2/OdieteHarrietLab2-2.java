/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package odieteharrietlab2;

/**
 *
 * @author hodiete
 */
import java.util.Scanner;
import java.util.ArrayList;
public class OdieteHarrietLab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Temperature> theList = new ArrayList<Temperature>(7);
        Temperature temp = new Temperature();
        double input;
        double newValue;
        double newTemp;
        int choice;
        int checker;
        char degree;
        int userChoice = 0;
        System.out.println("Please enter the forecast for the week:");
        for(int i = 0; i<7; i++)
        {
            System.out.print("Temperature " +(i+1)+ ": ");
            input = keyboard.nextDouble();
            temp = new Temperature(input);
            theList.add(i,temp);
        }
        do
        {
            System.out.println(".....................................................");
            System.out.println(".   1- Print out the 7 day forecast                 .");
            System.out.println(".   2- Convert the temperatures to a different unit .");
            System.out.println(".   3- Change the temperature for a day             .");
            System.out.println(".   4- Retrieve days with the same temperatures .");
            System.out.println(".   5- Exit program                                 .");
            System.out.println(".....................................................");
            System.out.print("Please enter your choice from 1-5: ");
            userChoice = keyboard.nextInt();
            switch(userChoice)
            {
                case 1:
                    for(int i = 0; i<theList.size(); i++)
                    {
                        System.out.println((i+1)+ " - " +theList.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Please enter the unit you would like to change the temperatures to");
                    System.out.print("Enter either C for Celsius, F for Fahrenheit or K for Kelvin: ");
                    degree = keyboard.next().charAt(0);
                    switch(degree)
                    {
                        case 'C':
                            for(int i = 0; i<7; i++)
                            {
                                newValue = theList.get(i).convertToCelsius(theList.get(i).getTemperature());
                                Temperature t = new Temperature(newValue, degree);
                                theList.set(i, t);
                            }
                            break;
                        case 'F':
                            for(int i = 0; i<7; i++)
                            {
                                newValue = theList.get(i).convertToFahrenheit(theList.get(i).getTemperature());
                                Temperature t = new Temperature(newValue, degree);
                                theList.set(i, t);
                            }
                            break;
                        case 'K':
                            for(int i = 0; i<7; i++)
                            {
                                newValue = theList.get(i).convertToKelvin(theList.get(i).getTemperature());
                                Temperature t = new Temperature(newValue, degree);
                                theList.set(i, t);
                            }
                            break;
                        default:
                            System.out.println("Invalid option");
                            System.out.println("Please try again");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Please enter the day you will like to change");
                    System.out.print("Please enter from 1-7: ");
                    choice = keyboard.nextInt();
                    System.out.print("Please enter the new temperature: ");
                    newTemp = keyboard.nextDouble();
                    if(choice <= 0 || choice > 7)
                    {
                        System.out.println("Unable to change temperature");
                        System.out.println("The day entered is not in the range of days of temperatures (1-7)");
                    }
                    else
                    {
                        theList.get(choice-1).setTemperature(newTemp);
                    }
                    break;
                case 4:
                    for(int i = 0; i < 7; i++)
                    {
                        checker = 0;
                        for(int j=i+1; j<7; j++)
                        {
                            if(theList.get(i).equals(theList.get(j)))
                            {
                                checker = theList.indexOf(i);
                                System.out.println("Day " +checker+ "has the same day as ");
                            }
                            else
                            {
                                System.out.println("no");
                            }
                        }
                        
                    }
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.out.println("Good-bye");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please try again");
            }
        }
        while(userChoice != 5);
        
    }

   
}
