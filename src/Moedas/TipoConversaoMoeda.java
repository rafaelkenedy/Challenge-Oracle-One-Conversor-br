package Moedas;

import java.math.BigDecimal;
public enum TipoConversaoMoeda {
    REAIS_DOLARES("De Reais a Dólares", "$", BigDecimal.valueOf(0.21)),
    REAIS_EUROS("De Reais a Euros", "€", BigDecimal.valueOf(0.19)),
    REAIS_LIBRAS("De Reais a Libras", "£", BigDecimal.valueOf(0.16)),
    REAIS_IENES("De Reais a Ienes", "¥", BigDecimal.valueOf(29.84)),
    REAIS_WON_COREANO("De Reais a Won Coreano", "₩", BigDecimal.valueOf(267.47)),
    DOLARES_REAIS("De Dólares a Reais", "R$", BigDecimal.valueOf(4.84)),
    EUROS_REAIS("De Euros a Reais", "R$", BigDecimal.valueOf(5.27)),
    LIBRAS_REAIS("De Libras a Reais", "R$", BigDecimal.valueOf(6.15)),
    IENES_REAIS("De Ienes a Reais", "R$", BigDecimal.valueOf(0.034)),
    WON_COREANO_REAIS("De Won Coreano a Reais", "R$", BigDecimal.valueOf(0.0037));

    private String descricao;
    private String simbolo;
    private BigDecimal taxaConversao;

    TipoConversaoMoeda(String descricao, String simbolo, BigDecimal taxaConversao) {
        this.descricao = descricao;
        this.simbolo = simbolo;
        this.taxaConversao = taxaConversao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public BigDecimal getTaxaConversao() {
        return taxaConversao;
    }

    public static TipoConversaoMoeda fromDescricao(String descricao) {
        for (TipoConversaoMoeda tipo : TipoConversaoMoeda.values()) {
            if (tipo.getDescricao().equals(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de conversão inválido: " + descricao);
    }
}
