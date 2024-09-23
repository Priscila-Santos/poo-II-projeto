import tech.ada.locadora.grupo_veiculo.GrupoCaminhao;
import tech.ada.locadora.grupo_veiculo.GrupoCarro;
import tech.ada.locadora.grupo_veiculo.GrupoVeiculo;
import tech.ada.locadora.modelo.veiculo.Caminhao;
import tech.ada.locadora.modelo.veiculo.Carro;
import tech.ada.locadora.modelo.veiculo.Veiculo;
import tech.ada.locadora.repository.VeiculoRepositoryImpl;
import tech.ada.locadora.servico.VeiculoService;
import tech.ada.locadora.servico.VeiculoServiceImpl;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) throws Exception {


        VeiculoRepositoryImpl<Veiculo> veiculoRepository = new VeiculoRepositoryImpl<>();

        // Criando e salvando veículos
        Veiculo caminhao1 = new Caminhao(1, "ABC1234", "Modelo1", "Marca1", 2020, true, GrupoVeiculo.CAMINHAO, GrupoCaminhao.LEVE);
        Veiculo caminhao2 = new Caminhao(2, "DEF5678", "Modelo2", "Marca2", 2021, false, GrupoVeiculo.CAMINHAO, GrupoCaminhao.PESADO);
        //Veiculo carro1 = new Carro(3, "ABC123", "UNO", "FIAT", 2005,true, GrupoVeiculo.CARRO, GrupoCarro.EXECUTIVO);

        veiculoRepository.salvar(caminhao1);
        veiculoRepository.salvar(caminhao2);

        // Listando todos os veículos
        List<Veiculo> veiculos = veiculoRepository.todos();
        System.out.println("Todos os veículos:");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculoToString(veiculo));
        }

        // Buscando um veículo por placa
        Optional<Veiculo> veiculoBuscado = veiculoRepository.buscarPor("ABC1234");
        veiculoBuscado.ifPresent(veiculo -> System.out.println("Veículo encontrado: " + veiculoToString(veiculo)));

        // Alterando um veículo
        caminhao1.setModelo("Modelo1 Alterado");
        veiculoRepository.alterar(caminhao1);

        // Listando todos os veículos após alteração
        veiculos = veiculoRepository.todos();
        System.out.println("Todos os veículos após alteração:");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculoToString(veiculo));
        }
    }


    private static String veiculoToString(Veiculo veiculo) {
        return "ID: " + veiculo.getId() +
                ", Placa: " + veiculo.getPlaca() +
                ", Modelo: " + veiculo.getModelo() +
                ", Marca: " + veiculo.getMarca() +
                ", Ano de Fabricação: " + veiculo.getAnoFabricacao() +
                ", Disponível: " + veiculo.getDisponivel() +
                ", Grupo de Veículo: " + veiculo.getGrupoVeiculo();
    }

       /* VeiculoService<Carro> carroService = new VeiculoServiceImpl();
        Carro ferrari = new Carro("XPTO1234", "F10", "Ferrari", true);
        Carro uno = new Carro("UNOO6789", "UNICO", "Fiat", false);
        carroService.cadastrar(ferrari);
        carroService.cadastrar(uno);

        System.out.println("ANTES");
        carroService.listar().stream().forEach(System.out::println);

        uno.setDisponivel(true);
        uno.setModelo("87");
        carroService.alterar(uno);

        System.out.println("DEPOIS");
        carroService.listar().stream().forEach(System.out::println);*/

}
