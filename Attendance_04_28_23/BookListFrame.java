// Importing necessary classes and packages
package Attendance_04_28_23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;

//Defining a class that extends the JFrame class and implements the ActionListener interface
public class BookListFrame extends JFrame implements ActionListener {
	// Declaring private instance variables
    private JButton borrowButton, exitButton;
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private int[] bookCopies;
    
    // Constructor that creates a BookListFrame object
    public BookListFrame(String title) {
        super(title);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(543, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Initializing the array that stores the number of copies available for each book
        bookCopies = new int[]{3, 2, 4};
        
        // Creating a DefaultTableModel object with column headers and adding rows to it
        tableModel = new DefaultTableModel(new String[] {"Book Title", "Author Name", "Copies Available"}, 0);
        tableModel.addRow(new String[] {"1. Florante at Laura", "Francisco Balagtas", Integer.toString(bookCopies[0])});
        tableModel.addRow(new String[] {"2. Noli Me Tangere", "Jose Rizal", Integer.toString(bookCopies[1])});
        tableModel.addRow(new String[] {"3. Ibong Adarna", "Lope de Vega", Integer.toString(bookCopies[2])});
        
        // Creating a JTable object and setting its properties
        bookTable = new JTable(tableModel);
        bookTable.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        scrollPane.setBounds(0, 0, 527, 188);
        
        // Creating JButton objects and adding them to a JPanel object
        borrowButton = new JButton("Borrow Book");
        borrowButton.setForeground(Color.BLACK);
        exitButton = new JButton("Exit");
        exitButton.setForeground(Color.BLACK);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 188, 527, 33);
        buttonPanel.add(borrowButton);
        buttonPanel.add(exitButton);
        getContentPane().setLayout(null);
        
        // Adding the JScrollPane and JPanel objects to the JFrame object
        getContentPane().add(scrollPane);
        getContentPane().add(buttonPanel);
        
        // Adding action listeners to the JButtons
        borrowButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        // Setting the JFrame object to be visible
        setVisible(true);
    }
    
    // Overriding the actionPerformed method of the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == borrowButton) { // When the "Borrow Book" button is clicked
        	// Displaying an input dialog to ask for the book number to borrow
            String input = JOptionPane.showInputDialog(this, "Enter book number (1-" + bookTable.getRowCount() + "):");
            if (input != null) {
                try {
                    int bookIndex = Integer.parseInt(input) - 1;
                    if (bookIndex >= 0 && bookIndex < bookTable.getRowCount()) { // Checking if the input book number is valid
                        int copiesAvailable = Integer.parseInt((String)tableModel.getValueAt(bookIndex, 2));
                        if (copiesAvailable > 0) { // Checking if there are still available copies for the chosen book
                            copiesAvailable--;
                            tableModel.setValueAt(Integer.toString(copiesAvailable), bookIndex, 2); // Updating the number of copies available in the JTable
                            JOptionPane.showMessageDialog(this, "Book Rented");
                        } else { // If no copies available, it displays no copies.
                            JOptionPane.showMessageDialog(this, "No copies available for this book.");
                        }
                    } else { // If number of index is out of choice, it display Index Does Not Exist.
                        JOptionPane.showMessageDialog(this, "INDEX DOES NOT EXIST, Try Again!");
                    }
                } catch (NumberFormatException ex) { // Shows Invalid Input if the Code Didn't Run.
                    JOptionPane.showMessageDialog(this, "Invalid input.");
                }
            }
        } else if (e.getSource() == exitButton) {
        	// Exit the program if the Exit button is clicked
            System.exit(0);
        }
    }
}
