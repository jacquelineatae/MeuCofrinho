package entity;

import service.ConversorMoedaService;

public class MoedaEuro extends Moeda {
    private double quantidade;

    public MoedaEuro(double quantidade) {
        super(Tipo.EURO);
        this.quantidade = quantidade;
    }

    @Override
    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}