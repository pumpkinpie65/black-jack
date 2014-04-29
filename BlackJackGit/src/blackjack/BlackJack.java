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
        emptyHands();
        //printDeck(deck);
        shuffleDeck();
        printDeck(deck);
        
        dealCards();
        
        setPlayerScore(calculateScoreFromHand(playerHand));
        setDealerScore(calculateScoreFromHand(dealerHand));
        
        print("Player Hand: " + playerScore);
        printDeck(playerHand);
        print("Dealer Hand: " + dealerScore);
        printDeck(dealerHand);
        
    }
    
    public void newDeck()
    {
        deck = new CardList(52);
    }
    
    public void emptyHands()
    {
        playerHand = new CardList(0);
        dealerHand = new CardList(0);
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
        playerScore = calculateScoreFromHand(playerHand);
    }
    
    public void dealerHit()
    {
        dealerHand.insertCard(deck.deleteCard(0));
        dealerScore = calculateScoreFromHand(dealerHand);
    }
    
    public boolean dealerShouldHit()
    {
        if (dealerScore < 17)
        {
            return true;
        }
        else
            return false;
    }
    
    public void playerStand()
    {
        while (dealerShouldHit())
        {
            dealerHit();
        }
    }
    
    public String getEndMessage()
    {
        String endMessage = "Game Over";
        
        if (playerScore > dealerScore)
        {
            endMessage = "You win!";
        }
        else if (playerScore == dealerScore)
        {
            endMessage = "You push.";
        }
        else
        {
            endMessage = "You lose all your money!";
        }
        return endMessage;
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
