/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ventaboletos;

import javax.swing.JOptionPane;

/**
 *
 * @author 701
 */
public class VentaBoletos {

    static int[] salas = {50, 20, 20, 50, 20, 50, 150};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String opc;
        int sala, boletos;
        do {
            try {
                opc = JOptionPane.showInputDialog(null, "", "", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[]{"Venta de boletos", "Cerrar taquilla"}, "Venta de boletos").toString();
            } catch (NullPointerException e) {
                opc = "";
            }
            switch (opc) {
                case "Venta de boletos" -> {
                    sala = (int) JOptionPane.showInputDialog(null, "¿Que sala quieres?", "Menú", JOptionPane.QUESTION_MESSAGE, null, new Object[]{1, 2, 3, 4, 5, 6, 7}, 1);

                    try {
                        boletos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos boletos quieres?\nBoletos disponibles para la sala" + sala + ": " + (salas[sala - 1]), "1"));
                        if (salas[sala - 1] == 0) {
                            throw new SinLugar("Ya no hay lugar");
                        } else if (boletos > salas[sala - 1]) {
                            throw new SinLugar("No hay asientos suficientes");
                        } else {

                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingresa un numero");
                    } catch (SinLugar e1) {

                    }
                }
                case "Cerrar taquilla" -> {
                    JOptionPane.showMessageDialog(null, "Gracias c:");
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "UnU");
                }
            }
        } while (true);
    }
}

class SinLugar extends Exception {

    public SinLugar(String message) {
        super(message);
    }

}
