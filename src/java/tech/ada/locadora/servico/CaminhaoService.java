package tech.ada.locadora.servico;

import tech.ada.locadora.modelo.veiculo.Caminhao;

import java.util.ArrayList;
import java.util.List;

public class CaminhaoService implements VeiculoService<Caminhao> {

    private List<Caminhao> caminhaoRepository = new ArrayList<>();
    @Override
    public Caminhao cadastrar(Caminhao caminhao) {
        caminhaoRepository.add(caminhao);
        return caminhao;
    }

    @Override
    public Caminhao alterar(Caminhao caminhao) {
        for (int i = 0; i < caminhaoRepository.size(); i++) {
            if (caminhaoRepository.get(i).getId() == caminhao.getId()) {
                caminhaoRepository.set(i, caminhao);
                return caminhao;
            }
        }
        return null;
    }

    @Override
    public Caminhao buscarPorNome(String nome) {
        for(Caminhao caminhao : caminhaoRepository) {
            if(caminhao.getModelo().equalsIgnoreCase(nome)) {
                return caminhao;
            }
        }
        return null;
    }

    @Override
    public List<Caminhao> listar() {
        return new ArrayList<>(caminhaoRepository);
    }

    @Override
    public void remover(Caminhao caminhao) {
        caminhaoRepository.remove(caminhao);
    }
}
