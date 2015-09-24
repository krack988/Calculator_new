
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator implements ActionListener {
    double rezult=0, x1=0,x2;
    char symbol;
    JFrame myFrame = new JFrame("My Calculator");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JTextField text = new JTextField(25);
    JButton[] button = new JButton[10];
    JButton buttonC = new JButton("C");
    JButton buttonEqual = new JButton("=");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonMultiply = new JButton("*");
    JButton buttonDivide = new JButton("/");
    JButton buttonPoint = new JButton(".");
    JButton buttonFact = new JButton("!n");
    JButton buttonFibonachi = new JButton("Fib");
    JButton buttonSin = new JButton("Sin");
    JButton buttonCos = new JButton("Cos");


    public Calculator() {
        myFrame.setSize(250, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout border = new BorderLayout();
        myFrame.setLayout(border);
        myFrame.add("North", text);
        text.setHorizontalAlignment(JTextField.RIGHT);
        myFrame.add("Center", panel1);
        GridLayout gridNumber = new GridLayout(5, 3);
        panel1.setLayout(gridNumber);
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("" + i);
            panel1.add(button[i]);
            button[i].addActionListener(this);
        }
        panel1.add(buttonEqual);
        panel1.add(buttonPoint);
        panel1.add(buttonC);

        myFrame.add("East", panel2);
        GridLayout gridSigns = new GridLayout(5, 2);
        panel2.setLayout(gridSigns);

        panel2.add(buttonPlus);
        panel2.add(buttonMinus);
        panel2.add(buttonMultiply);
        panel2.add(buttonDivide);
        panel2.add(buttonFact);
        panel2.add(buttonFibonachi);
        panel2.add(buttonSin);
        panel2.add(buttonCos);

        buttonEqual.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonFact.addActionListener(this);
        buttonFibonachi.addActionListener(this);
        buttonSin.addActionListener(this);
        buttonCos.addActionListener(this);
        buttonC.addActionListener(this);
        buttonPoint.addActionListener(this);

        myFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        String value = text.getText();

        for (int i=0;i<10;i++){
            if (event.getActionCommand().equals(i)){
                text.setText(value+i);
                value=text.getText();
            }
        }
        if (event.getActionCommand().equals(".")) {
            text.setText(value + ".");
            value = text.getText();
        }

            if (!"".equals(value)) {
                try {
                    x1 = Double.valueOf(value);
                }catch(NumberFormatException exception1){
                    JOptionPane.showConfirmDialog(null,"Please! enter only numbers","Warning!!!",JOptionPane.PLAIN_MESSAGE);
                }
                if (event.getActionCommand().equals("C")) {
                    text.setText("");

                }
                if (event.getActionCommand().equals("+")) {
                    rezult = x1;
                    text.setText("");
                    symbol = '+';
                }
                if (event.getActionCommand().equals("-")) {
//                value = text.getText();
//                x1 = Double.valueOf(value);
                    rezult = x1;
                    text.setText("");
                    symbol = '-';
                }
                if (event.getActionCommand().equals("*")) {
//                value = text.getText();
//                x1 = Double.valueOf(value);
                    rezult = x1;
                    text.setText("");
                    symbol = '*';
                }
                if (event.getActionCommand().equals("/")) {
//                value = text.getText();
//                x1 = Double.valueOf(value);
                    rezult = x1;
                    text.setText("");
                    symbol = '/';
                }

                if (event.getActionCommand().equals("=")) {

//                value = text.getText();
//                x2 = Double.valueOf(value);
                    if (symbol == '+') {
                        rezult += x1;
                    }
                    if (symbol == '-') {
                        rezult -= x1;
                    }
                    if (symbol == '*') {
                        rezult *= x1;
                    }
                    if (symbol == '/') {
                        try {
                            rezult /= x1;
                        }catch (ArithmeticException exception_zero){
                            JOptionPane.showConfirmDialog(null, "Divide by zero", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
                        }

                    }
                    text.setText(Double.toString(rezult));
                }

                if (event.getActionCommand().equals("!n")) {
                    value = text.getText();
                    rezult = factarial(Double.valueOf(value));
                    text.setText(Double.toString(rezult));
                }
                if (event.getActionCommand().equals("Fib")) {
                    value = text.getText();
                    rezult = fibonachi(Double.valueOf(value));
                    text.setText(Double.toString(rezult));
                }
                if (event.getActionCommand().equals("Sin")) {
                    value = text.getText();
                    rezult = Math.sin(Double.valueOf(value));
                    text.setText(Double.toString(rezult));
                }
                if (event.getActionCommand().equals("Cos")) {
                    value = text.getText();
                    rezult = Math.cos(Double.valueOf(value));
                    text.setText(Double.toString(rezult));
                }

            } else
                JOptionPane.showConfirmDialog(null, "Please, enter the number", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
    }

    public double factarial(double f) {
        if (f == 1) return 1;
        return factarial(f - 1) * f;
    }

    public double fibonachi(double fib) {
        if (fib == 0) return 1;
        if (fib == 1) return 1;
        else
            return fibonachi(fib - 1) + fibonachi(fib - 2);
    }
}
