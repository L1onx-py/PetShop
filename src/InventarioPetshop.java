import java.util.ArrayList;
import java.util.List;

public class InventarioPetshop {
    private List<ServicoPetshop> servico = new ArrayList<>();

    public void adicionaServico(ServicoPetshop servicosPetshop){
        servico.add(servicosPetshop);
    }

    public double calculaValorServico() {
        double valorTotal = 0;
        for (ServicoPetshop s : servico){
            valorTotal += s.calculaPreco();
        }
        return valorTotal;
    }

    public String listaServicos() {
        String servicos = "";
        for (ServicoPetshop s : servico){
            servicos += s.descricao() + "\n";
        }
        return servicos;
    }

    public String descricaoServico(ServicoPetshop servico){
        return servico.descricao();
    }

}