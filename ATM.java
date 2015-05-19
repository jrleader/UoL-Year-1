//Program created by X M LI
//Student No: 201058231
//The code below constructs a GUI and 
//the GUI simulates the behavior of an ATM machine.
import java.awt.*;

import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ATM extends JFrame{
//create elements in the GUI and variables needed for realizing the functionality
/*of the ATM
*/
	private JButton[] numkey = new JButton[10];
	private JButton clear;
	private JButton enter;
	private JButton[] cashoptionskey = new JButton[4];
	private JButton deposit;
	private JButton exit;
	private JTextField inputdisp = new JTextField(10);
	private JTextArea instdisp = new JTextArea(2,10);
	private String input = "";
	private final String defaultPIN = "1234";
	private int currentBal = 10;
	//----------Constructor----------
	ATM() {
		super("Cash machine");
	//----------create number keys----------
		for(int i = 0; i < numkey.length; i++){
			String keyval = "" + (i+1);
			numkey[i] = new JButton(keyval);
			if(i == numkey.length - 1)
				numkey[i] = new JButton("" + 0);
			final int j = i + 1;
			//define the action which will be performed after the
			//-----------------key is pressed-----------------
			numkey[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					input += e.getActionCommand();
					inputdisp.setText(inputdisp.getText() + e.getActionCommand());
				}
			});	
			}
		//create keys which are used to withdraw a certain amount of cash
		for(int i = 0; i < cashoptionskey.length; i++) {
			final int j = i + 1;
			String keyval = "" + ((int)5 * Math.pow(2,i));
			cashoptionskey[i] = new JButton(keyval);
			//define the action which will be performed after the
			//-----------------key is pressed-----------------
			cashoptionskey[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					input = "withdraw" + j;
				}
			});
		}
		//create the "clear" button, which is used to reset the input
		clear = new JButton("CLR");
		//define the action which will be performed after the
		//-----------------key is pressed-----------------
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputdisp.setText("");
				input = "";
			}
		});
		//create the "enter" button, which is used to confirm the input
		enter = new JButton("ENT");
		//define the action which will be performed after the
		//-----------------key is pressed-----------------
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				if(input.equals(defaultPIN)) {
					instdisp.setText("");
					instdisp.setText("PIN correct, please proceed at your discretion");
				}
				else {
					instdisp.setText("");
					instdisp.setText("Sorry, PIN is not correct, please re-enter.\n"
							+ "You have" + (3 - count) + "chances remaining");
				}
			}
		});
		//create the "deposit" button
		deposit = new JButton("Deposit");
		//define the action which will be performed after the
		//-----------------key is pressed-----------------
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input = "deposit";
			}
		});
		//create the "exit" button
		exit = new JButton("Exit");
		//define the action which will be performed after the
		//-----------------key is pressed-----------------
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input = "exit";
			}
		});
		buildGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
//create elements in the interface and set the pattern for alignment
	void buildGUI() {
		//create an instance of Jpanel named panel1
		JPanel panel1 = new JPanel();
		//set the layout used by panel1
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		//add elements to it, which are a JTextArea and a JTextField
		panel1.add(instdisp);
		panel1.add(inputdisp);
		//create an instance of Jpanel named panel2
		JPanel panel2 = new JPanel();
		//set the layout used by panel2
		panel2.setLayout(new GridLayout(4,3));
		//add buttons to panel2
		for(int i = 0; i < numkey.length; i++) 
			panel2.add(numkey[i]);
		panel2.add(clear);
		panel2.add(enter);
		//create an instance of Jpanel named panel4
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3,2));
		//add buttons to panel4
		for(int i = 0; i < cashoptionskey.length; i++)
			panel4.add(cashoptionskey[i]);
		panel4.add(deposit);
		panel4.add(exit);
		//set the overall appearance of the GUI
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.WEST);
		//add(panel3, BorderLayout.NORTH);
		add(panel4, BorderLayout.EAST);
	}
	//----------describe the GUI behavior during the stage of "entering PIN"----------
	void inputPIN() {
		instdisp.setText("");
		instdisp.append("Please enter the PIN of your card on the numeric keypad");
			
/**		if(input.equals(defaultPIN))	
			dispBal();
		else
			inputPIN();
			*/
	}
	
	//----------check if the PIN entered by the user is correct----------
/**	void checkPIN() {
		int count = 0;
		String num = "";
		if(num.equals(defaultPIN)) {
			input = "";
			dispBal();
		}
		else {
			if(num.length() >= 4) {
				instdisp.setText("");
				instdisp.append("PIN incorrect, please re-enter");
				count++;
				if(count == 3)
					System.exit(-1);
				inputPIN();
			}
			else {
			num += input;
			checkPIN();
			}
		}
		
			
				
	}
*/
	//----------describe the GUI behavior when displaying balances----------
	void dispBal() {
		instdisp.setText("");
		instdisp.append("Welcome, your current balance is GBP " + currentBal + "\n\n");
	}
	//----------describe the GUI behavior when displaying various options---------- 
	//-------------------------for the user to select-------------------------
	//--------------------after confirming the PIN is correct--------------------
	void dispOptions() {
		instdisp.append("Please select the function you require");
		if(input == "deposit")
			deposit();
		if(input == "withdraw1" | input == "withdraw2" | input == "withdraw3" | input == "withdraw4")
			withdraw();
		if(input == "exit")
			backToStartScreen();
	}
	//----------describe the process of a cash deposit
	void deposit() {
		instdisp.setText("");
		int depositedVal = Integer.parseInt(input);
		instdisp.append("Please input the amount");
		do {
			instdisp.append("Please input a value that is less than 1000");
		}
		while(depositedVal >= 1000);
		currentBal = currentBal + depositedVal;
		System.out.print("You have deposited: GBP " + depositedVal + "\n"
				+ "Your current balance is: GBP " + currentBal);
		}
	//----------describe the process of a cash withdrawal
	void withdraw() {
		instdisp.setText("");
		setView();
		switch(input) {
		case "withdraw1":
			currentBal = currentBal - 5;
			System.out.print("You have withdrawn: GBP " + 5 + "\n"
					+ "Your current balance is: GBP " + currentBal);
			break;
		case "withdraw2":
			currentBal = currentBal - 10;
			System.out.print("You have withdrawn: GBP " + 10 + "\n"
					+ "Your current balance is: GBP " + currentBal);
			break;
		case "withdraw3":
			currentBal = currentBal - 20;
			System.out.print("You have withdrawn: GBP " + 20 + "\n"
					+ "Your current balance is: GBP " + currentBal);
			break;
		case "withdraw4":
			currentBal = currentBal - 40;
			System.out.print("You have withdrawn: GBP " + 40 + "\n"
					+ "Your current balance is: GBP " + currentBal);
			break;
		}
	}
	//----------describe the GUI behavior after the user has chosen to go back to
	//------------------the screen where the PIN is prompted to be entered------------------
	void backToStartScreen() {
		instdisp.setText("");
		instdisp.append("Thank you for using this ATM, see you next time");
		inputPIN();
	}
	//set the buttons which should be disabled during the phase of withdrawing cash
	void setView() {
		if(currentBal < 5) {
			for(int i = 0; i < cashoptionskey.length; i++)
				cashoptionskey[i].setEnabled(false);
		}
		else if(currentBal >= 5 && currentBal < 10) {
			for(int i = 1; i < cashoptionskey.length; i++)
				cashoptionskey[i].setEnabled(false);
		}
		else if(currentBal >= 10 && currentBal < 20) {
			cashoptionskey[2].setEnabled(false);
			cashoptionskey[3].setEnabled(false);
		}
		else if(currentBal >= 20 && currentBal < 40) {
			cashoptionskey[3].setEnabled(false);
		}
		else {
			for(int i = 0; i < cashoptionskey.length; i++)
				cashoptionskey[i].setEnabled(true);
		}
	}
	//----------main method----------
	public static void main(String args[]) {
		ATM ATM = new ATM();
		ATM.inputPIN();
	}
}
