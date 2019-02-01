/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odieteharrieta1;
import java.util.*;
/**
 *
 * @author Harriet
 */
public class DayPlanner {
    
    private static HomeActivity[] act1;
    private static SchoolActivity[] act2;
    private static OtherActivity[] act3;
    private int numberHomeActs;
    private int numberSchoolActs;
    private int numberOtherActs;
    private int maxNumber;
    
    /**
    * Initializes the maxNumber to five and act1, act2 and act3 to the size
    * of the maxNumber and numberHomeActs, numberSchoolActs and 
    * numberOtherActs to zero.
    */
    DayPlanner()
    {
        /*Instance variables initialization*/
        maxNumber = 5;
        act1 = new HomeActivity[maxNumber];
        act2 = new SchoolActivity[maxNumber];
        act3 = new OtherActivity[maxNumber];
        numberHomeActs = 0;
        numberSchoolActs = 0;
        numberOtherActs = 0;
    }
    
    /**
    * Adds activities to either the HomeAcitivity array or SchoolActivity 
    * array or OtherActivity array.
    * @param userChoice Used to know what array to store the activities to.
    */
    public void addActivity(String userChoice)
    {
        Scanner input = new Scanner(System.in);
        HomeActivity hAct;
        SchoolActivity sAct;
        OtherActivity oAct;
        Time start;
        Time end; 
        String title;
        String comment;
        int year;
        int month;
        int day;
        int hour;
        int minute;
        
        //Getting the user's input to add to the array of classes
        System.out.print("Please enter a title for the activity: "); 
        title = input.nextLine();
        while(title.equals(""))
        {
            System.out.print("Please enter a title for the activity: ");
            title = input.nextLine();
        }
        System.out.println("Pleae enter a starting time");
        System.out.print("Enter the date (YYYY MM DD): ");
        year = input.nextInt();
        month = input.nextInt();
        day = input.nextInt();
        System.out.print("Enter the time (HH MM): ");
        hour = input.nextInt();
        minute = input.nextInt();
        System.out.println("Starting time: " +day+ "/" +month+ "/" +year+ " " +hour+ ":" +minute);
        start = new Time(year, month, day, hour, minute);
        System.out.println("Pleae enter an ending time");
        System.out.print("Enter the date (YYYY MM DD): ");
        year = input.nextInt();
        month = input.nextInt();
        day = input.nextInt();
        System.out.print("Enter the time (HH MM): ");
        hour = input.nextInt();
        minute = input.nextInt();
        System.out.println("Ending time: " +day+ "/" +month+ "/" +year+ " " +hour+ ":" +minute);
        end = new Time(year, month, day, hour, minute);
        input.nextLine();
        System.out.print("Please enter a comment or just press enter (Optional): ");
        comment = input.nextLine();
        if(userChoice.equalsIgnoreCase("home"))
        {
            //If the user enters home add create a HomeActivity object
            hAct = new HomeActivity(title, start, end, comment);
            if(numberHomeActs >= act1.length)
            {
                //If the array containing HomeActivity is full
                System.out.println("Home Activity is full");
            }
            else
            {
                //If the array containing HomeActivity is not full
                act1[numberHomeActs] = hAct;
                numberHomeActs++;
            }
        }
        else if(userChoice.equalsIgnoreCase("school"))
        {
            //If the user enters home add create a SchoolActivity object
            sAct = new SchoolActivity(title, start, end, comment);
            if(numberSchoolActs >= act2.length)
            {
                //If the array containing SchoolActivity is full
                System.out.println("School Activity is full");
            }
            else
            {
                //If the array containing SchoolActivity is not full
                act2[numberSchoolActs] = sAct;
                numberSchoolActs++;
            }
        }
        else if(userChoice.equalsIgnoreCase("other"))
        {
            System.out.print("Enter the location: ");
            String location = input.nextLine();
            while(location.equals(""))
            {
                System.out.print("Please enter a title for the activity: ");
                location = input.nextLine();
            }
            //If the user enters other creates an OtherActivity object
            oAct = new OtherActivity(title, start, end, location, comment);
            if(numberOtherActs >= act3.length)
            {
                //If the array containing OtherActivity is full
                System.out.println("Other Activity is full");
            }
            else
            {
                //If the array containing OtherActivity is not full
                act3[numberOtherActs] = oAct;
                numberOtherActs++;
            }
        }
    }
    
    public void searchArrays(String[] keywords, String [] getSTime, String [] getETime, String theAct)
    {
        boolean found;
        Object [] newArray = new Object[15];
        if(keywords[0].equals("") && getSTime[0].equals("") && getETime[0].equals("") && theAct.equals(""))
        {
            System.arraycopy(act1, 0, newArray, 0, maxNumber);
            System.arraycopy(act2, 0, newArray, maxNumber, maxNumber);
            System.arraycopy(act3, 0, newArray, 10, maxNumber);
            for(int i=0; i<newArray.length; i++)
            {
                if(newArray[i] != null)
                {
                    System.out.println(newArray[i]);
                }   
            }
        }
        else if(!(keywords[0].equals("")))
        {
            HomeActivity [] hAct = act1.clone();
            SchoolActivity [] sAct = act2.clone();
            OtherActivity [] oAct = act3.clone();
            for(int i = 0; i< maxNumber; i++)
            {
                found = false;
                for(int j = 0 ; j<keywords.length; j++)
                {
                    if(hAct[i] != null)
                    {
                        if(hAct[i].getTitle().toLowerCase().contains(keywords[j]))
                        {
                            found = true;
                        }
                        if(found == false)
                        {
                            hAct[i] = null;
                        }
                    }
                }
            }
            for(int i = 0; i< maxNumber; i++)
            {
                found = false;
                for(int j = 0 ; j<keywords.length; j++)
                {
                    if(sAct[i] != null)
                    {
                        if(sAct[i].getTitle().toLowerCase().contains(keywords[j]))
                        {
                            found = true;
                        }
                        if(found == false)
                        {
                            sAct[i] = null;
                        }
                    }
                }
            }
            for(int i = 0; i< maxNumber; i++)
            {
                found = false;
                for(int j = 0 ; j<keywords.length; j++)
                {
                    if(oAct[i] != null)
                    {
                        if(oAct[i].getTitle().toLowerCase().contains(keywords[j]))
                        {
                            found = true;
                        }
                        if(found == false)
                        {
                            oAct[i] = null;
                        }
                    }
                }
            }
            for(int i = 0; i<hAct.length; i++)
            {
                if(hAct[i]!= null)
                {
                    System.out.println(hAct[i]);
                }
            }
            for(int i = 0; i<sAct.length; i++)
            {
                if(sAct[i]!= null)
                {
                    System.out.println(sAct[i]);
                }
            }
            for(int i = 0; i<oAct.length; i++)
            {
                if(oAct[i]!= null)
                {
                    System.out.println(oAct[i]);
                }
            }
            /*if(keywords[0].equals("") && (!getSTime[0].equals("")) && getETime[0].equals("") && theAct.equals(""))
            {
                DayPlanner t = new DayPlanner();
                t.searchStartTime(getSTime, newArray);
            }*/
            /*if(!(getSTime[0].equals("")))
            {
                int j = 0;
                startTime = new int[getSTime.length];
                for (int i = 0; i < getSTime.length; i++) 
                {
                    startTime[i] = Integer.parseInt(getSTime[i].trim());
                }
                sTime = new Time(startTime[0], startTime[1], startTime[2], startTime[3], startTime[4]);
                */
            /*else
            {
                for(int i = 0; i<newArray.length; i++)
                {
                    if(newArray[i]!= null)
                    {
                        System.out.println(newArray[i]);
                    }
                }
            }*/
        }
        else if(!getSTime[0].equals(""))
        {
            int j = 0;
            int [] startTime = new int[getSTime.length];
            Time t = new Time();
            for (int i = 0; i < getSTime.length; i++) 
            {
                startTime[i] = Integer.parseInt(getSTime[i].trim());
            }
            Time sTime = new Time(startTime[0], startTime[1], startTime[2], startTime[3], startTime[4]);
            for(int i = 0; i<act1.length; i++)
            {
                found = false;
                if(act1[i] != null)
                {
                    if(t.compareTo(act1[i].getStartTime(), sTime) == 1)
                    {
                        found = true;
                    }
                    if(found == true)
                    {
                        newArray[j] = act1[i];
                        j++;
                    }
                }
            }
            for(int i = 0; i<newArray.length; i++)
            {
                if(newArray[i]!= null)
                {
                    System.out.println(newArray[i]);
                }
            }
        }
    }
    
    /**
    * Searches an activity array depending on what the userChoice. If userChoice
    * is home it searches the HomeAcitivity array and if userChoice is school, it
    * searches the SchoolActivity array and if userChoice is other it searches the
    * OtherActivity array.
    * @param userChoice Used to know what array to search.
    * @param keywords Used to search an array for the keywords if given.
    */
    public void searchActivity(String userChoice, String[] keywords)
    {
        
        if(userChoice.equalsIgnoreCase("home"))
        {
            if(keywords[0].equals(""))
            {
                //Does this if the first string in the first position of the array is empty
                System.out.println("The home activities: ");
                for(int i= 0; i<numberHomeActs; i++)
                {
                    System.out.println(act1[i]);
                } 
            }
            else if (!(keywords[0].equals("")))
            {
                HomeActivity [] newHAct = act1.clone();
                boolean found;
                //Does this if the first string in the first position of the array is not empty
                for(int i = 0; i< maxNumber; i++)
                {
                    //Runs for the size of the maxNumber and sets found to false
                    found = false;
                    for(int j = 0 ; j<keywords.length; j++)
                    {
                        //Runs for the length of the keywords array
                        if(newHAct[i] != null)
                        {
                            //Does this if the home activity at i is not a null
                            if(newHAct[i].getTitle().toLowerCase().contains(keywords[j]))
                            {
                                //Checks to see if home activity array at i's title contains the keywords at j and sets found to true
                                found = true;
                            }
                            if(found == false)
                            {
                                //Sets the newHAct at i to null if found is false
                                newHAct[i] = null;
                            }
                        }
                    }
                }
                for(int i = 0; i<newHAct.length; i++)
                {
                    //This runs for the length of the newHAct array
                    if(newHAct[i]!= null)
                    {
                        //This prints out the home activities stored in the array  if it is not null
                        System.out.println(newHAct[i]);
                    }
                }
            }  
        }
        if(userChoice.equalsIgnoreCase("school"))
        {
            
            if(keywords[0].equals(""))
            {
                System.out.println("The school activities: ");
                for(int i= 0; i<numberSchoolActs; i++)
                {
                    System.out.println(act2[i]);
                } 
            }
            else if (!(keywords[0].equals("")))
            {
                SchoolActivity [] newSAct = act2.clone();
                boolean found;
                for(int i = 0; i< maxNumber; i++)
                {
                    found = false;
                    for(int j = 0 ; j<keywords.length; j++)
                    {
                        if(newSAct[i] != null)
                        {
                            if(newSAct[i].getTitle().toLowerCase().contains(keywords[j]))
                            {
                                found = true;
                            }
                            if(found == false)
                            {
                                newSAct[i] = null;
                            }
                        }
                    }
                }
                for(int i = 0; i<newSAct.length; i++)
                {
                    if(newSAct[i]!= null)
                    {
                        System.out.println(newSAct[i]);
                    }
                }
            }  
        }
        if(userChoice.equalsIgnoreCase("other"))
        {
            if(keywords[0].equals(""))
            {
                System.out.println("The other activities: ");
                for(int i= 0; i<numberOtherActs; i++)
                {
                    System.out.println(act3[i]);
                } 
            }
            else if (!(keywords[0].equals("")))
            {
                OtherActivity [] newOAct = act3.clone();
                boolean found;
                for(int i = 0; i< maxNumber; i++)
                {
                    found = false;
                    for(int j = 0 ; j<keywords.length; j++)
                    {
                        if(newOAct[i] != null)
                        {
                            if(newOAct[i].getTitle().toLowerCase().contains(keywords[j]))
                            {
                                found = true;
                            }
                            if(found == false)
                            {
                                newOAct[i] = null;
                            }
                        }
                    }
                }
                for(int i = 0; i<newOAct.length; i++)
                {
                    if(newOAct[i]!= null)
                    {
                        System.out.println(newOAct[i]);
                    }
                }
            }  
        }
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userInput;
        String activity;
        System.out.println("****************************************************");
        System.out.println("*             Welcome to Day Planner               *");
        System.out.println("*            Managing daily activities             *");
        System.out.println("****************************************************");
        DayPlanner n = new DayPlanner();
        
        do
        {
            System.out.println("To add a new activity, simply type \"" +"add" + "\"");
            System.out.println("To search for an activity, simply type \"" +"search"+ "\"");
            System.out.println("To exit program, simply type \"" +"quit"+ "\"");
            System.out.print("Enter your choice: ");
            userInput = keyboard.nextLine();
             
            while(!userInput.equalsIgnoreCase("add") && !userInput.equalsIgnoreCase("search") && !userInput.equalsIgnoreCase("quit"))
            {
                System.out.println("Invalid choice");
                System.out.print("Please enter your choice again (home, school or other): ");
                userInput = keyboard.nextLine();
            }
            if(userInput.equalsIgnoreCase("add"))
            {
                System.out.print("Please enter the type of activity (home, school or other): ");
                activity = keyboard.nextLine();
                while(!activity.equalsIgnoreCase("home") && !activity.equalsIgnoreCase("school") && !activity.equalsIgnoreCase("other"))
                {
                    System.out.println("Invalid choice");
                    System.out.print("Enter your choice again (either home, school, other): ");
                    activity = keyboard.nextLine();
                }
                //Calls the addActivity method
                n.addActivity(activity);
            }
            if(userInput.equalsIgnoreCase("search"))
            {
                System.out.println("Please enter keywords to search for: ");
                String [] keywords = keyboard.nextLine().toLowerCase().split(" ");
                System.out.println("Please enter a starting time (YYYY MM DD hh mm) to search for: ");
                String [] getSTime = keyboard.nextLine().split(" ");
                System.out.println("Please enter an ending time to search for: ");
                String [] getETime = keyboard.nextLine().split(" ");
                System.out.println("Please enter an activity: ");
                String sActivity = keyboard.nextLine();
                System.out.println("Searching day planner...");
                //This will go through if the user enters the activity or does or doesn't enter keywords
                if(getSTime[0].equals("") && getETime[0].equals("") &&!(sActivity.equals("")))
                {
                    n.searchActivity(sActivity, keywords);
                }
                else
                {
                    n.searchArrays(keywords, getSTime, getETime, sActivity);
                }
            }
            if(userInput.equalsIgnoreCase("quit"))
            {
                System.out.println("********************************");
                System.out.println("* Thanks for using day planner *");
                System.out.println("*      Have a nice day.        *");
                System.out.println("********************************");
            }
        }
        while(!userInput.equalsIgnoreCase("quit"));
    }
}