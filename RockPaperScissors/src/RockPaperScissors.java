import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame  implements ActionListener {
    // images
    ImageIcon rockIcon = new ImageIcon("images/rock.png");
    ImageIcon paperIcon = new ImageIcon("images/paper.png");
    ImageIcon scissorsIcon = new ImageIcon("images/scissors.png");

    // buttons
    JButton rockButton, paperButton, scissorsButton;

    // computer choices
    String[] choices = {"Rock", "Paper", "Scissors"};

    // playerChoice
    String playerChoice, computerChoice;

    // player choice and computer icons
    JLabel playerChoiceIcon, computerChoiceIcon, versusLabel, resultLabel, computerChoiceLabel;

    // scores label
    JLabel playerScoreLabel, computerScoreLabel;

    // scores
    int playerScore = 0, computerScore = 0;

    // initialize random
    Random random;

    RockPaperScissors() {
        // set the title of GUI
        super("Rock Paper Scissors");

        // set default close operation to exit on close, this allows the frame to close once after exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set size 500 pixel wide and 500 pixel tall
        setSize(500, 500);

        // disable resize frame
        setResizable(false);

        // this allows GUI to open at the center of the screen
        setLocationRelativeTo(null);

        // set the background color
        getContentPane().setBackground(new Color(209, 209, 214));

        // set layout to null to manually position the components
        setLayout(null);

        // add the components
        addComponents();
    }

    public void addComponents() {
        // label of the title
        JLabel titleLabel = new JLabel("Rock Paper Scissors");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
        titleLabel.setBounds(65, 20, 350, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        // player label
        JLabel playerLabel = new JLabel("Player");
        playerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        playerLabel.setBounds(50, 100, 100, 50);
        add(playerLabel);

        // player score label
        playerScoreLabel = new JLabel("0");
        playerScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        playerScoreLabel.setBounds(30, 130, 100, 50);
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // player choice Icon
        playerChoiceIcon = new JLabel();
        playerChoiceIcon.setFont(new Font("Arial", Font.BOLD, 20));
        playerChoiceIcon.setBounds(120, 200, 64, 64);
        playerChoiceIcon.setIcon(rockIcon);
        playerChoiceIcon.setVisible(false);
        add(playerChoiceIcon);

        // result label
        resultLabel = new JLabel("Choose");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 30));
        resultLabel.setBounds(160, 260, 150, 100);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        // choices label
        computerChoiceLabel = new JLabel();
        computerChoiceLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        computerChoiceLabel.setBounds(160, 285, 150, 100);
        computerChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoiceLabel.setVisible(false);
        add(computerChoiceLabel);

        // versus label
        versusLabel = new JLabel("VS");
        versusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        versusLabel.setBounds(220, 200, 64, 64);
        versusLabel.setVisible(false);
        add(versusLabel);

        // computer label
        JLabel computerLabel = new JLabel("Computer");
        computerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        computerLabel.setBounds(340, 100, 100, 50);
        add(computerLabel);

        // computer score label
        computerScoreLabel = new JLabel("0");
        computerScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        computerScoreLabel.setBounds(335, 130, 100, 50);
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        // computer choice icon
        computerChoiceIcon = new JLabel();
        computerChoiceIcon.setFont(new Font("Arial", Font.BOLD, 20));
        computerChoiceIcon.setBounds(290, 200, 64, 64);
        computerChoiceIcon.setIcon(paperIcon);
        computerChoiceIcon.setVisible(false);
        add(computerChoiceIcon);

        // choices button
        rockButton = new JButton("ROCK");
        rockButton.setFont(new Font("Arial", Font.BOLD, 15));
        rockButton.setBounds(37, 380, 125, 50);
        rockButton.setFocusable(false);
        rockButton.addActionListener(this);
        add(rockButton);

        // paper button
        paperButton = new JButton("PAPER");
        paperButton.setFont(new Font("Arial", Font.BOLD, 15));
        paperButton.setBounds(177, 380, 125, 50);
        paperButton.setFocusable(false);
        paperButton.addActionListener(this);
        add(paperButton);

        // scissors button
        scissorsButton = new JButton("SCISSORS");
        scissorsButton.setFont(new Font("Arial", Font.BOLD, 15));
        scissorsButton.setBounds(317, 380, 125, 50);
        scissorsButton.setFocusable(false);
        scissorsButton.addActionListener(this);
        add(scissorsButton);
    }

    // this will display computer's choice
    public void setComputerChoiceLabel() {
        computerChoiceLabel.setVisible(true);
        computerChoiceLabel.setText("Computer Pick: " + computerChoice);
    }

    // displays icon of the computer's choice
    public void setComputerChoiceIcon() {
        switch (computerChoice) {
            case "Rock":
                computerChoiceIcon.setIcon(rockIcon);
                break;
            case "Paper":
                computerChoiceIcon.setIcon(paperIcon);
                break;
            case "Scissors":
                computerChoiceIcon.setIcon(scissorsIcon);
                break;
        }
    }

    // evaluate the choices whether if it is  win, lose or draw
    public void choicesEvaluation() {
        String verdict;
        if (playerChoice.equals(computerChoice)) {
            verdict = "Draw";
            resultLabel.setText(verdict);
        } else if (playerChoice.equals("Rock") && computerChoice.equals("Scissors") ||
        playerChoice.equals("Paper") && computerChoice.equals("Rock") ||
        playerChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            verdict = "You Win";
            resultLabel.setText(verdict);
            setScores(verdict);
        } else {
            verdict = "You Lose";
            resultLabel.setText(verdict);
            setScores(verdict);
        }
        playerScoreLabel.setText(String.valueOf(playerScore));
        computerScoreLabel.setText(String.valueOf(computerScore));
    }

    // increment the score if the verdict is Win and decrement score if Lose
    public void setScores(String verdict) {
        if (verdict.equals("You Win")) {
            playerScore++;
        } else if (verdict.equals("You Lose")) {
            computerScore++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // finish the instantiation of the Random object
        random = new Random();
        // generate random choice of the computer
        computerChoice = choices[random.nextInt(choices.length)];

        if (e.getSource() == rockButton) {
            playerChoice = "Rock";
            playerChoiceIcon.setVisible(true);
            playerChoiceIcon.setIcon(rockIcon);
            versusLabel.setVisible(true);
            setComputerChoiceLabel();
            computerChoiceIcon.setVisible(true);
            setComputerChoiceIcon();
            choicesEvaluation();
        } else if (e.getSource() == paperButton) {
            playerChoice = "Paper";
            playerChoiceIcon.setVisible(true);
            playerChoiceIcon.setIcon(paperIcon);
            versusLabel.setVisible(true);
            setComputerChoiceLabel();
            computerChoiceIcon.setVisible(true);
            setComputerChoiceIcon();
            choicesEvaluation();
        } else {
            playerChoice = "Scissors";
            playerChoiceIcon.setVisible(true);
            playerChoiceIcon.setIcon(scissorsIcon);
            versusLabel.setVisible(true);
            setComputerChoiceLabel();
            computerChoiceIcon.setVisible(true);
            setComputerChoiceIcon();
            choicesEvaluation();
        }
    }
}




