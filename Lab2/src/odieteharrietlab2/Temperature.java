/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package odieteharrietlab2;

/**
 *
 * @author hodiete
 */
public class Temperature {
    private double theTemperature;
    private char unit;
    String degree = "\u00b0";
    
    public Temperature()
    {
      this.theTemperature = 0.0;
    }
    
    public Temperature(double temp)
    {
        this.theTemperature = temp;
        this.unit = 'C';
    }
    public Temperature(double temp, char theUnit)
    {
        this.theTemperature = temp;
        this.unit = theUnit;
    }
    public void setTemperature(double newTemp)
    {
        this.theTemperature = newTemp;
    }
    
    public void setTemperature(double newTemp, char newUnit)
    {
        this.theTemperature = newTemp;
        this.unit = newUnit;
    }
    
    public double getTemperature()
    {
        return theTemperature;
    }
    
    @Override
    public String toString()
    {
        return "The temperature is: " +theTemperature +degree +unit;
    }
    
    public boolean equals(Temperature otherTemp)
    {
        if(otherTemp == null)
        {
            return false;
        }
        else
        {
          return theTemperature == otherTemp.theTemperature && unit == otherTemp.unit;  
        }
    }
    
    public double convertToCelsius(double temp)
    {
        double newTemp = 0.0;
        if(unit == 'C')
        {
           newTemp = temp;
        }
        else if(unit == 'F')
        {
            newTemp = (5.0/9.0)*(temp - 32.0);
        }
        else if(unit == 'K')
        {
            newTemp = temp - 273.0;
        }
        return newTemp;
    }
    
    public double convertToFahrenheit(double temp)
    {
        double newTemp = 0.0;
        if(unit == 'F')
        {
           newTemp = temp;
        }
        else if(unit == 'C')
        {
            newTemp = ((9.0/5.0)*(temp)) + 32.0;
        }
        else if(unit == 'K')
        {
            newTemp = ((9.0/5.0) * (temp - 273.0)) + 32.0;
        }
        return newTemp;
    }
    
    public double convertToKelvin(double temp)
    {
        double newTemp = 0.0;
        if(unit == 'K')
        {
           newTemp = temp;
        }
        else if(unit == 'C')
        {
            newTemp = temp + 273.0;
        }
        else if(unit == 'F')
        {
            newTemp = ((5.0/9.0) * (temp - 32.0)) + 273.0;
        }
        return newTemp;
    }
}
