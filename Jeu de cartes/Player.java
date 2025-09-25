/**
 *The Player class should be able to represent the set of cards a player has in hand.
 * The player class must allow to take a card from the deck and put it in the hand, 
 * count the points of the cards in hand...
 **/
import java.util.ArrayList;

public class Player {
     private ArrayList<Card>  hand;   // The cards in the plyaer's hand.
 
     /*Constructor*/
    public Player(){
       hand = new ArrayList<Card>();
    }  
 
 /*Accessor*/
 public ArrayList<Card> getHand() {
    this.hand = hand;
    return hand;
    }
 
 /**
     * Remove all cards from the hand, leaving it empty.
  */
    public void clear() {
       hand.clear();
    }

    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     * @param card the non-null card to be added.
     * @throws NullPointerException if the parameter card is null.
     */
    public void add(Card card) {
        this.hand.add(card);
        if (card == null){
            throw new NullPointerException();
        }
    }

    /**
     * Remove a card from the hand, if present.
     * @param card the card to be removed.  If card is null or if the card is not in 
     * the hand, then nothing is done.
     */
    public void remove(Card card) {
        hand.remove(card);
        if (card == null || hand.contains(card) == false){
            hand = hand;
        }
    }

    /**
     * Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are numbered starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void remove(int position) {
        if (position < 0 || position >= hand.size()){
            hand.remove(position);
        }
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int totalCards() {
        int x = hand.size();
    return x;
    }

    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        Card card1 = this.hand.get(position);
        return card1;
    }

   /**
     * Computes and returns the total value of this hand in the game
     */
    public int getHandTotal () {
        int size = this.totalCards();
        boolean verif = false;
        int total = 0;
        for (int i = 0; i<size;i++){

            if (this.hand.get(i) != null && this.hand.get(i).getValue() <= 10 ){ // le total s'incrémente avec la valeur de la carte si elle est inférieure ou égale à 10
                total = total + this.hand.get(i).getValue(); 
            } 
            if (this.hand.get(i) != null && this.hand.get(i).getValue() > 10 ){ //le total s'incrémente avec 10 si la valeur est supérieure à 10
                total = total + 10;

            }
            if(this.hand.get(i) != null && this.hand.get(i).getValue() == 1){ // vérifie s'il y a un as
                verif = true;
            }
        }
        if (verif==true && (total+10)<= 21){ // s'il y a un as et que en passant de 1 à 11, le total est inférieur ou égal à 21 alors on lui ajoute 10 
            total+=10;
        }
        return total;

    }  
    
    /**
     * Sorts the cards in the hand so that cards of the same color are
     * grouped together, and within a color the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByColor() {
        int size = this.hand.size();
        for (int i = 0; i<size-1;i++){
            Card tmp = this.hand.get(i);
            if (tmp.getColor() > this.hand.get(i+1).getColor()){
                tmp = this.hand.get(i+1);
            } else{
                tmp = tmp;
            }
        }
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by color.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        int size = this.hand.size();
        for (int i = 0; i<size-1;i++){
            Card tmp = this.hand.get(i);
            if (tmp.getValue() > this.hand.get(i+1).getValue()){
                tmp = this.hand.get(i+1);
            } else{
                tmp = tmp;
            }
        }
    }
} 