import java.awt.*;
import javax.swing.*;

public class Calculator {

    static double num1 = 0;
    static double num2 = 0;
    static String operator = "";

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setLayout(new BorderLayout());

        // Display
        JTextField display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setPreferredSize(new Dimension(350, 80));

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Buttons
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonPlus = new JButton("+");

        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonMinus = new JButton("-");

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonMultiply = new JButton("*");

        JButton button0 = new JButton("0");
        JButton buttonClear = new JButton("C");
        JButton buttonEquals = new JButton("=");
        JButton buttonDivide = new JButton("/");

        // Add buttons to panel
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);

        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMinus);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMultiply);

        panel.add(button0);
        panel.add(buttonClear);
        panel.add(buttonEquals);
        panel.add(buttonDivide);

        // Add display and panel to frame
        frame.add(display, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Number buttons
        button7.addActionListener(e ->
            display.setText(display.getText() + "7"));

        button8.addActionListener(e ->
            display.setText(display.getText() + "8"));

        button9.addActionListener(e ->
            display.setText(display.getText() + "9"));

        button4.addActionListener(e ->
            display.setText(display.getText() + "4"));

        button5.addActionListener(e ->
            display.setText(display.getText() + "5"));

        button6.addActionListener(e ->
            display.setText(display.getText() + "6"));

        button1.addActionListener(e ->
            display.setText(display.getText() + "1"));

        button2.addActionListener(e ->
            display.setText(display.getText() + "2"));

        button3.addActionListener(e ->
            display.setText(display.getText() + "3"));

        button0.addActionListener(e ->
            display.setText(display.getText() + "0"));

        // Plus
        buttonPlus.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = "+";
            display.setText("");
        });

        // Minus
        buttonMinus.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = "-";
            display.setText("");
        });

        // Multiply
        buttonMultiply.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = "*";
            display.setText("");
        });

        // Divide
        buttonDivide.addActionListener(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = "/";
            display.setText("");
        });

        // Equals
        // Bug fixing
        buttonEquals.addActionListener(e -> {

            num2 = Double.parseDouble(display.getText());

            double result = 0;

            if (operator.equals("+")) {
                result = num1 + num2;
            }

            if (operator.equals("-")) {
                result = num1 - num2;
            }

            if (operator.equals("*")) {
                result = num1 * num2;
            }

            if (operator.equals("/")) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Cannot divide by 0");
                    return;
                }
            }

            display.setText(String.valueOf(result));
        });

        // Clear
        buttonClear.addActionListener(e -> {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        });

        // Show frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}