package Utils;

import javax.swing.JOptionPane;

public class Continuar {
    public static boolean desejaContinuar() {
        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja continuar?",
                "Continuar?",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
        switch (resposta) {
            case JOptionPane.YES_OPTION:
                return true;
            case JOptionPane.NO_OPTION:
                Mensagens.programaFinalizado();
                return false;
            default:
                Mensagens.programaConcluido();
                return false;
        }
    }
}
