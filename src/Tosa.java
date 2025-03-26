public class Tosa extends ServicoPetshop {

    public Tosa(int codigo, Tamanho tamAnimal, String descricao){
        super(codigo,tamAnimal);
    }

    @Override
    public Double calculaPreco() {
        return switch (getTamAnimal()) {
            case PEQUENO -> 30.00;
            case MEDIO -> 40.00;
            case GRANDE -> 50.00;
        };
    }

    @Override
    public String descricao() {
        return "Serviço Realizado: Tosa | " + " Tamanho Animal: " + getTamAnimal() + " | Valor: R$ " + calculaPreco();
    }

    @Override
    public String toString() {
        return "Tosa{}";
    }
}