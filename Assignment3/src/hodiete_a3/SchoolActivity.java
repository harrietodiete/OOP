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
public class SchoolActivity extends Activity{
    /**
    * Initializes the title, startTime, endTime and comment variables to the 
    * parameters argument passed into the method.
    * @param type The variable used to initialize the type variable.
    * @param title The variable used to initialize the title variable.
    * @param startingTime The variable used to initialize the startingTime variable.
    * @param endingTime The variable used to initialize the endingTime variable.
    * @param comment The variable used to initialize the comment variable.
    */
    public SchoolActivity(String type, String title, Time startingTime, Time endingTime, String comment)
    {
        super(type, title, startingTime, endingTime, comment);
    }
}
