package tech.ada.locadora.modelo.veiculo;

import tech.ada.locadora.grupo_veiculo.GrupoVeiculo;

import java.math.BigDecimal;

public class Carro extends Veiculo {

    private BigDecimal valor = new BigDecimal("150");

    public Carro(int id, String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoVeiculo grupoVeiculo, BigDecimal valor) {
        super(id, placa, modelo, marca, anoFabricacao, disponivel, grupoVeiculo);
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "valor=" + valor +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }

    @Override
    public BigDecimal getPrecoGrupo() {
        return null;
    }
}
