/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author harrietodiete
 */
public class CardGame {
    private static final int    PANEL_PLAYEDCARDS = 0;
    private static final int    PANEL_HAND = 1;
    private static final int    PANEL_INFO = 2;
    
    private static final int    TRANSLATE_Y = 10;
    
    private static final int    CARD_WIDTH = CardLayout.DEFAULT_CMP_WIDTH;
    private static final int    CARD_HEIGHT = CardLayout.DEFAULT_CMP_HEIGHT;

    private static final int    TIMER_MIN = 5;
    private static final int    TIMER_MAX = 80;
    

    private static final String TEXT_SHUFFLE = "Shuffle";
    private static final String TEXT_DISTRIBUTE = "Distribute";
    private static final String TEXT_COLLECT = "Collect";
    private static final String TEXT_PLAY = "Play";
    
    private static final String TEXT_PROP_CARD = "CARD";
    private static final String TEXT_PROP_PLAYER = "PLAYER";
    private static final String TEXT_TITLE = "Card Game(General)";
    private static final String TEXT_PROP_INCONSIDERATION = "In Consider";

    private static Color COLOR_DEFAULT;
    private static Color COLOR_INVALID_CONSIDERATION = Color.ORANGE;
    
    private static Game[] games;
    private static Game currentGame;
    private static JPanel controlPanel;
    private static ArrayList<JLabel> guiCards;
    private static JPanel deckPanel;
    private static JPanel playersPanel;
    private static JPanel contentPanel;
    private static JFrame window;
    private static ArrayList<DelayedEvent>    delayedEvents;
    private static javax.swing.Timer displayTimer;    

    private static void fliCards(){
        for(JLabel guiCard:guiCards)
            flipCard(guiCard);
    }
    
    private static void flipCard(JLabel guiCard){
        Card card = (Card)guiCard.getClientProperty(TEXT_PROP_CARD);
        card.setFaceup(!card.getFaceup());                   
    }
    
    private static void hookupCardswithGUI(ArrayList<Card> cards, JPanel pnl){
        for(int i = 0; i< cards.size(); i++){
            Card card = cards.get(i);
            JLabel guiCard = (JLabel)pnl.getComponent(i);
            guiCard.putClientProperty(TEXT_PROP_CARD, card); 
            guiCard.setVisible(true);
            guiCard.setIcon(card.getFaceup()?(ImageIcon)card.getImage():(ImageIcon)Card.getBackImage());
            card.setGUIComponent(guiCard);
        }        
    }   
    private static void allFaceup(boolean faceup){
        for(JLabel guiCard:guiCards){
            Card card = (Card)guiCard.getClientProperty(TEXT_PROP_CARD);
            if (card.getFaceup() != faceup)  
                flipCard(guiCard);
        }
    }
    public  static class DelayedEvent{
        public int  eventCode;
        public ElementClass[] ecs;
        public DelayedEvent(int code, ElementClass[] ecs){
            eventCode = code;
            this.ecs = ecs;
        }
    }
    static ActionListener timerDelayedEvents = new ActionListener(){
        public void actionPerformed(ActionEvent actionEvent){
            if(delayedEvents.size()>0){
                DelayedEvent de = (DelayedEvent)delayedEvents.remove(0);
                ElementClass[] ecs = de.ecs;
                switch(de.eventCode){
                 case GameNotifier.PLAYEREVENT_RECEIVECARD:
                     guiAddCard((Card)ecs[0], getPlayerPanel((JPanel)ecs[1].getGUIComponent(),PANEL_HAND));
                     break;
                 case GameNotifier.DECKEVENT_ADDCARD:
                     guiAddCard((Card)ecs[0], (JPanel)ecs[1].getGUIComponent());
                     break;
                 case GameNotifier.PLAYEREVENT_PLAYCARD:
                     guiRemoveCard((Card)ecs[0], getPlayerPanel((JPanel)ecs[1].getGUIComponent(),PANEL_HAND));
                     break;
                 case GameNotifier.PLAYEREVENT_CARDPLAYED:
                     guiAddCard((Card)ecs[0], getPlayerPanel((JPanel)ecs[1].getGUIComponent(),PANEL_PLAYEDCARDS));
                     break;
                 case GameNotifier.PLAYEREVENT_COLLECTCARD:
                     guiRemoveCard((Card)ecs[0], getPlayerPanel((JPanel)ecs[1].getGUIComponent(),PANEL_PLAYEDCARDS));
                     break;
                 case GameNotifier.GAMEEVENT_WIN:
                     JOptionPane.showMessageDialog(null, ((Player)ecs[0]).getName() + " Wins", "Card Game", JOptionPane.INFORMATION_MESSAGE); 
                     break;
                 case GameNotifier.GAMEEVENT_LOSE:    
                     JOptionPane.showMessageDialog(null, ((Player)ecs[0]).getName() + " Loses", "Card Game", JOptionPane.INFORMATION_MESSAGE);
                 case GameNotifier.DECKEVENT_DISTRIBUTECARD:
                     guiRemoveCard((Card)ecs[0], (JPanel)ecs[1].getGUIComponent());
                     break;  
                 case GameNotifier.PLAYEREVENT_INFOCHNGED:
                     getPlayerPanel((JPanel)ecs[0].getGUIComponent(), PANEL_INFO).updateUI();
                     break;
                 case GameNotifier.PLAYEREVENT_SCORECHNGED:
                     Graphics g = getPlayerPanel((JPanel)ecs[0].getGUIComponent(), PANEL_INFO).getGraphics();
                     if(g!=null){
                        g.clearRect(10, 40, 100, 20);
                        g.drawString("Score:  " + ((Player.Score)ecs[1]).score,10,60);                        
                     }
                     break;
                 case GameNotifier.GAMEEVENT_END:
                     JOptionPane.showMessageDialog(null, "Game Over", "Card Game", JOptionPane.INFORMATION_MESSAGE);
                     break;          
                 case GameNotifier.CARDEVENT_FLIPCARD:
                     Card card = (Card)ecs[0];
                     JLabel guiCard = (JLabel)card.getGUIComponent();
                     guiCard.setIcon((ImageIcon)(card.getFaceup()?card.getImage():Card.getBackImage()));  
                     break;
                }                 
            }
        }
    };

    private static void guiAddCard(Card c, JPanel panel){
       
        Component guiObj = (Component)c.getGUIComponent();
        panel.add(guiObj,0);
        guiObj.setVisible(true);
    }

    private static void guiRemoveCard(Card c, JPanel panel){
        Component guiObj = (Component)c.getGUIComponent();
        guiObj.setVisible(false);
        panel.remove(guiObj);
    }
    private static JPanel getPlayerPanel(JPanel PlayerPanel, int index){
        return (JPanel)PlayerPanel.getComponent(index);
    }

    private static ArrayList<Card> getCards(Deck deck){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i = 0; i<deck.getCardCount(); i++)
            cards.add(deck.getCard(i));
        return cards;
    }
    private static ArrayList<Card> getHandCards(Player player){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i = 0; i<player.getCardCount(); i++)
            cards.add(player.getCard(i));
        return cards;
        
    }
    private static ArrayList<Card> getPlayedCards(Player player){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i = 0; i<player.getPlayedCardCount(); i++)
            cards.add(player.getPlayedCard(i));
        return cards;
        
    }   
    //take cards into consideration or withdraw consideration
    private static void considerCard(JLabel cardLabel, boolean consideration){
        Point pt = cardLabel.getLocation();
        if(cardLabel.getClientProperty(TEXT_PROP_INCONSIDERATION) == null && consideration)
            pt.translate(0,-TRANSLATE_Y);
        else if(cardLabel.getClientProperty(TEXT_PROP_INCONSIDERATION) != null && !consideration)
            pt.translate(0,TRANSLATE_Y);
        
        cardLabel.setLocation(pt);
        cardLabel.putClientProperty(TEXT_PROP_INCONSIDERATION, consideration?TEXT_PROP_INCONSIDERATION:null);
    }
    private static void considerCards(boolean consider){
        for(int i = 0; i<currentGame.getPlayerCount(); i++){
            Player player = currentGame.getPlayer(i);
            JPanel pnl = (JPanel)player.getGUIComponent();
            considerCards(getPlayerPanel(pnl, PANEL_HAND), consider);
        }
    }
    private static void considerCards(JPanel pnl, boolean consider){
        for(Component c:pnl.getComponents())
            considerCard((JLabel)c,consider);     
    }
    private static void resetValidity(){
        for(Component c:playersPanel.getComponents()){
            JPanel playerPanel = (JPanel)c;
            JPanel handPanel = getPlayerPanel(playerPanel, PANEL_HAND);
            handPanel.setBackground(COLOR_DEFAULT);
        }
    }
    private static class PlayerInfoPanel extends JPanel {
        Player player;
        public PlayerInfoPanel(Player player) {
            this.player = player;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);                   
            // Draw Text
            g.drawString("Name: "+player.getName(),10,20);
            g.drawString("Role:    "+player.getRole().toString(),10,40);
            g.drawString("Score:  " + player.score(),10,60);
            g.drawString("Credit: " + player.getCredit(),10,80);            
        }  
    }
    public static ArrayList<Card> getCardsInConsider(JPanel handPanel){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i = 0; i<handPanel.getComponentCount(); i++){
            JLabel guiCard = (JLabel)handPanel.getComponent(i);
            if(guiCard.getClientProperty(TEXT_PROP_INCONSIDERATION) != null){
               cards.add((Card)guiCard.getClientProperty(TEXT_PROP_CARD));
            }
        }       
        return cards;
    }
    
    //mouse listerner on cards
    private static MouseListener cardListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {         
            JLabel guiCard = (JLabel)e.getSource();
            //flipCard(guiCard);
            if(guiCard.getParent()!=deckPanel){
                considerCard(guiCard, guiCard.getClientProperty(TEXT_PROP_INCONSIDERATION) == null);
                
                //validate the cards in consideraion
                JPanel handPanel = (JPanel)guiCard.getParent();
                boolean valid = currentGame.validate((Player)handPanel.getClientProperty(TEXT_PROP_PLAYER), getCardsInConsider(handPanel));
                handPanel.setBackground(valid?COLOR_DEFAULT:COLOR_INVALID_CONSIDERATION);
            }
            else
                flipCard(guiCard);
        }
    };
    private static MouseListener handListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {         
            JPanel handPanel = (JPanel)e.getSource();
            if(handPanel.getBackground().equals(COLOR_INVALID_CONSIDERATION))
                return;
            if(e.getClickCount() == 1) {//withdraw consideration
                ArrayList<Card> cards = new ArrayList<Card>();
                Player player = (Player)((JPanel)e.getSource()).getClientProperty(TEXT_PROP_PLAYER);
                for(int i = 0; i<handPanel.getComponentCount(); i++){
                    JLabel guiCard = (JLabel)handPanel.getComponent(i);
                    if(guiCard.getClientProperty(TEXT_PROP_INCONSIDERATION) != null){
                       cards.add((Card)guiCard.getClientProperty(TEXT_PROP_CARD));
                    }
                }
                considerCards(false);
                resetValidity();
                player.playCard(cards);                
            }
        }
    };
    private static class EventHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getActionCommand().equals(TEXT_DISTRIBUTE)){
             currentGame.distributeCards(0);
         }else if(e.getActionCommand().equals(TEXT_SHUFFLE)){
             currentGame.getDeck().shuffle();
         }else if(e.getActionCommand().equals(TEXT_COLLECT)){
             considerCards(false);
             currentGame.collectCards();
             resetValidity();
         }else if(e.getActionCommand().equals(TEXT_PLAY)){
             considerCards(false);
             currentGame.play();
         }
         
      }
    }
 
    private static class GameNotifierImp implements GameNotifier{
         @Override
         public void fireEvent(int code, ElementClass[] ecs){
            switch(code){
                 case DECKEVENT_ORDERCHANGED:
                     hookupCardswithGUI(getCards((Deck)ecs[0]), (JPanel)ecs[0].getGUIComponent());
                     break;
                 case PLAYEREVENT_ORDERCHANGED:
                     hookupCardswithGUI(getHandCards((Player)ecs[0]), getPlayerPanel((JPanel)ecs[0].getGUIComponent(), PANEL_INFO));
                     break;
                 default:
                     delayedEvents.add(new DelayedEvent(code, ecs));
                     
            } 
         }
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int NUM_PLAYERS = 4;
        try{
        //choose the number of players
        Object[] possibleValues = { "1", "2", "3", "4", "5", "6","7","8" };
        NUM_PLAYERS = Integer.parseInt((String)JOptionPane.showInputDialog(null, "The number of Players", "Input", 
                JOptionPane.DEFAULT_OPTION, null, possibleValues, possibleValues[NUM_PLAYERS-1]));
        }catch(Exception e){return;}
        

        //create delayed evnts Queue
        delayedEvents = new ArrayList<DelayedEvent>();
        
        //create and start a timer to process delayed events
        displayTimer = new javax.swing.Timer(TIMER_MAX/4, timerDelayedEvents);      
        
        /*replace the second one to your own game class*/
        String[] options = new String[]{"Game (General Class)", "Your Game (Derived)"};      
        games = new Game[]{new Game(NUM_PLAYERS), new Game(NUM_PLAYERS+1)};
        
        
        
        
        JComboBox cmbGames = new JComboBox(options);
        cmbGames.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        currentGame = games[combo.getSelectedIndex()];
                        hookupGUI();
                    }
                }            
        );        
        
        //hookup notifer for all game objects
        for(int i = 0; i< games.length; i++){
            //every game keeps its own notifier
            games[i].setNotifier(new GameNotifierImp());
            Deck deck = games[i].getDeck();
            //create the game notification object;      
            deck.setNotifier(games[i].getNotifier());
            
            //load images for cards for each of the game
            for(int j = 0; j<deck.getCardCount(); j++){
                Card card = deck.getCard(j);
                String strCard = card.toString();
                card.setImage(new ImageIcon("images/"+strCard+".png")); 
                card.setNotifier(games[i].getNotifier());
            }        
            for(int j=0; j<games[i].getPlayerCount();j++)
                games[i].getPlayer(j).setNotifier(games[i].getNotifier());
        }
        Card.setBackImage(new ImageIcon("images/b1fv.png"));
        
        cmbGames.setSelectedItem(0);
        currentGame = games[0];
       
        //create control buttons and control panel
        EventHandler listener = new EventHandler();        
        JLabel lblCard =new JLabel();
        JButton shuffleButton = new JButton(TEXT_SHUFFLE);
        shuffleButton.addActionListener(listener);        
        JButton distributeButton = new JButton(TEXT_DISTRIBUTE);
        distributeButton.addActionListener(listener);        
        JButton collectButton = new JButton(TEXT_COLLECT);
        collectButton.addActionListener(listener);        
        JButton startButton = new JButton(TEXT_PLAY);
        startButton.addActionListener(listener);        
        
        
        controlPanel = new JPanel(); 
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
 
        controlPanel.add(startButton, FlowLayout.LEFT);
        controlPanel.add(collectButton, FlowLayout.LEFT);
        controlPanel.add(distributeButton, FlowLayout.LEFT);
        controlPanel.add(shuffleButton, FlowLayout.LEFT);
        controlPanel.add(cmbGames, FlowLayout.LEFT);
        
        //create the deck panel  
        deckPanel = new JPanel();
        deckPanel.setLayout(new CardLayout());
        deckPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        //create GUI components for card object, in reverse order for proper gui rendering
        guiCards = new ArrayList<JLabel>();
        for (int i = currentGame.getDeck().getCardCount()-1; i>=0; i--){
            JLabel guiCard = new JLabel();
            Card card = currentGame.getDeck().getCard(i);
            guiCards.add(guiCard);            
            guiCard.addMouseListener(cardListener);
            guiCard.setPreferredSize(new Dimension(72,96)); //avoid excessive button border
        }
        
        //create panel for players
        playersPanel = new JPanel();
        playersPanel.setLayout(new GridLayout(1,0));
        playersPanel.setPreferredSize(new Dimension(1200, CARD_HEIGHT*4));        
        COLOR_DEFAULT = playersPanel.getBackground();
        
        //create the GUI panel that accomondates deckPanel, playerPanels and controlPanel
        contentPanel = new JPanel(); 
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(controlPanel,BorderLayout.NORTH);
        contentPanel.add(deckPanel,BorderLayout.CENTER);        
        contentPanel.add(playersPanel, BorderLayout.SOUTH);
        
        //create the main window
        window = new JFrame("CIS*2430Lab - " + TEXT_TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(contentPanel);
        window.setSize(1250,600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        
         hookupGUI();

    }

    private static void hookupGUI(){
        JPanel pnl;
        //stop timer and clear eventsQue
        displayTimer.stop();
        delayedEvents.clear();
        
        contentPanel.setVisible(false);
        //clean up deck cards by removing all card labels away first
        deckPanel.removeAll();

        //clean up individual player's cards
        for(int i = 0; i< playersPanel.getComponentCount(); i++){
            pnl = getPlayerPanel((JPanel)playersPanel.getComponent(i), PANEL_HAND);
            pnl.removeAll();
            pnl = getPlayerPanel((JPanel)playersPanel.getComponent(i), PANEL_PLAYEDCARDS);
            pnl.removeAll();         
        }      
        //clean up entire players' panel
        playersPanel.removeAll();
        
        //set up vertical grid layout for player' panel
        GridLayout playerLayout = new GridLayout(0,1);   
        //one CardLayout object shared by all players'card panels
        CardLayout handLayout = new CardLayout(CardLayout.ORIENTATION.ORIENTATION_HORIZONTAL,13);
        CardLayout playedCardLayout = new CardLayout(CardLayout.ORIENTATION.ORIENTATION_HORIZONTAL, 2);
                
        //now create individual player's panels;
        for(int i = 0; i< currentGame.getPlayerCount(); i++){
            //create each player's panel
            JPanel pnlPlayer = new JPanel();
            pnlPlayer.setLayout(playerLayout);
            pnlPlayer.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
            if(i%2==1)
                pnlPlayer.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            
            //hookup Player object
            Player player = currentGame.getPlayer(i);         
            pnlPlayer.putClientProperty(TEXT_PROP_PLAYER, player);
            player.setGUIComponent(pnlPlayer);
            
            //create 3 panels for each player, from top to bottom:1.played card panel, 2.hand panel, 3.player info panel
            for(int j = 0; j<2; j++)  
                pnlPlayer.add(new JPanel());
            pnlPlayer.add(new PlayerInfoPanel(player));
            
            //setup played cards panel
            pnl = getPlayerPanel(pnlPlayer, PANEL_PLAYEDCARDS);
            pnl.setLayout(playedCardLayout);
            
            //setup hand panel
            pnl = getPlayerPanel(pnlPlayer, PANEL_HAND);
            pnl.setLayout(handLayout);
            pnl.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            pnl.addMouseListener(handListener);
            pnl.putClientProperty(TEXT_PROP_PLAYER, player);
                        
            //setup info panel
            pnl = getPlayerPanel(pnlPlayer, PANEL_INFO);
            pnl.setLayout(null);

            playersPanel.add(pnlPlayer);
        }
                        
        //make a copy of the references for all gui cards
        ArrayList<JLabel> guicardsCopy = new ArrayList<JLabel>(guiCards);  
        
        //hookup deck with GUI
        currentGame.getDeck().setGUIComponent(deckPanel);
        while(deckPanel.getComponentCount()<currentGame.getDeck().getCardCount())
            deckPanel.add(guicardsCopy.remove(0));
        hookupCardswithGUI(getCards(currentGame.getDeck()), deckPanel);  
        
        //hookup players with gui
        for(int i = 0; i< playersPanel.getComponentCount(); i++){
            JPanel playerPanel = (JPanel)playersPanel.getComponent(i);
            Player player =  currentGame.getPlayer(i);
            
            player.setGUIComponent(playerPanel);
            playerPanel.putClientProperty(TEXT_PROP_PLAYER, player);
            
            //hand panel hookup
            pnl = getPlayerPanel((JPanel)playersPanel.getComponent(i), PANEL_HAND);
            pnl.putClientProperty(TEXT_PROP_PLAYER, player);
            while(pnl.getComponentCount() <currentGame.getPlayer(i).getCardCount())
                pnl.add(guicardsCopy.remove(0));
            hookupCardswithGUI(getHandCards(currentGame.getPlayer(i)), pnl);
            
            //played cards panel hookup
            pnl = getPlayerPanel((JPanel)playersPanel.getComponent(i), PANEL_PLAYEDCARDS);
            while(pnl.getComponentCount() < currentGame.getPlayer(i).getPlayedCardCount())
                pnl.add(guicardsCopy.remove(0));  
            hookupCardswithGUI(getPlayedCards(currentGame.getPlayer(i)), pnl);
        }     
        contentPanel.setVisible(true);
        displayTimer.start();
    }
 
    
}
