package Museu;
public class Escultura extends obraDeArte {
    
    private String tipoMaterial;

    public Escultura(String nomeObra, String nomeCriador, double valor, int ano, double altura, String material){
        super(nomeObra, nomeCriador, valor, ano, altura);
        this.tipoMaterial = material;
    }

    public String getTipoMaterial(){
        return tipoMaterial;
    }

    @Override
    public String toString(){
        return String.format("[Escultura]" + super.toString() + "Tipo do material: %s\n" , tipoMaterial);
         
    }
}
