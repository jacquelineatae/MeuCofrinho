package cofrinho;

import moedas.Moeda;
import moedas.MoedaDolar;
import moedas.MoedaEuro;
import moedas.MoedaReal;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    private List<Moeda> moedas;

    private ConversorDolarService conversorDolarService;
    private ConversorEuroService conversorEuroService;
    private ConversorReal conversorReal;

    public Cofrinho(ConversorDolarService conversorDolarService, ConversorEuroService conversorEuroService, ConversorReal conversorReal) {
        moedas = new ArrayList<>();
        // Inicialize os conversores de moeda
        this.conversorDolarService = conversorDolarService;
        this.conversorEuroService = conversorEuroService;
        this.conversorReal = conversorReal;
    }

    public void adicionarMoeda(double quantidade, int tipoMoeda) {
        Moeda moeda;
        switch (tipoMoeda) {
            case 1:
                // Ao adicionar uma moeda, passe o conversor de moeda correspondente
                moeda = new MoedaDolar(quantidade, conversorDolarService);
                break;
            case 2:
                moeda = new MoedaEuro(quantidade, conversorEuroService);
                break;
            case 3:
                moeda = new MoedaReal(quantidade, conversorReal);
                break;
            default:
                System.out.println("Tipo de moeda inválido.");
                return;
        }
        moedas.add(moeda);
        System.out.println("Moeda adicionada com sucesso!");
    }


    public void removerMoeda(double quantidade, int tipoMoeda) {
        for (Moeda moeda : moedas) {
            if (moeda.getTipo() == tipoMoeda) {
                if (quantidade <= moeda.getQuantidade()) {
                    moeda.setQuantidade(moeda.getQuantidade() - quantidade);
                    System.out.println("Moeda removida com sucesso!");
                    return;
                } else {
                    System.out.println("Quantidade de moeda insuficiente para remover.");
                    return;
                }
            }
        }
        System.out.println("Tipo de moeda não encontrado.");
    }

    public void listarMoedas() {
        System.out.println("Moedas no cofrinho:");
        Map<String, Double> valoresPorMoeda = new HashMap<>();

        // Agrupar os valores por tipo de moeda
        for (Moeda moeda : moedas) {
            String descricao = moeda.getDescricao();
            double quantidade = moeda.getQuantidade();

            // Se já houver valor para essa moeda, adicione ao valor existente
            if (valoresPorMoeda.containsKey(descricao)) {
                double valorAtual = valoresPorMoeda.get(descricao);
                valoresPorMoeda.put(descricao, valorAtual + quantidade);
            } else {
                valoresPorMoeda.put(descricao, quantidade);
            }
        }

        // Exibir as moedas agrupadas
        for (Map.Entry<String, Double> entry : valoresPorMoeda.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }


    public void calcularSaldo() {
        double saldo = 0.0;
        for (Moeda moeda : moedas) {
            saldo += moeda.getQuantidade() * moeda.getValor();
        }
        System.out.println("Total do dinheiro no cofrinho convertido para Real: R$" + saldo);
    }

}

