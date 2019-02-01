/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4gui;

/**
 *
 * @author harrietodiete
 */
public class Card {
    enum Suit{SPADES, HEARTS, CLUBS, DIAMONDS};
    private Suit suit;
    private int rank;
    private boolean faceup;
    private Object image;
    private static Object backImage;
    
    Card(Suit suit, int rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
    
    int getRank()
    {
        return rank;
    }
    
    Suit getSuit()
    {
        return suit;
    }
    
    void setFaceup(boolean faceup)
    {
        this.faceup = faceup;
    }
    
    boolean getFaceup()
    {
        return faceup;
    }
    
    Object getImage()
    {
        return image;
    }
    
    void setImage(Object image)
    {
        this.image = image;
    }
    
    static void setBackImage(Object image)
    {
        backImage = image;
    }
    
    static Object getBackImage()
    {
        return backImage;
        
    }
    
    @Override
    public String toString()
    {
         return(suit.name()+rank);
    }
    
    public boolean equals(Card card)
    {
        return (suit != card.suit && rank == card.rank);  
    }
}
