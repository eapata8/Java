class Tab {
public static void trier( int [ ] tab ){
int i , j , min , tmp ; // déclaration de 4 variables de type entier (int).
for ( i = 0 ; i < tab.length - 1 ; i++) { //ligne 4
  min = i; // Ligne 5
  for ( j = i + 1 ; j < tab.length ; j++) {//ligne 6: boucle for imbriquée
    if ( tab[j] <tab[ min ]  ) {// ligne 7
      min =  j   ; // ligne 8
    }
  }

  tmp = tab[min] ;    // ligne 12
  tab[min] = tab[ i ] ;  // ligne 13
  tab [ i ] = tmp ;     // ligne 14
}
 }

public static int moyenne(int[] tab){
        int somme, moyenne;
        int i;
        
        somme = 0;        
        for (i = 0; i < tab.length; i++) {
            somme +=  tab[i];
        }
        
        moyenne = somme/tab.length;
        return moyenne;
}

public static int count(int[] tab, int val){
int i, counter;
counter=0;
for ( i = 0 ; i < tab.length - 1; i++){
	if (tab[i]<val){
	counter++;
	}
}

	return counter;
 }

public static void split(int[] tab,int[] petit, int val){ 
int i;
for ( i = 0 ; i < tab.length - 1 ; i++){
	if(tab[i] < val){
	 petit[i]=tab[i];
	}
}  
 }

public static void main (String args [ ] )
{

int tab1 [ ] = { 3,55,7, 1, 88, 9 , 4, -10 };
int i,moyenne, size;
int[] petitTab,tab2;
tab2 = new int[]{10,34,62,56,82,7,95};
trier(tab1 ) ;
trier(tab2 ) ;
moyenne=moyenne(tab2);
size = count(tab2, moyenne); 
petitTab = new int[size];

System.out.println ("Les éléments de tab1 et tab2 triés sont : " ) ;
for ( i =0; i<tab1.length ; i++) {
/*Impression du contenu de tab1 trié*/
  if ( i >0) {
  System.out.print ( " , " ) ;
 }
 System.out.print (tab1 [ i ] ) ;
 }
System.out.println ( ) ;
for ( i =0; i<tab2.length ; i++) {
/*Impression du contenu de tab2 trié*/
  if ( i >0) {
  System.out.print ( " , " ) ;
 }
 System.out.print (tab2 [ i ] ) ;
 }
System.out.println ( ) ;
System.out.print ("La valeur moyenne de tab2 est " + moyenne(tab2)) ;
System.out.println ( ) ;
moyenne=moyenne(tab2);
split(tab2,petitTab,moyenne);
 System.out.print("Les éléments de petitTab sont : ");           
        for(i=0; i<petitTab.length; i++) {
            if (i>0) {
                System.out.print(", ");
            }
            System.out.print(petitTab[i]);           
        }
System.out.println ( ) ;
 }

}
