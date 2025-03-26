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
        return "Serviço Realizado: Hotel | " + " Tamanho Animal: ";
    }
}
