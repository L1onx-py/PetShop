import java.util.Objects;

public class Hotel extends ServicoPetshop{

    private int qtdHoras;

    public Hotel(int codigo, Tamanho tamAnimal, int qtdHoras) {
        super(codigo, tamAnimal);
        this.qtdHoras = qtdHoras;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    @Override
    public Double calculaPreco() {
        return switch (getTamAnimal()){
            case GRANDE -> 25.00 * getQtdHoras();
            case MEDIO -> 18.00 * getQtdHoras();
            case PEQUENO -> 12.00 * getQtdHoras();
        };
    }

    @Override
    public String descricao() {
        return "Serviço Realizado: Hotel | " + " Tamanho Animal: " + getTamAnimal() + " | Valor: R$ " + calculaPreco();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hotel hotel = (Hotel) o;
        return qtdHoras == hotel.qtdHoras;
    }

    @Override
    public int hashCode() {        return Objects.hash(super.hashCode(), qtdHoras);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "qtdHoras=" + qtdHoras +
                '}';
    }
}
