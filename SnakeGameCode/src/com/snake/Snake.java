// Main/Entry class for game Snake.
package com.snake;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Snake implements ItemListener {

	
	static SnakePanel panel;
	static StartScreen startPanel;
	JPanel cards; //a panel that uses CardLayout
	JTabbedPane tabbedPane;
	final static String STARTGAMEPANEL = "Start Game";
	final static String STOPGAMEPANEL = "Pause Game";
//	final static JButton startGame, stopGame;
	
	    public static void main(String[] args) throws Exception{

	//	JButton startAnim, stopAnim, calcSteer;
		//	long startTime = System.currentTimeMillis();
			
			// Create a window (frame)
			final JFrame frame = new JFrame("Snake Game");
		//	frame.setLayout(new GridBagLayout());
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        
		    //Create and set up the content pane.
	//	    Snake demo = new Snake();
	//	    demo.addComponentToPane(frame.getContentPane());
			
			JPanel south = new JPanel(new GridLayout(0,1,2,2));
			JPanel north = new JPanel(new GridLayout(4, 2));
			
	/*		startAnim = new JButton("Start");
	        startAnim.setBounds(300, 20, 100, 50);
	        
	        stopAnim = new JButton("Pause");
	        stopAnim.setBounds(100, 400, 100, 50);
	        
	        south.add(startAnim, BorderLayout.PAGE_START);
	        south.add(stopAnim, BorderLayout.PAGE_END);*/
	        
	         panel = new SnakePanel();
			frame.getContentPane().add(panel);
			panel.startThread();
			
			frame.add(south, BorderLayout.PAGE_END);
			frame.add(north, BorderLayout.PAGE_START);
			
	  /*      startAnim.addActionListener(new ActionListener(){ 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// Create a canvas (BouncePanel) and add it to the window
	            	panel = new SnakePanel();
	            	panel.startThread();
	            	
	            //	panel = new SnakePanel();
	            }
	        });
	        
	        stopAnim.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		panel.terminate();
	        	}
	        });*/
	        
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
		    frame.setLocationRelativeTo(null);
			frame.setVisible(true);	

		}
	
	public void actionPerformed(ActionEvent e) {
		   
	} 
	    
	  public void addComponentToPane(Container pane) {
	        //Put the JComboBox in a JPanel to get a nicer look.
	        JPanel comboBoxPane = new JPanel(); //use FlowLayout
	        String comboBoxItems[] = { STARTGAMEPANEL, STOPGAMEPANEL };
//	        JComboBox cb = new JComboBox(comboBoxItems);
	        tabbedPane = new JTabbedPane();
//	        cb.setEditable(false);
//	        cb.addItemListener(this);
//	        comboBoxPane.add(cb);
	        
	        //Create the "cards".
	        JPanel card1 = new JPanel();
	        panel = new SnakePanel();
	    //	frame.getContentPane().add(panel);
	        card1.add(panel);
	        panel.startThread();
	        
	        JPanel card2 = new JPanel();
	        startPanel = new StartScreen();
	        card2.add(panel);
	        
	        //Create the panel that contains the "cards".
	   //     cards = new JPanel(new CardLayout());
	   //     cards.add(card1, STARTGAMEPANEL);
	   //     cards.add(card2, STOPGAMEPANEL);
	        
	        tabbedPane.addTab(STOPGAMEPANEL, card2);
	        tabbedPane.addTab(STARTGAMEPANEL, card1);
	        
	        pane.add(comboBoxPane, BorderLayout.PAGE_START);
	        pane.add(tabbedPane, BorderLayout.CENTER);
	    }
	  
	  public void itemStateChanged(ItemEvent evt) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, (String)evt.getItem());
	    }

}
