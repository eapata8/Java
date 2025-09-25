/**********************Q1-Devoir2 ITI1521....*/
/**
 * TestOperation
 */
public class TestOperation {
    
    private static Operation[] questions;  // questions pour le test

    private static int[] reponses;   // r�ponses de l'utilisateur aux questions
    
      
    /**
     * Cr�e le tableau questions de 10 elements
     */
    private static void creezTest() {
    questions = new Operation[10]; //initialisation d'un tableau question de taille 10
    for (int i=0; i<10; i++){// boucle qui ajoute 10 objets de la classe Op�ration dans le tableau questions
        Operation tmp = new Operation();
        questions[i] = tmp;
    }

    }//end of creezTest()
    
    
    /**
     * Affiche toutes les questions du test 
     * et obtient les r�ponses de l'utilisateur.
     * Compare la r�ponse de l��l�ve � la bonne r�ponse 
     * (si elles sont diff�rentes, affiche la bonne r�ponse); 
     * les bonnes r�ponses sont compt�es et affich�es � la fin.
     * Les r�ponses sont stock�es dans un tableau, 
     * qui est cr�� dans ce sous-programme.
     *
     * et calcule et affiche une note pour le test. 
     */
    private static void effectuezTest() {
         int counter = 0;// initialisation du compteur de r�ponses justes
         reponses = new int [10];//initialisation d'un tableau reponses de taille 10
          for(int i=0; i<10 ;i++){ // traverse chaque �l�ment du tableau questions
            if ((questions[i]).getRand() == 0){ // v�rifie si c'est une addition
            System.out.print("Question "+(i+1)+":  "+ questions[i].getQuestion0());// imprime la question 
            int rep = ReadInt.getInt(" ");// recueille la r�ponse de l'utilisateur//
            reponses[i]= rep;
            if(reponses[i] == questions[i].getAddition()){// v�rifie si la r�ponse de l'utilisateur est juste
            counter++;// incr�mente le compteur de r�ponses justes//
            }
            else{
                System.out.println("INCORRECT. La r�ponse est "+ questions[i].getAddition()); //corrige les r�ponses fausses
            }
         }
            if ((questions[i]).getRand() ==1){// v�rifie si c'est une multiplication et suit les m�mes �tapes qu'en haut
            System.out.print("Question "+(i+1)+":  "+ questions[i].getQuestion1());
            int rep = ReadInt.getInt(" ");
            reponses[i]= rep;
            if(reponses[i] == questions[i].getProduct()){
            counter++;
            }
            else{
                System.out.println("INCORRECT. La r�ponse est "+ questions[i].getProduct());
            } 

         }
      }
     System.out.println(" ");
     System.out.println("Vous avez "+counter+" r�ponses correctes");//Imprime le nombre de r�ponses justes
     System.out.println("Votre note pour ce test est "+ (counter*100/10) + " %");// Imprime la note en pourcentage du test
         
    }//end of effectuezTest()
    
   
    /*
     * Programme principal main
     */ 
    public static void main(String[] args) {
        System.out.println();
        System.out.println("SVP r�pondre aux 10 questions d'operations arithmetiques suivantes :");
        System.out.println();
        creezTest();
        effectuezTest();
   }//end of main()
    

} // end class OperationTest 
