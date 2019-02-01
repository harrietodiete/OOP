/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4gui;

import java.util.*;

/**
 *
 * @author harrietodiete
 */
public class Game {
    
    private ArrayList<Player> numPlayers;
    Deck cardDeck;
    public Game(int numPlayers)
    {
        cardDeck = new Deck();
        this.numPlayers = new ArrayList<Player>(numPlayers);
    }
    public Deck getDeck()
    {
        return cardDeck;
    }
    public int getPlayerCount()
    {
        return numPlayers.size();
    }
    public Player getPlayer(int pos)
    {
        return numPlayers.get(pos);
    }
    public void distributeCards(int rounds)
    {
        
    }
    public void collectCards()
    {
        
    }
    public void play()
    {
        
    }
}
