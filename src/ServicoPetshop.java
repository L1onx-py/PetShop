import java.time.LocalDate;
import java.util.Objects;

public abstract class ServicoPetshop implements ServicoPetshopIF {

    private LocalDate data;
    private int codigo;
    private Tamanho tamAnimal;


    public ServicoPetshop (int codigo, Tamanho tamAnimal){

        this.data = LocalDate.now();
        this.codigo = codigo;
        this.tamAnimal = tamAnimal;
    }

    public LocalDate getData() {
        return data;
    }

    public int getCodigo() {
        return codigo;
    }

    public Tamanho getTamAnimal() {
        return tamAnimal;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTamAnimal(Tamanho tamAnimal) {
        this.tamAnimal = tamAnimal;
    }

    @Override
    public abstract Double calculaPreco();

    @Override
    public abstract String descricao();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoPetshop that = (ServicoPetshop) o;
        return codigo == that.codigo && Objects.equals(data, that.data) && tamAnimal == that.tamAnimal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, codigo, tamAnimal);
    }
}
