      			README
			======
	         DAY PLANNER PROGRAM 
	    ------------------------------
REFERENCES
***********
~ Made use of Mr. Fei Song’s day planner code.

PROBLEM TO SOLVE
****************
Simplifying the code for assignment 1 and adding some improvements to it by:
1. Making a super class called Activity that HomeActivity, SchoolActivity and OtherActivity classes inherit functions from it. 
2. Making an arrayList of the type Activity in order to store all the activity types
3. Adding activities to the arrayList of Activity by reading an input file and storing the activities to an output file at the end of the program. 
4. Making use of a hash map to improve the keyword search and also improving the combined searches.

ASSUMPTIONS
***********
The arrayList of Activity grows dynamically.
The user has to add a file in order for the program to run. 
If the user types in one file as the command line argument, it will use the file as both the input file and output file. 
If the user types in two files as the command line arguments, it will take the first file to be used as the input file and the second file to be used as the output file.
The file has to be in the right format in order for the program to read it.
The user has to enter “add” or “a” with the case of it being ignored to add to the day planner.
The user has to enter “search” or “s” with the case of it being ignored to search the day planner.
The user has to enter “quit” or “q” with the case of it being ignored to quit the day planner.

LIMITATIONS
***********
None at the moment.

USER GUIDE TO THE DAY PLANNER PROGRAM
*************************************
- The user has to open up NetBeans IDE 8.0.1
- Then the user has to go to the Open Project icon and open hodiete_a2
- The program is already loaded with the command line arguments that consist of the files, unless you want to change it.
- The user has to click the Run Project icon to run the program.

TEST PLAN
*********

Command Loop
************
Test for command loop
- Checking to see if the program does not accept anything order than “add”, “ADD”, “a”, “A”, “search”, “SEARCH”, “s”, “S”, “QUIT”, “quit”, “Q”, or “q”.
Results
-The program doesn’t accept invalid inputs, but prompts the user when invalid inputs are given.

File Reading
************
Test for file reading
- By checking to see if the file being read existed.
- By checking to see if the file being read was blank.
- By checking to see if the program reads the file if the user enters either one command line argument or two.
Results
- The program exited when the file did not exist.
- The program ran and didn’t crash on blank reading file.
- The program used the first command line argument as the file to be read.

Writing to File
***************
Test for writing to file
- By checking to see if the program writes to the same file when only one file is given as the command line argument.
- By checking to see if the program writes to the output file when two files are given as the command line argument. The output file is the second command line argument.

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

ADDING TO DAY PLANNER
*********************
Test for adding to day planner
- Checked to see if the activity the user inputted actually store in the arrayList
Results
- The activity was correctly added to the array list.

SEARCHING IN DAY PLANNER
*************************
Test for searching in day planner 
- Checked to see the what the program returned when no input was proved for the search.
- Checked to see the what the program returned when only an activity type was given.
- Checked to see the what the program returned when only keywords were given.
Results
- The program returned all activities stored.
- The program returned all the specified activity type given.
- The program returned all the activities that contained the given keywords.

*********************
- Combine search with the title and every other search could have been done could have been done better



      