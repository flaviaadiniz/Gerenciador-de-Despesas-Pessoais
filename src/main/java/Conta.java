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
        System.out.println(this);
    }

    public void mesclarContas(Conta conta1, Conta conta2) {
        for (Transacao t : conta2.getTransacoes()) {
            conta1.setTransacoes(t);
        }

        System.out.println("Lista de transações das duas contas:");
        for (Transacao t : conta1.getTransacoes()) {
            System.out.println(t);
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
            this.setSaldo(getSaldo() + transacao.getValor());
        } else {
            this.setSaldo(getSaldo() - transacao.getValor());
        }
    }

    @Override
    public String toString() {
        return "CONTA - " +
                "Agência: " + agencia +
                " | Banco: " + banco +
                " | Número da Conta: " + numeroConta +
                " | Saldo: " + saldo +
                " | Transações: " + transacoes;
    }
}