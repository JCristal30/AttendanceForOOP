// importing necessary package
package Attendance_04_28_23;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LoginFrame extends JFrame implements ActionListener {
	
	// Declare private variables for the buttons, panel, and frame
    private JButton adminButton, librarianButton;
    private JPanel panel;
    private JFrame frame;

    // Constructor method for the LoginFrame class, takes a title parameter
    public LoginFrame(String title) {
    	// Call the superclass constructor with the title parameter
        super(title);
        getContentPane().setBackground(SystemColor.activeCaption);
        getContentPane().setForeground(Color.BLUE);
        // Set the size of the frame
        setSize(430, 278);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBounds(481, 0, 10, 216);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set the layout of the panel to a centered flow layout

        getContentPane().add(panel); // Add the panel to the content pane
        adminButton = new JButton("Admin Login");
        adminButton.setBackground(Color.CYAN);
        adminButton.setBounds(145, 97, 123, 53);
        getContentPane().add(adminButton); // Add the button to the content pane
        librarianButton = new JButton("Librarian Login");
        librarianButton.setBackground(Color.CYAN);
        librarianButton.setForeground(Color.BLACK);
        librarianButton.setBounds(145, 163, 123, 53);
        getContentPane().add(librarianButton); // Add the button to the content pane
        
        JLabel MngmntTitle = new JLabel("Librarian Management"); // Create a new title label
        MngmntTitle.setBounds(113, 36, 203, 35);
        MngmntTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        getContentPane().add(MngmntTitle); // Add the label to the content pane
        
        librarianButton.addActionListener(this); // Add an action listener to the librarian login button
        adminButton.addActionListener(this); // Add an action listener to the admin login button

        setVisible(true); // Set the visibility of the frame to true
    }

    public void actionPerformed(ActionEvent e) { // Action listener method, called when a button is clicked
        if (e.getSource() == adminButton) {  // If the admin login button is clicked
            new AdminLoginFrame("Admin Login"); // It directed to AdminLoginFrame.
            dispose(); //dispose of the current frame
        } else if (e.getSource() == librarianButton) { // If the librarian button click it directed to LibrarianLoginFrame.
            new LibrarianLoginFrame("Librarian Login"); 
            dispose(); // dispose of the current frame
        }
    }
    // Main method, creates a new LoginFrame.
    public static void main(String[] args) {
        new LoginFrame("NU Library System");
    }
}
