package hodiete_a2;

/**
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
        if (timeOK(year, month, day, hour, minute))
        {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
        }
        else
        {
            System.out.println("Fatal Error for Time");
            System.exit(0);
        }
    }

    /**
    * Create a time object with no arguments
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
    * Sets the year variable to the parameter argument passed into the method.
    * @param year The variable that the year variable is set to.
    */
    public void setYear(int year)
    {
        if (year >= 0)
        {
            this.year = year;
        }
        else
        {
            System.out.println("Invalid value for year: " + year);
            System.exit(0);
        }
    }
    
    /**
    * Sets the month variable to the parameter argument passed into the method.
    * @param month The variable that the month variable is set to.
    */
    public void setMonth(int month)
    {
        if (month >= 0)
        {
            this.month = month;
        }
        else
        {
            System.out.println("Invalid value for month: " + month);
            System.exit(0);
        }
    }
    
    /**
    * Sets the day variable to the parameter argument passed into the method.
    * @param day The variable that the day variable is set to.
    */
    public void setDay(int day)
    {
        if (day >= 0)
        {
           this.day = day;
        }
        else
        {
            System.out.println("Invalid value for day: " + day);
            System.exit(0);
        }
    }

    /**
    * Sets the hour variable to the parameter argument passed into the method.
    * @param hour The variable that the hour variable is set to.
    */
    public void setHour(int hour)
    {
        if (hour >= 0)
        {
            this.hour = hour;
        }
        else
        {
            System.out.println("Invalid value for hour: " + hour);
            System.exit(0);
        }
    }

    /**
    * Sets the minute variable to the parameter argument passed into the method.
    * @param minute The variable that the minute is set to.
    */
    public void setMinute(int minute)
    {
        if (minute >= 0)
        {
            this.minute = minute;
        }
        else
        {
            System.out.println("Invalid value for minute: " + minute);
            System.exit(0);
        }
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
        return (year >= 0) && (month >= 0) && (day >= 0) && (hour >= 0) && (minute >= 0);
    }
}
