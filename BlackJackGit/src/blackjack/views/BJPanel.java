/*
 * David Zima
 * created: 4/15/14 last updated: 4/29/14
 * CS 182 Lab Project 4 Link List Card Game
 */
package blackjack.views;

import blackjack.models.Card;
import blackjack.models.CardList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class BJPanel extends JPanel {

    CardList playerHand;
    CardList dealerHand;
    String message = "";
    boolean displayDealerHand;
    boolean displayDealerScore;
    boolean displayPlayerScore;
    int dealerScore = 0;
    int playerScore = 0;
    
    public BJPanel(CardList thePlayerHand, CardList theDealerHand)
    {
        playerHand = thePlayerHand;
        dealerHand = theDealerHand;
        message = "";
        displayDealerHand = false;
        displayDealerScore = false;
        displayPlayerScore = false;
    }
    
    @Override
    public void paint(Graphics g) {
        
        System.out.println("BJPanel.paint");
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        
        setBackground(new Color(0x005000));
        printDeck(g);
        paintDealerHand(g);
        paintPlayerHand(g);
        paintMessage(g);
        
        if (displayDealerScore)
        {
            paintDealerScore(g);
        }
        
        if (displayPlayerScore)
        {
            paintPlayerScore(g);
        }
        //super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
    }

    public void setPlayerHand(CardList hand)
    {
        playerHand = hand;
        playerScore = 0;
    }
    
    public void setDealerHand(CardList hand)
    {
        dealerHand = hand;
        dealerScore = 0;
    }
    
    public void setMessage(String newMessage) {
        message = newMessage;
    }
    
    public void setDisplayDealerHand(boolean shouldDisplayDealerHand) {
        displayDealerHand = shouldDisplayDealerHand;
    }
    
    public void setDisplayDealerScore(boolean shouldDisplayDealerScore) {
        displayDealerScore = shouldDisplayDealerScore;
    }
    
    public void setDisplayPlayerScore(boolean shouldDisplayPlayerScore) {
        displayPlayerScore = shouldDisplayPlayerScore;
    }
    
    public void setDealerScore(int newScore) {
        dealerScore = newScore;
    }
    
    public void setPlayerScore(int newScore) {
        playerScore = newScore;
    }
    
    private Graphics printDeck(Graphics g) {

        int xPos = 20;
        int yPos = 20;

        ImageIcon imageIcon = new ImageIcon("src/blackjack/images/gbCard52.gif");

        System.out.println("back of card:" + imageIcon.toString());

        Image backOfCardImage = imageIcon.getImage();
        g.drawImage(backOfCardImage, xPos, yPos, this);

        return g;
    }

    private Graphics paintDealerHand(Graphics g) {
        
        int xPos = 300;
        int yPos = 120;
        
        if (!displayDealerHand)
        {
            ImageIcon imageIcon = new ImageIcon("src/blackjack/images/gbCard52.gif");
            Image backOfCardImage = imageIcon.getImage();

            g.drawImage(backOfCardImage, xPos, yPos, this);

            xPos += 80;

            g.drawImage(dealerHand.getFirstCard().getNextCard().getCardImage(), xPos, yPos, this);
        }
        else
        {
            Card current = dealerHand.getFirstCard();
            
            while (current != null)
            {
                g.drawImage(current.getCardImage(), xPos, yPos, this);

                xPos += 80;

                current = current.getNextCard();
            }
        }
        
        
        return g;
    }
    
    private Graphics paintPlayerHand(Graphics g) {
        int xPos = 300;
        int yPos = 360;
        
        Card current = playerHand.getFirstCard();
        
        while (current != null)
        {
            g.drawImage(current.getCardImage(), xPos, yPos, this);
            
            xPos += 80;
            
            current = current.getNextCard();
        }
        
        return g;
    }
    
    private Graphics paintMessage(Graphics g) {
        
        g.drawString(message, 300, 350);
        
        return g;
    }
    
    private Graphics paintDealerScore(Graphics g) {
        
        g.drawString("Dealer Score: " + dealerScore, 600, 60);
        
        return g;
    }
    
    private Graphics paintPlayerScore(Graphics g) {
        
        g.drawString("Player Score: " + playerScore, 600, 80);
        
        return g;
    }
    
    /*public void paintComponent(Graphics g, CardList deck) {

        System.out.println("BJPanel.paintComponent");

        int xpos = 25, ypos = 5;
        if (deck == null) {
            return;
        }
        Card current = deck.getFirstCard();
        while (current != null) {
            Image tempimage = current.getCardImage();
            
            //System.out.println("Drawing at " + xpos + ", " + ypos);
            
            g.drawImage(tempimage, xpos, ypos, this);
            // note: tempimage member variable must be set BEFORE paint is called
            xpos += 80;
            if (xpos > 700) {
                xpos = 25;
                ypos += 105;
            }
            current = current.getNextCard();
        } //while
    }*/
}
