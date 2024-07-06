import java.awt.*;
import java.awt.event.*;

public class QuizGame extends Frame implements ActionListener {
    Label questionLabel;
    Checkbox[] options;
    CheckboxGroup optionGroup;
    Button nextButton;
    int currentQuestion;
    int score;

    // Sample questions and answers
    String[][] questions = {
        {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid"},
        {"What is 2 + 2?", "3", "4", "5", "6"},
        {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn"},
        {"How many continents are there?","2","6","7","4"},
        {"What is the color of water?","Red","Blue","white","Black"}
    };
    int[] answers = {0, 1, 1, 3, 2}; // Correct answers (index of the correct option)

    public QuizGame() {
        // Frame properties
        setTitle("Quiz Game");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);

        
        questionLabel = new Label();
        options = new Checkbox[4];
        optionGroup = new CheckboxGroup();
        

        for (int i = 0; i < 4; i++) {
            options[i] = new Checkbox("", optionGroup, false);
            add(options[i]);
        }

        nextButton = new Button("Next");
        nextButton.addActionListener(this);

        add(questionLabel,BorderLayout.SOUTH);
        add(nextButton,BorderLayout.EAST);

    
        currentQuestion = 0;
        score = 0;
        loadQuestion();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }


    public void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion][0]);
            for (int i = 0; i < 4; i++) {
                options[i].setLabel(questions[currentQuestion][i + 1]);
                options[i].setState(false);
            }
        } else {
            showResult();
        }
    }

    
    public void showResult() {
        questionLabel.setText("Your score: " + score + "/" + questions.length);
        for (Checkbox option : options) {
            option.setVisible(false);
        }
        nextButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (optionGroup.getSelectedCheckbox() != null) {
                int selectedOption = -1;
                for (int i = 0; i < options.length; i++) {
                    if (options[i] == optionGroup.getSelectedCheckbox()) {
                        selectedOption = i;
                        break;
                    }
                }
                if (selectedOption == answers[currentQuestion]) {
                    questionLabel.setText("correct answer");
                    score++;
                }
                currentQuestion++;
                loadQuestion();
            } else {
                questionLabel.setText("Please select an option!");
            }
        }
    }

    public static void main(String[] args) {
        new QuizGame();
    }
}
