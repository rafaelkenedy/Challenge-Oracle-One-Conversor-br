package Utils;

import javax.swing.JOptionPane;

public class Mensagens {
    private static void mostrarMensagem(String mensagem){
        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Menu",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void programaFinalizado(){
        mostrarMensagem("Programa Finalizado");
    }

    public static void programaConcluido(){
        mostrarMensagem("Programa Concluído");
    }
}
