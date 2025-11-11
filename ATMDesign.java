import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMDesign extends JFrame implements ActionListener {

    JLabel titleLabel, amountLabel, messageLabel;
    JTextField amountField;
    JButton withdrawButton, depositButton, balanceButton, clearButton, exitButton;

    double balance = 1000.00; 
    
    ATMDesign() {
        // Frame setup
        setTitle("ATM Interface Design");
        setSize(420, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        // Title Label
        titleLabel = new JLabel("ATM MACHINE", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(80, 20, 250, 30);
        add(titleLabel);

        // Amount Label
        amountLabel = new JLabel("Enter Amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        amountLabel.setBounds(50, 100, 120, 25);
        add(amountLabel);

        // Text Field for Amount
        amountField = new JTextField();
        amountField.setBounds(180, 100, 160, 25);
        add(amountField);

        // Withdraw Button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 150, 120, 35);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        // Deposit Button
        depositButton = new JButton("Deposit");
        depositButton.setBounds(220, 150, 120, 35);
        depositButton.addActionListener(this);
        add(depositButton);

        // Check Balance Button
        balanceButton = new JButton("Check Balance");
        balanceButton.setBounds(50, 200, 290, 35);
        balanceButton.addActionListener(this);
        add(balanceButton);

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setBounds(50, 250, 120, 35);
        clearButton.addActionListener(this);
        add(clearButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(220, 250, 120, 35);
        exitButton.addActionListener(this);
        add(exitButton);

        // Message Label
        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messageLabel.setForeground(Color.BLUE);
        messageLabel.setBounds(30, 310, 350, 30);
        add(messageLabel);

        setVisible(true);
    }

    // Action Events
    public void actionPerformed(ActionEvent e) {
        String input = amountField.getText();
        double amount = 0;

        // Parse amount safely
        if (!input.isEmpty()) {
            try {
                amount = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid amount entered!");
                return;
            }
        }

        if (e.getSource() == withdrawButton) {
            if (amount <= 0) {
                messageLabel.setText("Enter a valid withdrawal amount!");
            } else if (amount > balance) {
                messageLabel.setText("Insufficient Balance!");
            } else {
                balance -= amount;
                messageLabel.setText("Withdrawn ₹" + amount + " | New Balance: ₹" + balance);
            }
        } 
        else if (e.getSource() == depositButton) {
            if (amount <= 0) {
                messageLabel.setText("Enter a valid deposit amount!");
            } else {
                balance += amount;
                messageLabel.setText("Deposited ₹" + amount + " | New Balance: ₹" + balance);
            }
        } 
        else if (e.getSource() == balanceButton) {
            messageLabel.setText("Your Current Balance: ₹" + balance);
        } 
        else if (e.getSource() == clearButton) {
            amountField.setText("");
            messageLabel.setText("");
        } 
        else if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(this, "Thank you for using the ATM!");
            System.exit(0);
        }
    }

    // Main method
     public static void main(String args[]){
        new ATMInterface();
    }
}
