package tech.ada.locadora.modelo.veiculo;

import tech.ada.locadora.grupo_veiculo.GrupoVeiculo;

import java.math.BigDecimal;

public abstract class Veiculo {

    protected int id;
    protected String placa;
    protected String modelo;
    protected String marca;
    protected int anoFabricacao;
    protected Boolean disponivel;
    protected GrupoVeiculo grupoVeiculo;

    public Veiculo(int id, String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoVeiculo grupoVeiculo) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.disponivel = disponivel;
        this.grupoVeiculo = grupoVeiculo;
    }

    public abstract BigDecimal getPrecoGrupo();


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacao() {return anoFabricacao;}

    public void setAnoFabricacao(int anoFabricacao) {this.anoFabricacao = anoFabricacao;}

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public GrupoVeiculo getGrupoVeiculo() {return grupoVeiculo;}

    public void setGrupoVeiculo(GrupoVeiculo grupoVeiculo) {
        this.grupoVeiculo = grupoVeiculo;
    }
}
