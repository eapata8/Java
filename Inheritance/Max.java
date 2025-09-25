
public class Max
{
public static <T extends Comparable<T> > T maxi (T[] tab){ 
/*détermine et retourne
le plus grand élément d’un tableau tab passé en paramètre*/
T max = tab[0];
    for (T tab1 : tab) {
        if (tab1.compareTo(tab[0]) == 1) {
            max = tab1;
        }
    }
return max;
}
}


