package Temperatura;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

public class ConversorDeTemperatura {

    private static final String MENSAGEM_INSIRA_TEMPERATURA = "Insira uma temperatura: ";
    private static final String MENSAGEM_VALOR_INVALIDO = "Valor inválido";
    private static final String MENSAGEM_ESCOLHA_TIPO_CONVERSAO = "Escolha um tipo de conversão";
    private static final String TITULO_TEMPERATURAS = "Temperaturas";
    private static final String MENSAGEM_O_VALOR_DA_CONVERSAO_E_DE = "O valor da conversão é de ";

    public static void conversorTemperatura(){
        double temperatura = solicitarTemperatura();
        TipoConversaoTemperatura tipoConversao = tipoConversao();

        double valorConvertido = realizarConversaoTemperatura(temperatura, tipoConversao);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMaximumFractionDigits(1);
        String valorFormatado = nf.format(valorConvertido);

        JOptionPane.showMessageDialog(
                null,
                MENSAGEM_O_VALOR_DA_CONVERSAO_E_DE + valorFormatado + tipoConversao.getSímbolo() + "°");
    }

    private static double solicitarTemperatura(){
        double temperatura = 0;
        boolean entradaValida = false;
        do {
            try {
                String temperaturaString = JOptionPane.showInputDialog(MENSAGEM_INSIRA_TEMPERATURA);
                temperatura = Double.parseDouble(temperaturaString);
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, MENSAGEM_VALOR_INVALIDO);
            }
        } while (!entradaValida);
        return temperatura;
    }

    private static TipoConversaoTemperatura tipoConversao(){
        TipoConversaoTemperatura[] escalas = TipoConversaoTemperatura.values();
        String[] opcoes = new String[escalas.length];

        for(int i=0; i<escalas.length; i++){
            opcoes[i] = escalas[i].getDescricao();
        }

        String selecionado = null;
        TipoConversaoTemperatura tipoSelecionado = null;
        do{
            selecionado = (String) JOptionPane.showInputDialog(
                    null,
                    MENSAGEM_ESCOLHA_TIPO_CONVERSAO,
                    TITULO_TEMPERATURAS,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );
            if(selecionado != null){
                tipoSelecionado = TipoConversaoTemperatura.fromDescricao(selecionado);
            }
        }while(tipoSelecionado == null);
        return tipoSelecionado;
    }

    private static double realizarConversaoTemperatura(double temperatura, TipoConversaoTemperatura tipoConversao){
        return tipoConversao.converter(temperatura);
    }
}
