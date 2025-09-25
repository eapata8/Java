
public class Max
{
public static <T extends Comparable<T> > T maxi (T[] tab){ 
/*détermine et retourne
le plus grand élément d’un tableau tab passé en paramètre*/
T max = tab[0];
for (int i = 0; i<tab.length; i++){
	if(tab[i].compareTo(tab[0])==1){
		max = tab[i];
	}

}
return max;
}
}


