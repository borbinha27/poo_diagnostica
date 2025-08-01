package model;

public class Conta_corrente extends Conta {
    @Override
    public void atualiza(double taxa) {
        super.atualiza(taxa * 2);
    }

    @Override
    public void depositar(double valor) throws Operacao_exception{
        super.depositar(valor - 0.10); // Taxa
    }

    @Override
    public String getTipo() {
        return "Conta Corrente";
    }
}
