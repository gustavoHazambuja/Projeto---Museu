import java.time.Year;

public abstract class obraDeArte{

    private String nomeObra;
    private String nomeCriador;
    private double valorEstimado; // Em dólar
    private int anoCriacao;
    private double altura; // Em metros

    public obraDeArte(String nomeObra, String nomeCriador, double valor, int ano, double altura){
        this.nomeObra = nomeObra;
        this.nomeCriador = nomeCriador;
        this.valorEstimado = valor;
        this.anoCriacao = ano;
        this.altura = altura;
    }

    public String getNomeObra(){
        return nomeObra;
    }

    public String getNomeCriador(){
        return nomeCriador;
    }

    public double getValorEstimado(){
        return valorEstimado;
    }

    public int getAnoCriacao(){
        return anoCriacao;
    }

    public double getAltura(){
        return altura;
    }

    public  int getIdade(){
        return Year.now().getValue() - getAnoCriacao();
    }

    @Override
    public String toString(){
        return String.format("\nNome da obra: %s\n" +
        "Nome do criador: %s\n" +
        "Valor estimado: %.2f\n" +
        "Ano de criação: %d\n" +
        "Altura: %.2f\n"+
        "Idade: %d\n " , 
        nomeObra, nomeCriador, valorEstimado, anoCriacao, altura,getIdade());
    }
}
