package entidades.ENUM;

public enum MetodoDeAvaliacao {
    MEDIA_SIMPLES(1),
    MEDIA_PONDERADA(2);

    private int code;

    private MetodoDeAvaliacao(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MetodoDeAvaliacao valueOf(int code) {
        for (MetodoDeAvaliacao value : MetodoDeAvaliacao.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo para Metodo de Avaliação Invalido");
    }

}
