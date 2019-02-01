/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hodiete_a3;

/**
 *
 * @author harrietodiete
 */
public class OtherActivity extends Activity {
    private String location;    // location of the activity
    
    /**
    * Initializes the title, startTime, endTime and comment variables to the 
    * parameters argument passed into the method.
    * @param type The variable used to initialize the type variable.
    * @param title The variable used to initialize the title variable.
    * @param startingTime The variable used to initialize the startingTime variable.
    * @param endingTime The variable used to initialize the endingTime variable.
    * @param location The variable used to initialize the location variable.
    * @param comment The variable used to initialize the comment variable.
    */
    public OtherActivity(String type, String title, Time startingTime, Time endingTime, String location, String comment)
    {
       super(type, title, startingTime, endingTime, comment);
       this.location = location;
    }

    /**
    * Sets the location to the parameter argument passed into the method.
    * @param location The variable that the title variable is set to.
    */
    public void setLocation(String location)
    {
        this.location = location;
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
    * Tests for equality of two objects of type OtherActivity. To be equal,
    * the two objects must have the same type, title, same startingTime, same endingTime,
    * same location and same comment.
    * @param other The other activity being compared to the calling object.
    * @return Returns true if the calling object equals other.
    */
   @Override
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        else if (getClass() != other.getClass())
        {
            return false;
        }
        else
        {
            OtherActivity otherAct = (OtherActivity)other;
            return (super.equals(otherAct) && location.equals(otherAct.location));
        }
    }

    
    /**
    * Makes a string containing the type, title, startTime, endTime, location and comment variables.
    * @return Returns the String containing all the variables in the OtherActivity class.
    */
    @Override
    public String toString()
    {
        return "Type: " +getType()+ ", Title: " + getTitle() + ", Starting time: " + getStartingTime() + ", Ending time: " + getEndingTime() + ", Location: " +location+ ", Comment: " + getComment();	
    }
}
