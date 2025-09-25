

public class Set {

    private static final String str = System.getProperty( "line.separator" );
        
    // Instance variable
    private Cashier[] set;

    // Constructor
    //Prend en entrée le nombre de caisses et crée un tableau de caissiers de taille nbr
    //Exeption si nbr est inférieur à 1
    public Set( int nbr ) {
        if (nbr<1) {
            throw new IllegalArgumentException(Integer.toString(nbr));
        }
        set = new Cashier[nbr];
        for (int i =0; i<nbr; i++){
          set [i]= new Cashier(); 
        }   
    }

    // Instance methods

    //Prend en entrée un client et l'ajoute à la file de la caisse avec la plus courte file 
    public void add (Client client) {
        Cashier min = (set[0]); 
        for (int i = 1; i< set.length ; i++){
            if ((set[i]).getQueueSize() < min.getQueueSize()){
             min = set[i] ;   
            }
        }
        min.add(client);   
   }

   //compte le nombre de clients servis 
    public void servedClients( int currentTime ) {
        for (int i = 0; i< set.length ; i++){
            set[i].servedClients(currentTime);   
        }
    }

    // Affiche les infos des différentes caisses
    public String toString() {

    StringBuffer out= new StringBuffer();

        for (int i = 0; i< set.length ; i++){
        out.append("LINE ");
        out.append(i);
        out.append(":");
        out.append( str );

        out.append(set[i].toString());
        out.append( str );
   
        }
        return out.toString();
    }
}
