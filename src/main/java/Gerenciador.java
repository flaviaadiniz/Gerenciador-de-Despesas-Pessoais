import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Conta> contas = new ArrayList<>();
        int opcao;

        contas.add(new Conta("9876", "Santander", "123"));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-01-05"), "receita",
                "Salário", "Salário de fevereiro", 4500));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-02-07"), "despesa",
                "Academia", "Academia de fevereiro", 297));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-02-26"), "receita",
                "Venda Celular", "Venda do meu celular", 2500));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-03-10"), "despesa",
                "Plano de Saúde", "Plano de saúde Março", 700));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-03-12"), "receita",
                "Salário", "Salário de Março", 4500));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-04-01"), "despesa",
                "Academia", "Academia de abril", 297));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-04-29"), "receita",
                "Aulas particulares", "Aulas particulares em abril", 2000));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-05-04"), "despesa",
                "Veterinário", "Consulta do Brooklyn", 150));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-06-01"), "despesa",
                "Supermercado", "Compras de mercado", 250));
        contas.get(0).setTransacoes(new Transacao(LocalDate.parse("2023-06-10"), "despesa",
                "Cinema", "Cinema em junho", 60));

        contas.add(new Conta("9876", "Santander", "234"));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-01-05"), "receita",
                "Salário", "Salário de fevereiro", 6500));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-02-07"), "despesa",
                "Academia", "Academia de fevereiro", 400));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-02-26"), "receita",
                "PLR", "Participação Lucros Empresa", 1000));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-03-10"), "despesa",
                "Plano de Saúde", "Plano de saúde Março", 800));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-03-12"), "receita",
                "Salário", "Salário de Março", 6500));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-04-01"), "despesa",
                "Academia", "Academia de abril", 400));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-06-01"), "receita",
                "Venda Título Clube", "Venda do título do clube", 5000));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-05-04"), "despesa",
                "Viagem", "Viagem para São Paulo", 4700));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-06-01"), "despesa",
                "Supermercado", "Compras de mercado", 300));
        contas.get(1).setTransacoes(new Transacao(LocalDate.parse("2023-06-12"), "despesa",
                "Restaurante", "Jantar dia dos namorados", 250));


        do {

            System.out.println("\nBem vinda ao gerenciador de despesas pessoais!");
            System.out.println("Digite o número da opção desejada: ");
            System.out.println("1 - GERENCIAR CONTAS");
            System.out.println("2 - GERENCIAR TRANSAÇÕES");
            System.out.println("3 - PAINEL GERAL");
            System.out.println("4 - ENCERRAR O PROGRAMA");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite 1 para cadastrar uma conta.");
                    System.out.println("Digite 2 para remover uma conta.");
                    System.out.println("Digite 3 para mesclar contas.");
                    int opcaoConta = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoConta == 1) {
                        contas.add(criarConta());

                    } else if (opcaoConta == 2) {
                        System.out.println("ATENÇÃO! Todos os dados da conta serão removidos! Deseja prosseguir?");
                        System.out.print("Digite S (sim) ou N (não): ");
                        String decisao = scanner.nextLine();
                        if (decisao.equalsIgnoreCase("S")) {
                            System.out.println("Digite o número da conta que deseja remover: ");
                            String contaRemover = scanner.nextLine();
                            for (int i = 0; i < contas.size(); i++) {
                                if (contas.get(i).getNumeroConta().equals(contaRemover)) {
                                    contas.remove(contas.get(i));
                                    System.out.println("Conta removida com sucesso!");
                                    break;
                                }
                            }
                        }
                    } else if (opcaoConta == 3) {
                        Conta conta1 = new Conta();
                        System.out.print("Digite o número da primeira conta a mesclar: ");
                        String numConta1 = scanner.nextLine();
                        for (Conta conta : contas) {
                            if (conta.getNumeroConta().equals(numConta1)) {
                                conta1 = conta;
                            }
                        }

                        Conta conta2 = new Conta();
                        System.out.print("Digite o número da segunda conta a mesclar: ");
                        String numConta2 = scanner.nextLine();
                        for (Conta conta : contas) {
                            if (conta.getNumeroConta().equals(numConta2)) {
                                conta2 = conta;
                            }
                        }

                        contas.get(contas.indexOf(conta1)).mesclarContas(conta1, conta2);

                    }
                    break;

                case 2:
                    System.out.print("Digite a conta desejada: ");
                    String numConta = scanner.nextLine();
                    Conta conta = new Conta();

                    for (Conta c : contas) {
                        if (c.getNumeroConta().equals(numConta)) {
                            conta = c;
                        }
                    }

                    System.out.println("Digite 1 para ver o extrato da conta.");
                    System.out.println("Digite 2 para incluir uma transação.");
                    System.out.println("Digite 3 para editar a última transação realizada.");
                    System.out.println("Digite 4 para transferir fundos.");
                    int opcaoTransacao = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoTransacao == 1) {
                        contas.get(contas.indexOf(conta)).imprimeExtrato();

                    } else if (opcaoTransacao == 2) {
                        System.out.print("Digite o tipo de transação (Receita ou Despesa): ");
                        String tipo = scanner.nextLine();
                        System.out.print("Digite a categoria da transação (salário, alimentação, etc): ");
                        String categoria = scanner.nextLine();
                        System.out.print("Digite uma descrição para a transação: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Digite o valor da transação: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        Transacao transacao = new Transacao(LocalDate.now(), tipo, categoria, descricao, valor);
                        conta.setTransacoes(transacao);

                        System.out.println("Extrato atualizado:");
                        conta.imprimeExtrato();

                    } else if (opcaoTransacao == 3) {
                        System.out.print("Digite o tipo de transação (Receita ou Despesa): ");
                        String tipo = scanner.nextLine();
                        System.out.print("Digite a categoria da transação (salário, alimentação, etc): ");
                        String categoria = scanner.nextLine();
                        System.out.print("Digite uma descrição para a transação: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Digite o valor da transação: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        int indiceTransacao = conta.getTransacoes().size() - 1;
                        conta.getTransacoes().get(indiceTransacao).setData(LocalDate.now());
                        conta.getTransacoes().get(indiceTransacao).setTipo(tipo);
                        conta.getTransacoes().get(indiceTransacao).setCategoria(categoria);
                        conta.getTransacoes().get(indiceTransacao).setDescricao(descricao);
                        conta.getTransacoes().get(indiceTransacao).setValor(valor);
                        System.out.println("Despesa alterada com sucesso!");
                        conta.imprimeExtrato();
                    }
                    break;

                case 3:
                    System.out.println("RESUMO DAS CONTAS");
                    double saldoTotal = 0;

                    if (!contas.isEmpty()) {
                        for (Conta c : contas) {
                            System.out.println("Conta: " + c.getNumeroConta() + " | Saldo Atual: R$" + c.getSaldo());
                            saldoTotal += c.getSaldo();
                        }

                        //Revisar esta parte (imprimir total de receitas e despesas separado por conta)
                        double totalReceita = 0;
                        for (Conta c : contas) {
                            for (Transacao t : c.getTransacoes()) {
                                if (t.getTipo().equalsIgnoreCase("receita") &&
                                        t.getData().getMonth().equals(LocalDate.now().getMonth())) {
                                    totalReceita += t.getValor();
                                }
                            }
                        }
                        System.out.println("Total de Receitas do mês atual: R$" + totalReceita);

                        double totalDespesa = 0;
                        for (Conta c : contas) {
                            for (Transacao t : c.getTransacoes()) {
                                if (t.getTipo().equalsIgnoreCase("despesa") &&
                                        t.getData().getMonth().equals(LocalDate.now().getMonth())) {
                                    totalDespesa += t.getValor();
                                }
                            }
                        }
                        System.out.println("Total de Despesas do mês atual: R$" + totalDespesa);

                        //Revisar esta parte
                        System.out.println("\nSALDO GERAL DOS ÚLTIMOS 6 MESES: ");
                        double saldoSeisMeses = 0;
                        LocalDate currentDate = LocalDate.now();
                        LocalDate beginingDate = currentDate.minusMonths(6);

                        for (Conta c : contas) {
                            for (Transacao t : c.getTransacoes()) {
                                if (t.getData().isAfter(beginingDate)) {
                                    if (t.getTipo().equalsIgnoreCase("receita")) {
                                        saldoSeisMeses += t.getValor();
                                    } else {
                                        saldoSeisMeses -= t.getValor();
                                    }
                                }
                            }
                            System.out.println("Conta: " + c.getNumeroConta() + " | Balanço de todas as transações dos últimos" +
                                    " 6 meses: R$"+ saldoSeisMeses);
                        }

                    } else {
                        System.out.println("Não há contas registradas!");
                    }
            }

        } while (opcao != 4);

        scanner.close();
    }

    public static Conta criarConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVamos cadastrar uma conta! Digite os dados solicitados: ");
        System.out.print("Nome do Banco: ");
        String banco = scanner.nextLine();
        System.out.print("Número da Agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Número da conta: ");
        String numConta = scanner.nextLine();
        System.out.println("Conta criada com sucesso!");
        return new Conta(banco, agencia, numConta);
    }

}
