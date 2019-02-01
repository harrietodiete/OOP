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
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.io.*;
   import java.util.ArrayList;

public class DayPlannerGUI extends JFrame implements WindowListener{
    public static DayPlanner planner = new DayPlanner();
    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;
    private JFrame DayPWindow;
    private JMenuBar options  = new JMenuBar();
    private JMenu optionMenu = new JMenu("Commands");
    private JMenuItem addOption = new JMenuItem("Add");
    private JMenuItem searchOption = new JMenuItem("Search");
    private JMenuItem quitOption = new JMenuItem("Quit");
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem loadOption = new JMenuItem("Load a file");
    private JMenuItem saveOption = new JMenuItem("Save to a file");
    private JPanel initPanel;
    private JPanel addPanel;
    private JPanel searchPanel;
    private JLabel typeOne = new JLabel("Type:");
    private String[] typesItem = {"school", "home", "other"};
    private String[] typesSearch = {"", "school", "home", "other"};
    private JLabel titleOne = new JLabel("Title:");
    private JLabel startTimeOne = new JLabel("Starting time (year, month, day, hour, minute):");
    private JLabel endTimeOne = new JLabel("Ending time (year, month, day, hour, minute):");
    private JLabel commentOne = new JLabel("Comment:");
    private JLabel locationOne = new JLabel("Location:");
    private JButton reset = new JButton("RESET");
    private JButton enter = new JButton("ENTER");
    private JTextField titleField = new JTextField();
    private JTextField startField = new JTextField();
    private JTextField endField = new JTextField();
    private JTextField locField = new JTextField();
    private JTextField commentField = new JTextField();
    private static JTextArea message = new JTextArea(14,200);
    private ImageIcon background = new ImageIcon("images/blank-daily-calendarremake.jpg");
    
    /**
     * Sets up the JFrame and adds the menuBar to the JFrame. The menus are add to the menuBar
     * and the menuItems are added to the menu. Action Listeners are added to each menu item.
     */
    public DayPlannerGUI()
    {
        super("DayPlanner");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        addOptToFrame();
        searchOptToFrame();
        addOption.addActionListener(new AddListener());
        searchOption.addActionListener(new SearchListener());
        quitOption.addActionListener(new QuitListener());
        loadOption.addActionListener(new LoadFileListener());
        saveOption.addActionListener(new SaveFileListener());
        addOption.setBackground(Color.WHITE);
        optionMenu.add(addOption);
        searchOption.setBackground(Color.WHITE);
        optionMenu.add(searchOption);
        quitOption.setBackground(Color.WHITE);
        optionMenu.add(quitOption);
        loadOption.setBackground(Color.WHITE);
        fileMenu.add(loadOption);
        saveOption.setBackground(Color.WHITE);
        fileMenu.add(saveOption);
        optionMenu.setBackground(Color.PINK);
        options.add(optionMenu);
        fileMenu.setBackground(Color.PINK);
        options.add(fileMenu);
        options.setBackground(Color.PINK);
        add(options);
        setJMenuBar(options);
        initPanel = new JPanel(new BorderLayout());
        //Adding home image display
        JLabel imageFront = new JLabel("",background, JLabel.CENTER);
        initPanel.add(imageFront, BorderLayout.CENTER);
        add(initPanel);
        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Day Planner", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION)
        {
                JOptionPane.showMessageDialog(null, "Thank you for using Day Player!", "Day Planner", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) { 
    }
    
    /**
     * This opens up the file chooser for the user to choose what file they want to load into
     * the dayPlanner when they select the menu item save to file.
     */
    public class LoadFileListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //This initializes file chooser
            JFileChooser file = new JFileChooser();
            //This sets the filechooser window for the user to be able to open a file
            int choice = file.showOpenDialog(DayPlannerGUI.this);
            if(choice == JFileChooser.APPROVE_OPTION)
            {
                //If the choice is approved, it will get the file and pass it in the dayplanner readfile method to enable it to parse the file.
                File inputFile = file.getSelectedFile();
                planner.readFile(inputFile);
                //This will load the map with the activities from the file recently added.
                planner.loadMap();
                planner.printActivities();
            }
        }
    }
    
    /**
     * This opens up a new window for the user to enter the filename they would like to save
     * dayPlanner activities to.
     */
    public class SaveFileListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //This initializes file chooser
            JFileChooser file = new JFileChooser();
            //This sets the filechooser window for the user to be able to open a file
            int choice = file.showSaveDialog(DayPlannerGUI.this);
            if(choice == JFileChooser.APPROVE_OPTION)
            {
                //If the choice is approved, it will get the file and pass it in the dayplanner readfile method to enable it to parse the file.
                File inputFile = file.getSelectedFile();
                planner.writeToFile(inputFile);
            }
        }
    }
    
    /**
     * This sets the addPanel to be visible on the JFrame and sets the searchPanel and initPanel visibility to
     * false.
     */
    public class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent E)
        {
            //This sets the visibility of the panel's on the JFrame
            addPanel.setVisible(true);
            searchPanel.setVisible(false);
            initPanel.setVisible(false);
        }
    }
    
    /**
     * This sets the searchPanel visible on the JFrame and sets the addPanel and initPanel visibility to
     * false.
     */
    public class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent E)
        {
            //This sets the visibility of the panel's on the JFrame
            addPanel.setVisible(false);
            searchPanel.setVisible(true);
            initPanel.setVisible(false);
        }
    }
    
    /**
     * This sets the quit menu item to close the JFrame window.
     */
    public class QuitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent E)
        {
            int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Day Planner", JOptionPane.YES_NO_OPTION);
            if (exit == JOptionPane.YES_OPTION)
            {
                    JOptionPane.showMessageDialog(null, "Thank you for using Day Player!", "Day Planner", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
            }
        }
    }
    
    /**
     * This initializes and sets the different labels and the text fields that will be used to 
     * get the user's input for type, title, starting time, ending time and these inputs will be
     * used to search the arrayList of activities to find matches found.This will also set the 
     * searchPanel's visibility to false until the user clicks on the menu item search.
     */
    private void searchOptToFrame()
    {
        searchPanel = new JPanel(new BorderLayout(2,2));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        JPanel topPanel = new JPanel(new BorderLayout(2,2));
        topPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        topPanel.add(new JLabel("Searching activities:"), BorderLayout.NORTH);
        JPanel searchItems = new JPanel(new BorderLayout());
        searchItems.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        JPanel addFirst = new JPanel(new GridLayout(0,2));
        JPanel nextTwo = new JPanel(new GridLayout(0,1));
        JLabel titled = new JLabel("Search Results: ");
        JTextArea searchMessage = new JTextArea(14,200);
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setBorder(BorderFactory.createEmptyBorder(50,0,0,80));
        JComboBox typeBox = new JComboBox(typesSearch);
        JTextField titleS = new JTextField();
        JTextField startTime = new JTextField();
        JTextField endTime = new JTextField();
        JButton resetButton = new JButton("RESET");
        resetButton.setBackground(Color.RED);
        //This adds actions to the reset button
        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //This sets every text field, search result text area and type jcombo box to empty
                typeBox.setSelectedItem("");
                titleS.setText("");
                startTime.setText("");
                endTime.setText("");
                searchMessage.setText("");
            }
        });
        //This adds actions to the enter button
        JButton enterButton = new JButton("ENTER");
        enterButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Initializes and declares variables
                String typeToArray = String.valueOf(typeBox.getSelectedItem());
                System.out.println("Type: " +typeToArray);
                String titleToArray = titleS.getText();
                System.out.println("Title: " +titleToArray);
                String getStartTime = startTime.getText();
                String getEndTime = endTime.getText();
                Time startToArray = null;
                Time endToArray = null;
                System.out.println("End: " +endToArray);
                
                if(!(getStartTime.isEmpty()) && (getEndTime.isEmpty()))
                {
                    //This will run if the starting time text field is not empty and the ending time text field is empty
                    try
                    {
                        //This will try to change the string gotten from the starting time textfield to a time object
                        startToArray = planner.getTime(getStartTime);
                        if(startToArray == null)
                        {
                            //This will throw an exception if the getTime returned a null
                            throw new Exception("Unable to search for activity: The starting time given was not valid\n");
                        }
                        else
                        {
                            //This will call the search activties method in the dayplanner to find results.
                            endToArray = planner.getTime(getEndTime);
                            ArrayList<Activity> results = planner.searchActivities(typeToArray, titleToArray, startToArray, endToArray);
                            System.out.println(results.size());
                            if(results.isEmpty())
                            {
                                searchMessage.append("No results found\n");
                            }
                            else 
                            {
                                searchMessage.append("Matched results:\n");
                                for(int i = 0; i<results.size(); i++)
                                {
                                    searchMessage.append(results.get(i).toString()+"\n");
                                    System.out.println(results.get(i));
                                }
                            }
                        }
                    }
                    catch(Exception E)
                    {
                        searchMessage.append(E.getMessage());
                    }
                }
                if((getStartTime.isEmpty()) && !(getEndTime.isEmpty()))
                {
                    try
                    {
                        endToArray = planner.getTime(getEndTime);
                        if(endToArray == null)
                        {
                            throw new Exception("Unable to search for activity: The ending time given was not valid\n");
                        }
                        else
                        {
                            startToArray = planner.getTime(getStartTime);
                            ArrayList<Activity> results = planner.searchActivities(typeToArray, titleToArray, startToArray, endToArray);
                            System.out.println(results.size());
                            if(results.isEmpty())
                            {
                                searchMessage.append("No results found\n");
                            }
                            else 
                            {
                                searchMessage.append("Matched results:\n");
                                for(int i = 0; i<results.size(); i++)
                                {
                                    searchMessage.append(results.get(i).toString()+"\n");
                                    System.out.println(results.get(i));
                                }
                            }
                        }
                    }
                    catch(Exception E)
                    {
                        searchMessage.append(E.getMessage());
                    }
                }
                if(!(getStartTime.isEmpty()) && !(getEndTime.isEmpty()))
                {
                    try
                    {
                        startToArray = planner.getTime(getStartTime);
                        if(startToArray == null)
                        {
                            throw new Exception("Unable to search for activity: The starting time given was not valid\n");
                        }
                    }
                    catch(Exception E)
                    {
                        searchMessage.append(E.getMessage());
                    }
                    try
                    {
                        endToArray = planner.getTime(getEndTime);
                        if(endToArray == null)
                        {
                            throw new Exception("Unable to search for activity: The ending time given was not valid\n");
                        }
                    }
                    catch(Exception E)
                    {
                        searchMessage.append(E.getMessage());
                    }
                    if(startToArray != null && endToArray != null)
                    {
                        ArrayList<Activity> results = planner.searchActivities(typeToArray, titleToArray, startToArray, endToArray);
                        System.out.println(results.size());
                        if(results.isEmpty())
                        {
                            searchMessage.append("No results found\n");
                        }
                        else 
                        {
                            searchMessage.append("Matched results:\n");
                            for(int i = 0; i<results.size(); i++)
                            {
                                searchMessage.append(results.get(i).toString()+"\n");
                                System.out.println(results.get(i));
                            }
                        }
                    }
                }
                if(getStartTime.isEmpty() && getEndTime.isEmpty())
                {
                    startToArray = planner.getTime(getStartTime);
                    endToArray = planner.getTime(getEndTime);
                    ArrayList<Activity> results = planner.searchActivities(typeToArray, titleToArray, startToArray, endToArray);
                    System.out.println(results.size());
                    if(results.isEmpty())
                    {
                        searchMessage.append("No results found\n");
                    }
                    else 
                    {
                        searchMessage.append("Matched results:\n");
                        for(int i = 0; i<results.size(); i++)
                        {
                            searchMessage.append(results.get(i).toString()+"\n");
                            System.out.println(results.get(i));
                        }
                    }
                }
                searchMessage.append("\n");
            }
        });
        
        addFirst.add(new JLabel("Type:"), BorderLayout.WEST);
        addFirst.add(typeBox, BorderLayout.CENTER);
        addFirst.add(new JLabel("Title:"), BorderLayout.WEST);
        addFirst.add(titleS, BorderLayout.CENTER);
        nextTwo.add(new JLabel("Starting time (year, month, day, hour, minute):"));
        nextTwo.add(startTime);
        nextTwo.add(new JLabel("Ending time (year, month, day, hour, minute):"));
        nextTwo.add(endTime);
        buttons.add(resetButton);
        buttons.add(Box.createRigidArea(new Dimension(0,80)));
        buttons.add(enterButton);
        searchItems.add(addFirst,BorderLayout.NORTH);
        searchItems.add(nextTwo, BorderLayout.CENTER);
        searchItems.setPreferredSize(new Dimension(400,195));
        topPanel.add(searchItems, BorderLayout.WEST);
        topPanel.add(new JSeparator(JSeparator.VERTICAL));
        topPanel.add(buttons, BorderLayout.EAST);
        topPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.AFTER_LAST_LINE);
        JPanel messPanel = new JPanel(new BorderLayout());
        JPanel addMessage = new JPanel(new BorderLayout(2,2));
        addMessage.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        addMessage.add(titled, BorderLayout.NORTH);
        addMessage.add(new JScrollPane(searchMessage));
        searchMessage.setEditable(false);
        messPanel.add(addMessage);
        searchPanel.add(topPanel, BorderLayout.NORTH);
        searchPanel.add(messPanel, BorderLayout.CENTER);
        searchPanel.setVisible(false);
        add(searchPanel); 
    }
    
    /**
     * This initializes and sets the different labels and the text fields that will be used to 
     * get the user's input for type, title, starting time, ending time, location and comment to 
     * make these inputs into an activity and store it into the arrayList of Activities.This will 
     * also set the addPanel's visibility to false until the user clicks on the menu item add.
     */
    private void addOptToFrame()
    {       
        addPanel = new JPanel(new BorderLayout(2,2));
        addPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));            
        JPanel headPanel = new JPanel(new BorderLayout(2,2));
        headPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        headPanel.add(new JLabel("Adding an activity:"), BorderLayout.NORTH);
        JPanel addItems = new JPanel(new BorderLayout());
        addItems.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        JPanel addFirstTwo = new JPanel(new BorderLayout());
        JPanel addType = new JPanel(new GridLayout(0,2));
        JPanel addTitle = new JPanel(new GridLayout(0,2));
        JPanel addNextTwo = new JPanel(new GridLayout(0,1));
        JPanel addStart = new JPanel(new GridLayout(0,1));
        JPanel addEnd = new JPanel(new GridLayout(0,1));
        JPanel addLastTwo = new JPanel(new GridLayout(0,1));
        JPanel addLocation = new JPanel(new GridLayout(0,2));
        JPanel addComment = new JPanel(new GridLayout(0,2));
        JPanel buttonField = new JPanel();
        buttonField.setLayout(new BoxLayout(buttonField, BoxLayout.Y_AXIS));
        buttonField.setBorder(BorderFactory.createEmptyBorder(50,0,0,80));
        JComboBox typeOpt = new JComboBox(typesItem);
        typeOpt.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(typeOpt.getSelectedItem());
                if(String.valueOf(typeOpt.getSelectedItem()).equals("other"))
                {
                    addLocation.setVisible(true);
                }
                else
                {
                    addLocation.setVisible(false);
                }
            }
        });
        addType.add(typeOne, BorderLayout.WEST);
        addType.add(typeOpt, BorderLayout.CENTER);
        addTitle.add(titleOne, BorderLayout.WEST);
        addTitle.add(titleField, BorderLayout.CENTER);
        addStart.add(startTimeOne);
        addStart.add(startField);
        addEnd.add(endTimeOne);
        addEnd.add(endField);
        addLocation.add(locationOne, BorderLayout.WEST);
        addLocation.add(locField, BorderLayout.CENTER);
        addLocation.setVisible(false);
        addComment.add(commentOne, BorderLayout.WEST);
        addComment.add(commentField, BorderLayout.CENTER);
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //This sets every textfield and textarea to empty
                typeOpt.setSelectedItem("");
                titleField.setText("");
                startField.setText("");
                endField.setText("");
                locField.setText("");
                commentField.setText("");
                message.setText("");
            }
        });
        buttonField.add(reset);
        buttonField.add(Box.createRigidArea(new Dimension(0,80)));
        enter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //This sets what happens when enter is pressed by the user
                String type = String.valueOf(typeOpt.getSelectedItem());
                String theTitle = "";
                Time startingTime = null;
                Time endingTime = null;
                String location = "";
                String comment = "";
                System.out.println("Type: " +type);
                try
                {
                    theTitle = titleField.getText();
                    if(theTitle.isEmpty())
                    {
                        throw new Exception("Unable to add the Activity: No title was given\n");
                    }
                }
                catch(Exception E)
                {
                    message.append(E.getMessage());
                }
                try
                {
                    startingTime = planner.getTime(startField.getText());
                    if(startingTime == null)
                    {
                        throw new Exception("Unable to add the Activity: No starting time wasn't given or is not valid\n");
                    }
                }
                catch(Exception E)
                {
                    message.append(E.getMessage());
                }
                try
                {
                    endingTime = planner.getTime(endField.getText());
                    if(endingTime == null)
                    {
                        throw new Exception("Unable to add the Activity: No ending time wasn't given or is not valid\n");
                    }
                }
                catch(Exception E)
                {
                    message.append(E.getMessage());
                }
                try{
                    endingTime = planner.getTime(endField.getText());
                    if(endingTime != null && startingTime != null && endingTime.precedes(startingTime))
                    {
                        throw new Exception("Unable to add the Activity: Ending time can't start before starting time\n");
                    }
                }
                catch(Exception E)
                {
                    message.append(E.getMessage());
                    System.out.println(E.getMessage());
                }
                if(type.equals("other"))
                {
                    try
                    {
                        location = locField.getText();
                        if(location.isEmpty())
                        {
                            throw new Exception("Unable to add the Activity: No location was given\n");
                        }
                    }
                    catch(Exception E)
                    {
                        message.append(E.getMessage());
                    }
                }
                comment = commentField.getText();
                System.out.println("Start: " +startingTime);
                if(!(theTitle.isEmpty()) && startingTime != null && endingTime != null &&(startingTime.precedes(endingTime) || startingTime.equals(endingTime)))
                {
                    if (type.equalsIgnoreCase("home") || type.equalsIgnoreCase("h"))
                    {
                        planner.addHomeActivity(new HomeActivity(type, theTitle, startingTime, endingTime, comment));
                        planner.updateMap();
                        message.append("Activity was successfully added\n");
                    }
                    else if (type.equalsIgnoreCase("school") || type.equalsIgnoreCase("s"))
                    {
                        planner.addSchoolActivity(new SchoolActivity(type, theTitle, startingTime, endingTime, comment));
                        planner.updateMap();
                        message.append("Activity was successfully added\n");
                    }
                    else
                    {
                        if(!location.isEmpty())
                        {
                            planner.addOtherActivity(new OtherActivity(type, theTitle, startingTime, endingTime, location, comment));
                            planner.updateMap();
                            message.append("Activity was successfully added\n");
                        }
                    }
                } 
                message.append("\n");
                planner.printActivities();
            }
        });
        buttonField.add(enter);
        addFirstTwo.add(addType, BorderLayout.NORTH);
        addFirstTwo.add(addTitle, BorderLayout.AFTER_LAST_LINE);
        addItems.add(addFirstTwo,BorderLayout.NORTH);
        addNextTwo.add(addStart,BorderLayout.NORTH);
        addNextTwo.add(addEnd,BorderLayout.AFTER_LAST_LINE);
        addItems.add(addNextTwo, BorderLayout.CENTER);
        addLastTwo.add(addLocation, BorderLayout.NORTH);
        addLastTwo.add(addComment, BorderLayout.SOUTH);
        addItems.add(addLastTwo, BorderLayout.SOUTH);
        addItems.setPreferredSize(new Dimension(400,245));
        headPanel.add(addItems, BorderLayout.WEST);
        headPanel.add(new JSeparator(JSeparator.VERTICAL));
        headPanel.add(buttonField, BorderLayout.EAST);
        headPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.AFTER_LAST_LINE);
        JPanel messPanel = new JPanel(new BorderLayout());
        JPanel addMessage = new JPanel(new BorderLayout(2,2));
        addMessage.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        JLabel titled = new JLabel("Messages: ");
        addMessage.add(titled, BorderLayout.NORTH);
        addMessage.add(new JScrollPane(message));
        message.setEditable(false);
        messPanel.add(addMessage);
        addPanel.add(headPanel, BorderLayout.NORTH);
        addPanel.add(messPanel, BorderLayout.SOUTH);
        addPanel.setVisible(false);
        add(addPanel); 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DayPlannerGUI dPlanner = new DayPlannerGUI();
        dPlanner.setResizable(false);
        dPlanner.setLocationRelativeTo(null);
        dPlanner.setVisible(true);
    }
    
}
