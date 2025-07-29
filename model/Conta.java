package model;

public abstract class Conta {
    protected double saldo;

    public void depositar(double valor) throws Operacao_exception {
        if (valor <= 0) {
            throw new Operacao_exception("Valor de depósito inválido: " + valor);
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws Operacao_exception {
        if (valor <= 0) {
            throw new Operacao_exception("Valor de saque inválido: " + valor);
        }
        if (saldo < valor) {
            throw new Operacao_exception("Saldo insuficiente para saque. Saldo: " + saldo + ", Saque: " + valor);
        }
        this.saldo -= valor;
    }

    public void transferir(double valor, Conta destino) throws Operacao_exception {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa;
    }

    public abstract String getTipo();
}
