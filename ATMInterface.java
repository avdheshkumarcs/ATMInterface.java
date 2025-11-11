import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterface extends JFrame implements ActionListener{
    
    private JLabel titleLabel, balanceLabel, messageLabel;
    private JTextField amountField;
    private JButton withdrawButton, depositButton, checkBalanceButton, exitButton;

    private double balance = 1000.00; // initial balance

    public ATMInterface() {
        setTitle("ATM Interface");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        titleLabel = new JLabel("ATM Machine", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(100, 20, 200, 30);
        add(titleLabel);

        balanceLabel = new JLabel("Enter Amount:");
        balanceLabel.setBounds(50, 80, 100, 25);
        add(balanceLabel);

        amountField = new JTextField();
        amountField.setBounds(160, 80, 150, 25);
        add(amountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 130, 120, 30);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(200, 130, 120, 30);
        depositButton.addActionListener(this);
        add(depositButton);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(50, 180, 270, 30);
        checkBalanceButton.addActionListener(this);
        add(checkBalanceButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(50, 230, 270, 30);
        exitButton.addActionListener(this);
        add(exitButton);

        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setForeground(Color.BLUE);
        messageLabel.setBounds(50, 270, 270, 25);
        add(messageLabel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String amountText = amountField.getText();
        double amount = 0;

        if (!amountText.isEmpty()) {
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number.");
                return;
            }
        }

        if (e.getSource() == withdrawButton) {
            if (amount <= 0) {
                messageLabel.setText("Enter a valid withdrawal amount.");
            } else if (amount > balance) {
                messageLabel.setText("Insufficient balance!");
            } else {
                balance -= amount;
                messageLabel.setText("Withdrawn ₹" + amount + ". New balance: ₹" + balance);
            }
        } 
        else if (e.getSource() == depositButton) {
            if (amount <= 0) {
                messageLabel.setText("Enter a valid deposit amount.");
            } else {
                balance += amount;
                messageLabel.setText("Deposited ₹" + amount + ". New balance: ₹" + balance);
            }
        } 
        else if (e.getSource() == checkBalanceButton) {
            messageLabel.setText("Current balance: ₹" + balance);
        } 
        else if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(this, "Thank you for using the ATM!");
            System.exit(0);
        }

        amountField.setText("");
    }




    
    public static void main(String args[]){
        new ATMInterface();
    }
}
