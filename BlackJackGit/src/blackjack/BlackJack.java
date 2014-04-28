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
    private CardList playerHand = new CardList(0);
    private CardList dealerHand = new CardList(0);
    
    private int playerScore = 0;
    private int dealerScore = 0;

    public static void main(String[] args) {
        Window window = new Window(new BlackJack());
    }
    
    public void setPlayerScore(int newScore) {
        playerScore = newScore;
    }
    
    public void setDealerScore(int newScore) {
        dealerScore = newScore;
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
    
    public int getPlayerScore() {
        return playerScore;
    }
    
    public int getDealerScore() {
        return dealerScore;
    }
    
    public void startGame()
    {
        //printDeck(deck);
        newDeck();
        //printDeck(deck);
        shuffleDeck();
        printDeck(deck);
        
        dealCards();
        
        print("Player Hand: " + calculateScoreFromHand(playerHand));
        printDeck(playerHand);
        print("Dealer Hand: " + calculateScoreFromHand(dealerHand));
        printDeck(dealerHand);
        
    }
    
    public void newDeck()
    {
        deck = new CardList(52);
    }
    
    public void shuffleDeck()
    {
        deck.shuffle();
    }
    
    public void dealCards()
    {
        playerHand.insertCard(deck.deleteCard(0));
        dealerHand.insertCard(deck.deleteCard(0));
        playerHand.insertCard(deck.deleteCard(0));
        dealerHand.insertCard(deck.deleteCard(0));
    }
    
    public int calculateScoreFromHand(CardList hand)
    {
        //calculate the score from the cards
        int score = 0;
        int numberOfAces = 0;
        
        Card current = hand.getFirstCard();
        while (current != null)
        {
            int rank = current.getRank();
            if (rank == 11)
            {
                numberOfAces++;
            }
            score += rank;
            
            if (numberOfAces > 0 && score > 21)
            {
                score -= 10;    //if bust change Ace to 1
                numberOfAces--; //should I do this in case there's more than one?
            }
            
            
            current = current.getNextCard();
        }
        
        return score;
    }
    
    public void playerHit()
    {
        playerHand.insertCard(deck.deleteCard(0));
    }
    
    public void dealerHit()
    {
        dealerHand.insertCard(deck.deleteCard(0));
    }
    
    public void print(String message)
    {
        System.out.println(message);
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
