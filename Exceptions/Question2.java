/*Question 2-LAB8:ITI1521*/
import java.io.*;
public class Question2 {
public static void main( String [] args) {
int tab[] = { 10,24,31,60,100 };
System.out.println("enter a number as array index and find out its value");
try {
String line;
int pos;
BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
while (( line = input.readLine()) != null) {
if (line.equals("end"))
break;
else {
try {
int i = Integer.parseInt(line);
System.out.println("valid element and it is: "+tab[i]);
}
catch(ArrayIndexOutOfBoundsException a)
{
System.out.println("invalid elements");
System.out.println("generated exception : " + a);
}

catch(NumberFormatException n)
{
System.out.println("sorry no characters");
System.out.println("generated exception : " + n);
}
}
}
}
catch(IOException i){ }
}
}
