// Importing necessary classes and packages
package Attendance_04_28_23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

class WelcomeFrame extends JFrame {
	 // Declare instance variables
	private JLabel label;
	private JPanel panel;
	private JButton exitButton;
	
	public WelcomeFrame(String title) {
		// Set the frame title and size
		setTitle("Welcome to NU Library System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with absolute layout
        panel = new JPanel();
        panel.setLayout(null);

        // Create a label and add it to the panel
        label= new JLabel("Welcome to NU Library System!");
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label.setBounds(0, 0, 384, 238);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        // Create a button and add it to the panel
        exitButton = new JButton("Exit");
        exitButton.setBounds(0, 232, 384, 29);
        // Add an ActionListener to the button to hide the current frame and return to the LoginFrame
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginFrame loginFrame = new LoginFrame(title);
                loginFrame.setVisible(true);
            }
        });
        panel.add(exitButton);

        // Add the panel to the frame's content pane, center the frame, and make it visible
        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
