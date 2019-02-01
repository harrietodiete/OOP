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
public class Player {
    public enum ROLE{HUMAN, COMPUTER};
    private ArrayList<Card> handCard = new ArrayList<Card>(52);
    private ArrayList<Card> playCards = new ArrayList<Card>(52) ;
    private String name;
    private int credit;
    private ROLE role;
    public Player(String name, ROLE role, int credit)
    {
        this.name = name;
        this.role = role;
        this.credit = credit;
    }
    public String getName()
    {
        return name;
    }
    public ROLE getRole()
    {
        return role;
    }
    public int getCredit()
    {
        return credit;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setRole(ROLE role)
    {
        this.role = role;
    }
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    public int getCount()
    {
        return handCard.size();
    }
    public Card getCard(int pos)
    {
        return handCard.get(pos);
    }
    public void receiveCard(Card card)
    {
        handCard.add(card);
    }
    public playCard(ArrayList<Card> cards)
    {
        
    }
    public void clearHand()
    {
        playCards.addAll(handCard);
    }
    public int getPlayedCardCount()
    {
        return playCards.size();
    }
    Card collectPlayedCard(int pos)
    {
       Card played = playCards.get(pos);
       playCards.remove(pos);
       return played;
    }
}
