/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.views;

import blackjack.models.Card;
import blackjack.models.CardList;
import java.awt.Color;
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
    
    public BJPanel(CardList thePlayerHand, CardList theDealerHand)
    {
        playerHand = thePlayerHand;
        dealerHand = theDealerHand;
    }
    
    @Override
    public void paint(Graphics g) {
        
        System.out.println("BJPanel.paint");
        
        setBackground(new Color(0x005000));
        setDeck(g);
        paintDealerHand(g);
        paintPlayerHand(g);
        //super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
    }

    private Graphics setDeck(Graphics g) {

        int xPos = 20;
        int yPos = 20;

        ImageIcon imageIcon = new ImageIcon("src/blackjack/images/gbCard52.gif");

        System.out.println("back of card:" + imageIcon.toString());

        Image backOfCardImage = imageIcon.getImage();
        g.drawImage(backOfCardImage, xPos, yPos, this);

        return g;
    }

    private Graphics paintDealerHand(Graphics g) {
        
        int xPos = 360;
        int yPos = 20;
        
        ImageIcon imageIcon = new ImageIcon("src/blackjack/images/gbCard52.gif");
        Image backOfCardImage = imageIcon.getImage();
        
        g.drawImage(backOfCardImage, xPos, yPos, this);
        
        xPos += 80;
        
        g.drawImage(dealerHand.getFirstCard().getNextCard().getCardImage(), xPos, yPos, this);
        
        return g;
    }
    
    private Graphics paintPlayerHand(Graphics g) {
        int xPos = 360;
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
