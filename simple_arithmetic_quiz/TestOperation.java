/**********************Q1-Devoir2 ITI1521....*/
/**
 * TestOperation
 */
public class TestOperation {
    
    private static Operation[] questions;  // questions pour le test

    private static int[] reponses;   // réponses de l'utilisateur aux questions
    
      
    /**
     * Crée le tableau questions de 10 elements
     */
    private static void creezTest() {
    questions = new Operation[10]; //initialisation d'un tableau question de taille 10
    for (int i=0; i<10; i++){// boucle qui ajoute 10 objets de la classe Opération dans le tableau questions
        Operation tmp = new Operation();
        questions[i] = tmp;
    }

    }//end of creezTest()
    
    
    /**
     * Affiche toutes les questions du test 
     * et obtient les réponses de l'utilisateur.
     * Compare la réponse de l’élève à la bonne réponse 
     * (si elles sont différentes, affiche la bonne réponse); 
     * les bonnes réponses sont comptées et affichées à la fin.
     * Les réponses sont stockées dans un tableau, 
     * qui est créé dans ce sous-programme.
     *
     * et calcule et affiche une note pour le test. 
     */
    private static void effectuezTest() {
         int counter = 0;// initialisation du compteur de réponses justes
         reponses = new int [10];//initialisation d'un tableau reponses de taille 10
          for(int i=0; i<10 ;i++){ // traverse chaque élément du tableau questions
            if ((questions[i]).getRand() == 0){ // vérifie si c'est une addition
            System.out.print("Question "+(i+1)+":  "+ questions[i].getQuestion0());// imprime la question 
            int rep = ReadInt.getInt(" ");// recueille la réponse de l'utilisateur//
            reponses[i]= rep;
            if(reponses[i] == questions[i].getAddition()){// vérifie si la réponse de l'utilisateur est juste
            counter++;// incrémente le compteur de réponses justes//
            }
            else{
                System.out.println("INCORRECT. La réponse est "+ questions[i].getAddition()); //corrige les réponses fausses
            }
         }
            if ((questions[i]).getRand() ==1){// vérifie si c'est une multiplication et suit les mêmes étapes qu'en haut
            System.out.print("Question "+(i+1)+":  "+ questions[i].getQuestion1());
            int rep = ReadInt.getInt(" ");
            reponses[i]= rep;
            if(reponses[i] == questions[i].getProduct()){
            counter++;
            }
            else{
                System.out.println("INCORRECT. La réponse est "+ questions[i].getProduct());
            } 

         }
      }
     System.out.println(" ");
     System.out.println("Vous avez "+counter+" réponses correctes");//Imprime le nombre de réponses justes
     System.out.println("Votre note pour ce test est "+ (counter*100/10) + " %");// Imprime la note en pourcentage du test
         
    }//end of effectuezTest()
    
   
    /*
     * Programme principal main
     */ 
    public static void main(String[] args) {
        System.out.println();
        System.out.println("SVP répondre aux 10 questions d'operations arithmetiques suivantes :");
        System.out.println();
        creezTest();
        effectuezTest();
   }//end of main()
    

} // end class OperationTest 
