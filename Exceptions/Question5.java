/*Question5-LAB8:ITI1521*/
import java.io.*;
public class Question5{
public static void main(String [] args){
try
{
int[]a = new int[-5];
}
catch(NegativeArraySizeException a){
System.out.println("generated exception" + a);
}
System.out.println(" After the try block");
}
}
