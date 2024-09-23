package tech.ada.locadora.repository;

import tech.ada.locadora.grupo_veiculo.GrupoVeiculo;
import tech.ada.locadora.modelo.veiculo.Veiculo;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepositoryImpl<T extends Veiculo> extends VeiculoReposity<T> {

    private static final String FILE_NAME = "./veiculos.txt";

    @Override
    public T salvar(T veiculo) {
        try(BufferedWriter escrever = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            escrever.write(veiculoToString(veiculo));
            escrever.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return veiculo;
    }

    @Override
    public List<T> todos() {
        List<T> veiculos = new ArrayList<>();
        try(BufferedReader ler = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = ler.readLine()) != null){
                veiculos.add(stringToVeiculo(linha));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return veiculos;
    }

    @Override
    public T alterar(T veiculo) {
        List<T> veiculos = todos();
        for(int i = 0; i < veiculos.size(); i++) {
            if(veiculos.get(i).getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
                veiculos.set(i, veiculo);
                break;
            }
        }
        salvarTodos(veiculos);
        return veiculo;
    }

    @Override
    public Optional<T> buscarPor(String placa) {
        return todos()
                .stream()
                .filter(veiculo -> placa.equalsIgnoreCase(veiculo.getPlaca())).findFirst();
    }

    private void salvarTodos(List<T> veiculos) {
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (T veiculo : veiculos) {
                escrever.write(veiculoToString(veiculo));
                escrever.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String veiculoToString(T veiculo) {
        return veiculo.getId() + "," +
                veiculo.getPlaca() + "," +
                veiculo.getModelo() + "," +
                veiculo.getMarca() + "," +
                veiculo.getAnoFabricacao() + "," +
                veiculo.getDisponivel() + "," +
                veiculo.getGrupoVeiculo();
    }

    private T stringToVeiculo(String line) {
        String[] parts = line.split(",");
        return (T) new Veiculo(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                parts[3],
                Integer.parseInt(parts[4]),
                Boolean.parseBoolean(parts[5]),
                GrupoVeiculo.valueOf(parts[6])
        ) {
            @Override
            public BigDecimal getPrecoGrupo() {
                return null;
            }
        };
    }

}
