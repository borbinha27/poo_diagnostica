package model;

public class Conta_poupanca extends Conta {
    @Override
    public void atualiza(double taxa) {
        super.atualiza(taxa * 3);
    }

    @Override
    public String getTipo() {
        return "Conta Poupança";
    }
}
