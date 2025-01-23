public class Pintura extends obraDeArte {
    
    private String tipoTinta;

    public Pintura(String nomeObra, String nomeCriador, double valor, int ano, double altura, String tinta){
        super(nomeObra, nomeCriador, valor, ano, altura);
        this.tipoTinta = tinta;
    }

    public String getTipotinta(){
        return tipoTinta;
    }

    @Override
    public String toString(){
        return String.format("[Pintura]" + super.toString() + "Tipo da tinta: %s\n" , tipoTinta);
         
    }
}
