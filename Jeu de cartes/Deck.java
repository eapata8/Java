
/**
 *  Deck represents a deck of playing cards and contains 52 regular cards.
 */
public class Deck {

    private Card[] deck;  // an array of 52 cards.  
    private int number;  //the number of cards that have been dealt from the deck

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  
     */
    public Deck() {
        number = 0;
        int counter = 0;
        deck = new Card[52];
        for(int i=1; i<14; i++){
            for(int j=0 ;j<4; j++){
                Card tmp = new Card(i,j);
                deck[counter]= tmp;
                counter++;
            }
        }
    }


    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {

    // Vérifie s'il y a des cartes qui ont été prises du deck et réinitialise le deck ainsi que le nombre de cartes utilisées à 0
    if (number>0){ 
    number =0;
    int counter = 0;
    deck = new Card[52];
    for(int x=1; x<14; x++){
        for(int y=0 ;y<4; y++){
            Card tmp = new Card(x,y);
            deck[counter]= tmp;
            counter++;
        }
    }
}
    
    // Crée un tableau de 52 chiffres aléatroires compris entre 0 et 51
    int[] tab = new int[52];
    Card[] newDeck = new Card[52];
    int a = (int)(Math.random()*52);
    tab[0]=a;// initialise le premier élément
    for(int i =1; i<52; i++){ //continue le tableau pour les 51 autres éléments
        a = (int)(Math.random()*52);
        for(int j=1; j<tab.length; j++){
             while(a==tab[j]){// vérifie si le nombre random a déjà été engendré ou pas pour éviter les doublons et en génère un autre au cas échéant.
                a = (int)(Math.random()*52);
            }
            tab[i]=a;// incrémentation du tableau d'indices
        }
            }

    // remplis le nouveau tableau deck dans l'orde avec les éléments d'indice random générés dans tab 
    for(int k=0; k<52; k++){
        int c=tab[k];
        newDeck[k]= deck[c];
    }
    // remplace deck par le nouveau tableau obtenu
    deck = newDeck;

    }

    /** 
     * Returns the number of cards left in the deck.  
     */
    public int numberLeft() {
        int count = 0;
        for (int i=0;i<this.deck.length;i++){
            if (deck[i] != null){
                count += 1;
            } else{
                count = count;
            }
        }
        return count;
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the numberLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card take() {
        Card tmp;
        if (numberLeft()!=0){
            tmp = deck[numberLeft()-1];
            deck[numberLeft()-1] = null;
            number = number - 1;
        } else{
            throw new IllegalStateException();
        }
    return tmp;
    }
} // end class Deck
