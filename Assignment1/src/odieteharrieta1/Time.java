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
public class Time {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    
    /**
    *Default constructor for the Time class
    */
    public Time()
    {
    }
    
    /**
    * Initializes the year, month, day, hour and minute variables to the 
    * parameters argument passed into the method by calling the setTime method.
    * @param theYear The variable used to initialize the year variable.
    * @param theMonth The variable used to initialize the month variable.
    * @param theDay The variable used to initialize the day variable.
    * @param theHour The variable used to initialize the hour variable.
    * @param min The variable used to initialize the min variable.
    */
    public Time(int theYear, int theMonth, int theDay, int theHour, int min)
    {
        setTime(theYear, theMonth, theDay, theHour, min);
    }
    
    /**
    * Copies the contents of the cTime object to the variables in the Time class.
    * @param cTime The time object being copied.
    */
    public Time(Time cTime)
    {
        if(cTime == null)
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        year = cTime.year;
        month = cTime.month;
        day = cTime.day;
        hour = cTime.hour;
        minute = cTime.minute;   
    }
    
    /**
    * Sets the year, month, day, hour and day variables to the 
    * parameters argument passed into the method.
    * @param theYear The variable that the year variable is set to.
    * @param theMonth The variable that the month variable is set to.
    * @param theDay The variable that the day variable is set to.
    * @param theHour The variable that the hour variable is set to.
    * @param theMinute The variable that the minute is set to.
    */
    private void setTime(int theYear, int theMonth, int theDay, int theHour, int theMinute)
    {
        if(theYear < 1000 || theYear > 9999)
        {
            System.out.println("Error: Not a valid year");
            System.out.println("Year ranges from 1900 - 9999");
        }
        if(theMonth < 1 || theMonth > 12)
        {
            System.out.println("Error: Not a valid month");
            System.out.println("Month ranges from 1 - 12"); 
        }    
        if(theDay < 1 || theDay > 31)
        {
            System.out.println("Error: Not a valid day");
            System.out.println("Day ranges from 1 - 31");
        }
        if(theHour < 0 || theHour > 23)
        {
            System.out.println("Error: Not a valid hour");
            System.out.println("Hour ranges from 0 - 23");
        }
        if(theMinute < 0 || theMinute > 59)
        {
            System.out.println("Error: Not a valid minute");
            System.out.println("Hour ranges from 0 - 59");
        }
        else
        {
            this.year = theYear;
            this.day = theDay;
            this.month = theMonth;
            this.hour = theHour;
            this.minute = theMinute;
        }
    }
    
    /**
    * Retrieves the year variable in the Time class.
    * @return Returns the year variable in the Time class.
    */
    public int getYear()
    {
        return year;
    }
    
    /**
    * Retrieves the month variable in the Time class.
    * @return Returns the month variable in the Time class.
    */
    public int getMonth()
    {
        return month;
    }
    
    /**
    * Retrieves the day variable in the Time class.
    * @return Returns the day variable in the Time class.
    */
    public int getDay()
    {
        return day;
    }
    
    /**
    * Retrieves the hour variable in the Time class.
    * @return Returns the hour variable in the Time class.
    */
    public int getHour()
    {
        return hour;
    }
    
    /**
    * Retrieves the minute variable in the Time class.
    * @return Returns the minute variable in the Time class.
    */
    public int getMinute()
    {
        return minute;
    }
    
    /**
    * Makes a string containing the year, month, day, hour and minute variables.
    * @return Returns the String containing all the variables in the Time class.
    */
    @Override
    public String toString()
    {
        return(day+ "/" +month+ "/" +year+ " " +hour+ ":" +minute);
    }
    
    /**
    * Tests for equality of two objects of type Time. To be equal,
    * the two objects must have the same year, same month, same day, 
    * same hour and same minute.
    * @param otherTime The time being compared to the calling object.
    * @return Returns true if the calling object equals otherTime.
    */
    public boolean equals(Time otherTime)
    {
        if(otherTime == null)
        {
            return false;
        }
        else
        {
          return (year == otherTime.year && month == otherTime.month && day == otherTime.day && hour == otherTime.hour && minute == otherTime.minute);  
        } 
    }
    
    /**
    * Tests for precedes of two objects of type HomeActivity. For the first object
    * to precede the otherTime object, the first time year has to be less than the
    * otherTime year or the first time month has to be less than the otherTime or the
    * first time day has to be less than the otherTime day or the first time hour has
    * to be less than the otherTime hour or the first time minute has to be less than the 
    * otherTime minute.
    * @param otherTime The time being compared to the calling object.
    * @return Returns true if the calling object precedes the otherTime or false if it does not.
    */
    public boolean precedes(Time otherTime)
    {
        return((year < otherTime.year) || (year == otherTime.year && getMonth() < otherTime.getMonth()) || (year == otherTime.year && month == otherTime.month && day < otherTime.day) || (year == otherTime.year && month == otherTime.month && day == otherTime.day && hour < otherTime.hour) || (year == otherTime.year && month == otherTime.month && day == otherTime.day && hour == otherTime.hour && minute < otherTime.minute));
    }
    
    /**
    * Compares two time objects making use of the precede and equals methods.
    * @param time1 The first time being compared.
    * @param time2 The second time being compared.
    * @return Returns a 1 if the first time comes after the second, returns a -1
    * if the first time comes before the second time and returns 0 if he first time is
    * equal to the second time.
    */
    public int compareTo(Time time1, Time time2)
    {
        int result = 0;
        if(time1.precedes(time2) == true)
        {
            result = -1;
        }
        else if(time1.precedes(time2) == false)
        {
            result = 1;
        }
        else if(time1.equals(time2) == true)
        {
            result = 0;
        }
        return result;
    }
}
