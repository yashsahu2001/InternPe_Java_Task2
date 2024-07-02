package com.demonstration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;
    private Random random;

    public RockPaperScissors() {
        super("Rock Paper Scissors Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        resultLabel = new JLabel("Choose your move!");

        // Add action listeners
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        // Layout setup
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        add(buttonPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        random = new Random();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerMove = "";
        if (e.getSource() == rockButton) {
            playerMove = "rock";
        } else if (e.getSource() == paperButton) {
            playerMove = "paper";
        } else if (e.getSource() == scissorsButton) {
            playerMove = "scissors";
        }

        int computerInt = random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors
        String computerMove;
        switch (computerInt) {
            case 0:
                computerMove = "rock";
                break;
            case 1:
                computerMove = "paper";
                break;
            case 2:
                computerMove = "scissors";
                break;
            default:
                computerMove = "error";
                break;
        }

        String resultText = "You chose: " + playerMove + ", Computer chose: " + computerMove + ". ";

        // Determine the winner
        if (playerMove.equals(computerMove)) {
            resultText += "It's a tie!";
        } else if (playerMove.equals("rock") && computerMove.equals("scissors") ||
                playerMove.equals("paper") && computerMove.equals("rock") ||
                playerMove.equals("scissors") && computerMove.equals("paper")) {
            resultText += "You win!";
        } else {
            resultText += "Computer wins!";
        }

        resultLabel.setText(resultText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissors());
    }
}
