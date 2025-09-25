/**********************Q2-Devoir2 ITI1521....*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI extends JFrame implements ActionListener { 
	Calculator cal;
	JTextField input;

	public GUI(Calculator p){
		//creation d'un nouveau objet de type Calculator
		cal = new Calculator();
		//donner un titre au calculatrice
		setTitle("Calculator"); 
		//permettre de fermer la fenetre de la calculatrice
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//donner une grandeur a la calculatrice
		setSize(400,400);
		setVisible(true);
		//creation d'un paneau pour l'affichage des numeros
		JPanel paneau1 = new JPanel();
		paneau1.setBackground(Color.WHITE);
		//creation et implementation d'un text field pour la calculatrice
		input = new JTextField(25);
		add(paneau1, BorderLayout.NORTH);
		paneau1.add(input);
		
		//creation et implementation d'un paneau pour les boutons
		JPanel paneau2 = new JPanel();
		paneau2.setBackground(Color.RED);
		add(paneau2, BorderLayout.CENTER);
		paneau2.setLayout (new GridLayout ( 4, 4) );
		//creation des boutons pour les chiffres et les operations
		JButton zero = new JButton("0");
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton clear = new JButton("C");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton equal = new JButton("=");
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton multi = new JButton("*");
		JButton div = new JButton("/");
		JButton fac = new JButton("!");
		JButton pow = new JButton("POW");
		JButton sqrt = new JButton("sqrt");
		JButton log = new JButton("ln");
		//addition des boutons au paneau
		paneau2.add(zero);
		zero.addActionListener(this);
		paneau2.add(one);
		one.addActionListener(this);
		paneau2.add(two);
		two.addActionListener(this);
		paneau2.add(three);
		three.addActionListener(this);
		paneau2.add(clear);
		clear.addActionListener(this);
		paneau2.add(four);
		four.addActionListener(this);
		paneau2.add(five);
		five.addActionListener(this);
		paneau2.add(six);
		six.addActionListener(this);
		paneau2.add(seven);
		seven.addActionListener(this);
		paneau2.add(fac);
		fac.addActionListener(this);
		paneau2.add(eight);
		eight.addActionListener(this);
		paneau2.add(nine);
		nine.addActionListener(this);
		paneau2.add(plus);
		plus.addActionListener(this);
		paneau2.add(minus);
		minus.addActionListener(this);
		paneau2.add(multi);
		multi.addActionListener(this);
		paneau2.add(pow);
		pow.addActionListener(this);
		paneau2.add(sqrt);
		sqrt.addActionListener(this);
		paneau2.add(log);
		log.addActionListener(this);
		paneau2.add(equal);
		equal.addActionListener(this);
		paneau2.add(div);
		div.addActionListener(this);

	}



	public void actionPerformed(ActionEvent e) {
	   String str = e.getActionCommand();
	   //appel l'operation demander par l'utilisateur  
	   if (str == "+") { cal.add(); input.setText("0.0");}
	   if (str == "-") { cal.subtract(); input.setText("0.0");}
	   if (str == "*") { cal.multiply(); input.setText("0.0");}
	   if (str == "/") { cal.divide(); input.setText("0.0");}
	   if (str == "!") { cal.factorial();}
	   if (str == "POW") {cal.pow();input.setText("0.0");}
	   if (str == "sqrt") {cal.rootSquare();}
	   if (str == "ln"){cal.nepLog();}
	   //demande les operandes de l'utilisateur 
	   if(str.equals("0")||str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")||str.equals("5")||str.equals("6")||str.equals("7")||str.equals("8")||str.equals("9")){
	   	if (input.getText().equals("0.0")){
	   		input.setText("");
	   		input.setText(input.getText()+e.getActionCommand());
	   		cal.setSecond(Double.parseDouble(input.getText()));
	   		
	   	} else {
	   		input.setText(input.getText()+e.getActionCommand());
	   		cal.setSecond(Double.parseDouble(input.getText()));
	   	}
	   }
	   //evaluation de l'operation
	   if (str == "=") {cal.compute();input.setText(Double.toString(cal.display()));}
	   //remise a zero 
	   if (str=="C") {cal.clear();input.setText("0.0");}
 	}
	public static void main(String arg[]) {
	  GUI gui;
	  gui = new GUI(new Calculator());
	  gui.setVisible(true);
	}
}