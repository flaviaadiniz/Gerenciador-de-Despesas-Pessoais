import java.time.LocalDate;

public class Transacao {

    private LocalDate data;
    private String tipo;
    private String categoria;
    private String descricao;
    private double valor;

    public Transacao(LocalDate data, String tipo, String categoria, String descricao, double valor) {
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[ TRANSAÇÃO - " +
                "| Data: " + data +
                " | Tipo: " + tipo +
                " | Categoria: " + categoria +
                " | Descrição: " + descricao +
                " | Valor: " + valor +
                " ] \n";
    }
}
