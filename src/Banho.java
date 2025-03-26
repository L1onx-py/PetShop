import java.util.Objects;

public class Banho extends ServicoPetshop{

    private Pelo tamPelo;

    public Banho(int codigo,Tamanho tamAnimal,Pelo tamPelo){
        super(codigo,tamAnimal);
        this.tamPelo = tamPelo;
    }

    public Pelo getTamPelo() {
        return tamPelo;
    }

    public void setTamPelo(Pelo tamPelo) {
        this.tamPelo = tamPelo;
    }

    @Override
    public Double calculaPreco() {
        double precoBase = 0;

        switch (getTamAnimal()){
            case GRANDE -> precoBase = 70.00;
            case MEDIO -> precoBase = 60.00;
            case PEQUENO -> precoBase = 50.00;
        }

        return switch (getTamPelo()){
            case LONGO -> precoBase + 25.00;
            case MEDIO -> precoBase + 15.00;
            case CURTO -> precoBase;
        };
    }

    @Override
    public String toString() {
        return "Banho{" +
                "tamPelo=" + tamPelo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Banho banho = (Banho) o;
        return tamPelo == banho.tamPelo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tamPelo);
    }

    @Override
    public String descricao() {
        return "Serviço Realizado: Banho | " + " Tamanho Animal: " + getTamAnimal() + " | Tamanho Pelo: " + tamPelo + " | Valor: R$ " + calculaPreco();
    }
}
