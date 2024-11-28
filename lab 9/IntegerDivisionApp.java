import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivisionApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Integer Division Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel labelNum1 = new JLabel("Num1:");
        JTextField textNum1 = new JTextField(10);
        
        JLabel labelNum2 = new JLabel("Num2:");
        JTextField textNum2 = new JTextField(10);
        
        JButton buttonDivide = new JButton("Divide");
        JLabel labelResult = new JLabel("Result: ");
        JTextField textResult = new JTextField(10);
        textResult.setEditable(false);
        
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(labelNum1);
        panel.add(textNum1);
        panel.add(labelNum2);
        panel.add(textNum2);
        panel.add(buttonDivide);
        panel.add(labelResult);
        panel.add(textResult);

        frame.add(panel);

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String num1Str = textNum1.getText();
                    String num2Str = textNum2.getText();
                    
                    int num1 = Integer.parseInt(num1Str);
                    int num2 = Integer.parseInt(num2Str);

                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }

                    int result = num1 / num2;
                    textResult.setText(String.valueOf(result));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter valid integers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
