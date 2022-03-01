/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.githubtictactoe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Sunny
 */

//Implements ActionListener(Interface)
public class TicTacToe implements ActionListener{
    
    //Whos turn it is first Randomly
    Random random = new Random();
    
    //We need to build a JFrame
    JFrame frame = new JFrame();
    
    //Panel Made for the Title
    JPanel title_panel = new JPanel();
    
    //Panel made to hold the buttons
    JPanel button_panel = new JPanel();
    
    //Label to hold a textfield to show some sort of Message
    JLabel textfield = new JLabel();
    
    //We made an Array to hold 9 buttons
    JButton[] buttons = new JButton[9];
    
    //To see if player1 turn or player 2 turn
    //we don't need 2 of these because it is TRUE or FALSE
    boolean player1_turn;
    
    
    //Make Constructor
    TicTacToe(){
        
        //This is where the JFrame is created.....
        
        //To close the Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //To set the size of the Frame
        frame.setSize(800, 800);
        
        //Set the Frame background Color
        frame.getContentPane().setBackground(new Color(50,50,50));
        
        //Set the Frame Layout to BorderLayout
        frame.setLayout(new BorderLayout());
        
        //Set the Frame visiblity to see the Frame
        frame.setVisible(true);
        
        
        
        //Working on the textfield now.....
        
        //Set the Text(Title) background color to a Dark (Black) Color
        textfield.setBackground(new Color(25,25,25));
        
        //Set the Text color to Green
        textfield.setForeground(new Color(25,255,0));
        
        //Set the Font (type, BOLD, Size)
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        
        //Set the horizontal Alignment (Making Text Centered)
        textfield.setHorizontalAlignment(JLabel.CENTER);
        
        //Displaying the Title of the Game "Tic-Tac-Toe"
        textfield.setText("Tic-Tac-Toe");
        
        //Not sure what setOpaque to true does?
        textfield.setOpaque(true);
        
        //Working on the Title_Panel.....
        
        //Set the title_Panel to BorderLayout
        title_panel.setLayout(new BorderLayout());
        
        //Where we want this title to start.
        //First 0 and Second 0 is the TopLeft corner (x is 0, y is 0)
        //Length is 800 to match size of this frame
        //Height is 100. We don't want to match frame cause it will cover everything
        title_panel.setBounds(0,0,800,100);
        
        
        
        
        //Working on the Button_Panel.....
        
        //Set button_Panel to a GridLayout. It will hold all buttons properly
        //(3,3) is the demensions of the Buttons. 3x3= 9 buttons
        button_panel.setLayout(new GridLayout(3,3));
        
        //Changing the Color of the Buttons Background (Color Doesn't Matter Cause Buttons will be added over the Color
        button_panel.setBackground(new Color(150,150,150));
        
        //Since we are dealing with an ARRAY of Buttons we can use a FOR-LOOP
        //int i start @ 0 and increments up to 9
        for(int i = 0; i<9; i++){
            //We take our Buttons-Array @ index i and create a new JButton
            buttons[i] = new JButton();
            //Add this spacific button to our Button_Panel
            button_panel.add(buttons[i]);
            //Set Button Font (Type, Bold, Size)
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            //Still not sure what SetFocusable Does? But we don't it to be able to do that!
            buttons[i].setFocusable(false);
            //Add this Event to our ActionListener
            buttons[i].addActionListener(this);
            
        }
        
        
        //***VERY IMPORTANT***
        //Adding objects to our Frame....
        
        //Add textfield to our title_Panel and the title_panel to our Frame
        title_panel.add(textfield);
        //Set the title to BorderLayout.North so it doesn't cover the whole Frame
        //frame.add(title_panel); <--- this covers the whole Frame
        frame.add(title_panel,BorderLayout.NORTH);
        //Adding the button_Panel to the Frame
        frame.add(button_panel);
        
        
        //Calling the FirstTurn method.....
        
        firstTurn();
        
    }

    //This is to add unimplemented methods.
    @Override
    public void actionPerformed(ActionEvent event) {
        
        //FOR-LOOP through the Buttons
        for(int i=0; i<9; i++){
            //IF the EVENT is equal to buttons[i] ARRAY
            if(event.getSource()==buttons[i]){
                //Check to see who's turn it is
                //we don't need to say if(player1_turn == true) because this is already boolean value
                if(player1_turn){
                    //check to see if there is any text assigned to this button
                    //because if someone clicks on a button we're going to change the text on the button
                    //to X or O
                    if(buttons[i].getText()== ""){ //<--- checking for the text
                        //Set the forGround color
                        buttons[i].setForeground(new Color(255,0,0));
                        //Set the text
                        buttons[i].setText("X");
                        
                        //Flip player1_turn
                        player1_turn = false;
                        //Change the textfield to "O turn"
                        textfield.setText("O turn");
                        check();
                        
                    }
                    
                }
                else{
                    if(buttons[i].getText()== ""){ //<--- checking for the text
                        //Set the forGround color
                        buttons[i].setForeground(new Color(0,0,255));
                        //Set the text
                        buttons[i].setText("O");
                        
                        //Flip player1_turn
                        player1_turn = true;
                        //Change the textfield to "O turn"
                        textfield.setText("X turn");
                        check();
                    }
                }
            
            }
        
       }
    }
    
    //This is to see who's turn is first
    public void firstTurn(){
        
        //Is unnesseccary but Look cool.....
        //This makes the "Tic-Tac-Toe" title_panel change to "X turn" and "O turn" 
        //it waits a while before the title is changed.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //To decide who will go first? X or O??.....

        //random.nextInt(2) will give you numbers 0 and 1
        //IF random.nextInt(2) gives you 0 == 0 (is TRUE)
        //textfield will print "X turn"
        if(random.nextInt(2)==0){
            //Using the Boolean player1_Turn to see who goes first.
            player1_turn = true;
            //Chaning the textfield from "Tic-Tac-Toe" to "X Turn"
            textfield.setText("X turn");
        }
        //ELSE random.nextInt(2) gives you 1 == 0 (is FALSE)
        //textfield will print "O turn"
        else{
            player1_turn = false;
            //Changing the textfield from "Tic-Tac-Toe" to "O Turn"
            textfield.setText("O turn");
        }
    }
    //To check to see if there are any winning conditions
    public void check(){
        //Check X win conditions
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[0] is equal to "X"
                (buttons[0].getText()=="X")&&
                //Checking to see if button[1] is equal to "X"
                (buttons[1].getText()=="X")&&
                //Checking to see if button[2] is equal to "X"
                (buttons[2].getText()=="X")
                ){
            xWins(0,1,2);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[3] is equal to "X"
                (buttons[3].getText()=="X")&&
                //Checking to see if button[4] is equal to "X"
                (buttons[4].getText()=="X")&&
                //Checking to see if button[5] is equal to "X"
                (buttons[5].getText()=="X")
                ){
            xWins(3,4,5);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[6] is equal to "X"
                (buttons[6].getText()=="X")&&
                //Checking to see if button[7] is equal to "X"
                (buttons[7].getText()=="X")&&
                //Checking to see if button[8] is equal to "X"
                (buttons[8].getText()=="X")
                ){
            xWins(6,7,8);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[0] is equal to "X"
                (buttons[0].getText()=="X")&&
                //Checking to see if button[3] is equal to "X"
                (buttons[3].getText()=="X")&&
                //Checking to see if button[6] is equal to "X"
                (buttons[6].getText()=="X")
                ){
            xWins(0,3,6);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[1] is equal to "X"
                (buttons[1].getText()=="X")&&
                //Checking to see if button[4] is equal to "X"
                (buttons[4].getText()=="X")&&
                //Checking to see if button[7] is equal to "X"
                (buttons[7].getText()=="X")
                ){
            xWins(1,4,7);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[2] is equal to "X"
                (buttons[2].getText()=="X")&&
                //Checking to see if button[5] is equal to "X"
                (buttons[5].getText()=="X")&&
                //Checking to see if button[8] is equal to "X"
                (buttons[8].getText()=="X")
                ){
            xWins(2,5,8);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[0] is equal to "X"
                (buttons[0].getText()=="X")&&
                //Checking to see if button[4] is equal to "X"
                (buttons[4].getText()=="X")&&
                //Checking to see if button[8] is equal to "X"
                (buttons[8].getText()=="X")
                ){
            xWins(0,4,8);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "X"
                //Checking to see if button[2] is equal to "X"
                (buttons[2].getText()=="X")&&
                //Checking to see if button[4] is equal to "X"
                (buttons[4].getText()=="X")&&
                //Checking to see if button[6] is equal to "X"
                (buttons[6].getText()=="X")
                ){
            xWins(2,4,6);
        }
        
        //Check O Win conditions
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[0] is equal to "O"
                (buttons[0].getText()=="O")&&
                //Checking to see if button[1] is equal to "O"
                (buttons[1].getText()=="O")&&
                //Checking to see if button[2] is equal to "O"
                (buttons[2].getText()=="O")
                ){
            oWins(0,1,2);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[3] is equal to "O"
                (buttons[3].getText()=="O")&&
                //Checking to see if button[4] is equal to "O"
                (buttons[4].getText()=="O")&&
                //Checking to see if button[5] is equal to "O"
                (buttons[5].getText()=="O")
                ){
            oWins(3,4,5);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[6] is equal to "O"
                (buttons[6].getText()=="O")&&
                //Checking to see if button[7] is equal to "O"
                (buttons[7].getText()=="O")&&
                //Checking to see if button[8] is equal to "O"
                (buttons[8].getText()=="O")
                ){
            oWins(6,7,8);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[0] is equal to "O"
                (buttons[0].getText()=="O")&&
                //Checking to see if button[3] is equal to "O"
                (buttons[3].getText()=="O")&&
                //Checking to see if button[6] is equal to "O"
                (buttons[6].getText()=="O")
                ){
            oWins(0,3,6);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[1] is equal to "O"
                (buttons[1].getText()=="O")&&
                //Checking to see if button[4] is equal to "O"
                (buttons[4].getText()=="O")&&
                //Checking to see if button[7] is equal to "O"
                (buttons[7].getText()=="O")
                ){
            oWins(1,4,7);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[2] is equal to "O"
                (buttons[2].getText()=="O")&&
                //Checking to see if button[5] is equal to "O"
                (buttons[5].getText()=="O")&&
                //Checking to see if button[8] is equal to "O"
                (buttons[8].getText()=="O")
                ){
            oWins(2,5,8);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[0] is equal to "O"
                (buttons[0].getText()=="O")&&
                //Checking to see if button[4] is equal to "O"
                (buttons[4].getText()=="O")&&
                //Checking to see if button[8] is equal to "O"
                (buttons[8].getText()=="O")
                ){
            oWins(0,4,8);
        }
        
        if(     
                //buttons[0] is our first button
                // .getText checks the Text of the buttons and if it is equal to "O"
                //Checking to see if button[2] is equal to "O"
                (buttons[2].getText()=="O")&&
                //Checking to see if button[4] is equal to "O"
                (buttons[4].getText()=="O")&&
                //Checking to see if button[6] is equal to "O"
                (buttons[6].getText()=="O")
                ){
            oWins(2,4,6);
        }
    }
    //To see if X wins
    public void xWins(int a, int b, int c){
        //Changing the color of the background to green to show who won
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        //Disabling the buttons so you can't keep playing
        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        //Chaning the textfield(Title) to display "X wins"
        textfield.setText("X wins");
        
    }
    //To see if O wins
    public void oWins(int a, int b, int c){
        //Changing the color of the background to green to show who won
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        //Disabling the buttons so you can't keep playing
        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        //Chaning the textfield(Title) to display "O wins"
        textfield.setText("O wins");
    }
    
}
