
package hodiete_a2;
import java.util.*;
import java.io.*;

/**
 * @author harrietodiete
 */
public class DayPlanner {

    public static final String[] types = new String[]{"home", "school", "other", "h", "s", "o"};
    private ArrayList<Activity> Activities;
    private HashMap<String,ArrayList<Integer>> map;

    /**
    * Initializes the arrayList of activities and the hash map
    */
    public DayPlanner()
    {
        Activities = new ArrayList<Activity>();
        map = new HashMap<String, ArrayList<Integer>>();
    }

    /**
    * Creates a time object for valid input.
    * @param line Used to parse the input into the time.
    */
    private Time getTime(String line) 
    {
        String[] tokens = line.split("[ ,\n]+");
        if (tokens.length != 5)
        {
            return null;
        }
        for (int i = 0; i < 5; i++ )
        {
            if (!tokens[i].matches("[-+]?[0-9]+"))
            {
                return null;
            }
        }
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);
        int hour = Integer.parseInt(tokens[3]);
        int minute = Integer.parseInt(tokens[4]);
        if (Time.timeOK(year, month, day, hour, minute))
        {
            return new Time(year, month, day, hour, minute);
        }
        else
        {
            return null;
        }
    }

    /**
    * Adds a HomeActivity Object to the ArrayList of Activities.
    * @param home Contains the HomeActivity Object.
    */
    private void addHomeActivity(HomeActivity home) 
    {
        Activities.add(home);
    }
    
    /**
    * Adds a SchoolActivity Object to the ArrayList of Activities.
    * @param school Contains the SchoolActivity Object.
    */
    private void addSchoolActivity(SchoolActivity school)
    {
         Activities.add(school);
    }

    /**
    * Adds a OtherActivity Object to the ArrayList of Activities.
    * @param other Contains the OtherActivity Object.
    */
    private void addOtherActivity(OtherActivity other) 
    {
        Activities.add(other);
    }
    
    /**
    * Adds an activity to the arrayList of activities by making calls
    * to addHomeActivity, addSchoolActivity and addOtherActivity
    * depending on the type specified by the user.
    * @param input Used to read the user's input.
    */
    public void addActivity(Scanner input)
    {
        String type = "";
        do 
        {
            System.out.print( "Enter an activity type (home, school, or other)> " );
            type = input.nextLine();
        } 
        while (!matchedKeyword(type, types));

        System.out.print("Enter a title> ");
        String title = input.nextLine();

        Time startingTime = null;
        do 
        {
            System.out.print( "Enter a starting time (year, month, day, hour, minute)> " );
            startingTime = getTime(input.nextLine());
        } 
        while (startingTime == null);

        Time endingTime = null;
        do
        {
            System.out.print( "Enter an ending time (year, month, day, hour, minute)> " );
            endingTime = getTime(input.nextLine());
        } while (endingTime == null);

        String location = "";
        if( type.equalsIgnoreCase("other") || type.equalsIgnoreCase("o") )
        {
            System.out.print( "Enter a location> " );
            location = input.nextLine();
        }

        System.out.print( "Enter a line of comment> " );
        String comment = input.nextLine();

        if (type.equalsIgnoreCase("home") || type.equalsIgnoreCase("h"))
        {
            addHomeActivity(new HomeActivity(type, title, startingTime, endingTime, comment));
        }
        else if (type.equalsIgnoreCase("school") || type.equalsIgnoreCase("s"))
        {
            addSchoolActivity(new SchoolActivity(type, title, startingTime, endingTime, comment));
        }
        else
        {
            addOtherActivity(new OtherActivity(type,title, startingTime, endingTime, location, comment));
        }
    }

    /**
    * Check if a keyword is in the tokens.
    * @param keyword Used for checking keyword.
    * @param tokens Used to check the tokenized words.
    */
    private boolean matchedKeyword(String keyword, String[] tokens) {
            for (int i = 0; i < tokens.length; i++) 
                    if (keyword.equalsIgnoreCase(tokens[i]))
                            return true;
            return false;
    }

    /**
    * Check if a keywords are in the title.
    * @param keywords Used for checking keywords.
    * @param title Used to check the title keywords.
    */
    private boolean matchedKeywords(String[] keywords, String title) {
            String[] tokens = title.split( "[ ,\n]+" );
            for (int i = 0; i < keywords.length; i++) 
                    if (!matchedKeyword(keywords[i], tokens))
                            return false;
            return true;
    }

    /**
    * Searches the arrayList of activities by making a call to the searchMap method.
    * Uses the return value of the searchMap to do combined search.
    * @param input Used to read the user's input.
    */
    public void searchActivities(Scanner input)
    {
        String type = "";
        do
        {
            System.out.print("Enter an activity type (home, school, or other)> ");
            type = input.nextLine();
        }
        while (!type.isEmpty() && !matchedKeyword(type, types));

        Time startingTime = null;
        do
        {
            System.out.print("Enter a starting time (year, month, day, hour, minute)> ");
            String line = input.nextLine();
            if (line.isEmpty())
            {
                break;
            }
            else
            {
                startingTime = getTime(line);
            }
        }
        while (startingTime == null);

        Time endingTime = null;
        do 
        {
            System.out.print("Enter an ending time (year, month, day, hour, minute)> ");
            String line = input.nextLine();
            if (line.isEmpty())
            {
                break;
            }
            else
            {
                endingTime = getTime(line);
            }
        } 
        while (endingTime == null);

        System.out.print("Enter title keywords: ");
        String[] keywords = null;
        String line = input.nextLine();
        if (!line.isEmpty())
        {
            keywords = line.toLowerCase().split("[ ,\n]+");
        }
       
        // search for matched activities
        System.out.println("Matched activities: ");
        if(keywords != null)
        {
            Integer [] results;
            results = searchMap(keywords);
            ArrayList <Activity> newOne; 
            newOne = new ArrayList<Activity>();
            for(int i=0; i<results.length; i++)
            {
                newOne.add(Activities.get(results[i]));
            }
            if(startingTime == null  && endingTime == null && type.isEmpty())
            {
                for(int i=0; i<newOne.size(); i++)
                {
                    System.out.println(newOne.get(i));
                }
            }
            if(type.equalsIgnoreCase("home") || type.equalsIgnoreCase("h"))
            {
                for (int i = 0; i < newOne.size(); i++)
                {
                    if(newOne.get(i) instanceof HomeActivity)
                    {
                        HomeActivity getActivity = (HomeActivity)newOne.get(i);
                        if ((startingTime == null || getActivity.getStartingTime().compareTo(startingTime) >= 0) && (endingTime == null || getActivity.getEndingTime().compareTo(endingTime) <= 0))
                        {
                            System.out.println(getActivity);
                        }
                    }
                }
            }
            if(type.equalsIgnoreCase("school") || type.equalsIgnoreCase("s"))
            {
                for (int i = 0; i < newOne.size(); i++)
                {
                    if(newOne.get(i) instanceof SchoolActivity)
                    {
                        SchoolActivity getActivity = (SchoolActivity)newOne.get(i);
                        if ((startingTime == null || getActivity.getStartingTime().compareTo(startingTime) >= 0) && (endingTime == null || getActivity.getEndingTime().compareTo(endingTime) <= 0))
                        {
                            System.out.println(getActivity);
                        }
                    }
                }
            }
            if(type.equalsIgnoreCase("other") || type.equalsIgnoreCase("o"))
            {
                for (int i = 0; i < newOne.size(); i++)
                {
                    if(newOne.get(i) instanceof OtherActivity)
                    {
                        OtherActivity getActivity = (OtherActivity)newOne.get(i);
                        if ((startingTime == null || getActivity.getStartingTime().compareTo(startingTime) >= 0) && (endingTime == null || getActivity.getEndingTime().compareTo(endingTime) <= 0))
                        {
                            System.out.println(getActivity);
                        }
                    }
                }
            }
        }
        else
        {
            if (type.isEmpty() || type.equalsIgnoreCase("home") || type.equalsIgnoreCase("h"))
            {
                for (int i = 0; i < Activities.size(); i++)
                {
                    if(Activities.get(i) instanceof HomeActivity)
                    {
                        HomeActivity getActivity = (HomeActivity)Activities.get(i);

                        if ((startingTime == null || getActivity.getStartingTime().compareTo(startingTime) >= 0) && (endingTime == null || getActivity.getEndingTime().compareTo(endingTime) <= 0))
                        {
                            System.out.println(getActivity);
                        } 
                    }
                }         
            }
            if (type.isEmpty() || type.equalsIgnoreCase("school") || type.equalsIgnoreCase("s"))
            {
                for (int i = 0; i < Activities.size(); i++)
                {
                    if(Activities.get(i) instanceof SchoolActivity)
                    {
                        SchoolActivity getActivity = (SchoolActivity)Activities.get(i);
                        if ((startingTime == null || getActivity.getStartingTime().compareTo(startingTime) >= 0) && (endingTime == null || getActivity.getEndingTime().compareTo(endingTime) <= 0)) 
                        {
                             System.out.println(getActivity); 
                        }
                    }
                }   

            }

            if (type.isEmpty() || type.equalsIgnoreCase("other") || type.equalsIgnoreCase("o"))
            {
                for (int i = 0; i < Activities.size(); i++)
                {
                    if(Activities.get(i) instanceof OtherActivity)
                    {
                        OtherActivity getActivity = (OtherActivity)Activities.get(i);
                         if ((startingTime == null || getActivity.getStartingTime().compareTo(startingTime) >= 0) && (endingTime == null || getActivity.getEndingTime().compareTo(endingTime) <= 0))
                         {
                             System.out.println(getActivity);
                         } 
                    }
                }		
            }
        }
       
    }
    
    /**
    * Prints out the arrayList of Activities
    */
    public void printActivities()
    {
        for(int i = 0; i<Activities.size(); i++)
        {
            System.out.println((i)+ " - " +Activities.get(i));
        }
    }
    
    /**
    * Reads the file line by line an creates an activity from it and adds it
    * to the arrayList of Activities.
    * @param object The file object been read to the arrayList of activities.
    */
    private void readFile(File object)
    {
        Scanner inputFile = null;
        try
        {
           inputFile = new Scanner(new FileInputStream(object));
        }
        catch(FileNotFoundException e)
        {
            //If file does not exists
            System.out.println("File activities.txt was not found");
            System.out.println("or could not be opened.");
            System.exit(0);
        }
        //Variables declaration and initialization
        String next = "";
        String type = "";
        String title = "";
        Time start = new Time();
        Time end = new Time();
        String comment = "";
        String location = "";
        //This will run until it reaches the end of the file
        while (inputFile.hasNextLine())
        {
            next = inputFile.nextLine(); //reads the next line
            String getString[] = null;
            if(next.startsWith("type"))
            {
                //If the line starts with type
                getString =  next.split("= ");
                //Gets the string stored at position 1 in the array, the word type is at position 0
                type = getString[1];
                //Removes the quotations surrounding the string stored
                type = type.substring(1, type.length() - 1);
            }
            else if(next.startsWith("title"))
            {
                getString =  next.split("= ");
                title = getString[1];
                title = title.substring(1, title.length() - 1);
            }
            else if(next.startsWith("start"))
            {
                getString =  next.split("= ");
                String startTime = getString[1];
                
                startTime = startTime.substring(1, startTime.length() - 1);
                start = getTime(startTime);
            }
            else if(next.startsWith("end"))
            {
                getString =  next.split("= ");
                String endTime = getString[1];
                endTime = endTime.substring(1, endTime.length() - 1);
                end = getTime(endTime);
            }
            else if(next.startsWith("location"))
            {
                getString =  next.split("= ");
                location = getString[1];
                location = location.substring(1, location.length() - 1);
            }
            else if(next.startsWith("comment"))
            {
                getString =  next.split("= ");
                comment = getString[1];
                comment = comment.substring(1, comment.length() - 1);
            }
            if(next.isEmpty() || inputFile.hasNextLine() == false)
            {
                if(type.equalsIgnoreCase("home"))
                {
                    addHomeActivity(new HomeActivity(type, title, start, end, comment));
                }
                else if(type.equalsIgnoreCase("school"))
                {
                    addSchoolActivity(new SchoolActivity(type, title, start, end, comment));
                }
                else if(type.equalsIgnoreCase("other") && !(location.equals("")))
                {
                   addOtherActivity(new OtherActivity(type, title, start, end, location, comment));
                }
            }
        }
        inputFile.close();
        System.out.println("File loaded...");
        /*printActivities();*/
    }
    
    /**
    * Writes each activity in the arrayList of Activities to the given file 
    * object in the right format.
    * @param object The file object been written to.
    */
    private void writeToFile(File fileObject)
    {
        PrintWriter outputFile = null;
        try
        {
            outputFile = new PrintWriter(new FileOutputStream(fileObject));
        }
        catch(FileNotFoundException e)
        {
            //
            System.out.println("Error opening file");
            System.exit(0);
        }
        for(int i= 0; i<Activities.size(); i++)
        {
            Time startTime =  Activities.get(i).getStartingTime();
            Time endTime = Activities.get(i).getEndingTime();
            outputFile.println("type = \""+ Activities.get(i).getType() + "\"");
            outputFile.println("title = \"" + Activities.get(i).getTitle() + "\"");
            outputFile.println("start = \"" + startTime.getYear() + ", " + startTime.getMonth() + ", " + startTime.getDay() + ", "+ startTime.getHour() + ", " + startTime.getMinute() + "\"");
            outputFile.println("end = \"" + endTime.getYear() + ", " + endTime.getMonth() + ", " + endTime.getDay() + ", "+ endTime.getHour() + ", " + endTime.getMinute() + "\"");
            if(Activities.get(i) instanceof OtherActivity)
            {
                OtherActivity other = (OtherActivity)Activities.get(i);
                outputFile.println("location = \""+ other.getLocation()+ "\"");
            }
            outputFile.println("comment = \""+ Activities.get(i).getComment()+ "\"");
            outputFile.println();
        }
        outputFile.close();
        map.clear();
    }
    
    /**
    * Loads each activity that was read from the file that has now been stored in
    * the arrayList of Activities to the hashMap by using the title keywords
    * of each activity as the keys and the indexes they occur in the arrayList
    * as the value.
    */
    public void loadMap()
    {
        String keywords[] = null;
        
        //Runs for the size of the ArrayList of activities
        for(int i = 0; i<Activities.size(); i++)
        {
            keywords = Activities.get(i).getTitle().toLowerCase().split("[ ,\n]+");
            //This runs for the amount of keywords
            for(int j=0; j<keywords.length; j++)
            {
                if(!map.containsKey(keywords[j]))
                {
                    //If the keyword is not found in the map, create a new ArrayList of integers
                    ArrayList<Integer> position;
                    position = new ArrayList<Integer>();
                    //Add the position the keyword appears in the ArrayList of activities to the ArrayList of integers
                    position.add(Activities.indexOf(Activities.get(i)));
                    //Add the keyword and the position they occur in the ArrayList of activities to the hash map
                    map.put(keywords[j], position);
                }
                else
                {
                    //Gets the ArrayList of Integers at the repeated keywords
                    ArrayList<Integer> position = map.get(keywords[j]);
                    //Adds the position they occur in the ArrayList of activities to the back of the ArrayList of Integers
                    position.add(Activities.indexOf(Activities.get(i)));
                }
            }
        }
       
    }
    
    /**
    * Loads the most recent activity in the arrayList of Activities to the hashMap 
    * by using the title keywords of the activity as the keys and the index of the
    * activity n the arrayList as the value.
    */
    private void updateMap()
    {
        String keywords[] = null;
        
        keywords = Activities.get(Activities.size()-1).getTitle().toLowerCase().split("[ ,\n]+");
        //This runs for the amount of keywords
        for(int j=0; j<keywords.length; j++)
        {
            if(!map.containsKey(keywords[j]))
            {
                //If the keyword is not found in the map, create a new ArrayList of integers
                ArrayList<Integer> position;
                position = new ArrayList<Integer>();
                //Add the position the keyword appears in the ArrayList of activities to the ArrayList of integers
                position.add(Activities.indexOf(Activities.get(Activities.size() - 1)));
                //Add the keyword and the position they occur in the ArrayList of activities to the hash map
                map.put(keywords[j], position);
            }
            else
            {
                //Gets the ArrayList of Integers at the repeated keywords
                ArrayList<Integer> position = map.get(keywords[j]);
                //Adds the position they occur in the ArrayList of activities to the back of the ArrayList of Integers
                position.add(Activities.indexOf(Activities.get(Activities.size() - 1)));
            }
        } 
    } 

    /**
    * Searches the hash map to see if contains the given keywords and
    * stores the values they occur in the arrayList of Activities into an
    * arrayList of arrayList of Integers and then getting the intersection
    * of the them and passing them to the searchActivities.
    * @return Returns the indexes the keywords occur in the arrayList of 
    * Activities.
    */
    private Integer [] searchMap(String [] keyword)
    {
        ArrayList <ArrayList<Integer>> values = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i<keyword.length; i++)
        {
            if(map.containsKey(keyword[i]))
            {
                values.add(map.get(keyword[i]));
            }
            else
            {
                values.clear();
            }
        }
        for(int i=0; i<values.size(); i++)
        {
            for(int j=0; j<values.size(); j++)
            {
                values.get(i).retainAll(values.get(j));
            }
        }
        ArrayList <Integer> position;
        Integer[] results = {};
        for(int i = 0; i<values.size(); i++)
        {
            position = values.get(i);
            for(int j = 0; j<values.size(); j++)
            {
                results = position.toArray(new Integer[position.size()]);
            }
        }
        return results;
    }
    
    public static void main(String[] args) 
    {
        DayPlanner planner = new DayPlanner();
        File inputFile = null;
        File outputfile = null;
        if(args.length == 0)
        {
            System.out.println("Program failed to start");
            System.out.println("No input file or output file was given");
            System.exit(0);
        }
        else
        {
            if(args.length == 1)
            {
                inputFile = new File(args[0]);
            }
            else
            {
                inputFile = new File(args[0]);
                outputfile = new File(args[1]);
            }
        }
        while (!inputFile.exists())
        {
            System.out.println("The file does not exist.");
            System.exit(0);
        }
        planner.readFile(inputFile);
        planner.loadMap();
        //planner.searchMap();
        
        Scanner input = new Scanner(System.in);
        String command = "";
        do
        {
            System.out.print("Enter add, search, or quit> ");
            command = input.nextLine();
            if (command.equalsIgnoreCase("add") || command.equalsIgnoreCase("a"))
            {
                planner.addActivity(input);
                planner.updateMap();
            }
            else if (command.equalsIgnoreCase("search") || command.equalsIgnoreCase("s"))
            {
                planner.searchActivities(input);
            }
            else if(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q"))
            {
                if(outputfile == null)
                {
                    planner.writeToFile(inputFile);
                }
                else
                {
                    planner.writeToFile(outputfile);
                }
            }
        } 
        while (!command.equalsIgnoreCase("quit") && !command.equalsIgnoreCase("q"));
    }
}

