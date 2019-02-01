      			README
			======
	         DAY PLANNER PROGRAM 
	    ------------------------------
REFERENCES
***********
~ Made use of Mr. Fei Song’s day planner code.

PROBLEM TO SOLVE
****************
Using the day planner created in assignment 2 to create and implement a gui. 

ASSUMPTIONS
***********
The arrayList of Activity grows dynamically.
The file inputted into the program is in the right format.

LIMITATIONS
***********
None at the moment.

USER GUIDE TO THE DAY PLANNER PROGRAM
*************************************
- The user has to open up NetBeans IDE 8.0.1
- Then the user has to go to the Open Project icon and open hodiete_a3
- The user has to click the Run Project icon to run the program.

TEST PLAN
*********

TESTING FOR AN ACTIVITY
***********************
What I tested for
- Adding activities to the array list with different types and seeing if they get stored to the hash map.
How I tested for it
- I added the following activities to the day planner into their right text field and combo box:
   - Type: “home”, Title: “Gardening”, Starting time: “2014 08 11 14 30”,  Ending time: “2014 08 11 16 00”, Comment: “Water all the plants”.
   - Type: “school”, Title: “Design Class”, Starting time: “2014 09 04 13 30”,  Ending time: “2014 11 28 14 20”, Comment: “”.
   - Type: “other”, Title: “Movies with Friends”, Starting time: “2014 12 12 16 30”, Ending time: “2014, 12, 12, 19, 30”, Location: “Cineplex” Comment:”Bring snacks"
Expected Output
- Each activity was added into the array list successfully and the hash map used for searching.
- The messages text box displayed activities were successfully added.

TESTING FOR SEARCH
*******************

Empty search
What I tested for
- When every textfield and combo box is empty
How I tested for it
- Loaded a file to the array list and hash map
- Pressed enter when everything is empty
Expected Results
- This should print out the entire activities stored in the array list.

Uncombined Search

What I tested for
- Search with type.
How I tested for it
- Search with home, school or other.
Results expected
- Displays all the activities with the associated types on the search results text area.

What I tested for 
- Search for title.
How I tested for it
- By putting in the keyword “class” in the title.
Expected Output
- Displays all the activities containing the keyword class in them on the search results text area.

What I tested for 
- Search for starting time.
How I tested for it
- By putting the starting time as "2014 11 3 8 30”.
Expected Output
- Displays all the activities that have their starting time coming after it onto the search results text area.

What I tested for 
- Search for ending time.
How I tested for it
- By putting the ending time as: “2014, 11, 28, 9, 20”.
Expected Output
- Displays all the activities that have their ending time coming before it on the search results text area. 

Combined Search

What I tested for
- Search for when all the entries to search which are provided.
How I tested it
- The type used to search with was “school”, the keyword used to search with was “class”, the starting used to search with was "8:30, 11/3/2014” and ending time used to search with was "9:20, 11/28/2014”.
Expected Output
- Displays only one activity onto the search results text box because the activity contains all the required entries.

What I tested for
- Search with both type and title provided.
How I tested it
- The type used to search was “school” and the title used to search was “class”.
Expected Output
- Displays two activities onto the search results text box because only two activities in the array list contain both the type “school” and keyword “class”.

What I tested for
- Search with both type and starting time.
How I tested for it
- The type used to search with was “school”,and  the starting used to search with was "8:30, 11/3/2014”.
Expected Output
- Displays one activity onto the search results text box because only one activity contains the type and starting time used to search.

What I tested for
- Search with both type and ending time.
How I tested for it
- The type used to search with was “school”,and  the ending used to search with was "9:20, 11/28/2014”.
Expected Output
Displays one activity onto the search results text box because only one activity contains the type and ending time used to search.

What I tested for
- Search with both starting time and ending time.
How I tested for it
- The starting used to search with was "8:30, 11/3/2014” and the ending time used to search with was "9:20, 11/28/2014”.
Expected output
- Displays one activity onto the search results text area because only one activity contains the starting time and ending time used to search.

File Reading
************
Test for file reading
- By checking to see if the file being read existed.
- By checking to see if the file being read was blank.
Results
- The program exited when the file did not exist.
- The program ran and didn’t crash on blank reading file.

Writing to File
***************
Test for writing to file
- By checking to see if the program writes to the same file when only one file is given as the command line argument.

LOADING TO HASH MAP
*******************
Test for loading to hash map
- Checked to see if the hash map gets loaded properly.
Results
-The hash map got loaded correctly
 
UPDATING HASH MAP
*******************
Test for updating hash map
- Checked to see if the hash map updates after an entry is added by the user.
Results
-The hash map updates correctly

SEARCHING HASH MAP
*******************
Test for searching to hash map
- Checked to see if the keywords the user enters where in the hash map.
- Checked to see if the keywords the user enters where not in the hash map.
- Checked to see if the program finds the intersection between two keywords that exist in the hash map.
Results
- It returned the values each keyword occurred in.
- It didn’t return anything.
- It returned the correct intersection they occur at.


POSSIBLE ENHANCEMENTS
*********************
- The user has a choice to load a file or save to a file.
- A background image is set as the initial panel.
- The check on exit window pops up when the user chooses quit.
      