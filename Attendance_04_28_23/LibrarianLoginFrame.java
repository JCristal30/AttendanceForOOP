// importing necessary package
package Attendance_04_28_23;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

//Defining a class called LibrarianLoginFrame which extends the JFrame class and implements the ActionListener interface
public class LibrarianLoginFrame extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;
    private JPanel panel;
    private JFrame frame;

    // Defining a constructor which takes a String as a parameter
    public LibrarianLoginFrame(String title) {
        super(title); // Invoking the constructor of the parent class	
        setSize(424, 282); // Setting the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the default close operation of the window
        setLocationRelativeTo(null); // Setting the location of the window to the center of the screen
 
        panel = new JPanel(); // Creating a new JPanel
        panel.setBackground(Color.LIGHT_GRAY);
        label1 = new JLabel("Username:"); // Creating a new JLabel with the text "Username:"
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 13)); // Setting the font of the label
        label1.setBounds(51, 24, 124, 81); // Setting the bounds of the label
        textField = new JTextField(); // Creating a new JTextField
        textField.setBounds(170, 51, 172, 29); // Setting the bounds of the text field
        label2 = new JLabel("Password:"); // Creating a new JLabel with the text "Password:"
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 13)); // Setting the font of the label
        label2.setBounds(51, 69, 204, 81); // Setting the bounds of the label
        passwordField = new JPasswordField(); // Creating a new JPasswordField
        passwordField.setBounds(170, 96, 172, 29); // Setting the bounds of the password field
        loginButton = new JButton("Login"); // Creating a new JButton with the text "Login"
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
        loginButton.setBounds(46, 161, 129, 59); // Setting the bounds of the button
        cancelButton = new JButton("Cancel"); // Creating a new JButton with the text "Cancel"
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(236, 161, 124, 59); // Setting the bounds of the button
        panel.setLayout(null); // Setting the layout of the panel to null

        panel.add(label1); // Adding the label to the panel
        panel.add(textField); // Adding the text field to the panel
        panel.add(label2); // Adding the label to the panel
        panel.add(passwordField); // Adding the password field to the panel
        panel.add(loginButton); // Adding the button to the panel
        panel.add(cancelButton); // Adding the button to the panel

        getContentPane().add(panel, BorderLayout.CENTER); // Adding the panel to the content pane of the frame

        loginButton.addActionListener(this); // Adding an ActionListener to the  Login button
        cancelButton.addActionListener(this); // Adding an ActionListener to the Cancel button

        setVisible(true); // Setting the frame visible
    }

    // Implementing the actionPerformed() method of the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) { // if the login button is clicked
            String username = textField.getText(); // gets the text from the username text field
            String password = new String(passwordField.getPassword());  // gets the text from the password field as a String
            if (username.equals("Librarian_01") && password.equals("LibOne") // if the username and password match
                    || username.equals("Librarian_02") && password.equals("LibTwo")
                    || username.equals("Librarian_03") && password.equals("LibThre")) {
            	JOptionPane.showMessageDialog(this, "SUCCESSFULLY LOGIN"); // shows a success message dialog
                new BookListFrame("Book List"); // it directed to BookListFrame
                dispose();  // disposes the current JFrame
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password."); // shows an error message dialog
            }
        } else if (e.getSource() == cancelButton) { // if the cancel button is clicked
            new LoginFrame("NU Library System"); // return to LoginFrame
            dispose(); // disposes the current JFrame
        } 
    }
}