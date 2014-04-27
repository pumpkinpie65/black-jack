/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.views;

import java.awt.BorderLayout;
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

    @Override
    public void paint(Graphics g) {
        setBackground(new Color(0x005000));
        setDeck(g);
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
    
}
