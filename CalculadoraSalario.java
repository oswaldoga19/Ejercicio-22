// Archivo: CalculadoraSalario.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSalario extends JFrame {
    private JTextField nombreTextField;
    private JTextField salarioHoraTextField;
    private JTextField horasTrabajadasTextField;
    private JLabel resultadoLabel;

    public CalculadoraSalario() {
        setTitle("Calculadora de Salario Mensual");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nombreLabel = new JLabel("Nombre del empleado:");
        nombreTextField = new JTextField();
        JLabel salarioHoraLabel = new JLabel("Salario básico por hora:");
        salarioHoraTextField = new JTextField();
        JLabel horasTrabajadasLabel = new JLabel("Horas trabajadas en el mes:");
        horasTrabajadasTextField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel();

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreTextField.getText();
                    double salarioHora = Double.parseDouble(salarioHoraTextField.getText());
                    double horasTrabajadas = Double.parseDouble(horasTrabajadasTextField.getText());

                    double salarioMensual = salarioHora * horasTrabajadas;
                    if (salarioMensual > 450000) {
                        resultadoLabel.setText("Nombre: " + nombre + " | Salario mensual: $" + salarioMensual);
                    } else {
                        resultadoLabel.setText("Nombre: " + nombre);
                    }
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Ingresa valores válidos.");
                }
            }
        });

        panel.add(nombreLabel);
        panel.add(nombreTextField);
        panel.add(salarioHoraLabel);
        panel.add(salarioHoraTextField);
        panel.add(horasTrabajadasLabel);
        panel.add(horasTrabajadasTextField);
        panel.add(calcularButton);
        panel.add(resultadoLabel);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraSalario();
    }
}
