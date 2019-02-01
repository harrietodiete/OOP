      			README
			======

	         DAY PLANNER PROGRAM 
	    ------------------------------

PROBLEM TO SOLVE
****************
Storing objects of different classes into an array of the designated class type and searching through an array of objects.

ASSUMPTIONS
***********
Maximum number of objects each activity array can store is 5.
For the starting and ending times: 
- The year has to be between 1000 - 9999,
- The month has to be between 1 - 12,
- The day has to be between 1 - 31,
- The hour has to be between 0 - 23 and,
- The minute has to be between 0 - 59,
The user has to enter “add” with the case of it being ignored to add to the day planner.
The user has to enter “search” with the case of it being ignored to search the day planner.

LIMITATIONS
***********
The user can only add with just typing in “add” and can ignore the case it is in.
The user can only add with just typing in “add” and can ignore the case it is in.
The user can not search for an activity with using time.

USER GUIDE TO THE DAY PLANNER PROGRAM
*************************************
- The user has to open up NetBeans IDE 8.0.1
- Then the user has to go to the Open Project icon and open OdieteHarrietA1
- The user has to click the Run Project icon to run the program.

TEST PLAN
*********

Command Loop
************
The command loop accepts “add” for adding an activity, “search” for searching for an activity and “quit”, “Quit”, “Q”, “QUIT” and “quit” for quitting the program.

Adding an activity
******************
The program only accepts either “home” with the case ignored to add to home activities, “school” with the case ignored to add to school activities and “other” with the case ignored to add to other activities for when the user types in add in the command loop.
The user has to enter a title for the activities unless the program will keep prompting the user to enter a title
An activity can be added to an array of the activities (home, school or other) if the array has not yet reached its maximum size.
If the array has reached its maximum size, it will tell the user and won’t add it to the array.

Searching for an activity
*************************
1. If the user doesn’t enter anything to search for, it will print out all the activities stored in each array.
2. If the user only enters keywords it will search all the arrays for the keywords.
3. If the user enters both keywords and an activity, it will search for the keywords in that particular activity.

POSSIBLE ENHANCEMENTS
*********************
- User proofing for invalid time input.
- Comparing of the time periods could have been done better.
- Invalid input for when the user does not enter anything and just press enter could have been handled better.



      