package entity;

import service.ConversorMoedaService;

public class MoedaDolar extends Moeda {
    private double quantidade;

    public MoedaDolar(double quantidade) {
        super(Tipo.DOLAR);
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