import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField display;
    Button[] numberButtons = new Button[10];
    Button addButton, subButton, mulButton, divButton, eqButton, clrButton;
    Panel panel;
    String operator;
    double num1, num2, result;
    int a=10;
    int b=20;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 400);
        setLayout(new BorderLayout());
        setVisible(true);

        display = new TextField(50);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        display.setSize(500, 500);
        display.setBackground(Color.LIGHT_GRAY);

        panel = new Panel();
        panel.setLayout(new GridLayout(4, 4, 20, 10));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setSize(a,b);
        }

        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        eqButton = new Button("=");
        clrButton = new Button("C");

        addButton.setBackground(Color.BLACK);
        subButton.setBackground(Color.BLACK);
        mulButton.setBackground(Color.BLACK);
        divButton.setBackground(Color.BLACK);
       


        addButton.setForeground(Color.WHITE);
        subButton.setForeground(Color.WHITE);
        mulButton.setForeground(Color.WHITE);
        divButton.setForeground(Color.WHITE);

        eqButton.setBackground(Color.ORANGE);
        clrButton.setBackground(Color.GREEN);
        eqButton.setForeground(Color.WHITE);
        clrButton.setForeground(Color.WHITE);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        add(panel, BorderLayout.CENTER);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
        } else {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
