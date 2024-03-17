package service.conversao;

import moedas.Moeda;

public class ConversorMoedaService implements ConversorMoeda {
    @Override
    public double converter(double quantidade, Moeda moedaOrigem, Moeda moedaDestino) {
        double valorOrigem = quantidade * moedaOrigem.getValor();
        double taxaCambio = obterTaxaCambio(moedaOrigem, moedaDestino);
        return valorOrigem / taxaCambio;
    }

    private double obterTaxaCambio(Moeda moedaOrigem, Moeda moedaDestino) {
        // Implemente a lógica para obter a taxa de câmbio entre as duas moedas
        // Aqui você pode usar um mapa de taxas de câmbio pré-definido ou até mesmo fazer uma consulta a um serviço externo
        // Por simplicidade, vamos supor que as taxas de câmbio estão definidas no próprio método

        // Dólar para Real
        if (moedaOrigem instanceof MoedaDolar && moedaDestino instanceof MoedaReal) {
            return 5.3; // Exemplo de taxa de câmbio para o dólar em relação ao real
        }
        // Real para Dólar
        if (moedaOrigem instanceof MoedaReal && moedaDestino instanceof MoedaDolar) {
            return 1 / 5.3; // Inverte a taxa de câmbio para a conversão oposta
        }
        // Euro para Real
        if (moedaOrigem instanceof MoedaEuro && moedaDestino instanceof MoedaReal) {
            return 6.2; // Exemplo de taxa de câmbio para o euro em relação ao real
        }
        // Real para Euro
        if (moedaOrigem instanceof MoedaReal && moedaDestino instanceof MoedaEuro) {
            return 1 / 6.2; // Inverte a taxa de câmbio para a conversão oposta
        }
        // Adicione mais lógica para outras conversões de moeda, se necessário

        // Caso nenhuma correspondência seja encontrada, retorne 1, o que significa que as moedas são iguais
        return 1.0;
    }
}
