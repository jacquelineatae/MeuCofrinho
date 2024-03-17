package entity;

import service.ConversorMoedaService;

public abstract class Moeda {
    public enum Tipo {
        DOLAR, EURO, REAL
    }

    protected Tipo tipo;

    public Moeda(Tipo tipo) {
        this.tipo = tipo;
    }

    public abstract double getQuantidade();
    public abstract void setQuantidade(double quantidade);

    public double converterPara(Moeda moedaDestino, ConversorMoedaService conversorMoedaService) {
        return conversorMoedaService.converter(getQuantidade(), this, moedaDestino);
    }

    public Tipo getTipo() {
        return tipo;
    }
}