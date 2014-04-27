/*
 *David Zima
 * created: 4/15/14 last updated: 4/15/14
 * CS 182 Lab Project 4 Link List Card Game
 */


/*****************************************************************
   Class Link, the base class for a link list of playing cards
   May be placed in a file named Link.java

******************************************************************/

package blackjack.models;

/**
 *
 * @author David
 */
public class Link {
    protected Link next;

    public Link getNext() { return next; }
    public void setNext(Link newnext) { next = newnext; }

}  // end class Link