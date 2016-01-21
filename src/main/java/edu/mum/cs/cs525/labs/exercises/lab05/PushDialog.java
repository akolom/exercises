package edu.mum.cs.cs525.labs.exercises.lab05;

public class PushDialog extends javax.swing.JDialog
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Lab05 parentframe;
    
	public PushDialog(Lab05 parent)
	{
		parentframe = parent; // remember the parent frame
		// {{INIT_CONTROLS
		setTitle("StringDialog.");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(349,300);
		setVisible(false);
		getContentPane().add(JTextField);
		JTextField.setBounds(144,24,140,24);
		JLabel1.setText("Text to push:");
		getContentPane().add(JLabel1);
		JLabel1.setBounds(24,24,106,23);
		JButtonCancel.setText("Cancel");
		JButtonCancel.setActionCommand("Cancel");
		getContentPane().add(JButtonCancel);
		JButtonCancel.setBounds(60,84,105,28);
		JButtonOK.setText("OK");
		JButtonOK.setActionCommand("OK");
		getContentPane().add(JButtonOK);
		JButtonOK.setBounds(180,84,105,28);
		// }}

		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButtonCancel.addActionListener(lSymAction);
		JButtonOK.addActionListener(lSymAction);
		//}}
	}


	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == PushDialog.this)
				PushDialog_WindowClosing(event);
		}
	}

	void PushDialog_WindowClosing(java.awt.event.WindowEvent event)
	{
		dispose();
	}
	//{{DECLARE_CONTROLS
	javax.swing.JTextField JTextField = new javax.swing.JTextField();
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JButton JButtonCancel = new javax.swing.JButton();
	javax.swing.JButton JButtonOK = new javax.swing.JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButtonCancel)
				JButtonCancel_actionPerformed(event);
			else if (object == JButtonOK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonCancel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose(); //close the dialog
			 
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		parentframe.setPushString(JTextField.getText()); //make Lab4.pushtring equeal to user input
		dispose();	//close the dialog 
	}
}