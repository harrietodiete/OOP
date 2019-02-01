/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odieteharrieta1;

/**
 *
 * @author Harriet
 */
public class OtherActivity {
    private String title;
    private Time startTime;
    private Time endTime;
    private String location;
    private String comment;
   
    /**
    * Initializes the instance variables. Initializes the startTime 
    * and endTime to the default constructor in the Time class.
    */
    public OtherActivity()
    {
        this.title = "No title yet";
        this.startTime = new Time();
        this.endTime = new Time();
        this.location = "No location yet";
        this.comment = "No comments yet";
    }
    
    /**
    * Initializes the title, startTime, endTime and comment variables to the 
    * parameters argument passed into the method.
    * @param title The variable used to initialize the title variable.
    * @param startTime The variable used to initialize the startTime variable.
    * @param endTime The variable used to initialize the endTime variable.
    * @param location The variable used to initialize the location variable.
    * @param comment The variable used to initialize the comment variable.
    */
    public OtherActivity(String title, Time startTime, Time endTime, String location, String comment)
    { 
        this.title = title;
        this.startTime = new Time(startTime);
        this.endTime = new Time(endTime);
        this.location = location;
        this.comment = comment;
    }
    
    /**
    * Tests for equality of two objects of type OtherActivity. To be equal,
    * the two objects must have the same title, same startTime, same endTime and
    * same comment.
    * @param otherOthAct The other activity being compared to the calling object.
    * @return Returns true if the calling object equals otherOthAct.
    */
    public boolean equals(OtherActivity otherOthAct)
    {
        if(otherOthAct == null)
        {
            return false;
        }
        else
        {
            return(title.equals(otherOthAct.title) && startTime.equals(otherOthAct.startTime) && endTime.equals(otherOthAct.endTime) && location.equals(otherOthAct.location) && comment.equals(otherOthAct.comment));
        }
    }
    
    /**
    * Makes a string containing the title, startTime, endTime and comment variables.
    * @return Returns the String containing all the variables in the OtherActivity class.
    */
    @Override
    public String toString()
    {
        return("Title: " +title+ ", " + "Starting Time: " +startTime+ ", " + "Ending Time: " +endTime+ ", " + "Locaton: " +location+ ", " + "Comment: " +comment);
    }
    
    /**
    * Sets the title, startTime, endTime and comment variables to the 
    * parameters argument passed into the method.
    * @param title The variable that the title variable is set to.
    * @param startTime The variable that the startTime variable is set to.
    * @param endTime The variable that the endTime variable is set to.
    * @param location The variable that the location variable is set to.
    * @param comment The variable that the comment variable is set to.
    */
    public void setOtherActivity(String title, Time startTime, Time endTime, String location, String comment)
    { 
        this.title = title;
        this.startTime = new Time(startTime);
        this.endTime = new Time(endTime);
        this.location = location;
        this.comment = comment;
    }
    
    /**
    * Sets the title to the parameter argument passed into the method.
    * @param newTitle The variable that the title variable is set to.
    */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    
    /**
    * Sets the startTime to the parameter argument passed into the method.
    * @param newTime The variable that the starTime variable is set to.
    */
    public void setStartTime(Time newTime)
    {
        if(newTime == null)
        {
            System.out.println("Inconsistent starting time");
            System.exit(0);
        }
        startTime = new Time(newTime);   
    }
    
    /**
    * Sets the endTime to the parameter argument passed into the method.
    * @param newTime The variable that the endTime variable is set to.
    */
    public void setEndTime(Time newTime)
    {
        if(newTime == null)
        {
            System.out.println("Inconsistent ending time");
            System.exit(0);
        }
        endTime = new Time(newTime);   
    }
    
    /**
    * Sets the location to the parameter argument passed into the method.
    * @param newLocation The variable that the location variable is set to.
    */
    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
    
    /**
    * Sets the comment to the parameter argument passed into the method.
    * @param newComment The variable that the title variable is set to.
    */
    public void setComment(String newComment)
    {
        comment = newComment;
    }
    
    /**
    * Retrieves the title variable in the OtherActivity class.
    * @return Returns the title variable in the OtherActivity class.
    */
    public String getTitle()
    {
        return title;
    }
    
    /**
    * Retrieves the startTime variable in the OtherActivity class.
    * @return Returns the startTime variable in the OtherActivity class.
    */
    public Time getStartTime()
    {
        return new Time(startTime);
    }
    
    /**
    * Retrieves the endTime variable in the OtherActivity class.
    * @return Returns the endTime variable in the OtherActivity class.
    */
    public Time getEndTime()
    {
        return new Time(endTime);
    }
    
    /**
    * Retrieves the location variable in the OtherActivity class.
    * @return Returns the location variable in the OtherActivity class.
    */
    public String getLocation()
    {
        return location;
    }
    
    /**
    * Retrieves the comment variable in the OtherActivity class.
    * @return Returns the comment variable in the OtherActivity class.
    */
    public String getComment()
    {
        if(comment.equals(""))
        {
            return("No comment given");
        }
        else
        {
            return comment;
        }
    } 
}
