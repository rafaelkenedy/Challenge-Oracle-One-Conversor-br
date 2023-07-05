import javax.swing.JOptionPane;

import static Moedas.ConversorDeMoedas.conversorMoedas;
import static Temperatura.ConversorDeTemperatura.conversorTemperatura;
import static Utils.Continuar.desejaContinuar;
import static Utils.Mensagens.programaFinalizado;

public class Main {
    private static final String MENU_TITLE = "Menu";
    private static final String MENU_PROMPT = "Escolha uma opção";
    private static final String OPTION_MOEDA = "Conversor de Moeda";
    private static final String OPTION_TEMPERATURA = "Conversor de Temperatura";

    public static void main(String[] args) {
        String[] conversorOptions = {OPTION_MOEDA, OPTION_TEMPERATURA};
        boolean continuar;

        do {
            String conversorSelecionado = (String) JOptionPane.showInputDialog(
                    null,
                    MENU_PROMPT,
                    MENU_TITLE,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    conversorOptions,
                    conversorOptions[0]
            );

            continuar = processSelection(conversorSelecionado);

        } while (continuar);
    }

    private static boolean processSelection(String conversorSelecionado) {
        if (conversorSelecionado == null) {
            programaFinalizado();
            return false;
        }

        if (conversorSelecionado.equals(OPTION_MOEDA)) {
            conversorMoedas();
        } else if (conversorSelecionado.equals(OPTION_TEMPERATURA)) {
            conversorTemperatura();
        }

        return desejaContinuar();
    }
}
