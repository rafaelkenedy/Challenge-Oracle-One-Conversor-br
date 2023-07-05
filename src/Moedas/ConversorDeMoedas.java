package Moedas;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class ConversorDeMoedas {

    private static final int NEW_SCALE = 2;
    private static final String TITULO_MOEDAS = "Moedas";
    private static final String TITULO_VALOR_INVALIDO = "Valor inválido";
    private static final String MENSAGEM_INSIRA_VALOR = "Insira um valor: ";
    private static final String MENSAGEM_ESCOLHA_MOEDA = "Escolha a moeda para qual você deseja converter seu dinheiro";
    private static final String MENSAGEM_O_VALOR_DA_CONVERSAO_E_DE = "O valor da conversão é de ";

    public static void conversorMoedas() {
        BigDecimal valorMonetario = solicitarValorMonetario();
        TipoConversaoMoeda tipoMoeda = tipoConversao();

        BigDecimal valorConvertido = valorMonetario.multiply(tipoMoeda.getTaxaConversao())
                .setScale(NEW_SCALE, RoundingMode.HALF_UP);

        JOptionPane.showMessageDialog(
                null,
                MENSAGEM_O_VALOR_DA_CONVERSAO_E_DE + tipoMoeda.getSimbolo() + valorConvertido);
    }

    private static BigDecimal solicitarValorMonetario() {
        BigDecimal valorMonetario = null;
        boolean entradaValida = false;
        do {
            try {
                String valorString = JOptionPane.showInputDialog(MENSAGEM_INSIRA_VALOR);
                valorMonetario = new BigDecimal(valorString);
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, TITULO_VALOR_INVALIDO, TITULO_MOEDAS, JOptionPane.ERROR_MESSAGE);
            }
        } while (!entradaValida);
        return valorMonetario;
    }

    private static TipoConversaoMoeda tipoConversao() {
        TipoConversaoMoeda[] moedas = TipoConversaoMoeda.values();

        String[] descricoes = Arrays.stream(moedas)
                .map(TipoConversaoMoeda::getDescricao)
                .toArray(String[]::new);


        String descricaoSelecionada = (String) JOptionPane.showInputDialog(
                null,
                MENSAGEM_ESCOLHA_MOEDA,
                TITULO_MOEDAS,
                JOptionPane.PLAIN_MESSAGE,
                null,
                descricoes,
                Arrays.stream(descricoes).findFirst().orElse(null)
        );
        return TipoConversaoMoeda.fromDescricao(descricaoSelecionada);
    }
}
