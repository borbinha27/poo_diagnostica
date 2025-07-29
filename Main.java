import controller.Banco_controller;
import model.*;
import view.Banco_view;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Conta conta_comum = new Conta() {
            @Override
            public String getTipo() {
                return "Conta Comum";
            }
        };

        Conta conta_corrente = new Conta_corrente();
        Conta conta_poupanca = new Conta_poupanca();

        List<Conta> contas = List.of(conta_comum, conta_corrente, conta_poupanca);
        Banco_view view = new Banco_view();
        Banco_controller controller = new Banco_controller(view, contas);
        controller.executar(0.01); // Selic de 1%
        
    }
}
