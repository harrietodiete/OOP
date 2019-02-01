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
public class Deck {
    private ArrayList<Card> cards;
    
    Deck()
    {
        //Creates an arrayList consisting of 52 cards
        cards = new ArrayList<Card>(52);
        for(Card.Suit suit : Card.Suit.values())
        {
           for(int i= 1; i<14; i++)
           {
               //Adds the deck of card to the arrayList of cards
               cards.add(new Card(suit, i));
           }
        }
    }
    
    /*public ArrayList<Card>getCards()
    {*/
        //Returns the entire deck of cards
       /*return this.cards; 
    }*/
    public int getCardCount()
    {
        return cards.size();
    }
    public Card getCard(int pos)
    {
        return cards.get(pos);
    }
    public void addCard(Card card)
    {
        cards.add(card);
    }
    public Card removeCard(int pos)
    {
        return cards.remove(pos);
    }
    public void shuffle()
    {
        //Collections.shuffle(cards);
        Card newCard;
        Random randomNumber = new Random();
        
        for(int i= 0; i< cards.size(); i++)
        {
            int temp = randomNumber.nextInt(i+1);
            //swaps card at position i with randomly selected card
            newCard = cards.get(i); //newCard variable stores the card at i
            cards.set(i, cards.get(temp)); //This sets the card's position at i to the card at the random selected position
            cards.set(temp, newCard); //This sets the newCard variable to the random position*/
        }
    }
}
