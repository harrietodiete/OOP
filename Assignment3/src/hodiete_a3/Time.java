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
public class Time {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    /**
    * Initializes the year, month, day, hour and minute variables to the 
    * parameters argument passed into the method by first calling the timeOK 
    * method to make sure the time fits the format.
    * @param year The variable used to initialize the year variable.
    * @param month The variable used to initialize the month variable.
    * @param day The variable used to initialize the day variable.
    * @param hour The variable used to initialize the hour variable.
    * @param minute The variable used to initialize the minute variable.
    */
    public Time(int year, int month, int day, int hour, int minute)
    {
        try
        {
            if(timeOK(year, month, day, hour, minute))
            {
                this.year = year;
                this.month = month;
                this.day = day;
                this.hour = hour;
                this.minute = minute;
            }
            else
            {
                throw new Exception("Invalid entry for time");
            }
           
        }
        catch(Exception E)
        {
            E.getMessage();
        }
    }

    /**
    * Creates a time object with no arguments
    */
    public Time()
    {
        year = 0;
        month = 0;
        day = 0;
        hour = 0;
        minute = 0;
    }
    
    /**
    * Makes a copy of the Time passed into the method. 
    * It checks for if it is null and valid first.
    * @param aTime The time object passed into the arguments .
    */
    public Time(Time aTime)
    {
        if (aTime == null) //Not a real date.
        {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        try {
            if(timeOK(aTime.year, aTime.month, aTime.day, aTime.hour, aTime.minute))
            {
                year = aTime.year;
                month = aTime.month;
                day = aTime.day;
                hour = aTime.hour;
                minute = aTime.minute;
            }
            else
            {
                throw new Exception("Time not valid");
            }
        }
        catch(Exception E)
        {
            E.getMessage();
            aTime = null;
        }
        
    }
    
    /**
    * Sets the year variable to the parameter argument passed into the method.
    * @param year The variable that the year variable is set to.
    */
    public void setYear(int year)
    {
        try
        {
            if(year >= 0)
            {
                this.year = year;
            }
            else
            {
                throw new Exception("Year given not valid");
            }
        }
        catch(Exception E)
        {
            E.getMessage();
        }
    }
    
    /**
    * Sets the month variable to the parameter argument passed into the method.
    * @param month The variable that the month variable is set to.
    */
    public void setMonth(int month)
    {
        try
        {
            if(month > 0 && month <= 12)
            {
                this.month = month;
            }
            else
            {
                throw new Exception("Month given not valid");
            }
        }
        catch(Exception E)
        {
            E.getMessage();
        }
    }
    
    /**
    * Sets the day variable to the parameter argument passed into the method.
    * @param day The variable that the day variable is set to.
    */
    public void setDay(int day)
    {
        try
        {
            if(day > 0 && day <= 31)
            {
                this.day = day;
            }
            else
            {
                throw new Exception("Day given not valid");
            }
        }
        catch(Exception E)
        {
            E.getMessage();
        }
    }

    /**
    * Sets the hour variable to the parameter argument passed into the method.
    * @param hour The variable that the hour variable is set to.
    */
    public void setHour(int hour)
    {
        try
        {
            if(hour >= 0 && month <= 23)
            {
                this.hour = hour;
            }
            else
            {
                throw new Exception("Hour given not valid");
            }
        }
        catch(Exception E)
        {
            E.getMessage();
        }
    }

    /**
    * Sets the minute variable to the parameter argument passed into the method.
    * @param minute The variable that the minute is set to.
    */
    public void setMinute(int minute)
    {
        try
        {
            if(minute >= 0 && minute <= 59)
            {
                this.minute = minute;
            }
            else
            {
                throw new Exception("Minute given not valid");
            }
        }
        catch(Exception E)
        {
            E.getMessage();
        }
    }

    /**
    * Tests for precedes of two objects of type Time. For the first object
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
    * Tests for equality of two objects of type Time. To be equal,
    * the two objects must have the same year, same month, same day, 
    * same hour and same minute.
    * @param other The time being compared to the calling object.
    * @return Returns true if the calling object equals otherTime.
    */
    public boolean equals(Time other)
    {
        if (other == null)
        {
            return false;
        }
        else
        {
            return year == other.year && month == other.month && day == other.day && hour == other.hour && minute == other.minute;
        }
    }
    
     /**
    * Compares time object with the calling object.
    * @param other The time being compared.
    * @return Returns a 1 if the time object time comes before the calling object,
    * returns a -1 if it comes after it and returns a 0 if they are equal.
    */
    public int compareTo(Time other)
    {
        if (year < other.year)
        {
            return -1;
        }
        else if (year > other.year)
        {
            return 1;
        }
        else if (month < other.month)
        {
            return -1;
        }
        else if (month > other.month)
        {
            return 1;
        }
        else if (day < other.day)
        {
            return -1;
        }
        else if (day > other.day)
        {
            return 1;
        }
        else if (hour < other.hour)
        {
            return -1;
        }
        else if (hour > other.hour)
        {
            return 1;
        }
        else if (minute < other.minute)
        {
            return -1;
        }
        else if (minute > other.minute)
        {
            return 1;
        }
        else
        {
            return 0;
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
        return hour + ":" + minute + ", " + month + "/" + day + "/" + year;
    }

    /**
    * Checks to make sure the parameter arguments are all greater than zero.
    * @param year The variable used to initialize the year variable.
    * @param month The variable used to initialize the month variable.
    * @param day The variable used to initialize the day variable.
    * @param hour The variable used to initialize the hour variable.
    * @param minute The variable used to initialize the min variable.
    * @return Returns 1 if the parameter arguments are all greater than zero 
    * else it returns -1
    */
    static public boolean timeOK(int year, int month, int day, int hour, int minute)
    {
        return year >= 0 && month > 0 && month < 13 && day > 0 && day < 32 && hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    } 
}
