import java.util.ArrayList;
import java.util.List;

public class Conta {

    private String agencia;
    private String banco;
    private String numeroConta;
    private double saldo;
    private List<Transacao> transacoes;

    public Conta() {

    }

    public Conta(String agencia, String banco, String numeroConta) {
        this.agencia = agencia;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.saldo = 0;
        this.transacoes = new ArrayList<>();
    }

    public void imprimeExtrato() {
        for (int i = 0; i <= transacoes.size(); i++) {
            double saldoFinal = 0;
            if (transacoes.get(i).getTipo().equals("Receita")) {
                saldoFinal = this.getSaldo() + transacoes.get(i).getValor();
            } else if (transacoes.get(i).getTipo().equals("Despesa")) {
                saldoFinal = this.getSaldo() - transacoes.get(i).getValor();
            }
            this.saldo = saldoFinal;

            System.out.println(transacoes.get(i).toString() +
                    "| Saldo Final: " + transacoes.get(i) );
        }
    }


    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Transacao transacao) {
        this.transacoes.add(transacao);
        if (transacao.getTipo().equalsIgnoreCase("receita")) {
            setSaldo(getSaldo() + transacao.getValor());
        } else {
            setSaldo(getSaldo() - transacao.getValor());
        }
    }

}