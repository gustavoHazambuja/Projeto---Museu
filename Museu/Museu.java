
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Museu {
    
    private Set<obraDeArte> obras;
    private int qtd = 0;

    public Museu(){
        this.obras = new HashSet<obraDeArte>();
    }

    public int getQtd(){
        return qtd;
    }

    public void adicionarObraDeArte(obraDeArte obra){
        obras.add(obra);
        qtd++;
    }

    public void listarObras(){
        if(obras.isEmpty()){
            System.out.println("Nenhuma obra no museu!");
        }
            obras.stream()
                .forEach(System.out::println);
            
    }  

    public int qtdPinturas(){
        return (int) obras.stream()
            .filter(obra -> obra instanceof Pintura) // Filtra as obras para incluir apenas aquelas que são instâncias de Pintura
            .count(); // Conta quantas obras passaram pelo filtro e converte o resultado para int
            
    }

    public int qtdEsculturas(){
        return (int) obras.stream()
            .filter(obra -> obra instanceof Escultura) // Filtra as obras para incluir apenas aquelas que são instâncias de Escultura
            .count(); // Conta quantas obras passaram pelo filtro e converte o resultado para int
    }

    public double idadeMediaObras(){
        return obras.stream()
            .mapToInt(obraDeArte::getIdade)  // Converte cada obra para a sua idade (método getIdade)
            .average()  // Calcula a média das idades
            .orElse(0.0);  // Se não houver obras, retorna 0.0 
    }
    
    public double alturaMediaObras(){
        return obras.stream()
            .mapToDouble(obraDeArte::getAltura)  // Converte cada obra para a sua altura (método getAltura)
            .average()  // Calcula a média das alturas
            .orElse(0.0);  // Se não houver obras, retorna 0.0 
    }
    
    public double valorMedioObras(){
        return obras.stream()
            .mapToDouble(obraDeArte::getValorEstimado)  // Converte cada obra para o seu valor estimado (método getValorEstimado)
            .average()  // Calcula a média dos valores estimados
            .orElse(0.0);  // Se não houver obras, retorna 0.0
    }
    
    public int somatorioIdades(){
        return obras.stream()
            .mapToInt(obraDeArte::getIdade)  // Converte cada obra para a sua idade (método getIdade)
            .sum();  // Soma todas as idades das obras
    }

    public List<obraDeArte> obrasMais300Anos(){
        return obras.stream()
            .filter(obra -> obra.getIdade() > 300) // Filtra apenas as obras com mais de 300 anos
            .collect(Collectors.toList()); // Coleta os elementos filtrados em uma lista    
        
    }

    public List<obraDeArte> obrasMais400milhoes(){
        return obras.stream()
            .filter(obra -> obra.getValorEstimado() > 400000000) // Filtra as obras cujo valor estimado é maior que 400 milhões
            .collect(Collectors.toList()); // Coleta as obras filtradas em uma lista e a retorna
    }

    public String obraMaisCaraComMenosDe200Anos(){
        return obras.stream()
            .filter(obra -> obra.getIdade() < 200) // Filtra as obras com idade inferior a 200 anos
            .max(Comparator.comparing(obraDeArte::getValorEstimado))  // Encontra a obra com o maior valor estimado
            .map(obra -> " Nome: " + obra.getNomeObra() + ", Idade: " + obra.getIdade() +  ", Valor: " + obra.getValorEstimado()) // Formatação
            .orElse("Nenhuma obra encontrada!"); // Se não houver obras, retorna uma mensasgem
    }

    public String obraMaisBarataComMaisDe300Anos(){
        return obras.stream()
            .filter(obra -> obra.getIdade() > 300) // Filtra as obras com idade superior a 300 anos
            .min(Comparator.comparing(obraDeArte::getValorEstimado)) // Encontra a obra com o menor valor estimado
            .map(obra -> " Nome: " + obra.getNomeObra() + ", Idade: " + obra.getIdade() + ", Valor: " + obra.getValorEstimado()) // Formatação
            .orElse("Nenhuma obra encontrada!"); // Se não houver obras, retorna uma mensasgem
    }
    
    public String obraMaisAntiga(){
        return obras.stream()
            .min(Comparator.comparing(obraDeArte::getAnoCriacao))  // Encontra a obra com o menor ano de criação (mais antiga)
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Ano: " + obra.getAnoCriacao() + ", Idade: " + obra.getIdade())  // Formata o nome e ano da obra mais antiga
            .orElse("Nenhuma obra encontrada!");  // Se não houver obras, retorna uma mensagem 
    }
    
    public String obraMaisRecente(){
        return obras.stream()
            .max(Comparator.comparing(obraDeArte::getAnoCriacao))  // Encontra a obra com o maior ano de criação (mais recente)
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Ano: " + obra.getAnoCriacao() + ", Idade: " + obra.getIdade()) // Formata o nome e ano da obra mais recente
            .orElse("Nenhuma obra encontrada!"); // Se não houver obras, retorna uma mensagem 
    }

    public String obraMaisCara(){
        return obras.stream()
            .max(Comparator.comparing(obraDeArte::getValorEstimado))  // Encontra a obra com o maior valor estimado (mais cara)
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Valor: " + obra.getValorEstimado())  // Formata o nome e valor da obra mais cara
            .orElse("Nenhuma obra encontrada!");  // Se não houver obras, retorna uma mensagem
    }

    public String obrasMaisBarata(){
        return obras.stream()
            .min(Comparator.comparing(obraDeArte::getValorEstimado)) // Encontra a obra com o menor valor estimado (mais barata)
            .map(obra -> "Nome: " + obra.getNomeObra() + ", Valor: " + obra.getValorEstimado()) // Formata o nome e valor da obra mais barata
            .orElse("Nenhuma obra encontrada!"); // Se não houver obras, retorna uma mensagem
    }
    
}
