package Museu;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Museu {
    Scanner dados = new Scanner(System.in);
    
    private Set<obraDeArte> obras;

    public Museu(){
        this.obras = new HashSet<obraDeArte>();
    }

    public void adicionarObraDeArte(obraDeArte obra){
        obras.add(obra);
    }

    public void listarObras(){
        if(obras.isEmpty()){
            System.out.println("Nenhuma obra no museu!");
        }
            obras.stream()
                .forEach(System.out::println);
            
    }  

    public int qtdObras(){
        return obras.size();
    }

    public int qtdPinturas(){
        return (int) obras.stream()
            .filter(obra -> obra instanceof Pintura) 
            .count();
            
    }

    public int qtdEsculturas(){
        return (int) obras.stream()
            .filter(obra -> obra instanceof Escultura) 
            .count(); 
    }

    public double idadeMediaObras(){
        return obras.stream()
            .mapToInt(obraDeArte::getIdade)  
            .average()  
            .orElse(0.0);  
    }
    
    public double alturaMediaObras(){
        return obras.stream()
            .mapToDouble(obraDeArte::getAltura) 
            .average() 
            .orElse(0.0);  
    }
    
    public double valorMedioObras(){
        return obras.stream()
            .mapToDouble(obraDeArte::getValorEstimado)  
            .average() 
            .orElse(0.0); 
    }
    
    public int somatorioIdades(){
        return obras.stream()
            .mapToInt(obraDeArte::getIdade)  
            .sum();  
    }

    public List<obraDeArte> obrasMais300Anos(){
        return obras.stream()
            .filter(obra -> obra.getIdade() > 300) 
            .collect(Collectors.toList());   
        
    }

    public List<obraDeArte> obrasMais400milhoes(){
        return obras.stream()
            .filter(obra -> obra.getValorEstimado() > 400000000) 
            .collect(Collectors.toList()); 
    }

    public String obraMaisCaraComMenosDe200Anos(){
        return obras.stream()
            .filter(obra -> obra.getIdade() < 200) 
            .max(Comparator.comparing(obraDeArte::getValorEstimado)) 
            .map(obra -> " Nome: " + obra.getNomeObra() + ", Idade: " + obra.getIdade() +  ", Valor: " + obra.getValorEstimado()) 
            .orElse("Nenhuma obra encontrada!"); 
    }

    public String obraMaisBarataComMaisDe300Anos(){
        return obras.stream()
            .filter(obra -> obra.getIdade() > 300) 
            .min(Comparator.comparing(obraDeArte::getValorEstimado))
            .map(obra -> " Nome: " + obra.getNomeObra() + ", Idade: " + obra.getIdade() + ", Valor: " + obra.getValorEstimado())
            .orElse("Nenhuma obra encontrada!");
    }
    
    public String obraMaisAntiga(){
        return obras.stream()
            .min(Comparator.comparing(obraDeArte::getAnoCriacao))  
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Ano: " + obra.getAnoCriacao() + ", Idade: " + obra.getIdade()) 
            .orElse("Nenhuma obra encontrada!"); 
    }
    
    public String obraMaisRecente(){
        return obras.stream()
            .max(Comparator.comparing(obraDeArte::getAnoCriacao))  
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Ano: " + obra.getAnoCriacao() + ", Idade: " + obra.getIdade())
            .orElse("Nenhuma obra encontrada!"); 
    }        

    public String obraMaisCara(){
        return obras.stream()
            .max(Comparator.comparing(obraDeArte::getValorEstimado))  
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Valor: " + obra.getValorEstimado())  
            .orElse("Nenhuma obra encontrada!"); 
    }

    public String obrasMaisBarata(){
        return obras.stream()
            .min(Comparator.comparing(obraDeArte::getValorEstimado)) 
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Valor: " + obra.getValorEstimado()) 
            .orElse("Nenhuma obra encontrada!");
    }

    public obraDeArte buscarObraDeArte(){
        System.out.println("Informe o nome da obra de arte que deseja buscar:");
        String nome = dados.nextLine().toLowerCase();

        if(obras.isEmpty()){
            System.out.println("Nenhuma obra no museu.");
        }
        
        return obras.stream()
            .filter(obra -> obra.getNomeObra().contains(nome.toLowerCase()))
            .findFirst()
            .orElse(null);
    }
    
}
