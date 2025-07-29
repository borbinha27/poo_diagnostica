package controller;

import model.*;
import view.Banco_view;

import java.util.List;

public class Banco_controller {
    private final Banco_view view;
    private final List<Conta> contas;

    public Banco_controller(Banco_view view, List<Conta> contas) {
        this.view = view;
        this.contas = contas;
    }

    public void executar(double selic) {
        view.exibirMensagem("Depósitos Iniciais:");
        for (Conta conta : contas) {
            try {
                conta.depositar(1000);
                view.exibirMensagem(conta.getTipo() + " - Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            } catch (Operacao_exception e) {
                view.exibirMensagem("Erro ao depositar em " + conta.getTipo() + ": " + e.getMessage());
            }
        }

        view.exibirLinha();
        view.exibirMensagem("Atualização das contas (Selic: " + selic + ")");
        view.exibirLinha();

        Atualizador_de_contas atualizador = new Atualizador_de_contas(selic);
        for (Conta conta : contas) {
            atualizador.roda(conta);
        }

        view.exibirLinha();
        view.exibirMensagem("Saldo total no banco: R$ " + String.format("%.2f", atualizador.getSaldoTotal()));
    }
}
