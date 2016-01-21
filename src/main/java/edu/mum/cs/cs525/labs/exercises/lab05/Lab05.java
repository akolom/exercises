package edu.mum.cs.cs525.labs.exercises.lab05;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class Lab05 extends javax.swing.JFrame
{
    private VStack stack = new VStack();  // the stack object
    private String pushstring=""; // the string to push on the stack
    
	public Lab05 ()
	{
	    
		// {{INIT_CONTROLS
		setTitle("Stack application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(488,309);
		setVisible(false);
		JButtonPush.setText("Push");
		getContentPane().add(JButtonPush);
		JButtonPush.setBounds(36,48,110,27);
		JButtonPop.setText("Pop");
		getContentPane().add(JButtonPop);
		JButtonPop.setBounds(36,96,110,27);
		JButtonUndo.setText("Undo");
		getContentPane().add(JButtonUndo);
		JButtonUndo.setBounds(36,144,110,27);
		JButtonRedo.setText("Redo");
		getContentPane().add(JButtonRedo);
		JButtonRedo.setBounds(36,192,110,27);
		JScrollPane scrollPane = new JScrollPane(JList1);
		JList1.setListData(stack.getStackVector());
		scrollPane.setBounds(216,36,162,203);
		getContentPane().add(scrollPane);
		// }}

		// {{INIT_MENUS
		// }}

		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButtonPush.addActionListener(lSymAction);
		JButtonPop.addActionListener(lSymAction);
		JButtonUndo.addActionListener(lSymAction);
		JButtonRedo.addActionListener(lSymAction);
		//}}
	}

	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		  
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }

			//Create a new instance of our application's frame, and make it visible.
			(new Lab05 ()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	//{{DECLARE_CONTROLS
	javax.swing.JButton JButtonPush = new javax.swing.JButton();
	javax.swing.JButton JButtonPop = new javax.swing.JButton();
	javax.swing.JButton JButtonUndo = new javax.swing.JButton();
	javax.swing.JButton JButtonRedo = new javax.swing.JButton();
	javax.swing.JList JList1 = new javax.swing.JList();
	//}}

	//{{DECLARE_MENUS
	//}}

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == Lab05.this)
				JFrame1_windowClosing(event);
		}
	}

	void JFrame1_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		JFrame1_windowClosing_Interaction1(event);
	}

	void JFrame1_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButtonPush)
				JButtonPush_actionPerformed(event);
			else if (object == JButtonPop)
				JButtonPop_actionPerformed(event);
			else if (object == JButtonUndo)
				JButtonUndo_actionPerformed(event);
			else if (object == JButtonRedo)
				JButtonRedo_actionPerformed(event);
			
		}
	}

	void JButtonPush_actionPerformed(java.awt.event.ActionEvent event)
	{
	    pushstring= "";
	    PushDialog  dialog = new PushDialog(this); //ask the user what to push
	    dialog.setVisible(true);
	    if (!pushstring.equals("")) // after the dialog is closed, 
		   stack.push(pushstring);  // pushstring contains the user input
		JList1.setListData(stack.getStackVector());  // refresh the JList
		this.repaint();
			 
	}

	void JButtonPop_actionPerformed(java.awt.event.ActionEvent event)
	{
		stack.pop();
		JList1.setListData(stack.getStackVector()); // refresh the JList
		this.repaint();
			 
	}

	void JButtonUndo_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
	}

	void JButtonRedo_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
	}
	
	public void setPushString (String string){
	    pushstring = string;
	}
	

}
