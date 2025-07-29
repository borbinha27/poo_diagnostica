package model;

public class Atualizador_de_contas {
    private double saldoTotal = 0;
    private final double selic;

    public Atualizador_de_contas(double selic) {
        this.selic = selic;
    }

    public void roda(Conta conta) {
        System.out.printf("[%s]%n", conta.getTipo());
        System.out.printf("Saldo anterior: R$ %.2f%n", conta.getSaldo());
        conta.atualiza(this.selic);
        System.out.printf("Saldo atualizado: R$ %.2f%n%n", conta.getSaldo());
        this.saldoTotal += conta.getSaldo();
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }
}
