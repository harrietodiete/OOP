package hodiete_a2;

/**
 * @author harrietodiete
 */
public class Activity {
    private String type;        // type of the activity
    private String title;       // short description of the activity
    private Time startingTime;  // starting time of the activity
    private Time endingTime;    // ending time of the activity
    private String comment;     // additional details about the activity
	
    /**
    * Initializes the title, startTime, endTime and comment variables to the 
    * parameters argument passed into the method.
    * @param type The variable used to initialize the type variable.
    * @param title The variable used to initialize the title variable.
    * @param startingTime The variable used to initialize the startingTime variable.
    * @param endingTime The variable used to initialize the endingTime variable.
    * @param comment The variable used to initialize the comment variable.
    */
    public Activity(String type, String title, Time startingTime, Time endingTime, String comment)
    {
        if (valid(startingTime, endingTime))
        {
            this.type = type;
            this.title = title;
            this.startingTime = startingTime;
            this.endingTime = endingTime;
            this.comment = comment;
        }
        else
        {
            System.out.println("Invalid times for HomeActivity");
            System.exit(0);
        }
    }
    
    /**
    * Checks to make sure the parameter arguments are not null.
    * @param startingTime The variable used to initialize the startingTime variable.
    * @param endingTime The variable used to initialize the endingTime variable.
    * @return Returns 1 if the parameter arguments are not null else it returns -1.
    */
    public static boolean valid(Time startingTime, Time endingTime)
    {
        return (startingTime != null) && (endingTime != null);
    }
    
    /**
    * Sets the type to the parameter argument passed into the method.
    * @param type The variable that the type variable is set to.
    */
    public void setType(String type) 
    {
        this.type = type;
    }
    
    /**
    * Sets the title to the parameter argument passed into the method.
    * @param title The variable that the title variable is set to.
    */
    public void setTitle(String title) 
    {
        this.title = title;
    }
    
    /**
    * Sets the startingTime to the parameter argument passed into the method.
    * @param startingTime The variable that the startingTime variable is set to.
    */
    public void setStartingTime(Time startingTime)
    {
        if (startingTime == null)
        {
            System.out.println("Invalid starting time");
            System.exit(0);
        }
        else
        {
            this.startingTime = startingTime;
        }
    }
    
    /**
    * Sets the endingTime to the parameter argument passed into the method.
    * @param endingTime The variable that the endingTime variable is set to.
    */
    public void setEndingTime(Time endingTime)
    {
        if (endingTime == null)
        {
            System.out.println("Invalid ending time");
            System.exit(0);
        }
        this.endingTime = endingTime;
    }
    
    /**
    * Sets the comment to the parameter argument passed into the method.
    * @param comment The variable that the comment variable is set to.
    */
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    /**
    * Retrieves the type variable in the Activity class.
    * @return Returns the type variable in the Activity class.
    */
    public String getType()
    {
        return type;
    }
    
    /**
    * Retrieves the title variable in the Activity class.
    * @return Returns the title variable in the Activity class.
    */
    public String getTitle()
    {
        return title;
    }
    
    /**
    * Retrieves the startingTime variable in the Activity class.
    * @return Returns the startingTime variable in the Activity class.
    */
    public Time getStartingTime()
    {
        return startingTime;
    }
    
    /**
    * Retrieves the endingTime variable in the Activity class.
    * @return Returns the endingTime variable in the Activity class.
    */
    public Time getEndingTime()
    {
        return endingTime;
    }
    
    /**
    * Retrieves the comment variable in the Activity class.
    * @return Returns the comment variable in the Activity class.
    */
    public String getComment()
    {
        return comment;
    }
    
    /**
    * Tests for equality of two objects of type Activity. To be equal,
    * the two objects must have the same type, title, same startingTime, same endingTime and
    * same comment.
    * @param other The activity being compared to the calling object.
    * @return Returns true if the calling object equals other.
    */
    public boolean equals(Activity other)
    {
        if (other == null)
        {
            return false;
        }
        else
        {
            return type.equals(other.type) && title.equals(other.title) && startingTime.equals(other.startingTime) && endingTime.equals(other.endingTime) && comment.equals(other.comment);
	}
    }
    
    /**
    * Makes a string containing the type, title, startingTime, endingTime and comment variables.
    * @return Returns the String containing all the variables in the Activity class.
    */
    @Override
    public String toString()
    {
        return "Type: " +type+ ", Title: " + title + ", Starting time: " + startingTime + ", Ending time: " + endingTime + ", Comment: " + comment;	
    }
}
