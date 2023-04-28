package Attendance_04_28_23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

class AdminLoginFrame extends JFrame implements ActionListener {
	
	// These are the private instance variables for the AdminLoginFrame class.
    private JLabel label1, label2;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;
    private JPanel panel;
    private JFrame frame;
    
    // This is the constructor for the AdminLoginFrame class, which takes a String parameter for the window title.
    public AdminLoginFrame(String title) {
        super(title);
        
        // Set the size of the frame to be 400 x 255 pixels, and set the default close operation to be EXIT_ON_CLOSE.
        setSize(400, 255);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a new JPanel, and set the layout to null.
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        // Create a new JLabel for the "Username:" text, set its bounds to (72, 36, 98, 58), and add it to the panel.
        label1 = new JLabel("Username:");
        label1.setBounds(72, 36, 98, 58);
        
        // Create a new JTextField for the username, set its bounds to (180, 43, 140, 45), and add it to the panel.
        textField = new JTextField();
        textField.setBounds(180, 51, 140, 28);
        
        // Create a new JLabel for the "Password:" text, set its bounds to (72, 92, 98, 58), and add it to the panel.
        label2 = new JLabel("Password:");
        label2.setBounds(72, 92, 98, 58);
        
        // Create a new JPasswordField for the password, set its bounds to (180, 99, 140, 45), and add it to the panel.
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 107, 140, 28);
        
        // Create a new JButton for the "Login" button, set its bounds to (72, 161, 113, 40), and add it to the panel.
        loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
        loginButton.setBounds(72, 161, 113, 40);
        
        // Create a new JButton for the "Cancel" button, set its bounds to (216, 161, 113, 41), and add it to the panel.
        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(216, 161, 113, 41);        

        panel.add(label1);
        panel.add(textField);
        panel.add(label2);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(cancelButton);

        // Add the panel to the center of the content pane.
        getContentPane().add(panel, BorderLayout.CENTER);

        // Add an ActionListener to the loginButton and cancelButton.
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Set the frame to be visible.
        setVisible(true);
    }

    // Implement the actionPerformed() method of the ActionListener interface.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
        	// Get the username and password from the text fields and password field.
            String username = textField.getText();
            String password = new String(passwordField.getPassword());

            // Check if the username and password are correct.
            if (username.equals("Admin_01") && password.equals("AdminOne")
            	|| username.equals("Admin_02") && password.equals("AdminTwo")
    			|| username.equals("Admin_03") && password.equals("AdminThree")) {
            	// If they are correct, show a success message and open the WelcomeFrame.
            	JOptionPane.showMessageDialog(this, "SUCCESSFULLY LOGIN");
                new WelcomeFrame("NU Library System");
                dispose();
            } else {
            	// If they are not correct, show an error message.
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } else if (e.getSource() == cancelButton) {
        	// If the cancel button is clicked, go back to the LoginFrame.
        	new LoginFrame("NU Library System");
            dispose();
        }
    }
}
