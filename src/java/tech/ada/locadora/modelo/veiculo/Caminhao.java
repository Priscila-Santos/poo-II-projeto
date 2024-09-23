package tech.ada.locadora.modelo.veiculo;

import tech.ada.locadora.grupo_veiculo.GrupoCaminhao;
import tech.ada.locadora.grupo_veiculo.GrupoVeiculo;

import java.math.BigDecimal;

public class Caminhao extends Veiculo  {

    //private BigDecimal valor = new BigDecimal("200");
    private GrupoCaminhao valor;

    public Caminhao(int id, String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoVeiculo grupoVeiculo, GrupoCaminhao valor) {
        super(id, placa, modelo, marca, anoFabricacao, disponivel, grupoVeiculo);
        this.valor = valor;
    }

    @Override
    public BigDecimal getPrecoGrupo() {
        return valor.getValor();
    }

}
