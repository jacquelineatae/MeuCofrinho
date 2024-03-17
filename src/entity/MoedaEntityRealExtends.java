package entity;

import service.ConversorMoedaService;

public class MoedaReal extends Moeda {
    private double quantidade;

    public MoedaReal(double quantidade) {
        super(Tipo.REAL);
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