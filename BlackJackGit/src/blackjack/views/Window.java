/*
 * David Zima
 * created: 4/15/14 last updated: 4/29/14
 * CS 182 Lab Project 4 Link List Card Game
 *
 *
 */
package blackjack.views;

import blackjack.BlackJack;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Window extends JFrame implements ActionListener {

    private static int winxpos = 0, winypos = 0;      // place window here

    private JButton hitButton, exitButton, standButton, newGameButton;
    private JPanel southPanel;
    private BJPanel centerPanel;
    private static JFrame myFrame = null;
    
    private BlackJack blackJack;

    public Window()
    {
        init();
    }
    
    public Window(BlackJack newGameController)
    {
        blackJack = newGameController;
        blackJack.startGame();
        init();
        
        //centerPanel.paintComponent(centerPanel.getGraphics(), blackJack.getDeck());
        //centerPanel.paintComponent(new Graphics(), blackJack.getDeck());
    }

    private void init()
    {
        myFrame = this;                 // need a static variable reference to a JFrame object
        southPanel = new JPanel();
        southPanel.setBackground(Color.white);
        hitButton = new JButton("Hit");
        southPanel.add(hitButton);
        hitButton.addActionListener(this);
        standButton = new JButton("Stand");
        southPanel.add(standButton);
        standButton.addActionListener(this);
        newGameButton = new JButton("New Game");
        southPanel.add(newGameButton);
        newGameButton.addActionListener(this);
        exitButton = new JButton("Exit");
        southPanel.add(exitButton);
        exitButton.addActionListener(this);
        getContentPane().add("South", southPanel);

        centerPanel = new BJPanel(blackJack.getPlayerHand(), blackJack.getDealerHand());
        getContentPane().add("Center", centerPanel);

        //theDeck = new CardList(52);

        setSize(800, 700);
        setLocation(winxpos, winypos);

        setVisible(true);
    }
    
    ////////////              MAIN      ////////////////////////
    public static void main(String[] args) {
        Window window = new Window(new BlackJack());
        
    }

    ////////////   BUTTON CLICKS ///////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == newGameButton) {
            blackJack.startGame();
            centerPanel.setDealerHand(blackJack.getDealerHand());
            centerPanel.setPlayerHand(blackJack.getPlayerHand());
            centerPanel.setMessage("");
            centerPanel.setDisplayDealerHand(false);
            centerPanel.setDisplayScores(false);
            repaint();
        }
        if (e.getSource() == hitButton) {
            blackJack.playerHit();
            if (blackJack.playerBust())
            {
                centerPanel.setMessage(blackJack.getEndMessage());
                centerPanel.setDisplayScores(true);
            }
                
            repaint();
        }
        if (e.getSource() == standButton) {
            blackJack.playerStand();
            centerPanel.setMessage(blackJack.getEndMessage());
            centerPanel.setDealerScore(blackJack.getDealerScore());
            centerPanel.setPlayerScore(blackJack.getPlayerScore());
            centerPanel.setDisplayDealerHand(true);
            centerPanel.setDisplayScores(true);
            repaint();
        }
    }

}
