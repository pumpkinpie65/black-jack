/*
 * David Zima
 * created: 4/15/14 last updated: 4/26/14
 * CS 182 Lab Project 4 Link List Card Game
 */
/**
 * ***************************************************************
 * Class Card, the derived class each card is one object of type Card May be
 * placed in a file named Card.java
*****************************************************************
 */
package blackjack.models;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Card extends Link {

    final private Image cardimage;
    private String suit;
    private int rank;
    private String name;    //king, queen, 5, 7, ace, etc.

    public Card(int cardnum)
    {
        setSuit(cardnum);
        setRankAndName(cardnum);
        cardimage = loadCardFace(cardnum);
    }
    
    public Card(int cardnum, String newSuit, int newRank) {

        suit = newSuit;
        rank = newRank;

        cardimage = loadCardFace(cardnum);
    }

    final public void setSuit(int cardNum)
    {
        switch (cardNum)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                suit = "Clubs";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                suit = "Diamonds";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
                suit = "Hearts";
                break;
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                suit = "Spades";
                break;                
        }
    }
    
    final public void setRankAndName(int cardNum)
    {
        switch (cardNum)
        {
            case 0:
            case 13:
            case 26:
            case 39:
                rank = 1;
                name = "Ace";
                break;
            case 1:
            case 14:
            case 27:
            case 40:
                rank = 2;
                name = "2";
                break;
            case 2:
            case 15:
            case 28:
            case 41:
                rank = 3;
                name = "3";
                break;
            case 3:
            case 16:
            case 29:
            case 42:
                rank = 4;
                name = "4";
                break;
            case 4:
            case 17:
            case 30:
            case 43:
                rank = 5;
                name = "5";
                break;
            case 5:
            case 18:
            case 31:
            case 44:
                rank = 6;
                name = "6";
                break;
            case 6:
            case 19:
            case 32:
            case 45:
                rank = 7;
                name = "7";
                break;
            case 7:
            case 20:
            case 33:
            case 46:
                rank = 8;
                name = "8";
                break;
            case 8:
            case 21:
            case 34:
            case 47:
                rank = 9;
                name = "9";
                break;
            case 9:
            case 22:
            case 35:
            case 48:
                rank = 10;
                name = "10";
                break;
                
            //////////////
            //FACE CARDS//
            //////////////
                
            case 10:
            case 23:
            case 36:
            case 49:
                rank = 10;
                name = "Jack";
                break;
            case 11:
            case 24:
            case 37:
            case 50:
                rank = 10;
                name = "Queen";
                break;
            case 12:
            case 25:
            case 38:
            case 51:
                rank = 10;
                name = "King";
                break;                
        }
    }
    
    public Card getNextCard() {
        return (Card) next;
    }

    public Image getCardImage() {
        return cardimage;
    }
    
    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    
    public String getName() {
        return name;
    }
    
    private Image loadCardFace(int cardNum)
    {
        ImageIcon imageIcon = new ImageIcon("../images/gbCard" + cardNum + ".gif");
        Image image = imageIcon.getImage();
        
        if (image == null) {
            System.out.println("Error - image failed to load: ../images/gbCard" + cardNum + ".gif");
            System.exit(-1);
        }
        
        return image;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Name: ").append(getName());
        sb.append(" Suit: ").append(getSuit());
        sb.append(" Rank: ").append(getRank());
        sb.append(" Image: ").append(getCardImage().toString());
        
        return sb.toString();
    }
    
}  //end class Card
