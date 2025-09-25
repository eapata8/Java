/**********************Q2-Devoir2 ITI1521*********/
import java.lang.Math.*;

public class Calculator {
private double first, second; // two calculator operands
private String oP; //variable qui indique l'operateur

public Calculator() {}; //constructeur sans paramettre

public void setSecond(double second){ //setter pour la variable second
	this.second = second;
}

public void operation(String str) {
first = second; // keep first operand
second = 0; // initialize and get ready for second operand
oP = str; 
}

public void add() { operation("+"); } // addition

public void subtract() { operation("-"); } // subtraction 

public void multiply() { operation("*"); } // multiplication

public void divide() { operation("/"); } //division

public void factorial() { operation("!"); } //factorial

public void pow() { operation("POW"); } //power

public void rootSquare() { operation("sqrt"); } //square

public void nepLog() { operation("ln"); } //logarithme


public void compute() {
  //calcul de la valeur "second" dependant de l'operateur choisi
  if (oP == "+"){
   second = first + second;
	} else if (oP == "-"){
		second = first - second;
	} else if (oP == "*"){
		second = first*second;
	} else if (oP == "/"){
		second = first/second;
	} else if (oP == "!"){
		second = Math.sqrt(2*Math.PI*first)*Math.pow((first/2.718),first)*(1+1/(12*first));
	} else if (oP == "POW"){
		second = Math.pow(first,second);
	} else if (oP == "sqrt"){
		second = Math.sqrt(first);
	} else if (oP == "ln"){
		second = Math.log(first);
	}
 
} 
 
//remett la valeur a 0
public void clear() {
	second = 0;
}

//retour de la valeur second
public double display() {
	return second;
}
}





