

class Point implements Comparable <Point>
{ 
private int x, y ;

Point (int x, int y)
{ 
  this.x = x ; 
  this.y = y ;
}

public void display()
{ 
  System.out.println ( x + " " + y ) ;
}

public int compareTo (Point p)
/* prend en paramètre un objet p de type point et retourne 0 si les l’objet Point (this) et le paramètre p ont même distance à l’origine
- 1 si p a une distance plus petite que celle de l’objet (this)
- -1 sinon
*/ 
{ 
int distance1 = (this.x)*(this.x)+(this.y)*(this.y);
int distance2 = (p.x)*(p.x)+(p.y)*(p.y);
if((distance1-distance2)<0){
  return -1;
}

if ((distance1-distance2)>0){
  return 1;
}
else{
  return 0;
}
}
}
