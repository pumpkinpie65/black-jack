/*
 * David Zima
 * created: 4/15/14 last updated: 4/15/14
 * CS 182 Lab Project 4 Link List Card Game
 */
package blackjack;

import blackjack.models.Card;
import blackjack.models.CardList;
import blackjack.views.Window;

/**
 *
 * @author David
 */
public class BlackJack {
    
    private CardList deck;
    private CardList playerHand;
    private CardList dealerHand;
    

    public static void main(String[] args) {
        Window window = new Window(new BlackJack());
    }
    
    public CardList getDeck() {
        return deck;
    }
    
    public CardList getPlayerHand() {
        return playerHand;
    }
    
    public CardList getDealerHand() {
        return dealerHand;
    }
    
    public void startGame()
    {
        printDeck(deck);
        newDeck();
        printDeck(deck);
        shuffleDeck();
        printDeck(deck);
    }
    
    public void newDeck()
    {
        deck = new CardList(52);
    }
    
    public void shuffleDeck()
    {
        deck.shuffle();
    }
    
    public static void printDeck(CardList deckToPrint)
    {
        if (deckToPrint != null)
        {
            Card currentCard = deckToPrint.getFirstCard();
            while(currentCard != null)
            {
                System.out.println("" + currentCard.toString());
                currentCard = currentCard.getNextCard();
            }
        }
        else
        {
            System.out.println("printDeck's deckToPrint is null");
        }
    }
}
