public class Test {
 
   static Stack<Integer> trier (Stack<Integer> p1) {
/*Prend en paramètre une pile p1 et retourne une pile p2 contenant les nombres triés de p1 avec le minimum au sommet de la pile p2.
Permet le tri par insertion d’un ensemble de nombres entiers.*/
      Stack<Integer> p3 = new ArrayStack<Integer>( 10 );
      Stack<Integer> p2 = new ArrayStack<Integer>( 10 );
      Integer tmp;
     while (p1.isEmpty()== false) {
        if ((p2.isEmpty()==true)||(p1.peek()<p2.peek())) {
            tmp = p1.pop();
            p2.push(tmp);
            while(p3.isEmpty()==false){
            p2.push(p3.pop()); 
        }
        }
        else{p3.push(p2.pop());
        }
     }
     return p2;
}

    public static void main( String[] args ) {

        int[] tab = {4,3,2,5,8,0,2,6,9,3};
        Stack<Integer> pile;
        pile = new ArrayStack<Integer>( 10 );

        
         Stack<Integer> pileTrie;
         pileTrie = new ArrayStack<Integer>( 10 );

       /*Empiler la pile avec les elements de tab et afficher ses elements*/
        for (int i = 0; i < tab.length; i++) {
                pile.push(tab[i]);
        }

       System.out.println( "Les elements de ma pile sont au depart : "  );
       while ( ! pile.isEmpty() ) {
            System.out.println(  pile.pop() );
        }
        
        
       /*Empiler la pile a nouveau avec tab et afficher ses elements tries*/
       for (int i = 0; i < tab.length; i++) {
                pile.push(tab[i]);
        }
        pileTrie=trier(pile);
        
        System.out.println();
        System.out.println( "Les elements de ma pile triee sont : "  );
        while ( !pileTrie.isEmpty() ) {
            System.out.println( pileTrie.pop() );
        }

    }

}