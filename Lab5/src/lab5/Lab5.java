/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 *
 * @author harrietodiete
 */
public class Lab5 extends JFrame{
    private JMenuBar options  = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem addOption = new JMenuItem("Add Credits");
    private JMenuItem adjustOption = new JMenuItem("Adjust Odds"); ;
    private JMenuItem exitOption = new JMenuItem("Exit");
    private JMenuItem aboutOption = new JMenuItem("About");
    private JPanel mainPanel;
    private int credits = 20;
    private int creditsWon = 0;
    private int creditsLost = 0;
    private JLabel creditsField = new JLabel("Total Credits: " +credits);
    private JLabel winloseField = new JLabel("Credits Won/Loss: " +creditsWon+ "/" +creditsLost);
    private JLabel wonLabel = new JLabel("You've won the round");
    private JLabel loseLabel = new JLabel("You've lost the round");
    private JLabel slot1Label = new JLabel();
    private JLabel slot2Label = new JLabel();
    private JLabel slot3Label = new JLabel();
    private ImageIcon cherry = new ImageIcon("images/Cherries-128.png");
    private ImageIcon bell = new ImageIcon("images/Bell-128.png");
    private ImageIcon seven = new ImageIcon("images/Lucky_Seven-512.png");
    private ImageIcon bar = new ImageIcon("images/slot-machine-reel-symbol-bar.png");
    private ImageIcon goldNugget = new ImageIcon("images/Gold_Bar-icon.png");
    private ImageIcon[] symbols = {cherry, bell, seven, bar, goldNugget};
    private JTextField [] oddsSpace = new JTextField[15]; 
    private int slot1Sum = 0;
    private int slot2Sum = 0;
    private int slot3Sum = 0;
    
    public Lab5()
    {
        super("");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        //Adds listeners to the menuItems
        addOption.addActionListener(new addListener());
        adjustOption.addActionListener(new adjustListener());
        exitOption.addActionListener(new exitListener());
        aboutOption.addActionListener(new aboutListener());
        //Adding the menu items to the menus
        fileMenu.add(addOption);
        fileMenu.add(new JSeparator(JSeparator.HORIZONTAL));
        fileMenu.add(adjustOption);
        fileMenu.add(new JSeparator(JSeparator.HORIZONTAL));
        fileMenu.add(exitOption);
        helpMenu.add(aboutOption);
        //Adding the menus to the menbar
        options.add(fileMenu);
        options.add(helpMenu);
        //Setting the menubar on the jFrame
        setJMenuBar(options);
        //Setting the entire layout of the JFrame to box layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        //Adding the mainWindow panel to the JFrame
        mainWindow();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void removeCredits() throws OutOfCreditsException
    {
        if(credits > 2)
        {
            //This will happen when credits is greater than 2
            credits = credits - 3;
            creditsLost = creditsLost + 3;
            System.out.println("Credits: " +credits);
            creditsField.setText("Total Credits: "+credits);
        }
        else
        {
            //This will throw the out of credits exception once the credits is less than or equal to 2
             throw new OutOfCreditsException();
        }
    }
    
    public void addOdds() throws OddsNot100Exception
    {
        if(slot1Sum != 100 && slot2Sum!= 100 && slot3Sum != 100)
        {
            //This will throw the odds not 100 exception sum of odds in each slot is not 100
             throw new OddsNot100Exception();
        }
    }

    @SuppressWarnings("Convert2Lambda")
    private void mainWindow()
    {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0,20,30,20));
        JPanel stuffPanel = new JPanel(new BorderLayout());
        
        JPanel slotsPanel = new JPanel(new FlowLayout());
        slotsPanel.setBorder(BorderFactory.createEmptyBorder(40,2,10,2));
        JPanel creditsPanel = new JPanel(new BorderLayout());
        creditsPanel.setBorder(BorderFactory.createEmptyBorder(20,2,30,2));
        JPanel labelPanel = new JPanel(new GridBagLayout());
        labelPanel.setPreferredSize(new Dimension(150,20));
        labelPanel.setBackground(Color.WHITE);
        labelPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JPanel winlossPanel = new JPanel(new GridBagLayout());
        winlossPanel.setPreferredSize(new Dimension(150,20));
        winlossPanel.setBackground(Color.WHITE);
        winlossPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JPanel wlPanel = new JPanel(new GridBagLayout());
        wlPanel.setBorder(BorderFactory.createEmptyBorder(20,2,30,2));
        wlPanel.setBackground(Color.WHITE);
        wlPanel.setPreferredSize(new Dimension(150,100));
        wlPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JPanel slot1 = new JPanel(new GridBagLayout());
        slot1.setPreferredSize(new Dimension(100,100));
        slot1.setBackground(Color.WHITE);
        slot1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JPanel slot2 = new JPanel(new GridBagLayout());
        slot2.setPreferredSize(new Dimension(100,100));
        slot2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        slot2.setBackground(Color.WHITE);
        JPanel slot3 = new JPanel(new GridBagLayout());
        slot3.setPreferredSize(new Dimension(100,100));
        slot3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        slot3.setBackground(Color.WHITE);
        slotsPanel.add(slot1);
        slotsPanel.add(slot2);
        slotsPanel.add(slot3);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        creditsField.setFont(new Font("Serif", Font.BOLD, 12));
        labelPanel.add(creditsField,gbc);
        creditsPanel.add(labelPanel, BorderLayout.WEST);
        gbc.gridx = 0;
        gbc.gridy = 0;
        winloseField.setFont(new Font("Serif", Font.BOLD, 12));
        winlossPanel.add(winloseField,gbc);
        creditsPanel.add(winlossPanel, BorderLayout.EAST);
        stuffPanel.add(slotsPanel, BorderLayout.NORTH);
        stuffPanel.add(creditsPanel, BorderLayout.CENTER);
        stuffPanel.add(wlPanel, BorderLayout.SOUTH);
        JPanel spinPanel = new JPanel(new GridBagLayout());
        spinPanel.setBorder(BorderFactory.createEmptyBorder(0,20,10,10));
        spinPanel.setPreferredSize(new Dimension(100,10));
        gbc.ipady = 80;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton spinButton = new JButton("SPIN");
        spinButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    removeCredits();
                    Random getSymbol = new Random();
                    ImageIcon firstSlot = symbols[getSymbol.nextInt(symbols.length)];
                    ImageIcon secondSlot = symbols[getSymbol.nextInt(symbols.length)];
                    ImageIcon thirdSlot = symbols[getSymbol.nextInt(symbols.length)];
                    System.out.println(firstSlot + ", " + secondSlot +", " + thirdSlot);
                    Image image = firstSlot.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    firstSlot.setImage(image);
                    Image image1 = secondSlot.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    secondSlot.setImage(image1);
                    Image image2 = thirdSlot.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    thirdSlot.setImage(image2);
                    slot1Label.setIcon(firstSlot);
                    slot2Label.setIcon(secondSlot);
                    slot3Label.setIcon(thirdSlot);
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    slot1.add(slot1Label, gbc);
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    slot2.add(slot2Label, gbc);
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    slot3.add(slot3Label, gbc);
                    gbc.ipady = 80;
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    wonLabel.setFont(new Font("Serif", Font.BOLD, 24));
                    wonLabel.setForeground (Color.green);
                    wlPanel.add(wonLabel,gbc);
                    wonLabel.setVisible(false);
                    gbc.ipady = 80;
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    loseLabel.setFont(new Font("Serif", Font.BOLD, 24));
                    loseLabel.setForeground (Color.RED);
                    wlPanel.add(loseLabel,gbc);
                    loseLabel.setVisible(true);
                    if(firstSlot.equals(cherry) && secondSlot.equals(cherry) && thirdSlot.equals(cherry))
                    {
                        credits = credits + 3;
                        creditsField.setText("Total Credits: "+credits);
                        creditsWon = creditsWon + 3;
                        wonLabel.setVisible(true);
                        loseLabel.setVisible(false);
                    }
                    if(firstSlot.equals(bell) && secondSlot.equals(bell) && thirdSlot.equals(bell))
                    {
                        credits = credits + 6;
                        creditsField.setText("Total Credits: "+credits);
                        creditsWon = creditsWon + 6;
                        wonLabel.setVisible(true);
                        loseLabel.setVisible(false);
                    }
                    if(firstSlot.equals(seven) && secondSlot.equals(seven) && thirdSlot.equals(seven))
                    {
                        credits = credits + 25;
                        creditsField.setText("Total Credits: "+credits);
                        creditsWon = creditsWon + 25;
                        wonLabel.setVisible(true);
                        loseLabel.setVisible(false);
                    }
                    if(firstSlot.equals(bar) && secondSlot.equals(bar) && thirdSlot.equals(bar))
                    {
                        credits = credits + 100;
                        creditsField.setText("Total Credits: "+credits);
                        creditsWon = creditsWon + 100;
                        wonLabel.setVisible(true);
                        loseLabel.setVisible(false);
                    }
                    if(firstSlot.equals(goldNugget) && secondSlot.equals(goldNugget) && thirdSlot.equals(goldNugget))
                    {
                        credits = credits + 1000;
                        creditsField.setText("Total Credits: "+credits);
                        creditsWon = creditsWon + 1000;
                        wonLabel.setVisible(true);
                        loseLabel.setVisible(false);
                    }
                    //Sets creditsWon and lost on the jlabel to the new amount and displays it on the panel
                    winloseField.setText("Credits Won/Loss: " +creditsWon+ "/" +creditsLost);
                    System.out.println("Total Loss: " +creditsLost);
                    System.out.println("Total Wins: " + creditsWon);
                }
                catch(OutOfCreditsException E)
                {
                    //Gets the throw exception
                    E.getMessage();
                }
            }
        });
        spinPanel.add(spinButton, gbc);
        mainPanel.add(stuffPanel, BorderLayout.WEST);
        mainPanel.add(spinPanel, BorderLayout.EAST);
        //Adds the mainPnel to the jFrame
        add(mainPanel);

    }

    private static class OddsNot100Exception extends Exception {

        public OddsNot100Exception() {
            //Do nothing here
        }
    }

    private class OutOfCreditsException extends Exception {

        public OutOfCreditsException() {
            //This will pop open the addCreditsWindow once the exception is caught
            addCreditsWindow();
        }
    }
    
    public class addListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent E)
        {
            //This will open the addCreditsWindow if the user clicks on the menu item Add Credits
            addCreditsWindow();
        }
    }
    @SuppressWarnings("Convert2Lambda")
    public void addCreditsWindow()
    {
        JFrame addWindow = new JFrame("Add Credits");
        addWindow.setSize(400,100);
        addWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindow.setLayout(new BorderLayout());
        JPanel creditsPanel = new JPanel(new GridBagLayout());
        creditsPanel.setBorder(BorderFactory.createEmptyBorder(0,20,10,10));
        GridBagConstraints gbc = new GridBagConstraints();
        JTextField creditField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        creditsPanel.add(new JLabel("Credits"), gbc);
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        creditsPanel.add(creditField, gbc);
        addWindow.add(creditsPanel, BorderLayout.NORTH);
        JPanel buttonsField = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("Save");
        //Adding actions to the save button
        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int newCredits = 0;
                try {
                    //This will try to convert the creditField to an integer 
                    newCredits = Integer.parseInt(creditField.getText());
                } 
                catch (NumberFormatException E) 
                {
                    //This will close the addWindow window when no credits has been added and the save button is pressed
                    addWindow.dispose();
                }
                System.out.println("New Amount: " +creditField.getText());
                //This will add the new credits gotten to the old one
                credits = credits + newCredits;
                System.out.println("Credits: " +credits);
                //This will change the credits in the credits label to show the new one
                creditsField.setText("Total Credits: "+credits);
                //This will close the addWindow window
                addWindow.dispose();
            }
        });
        JButton cancelButton = new JButton("Cancel");
        buttonsField.add(saveButton);
        //Adding actions to the cancel button
        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //This will close the addWindow window
                addWindow.dispose();
            }
        });
        buttonsField.add(cancelButton);

        addWindow.add(buttonsField, BorderLayout.PAGE_END);

        addWindow.setResizable(false);
        addWindow.setLocationRelativeTo(null);
        addWindow.setVisible(true);
    }
    
    public class adjustListener implements ActionListener{
        @Override
        @SuppressWarnings("Convert2Lambda")
        public void actionPerformed(ActionEvent E)
        {
            JFrame adjustWindow = new JFrame("Adjust Odds");
            adjustWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            adjustWindow.setLayout(new BorderLayout());

            JPanel slots = new JPanel(new GridLayout(0,4));
            slots.setBorder(BorderFactory.createEmptyBorder(0,20,10,10));
            for(int i= 0; i<oddsSpace.length; i++)
            {
                oddsSpace[i] = new JTextField();
            }
            slots.add(new JLabel(""));
            slots.add(new JLabel("Slot 1"));
            slots.add(new JLabel("Slot 2"));
            slots.add(new JLabel("Slot 3"));
            slots.add(new JLabel("Cherry"));
            slots.add(oddsSpace[0]);
            slots.add(oddsSpace[1]);
            slots.add(oddsSpace[2]);
            slots.add(new JLabel("Bell"));
            slots.add(oddsSpace[3]);
            slots.add(oddsSpace[4]);
            slots.add(oddsSpace[5]);
            slots.add(new JLabel("Seven"));
            slots.add(oddsSpace[6]);
            slots.add(oddsSpace[7]);
            slots.add(oddsSpace[8]);
            slots.add(new JLabel("BAR"));
            slots.add(oddsSpace[9]);
            slots.add(oddsSpace[10]);
            slots.add(oddsSpace[11]);
            slots.add(new JLabel("Gold Nugget"));
            slots.add(oddsSpace[12]);
            slots.add(oddsSpace[13]);
            slots.add(oddsSpace[14]);
            adjustWindow.add(slots, BorderLayout.CENTER);
            JPanel buttons = new JPanel(new FlowLayout());
            JButton save = new JButton("Save");
            save.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                        slot1Sum = Integer.parseInt(oddsSpace[0].getText()) + Integer.parseInt(oddsSpace[3].getText()) + Integer.parseInt(oddsSpace[6].getText()) + Integer.parseInt(oddsSpace[9].getText()) + Integer.parseInt(oddsSpace[12].getText());
                        slot2Sum = Integer.parseInt(oddsSpace[1].getText()) + Integer.parseInt(oddsSpace[4].getText()) + Integer.parseInt(oddsSpace[7].getText()) + Integer.parseInt(oddsSpace[10].getText()) + Integer.parseInt(oddsSpace[13].getText());
                        slot3Sum = Integer.parseInt(oddsSpace[2].getText()) + Integer.parseInt(oddsSpace[5].getText()) + Integer.parseInt(oddsSpace[8].getText()) + Integer.parseInt(oddsSpace[11].getText()) + Integer.parseInt(oddsSpace[14].getText());
                        System.out.println("Slot 1 Sum: " +slot1Sum);
                        System.out.println("Slot 2 Sum: " +slot2Sum);
                        System.out.println("Slot 3 Sum: " +slot3Sum);
                        System.out.println("Cherry: " +oddsSpace[0].getText());
                        System.out.println("Bell: " +oddsSpace[1].getText());
                    }
                    catch (NumberFormatException E) 
                    {
                        adjustWindow.dispose();
                    }
                    try
                    {
                        addOdds();
                        adjustWindow.dispose();
                    }
                    catch(OddsNot100Exception E)
                    {
                        E.getMessage();
                    }
                }
            });
            JButton cancel = new JButton("Cancel");
            buttons.add(save);
            cancel.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    adjustWindow.dispose();
                }
            });
            buttons.add(cancel);
            adjustWindow.add(buttons, BorderLayout.AFTER_LAST_LINE);
            adjustWindow.pack();
            adjustWindow.setResizable(false);
            adjustWindow.setLocationRelativeTo(null);
            adjustWindow.setVisible(true);
        }
    }
    public class exitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent E)
        {
            //This will exit the program once the user clicks on the menu item Exit
            System.exit(0);
        }
    }
    public class aboutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent E)
        {
            JFrame aboutWindow = new JFrame("About");
            //aboutWindow.setSize(500,400);
            aboutWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            aboutWindow.setLayout(new BorderLayout());

            JPanel namePanel = new JPanel(new GridBagLayout());
            namePanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(2,2,2,2);
            gbc.gridx = 0;
            gbc.gridy = 0;
            namePanel.add(new JLabel("Harriet Odiete"), gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            namePanel.add(new JLabel("0841080"), gbc);
            aboutWindow.add(namePanel, BorderLayout.NORTH);

            JPanel description = new JPanel(new GridBagLayout());
            description.setBorder(BorderFactory.createEmptyBorder(0,20,10,10));
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.insets = new Insets(0,0,0,0);
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 0;
            description.add(new JLabel("Symbol"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            description.add(new JLabel("Payout"), gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            description.add(new JLabel("Cherry"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            description.add(new JLabel("3 Credits"), gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            description.add(new JLabel("Bell"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 2;
            description.add(new JLabel("6 Credits"), gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            description.add(new JLabel("Seven"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 3;
            description.add(new JLabel("25 Credits"), gbc);
            gbc.gridx = 0;
            gbc.gridy = 4;
            description.add(new JLabel("BAR"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 4;
            description.add(new JLabel("100 Credits"), gbc);
            gbc.gridx = 0;
            gbc.gridy = 5;
            description.add(new JLabel("Gold Nugget"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 5;
            description.add(new JLabel("1000 Credits"), gbc);
            aboutWindow.add(description, BorderLayout.CENTER);
            aboutWindow.pack();
            aboutWindow.setResizable(false);
            aboutWindow.setLocationRelativeTo(null);
            aboutWindow.setVisible(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       Lab5 slot = new Lab5();
       slot.setVisible(true);
    }
}
