package Temperatura;

public enum TipoConversaoTemperatura {
    CELSIUS_PARA_FAHRENHEIT("De Celsius para Fahrenheit", 'F'){
        @Override
        public double converter(double temperatura) {
            return (temperatura * 9 / 5) + 32;
        }
    },
    FAHRENHEIT_PARA_CELSIUS("De Fahrenheit para Celsius", 'C'){
        @Override
        public double converter(double temperatura) {
            return (temperatura - 32) * 5 / 9;
        }
    };

    private final String descricao;
    private final char simbolo;

    TipoConversaoTemperatura(String descricao, char simbolo) {
        this.descricao = descricao;
        this.simbolo = simbolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public char getSímbolo() {
        return simbolo;
    }

    public abstract double converter(double temperatura);

    public static TipoConversaoTemperatura fromDescricao(String descricao) {
        for (TipoConversaoTemperatura t : values()) {
            if (t.getDescricao().equals(descricao)) {
                return t;
            }
        }
        return null;
    }
}

