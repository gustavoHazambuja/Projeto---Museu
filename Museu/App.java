public class App {
    public static void main(String[] args) {
        
        Museu m = new Museu();

        // Pinturas 
        m.adicionarObraDeArte(new Pintura("Mona Lisa", "Leonardo da Vinci", 860000000, 1503, 0.77, "Óleo sobre madeira"));
        m.adicionarObraDeArte(new Pintura("A Noite Estrelada", "Vincent van Gogh", 100000000, 1889, 0.73, "Óleo sobre tela"));
        m.adicionarObraDeArte(new Pintura("Guernica", "Pablo Picasso", 200000000, 1937, 3.49, "Óleo sobre tela"));
        m.adicionarObraDeArte(new Pintura("O Grito", "Edvard Munch", 119900000, 1893, 0.91, "Óleo, têmpera e pastel sobre cartão"));
        m.adicionarObraDeArte(new Pintura("As Meninas", "Diego Velázquez", 500000000, 1656, 3.18, "Óleo sobre tela"));


        // Esculturas
        m.adicionarObraDeArte(new Escultura("Davi", "Michelangelo", 200000000, 1504, 5.17, "Mármore"));
        m.adicionarObraDeArte(new Escultura("O Pensador", "Auguste Rodin", 6000000, 1902, 1.87, "Bronze"));
        m.adicionarObraDeArte(new Escultura("Pietà", "Michelangelo", 300000000, 1499, 1.74, "Mármore"));
        m.adicionarObraDeArte(new Escultura("O Beijo", "Auguste Rodin", 15000000, 1889, 1.80, "Mármore"));
        m.adicionarObraDeArte(new Escultura("Reclining Figure", "Henry Moore", 25000000, 1951, 3.05, "Bronze"));

        System.out.println("Obras listadas:");
        m.listarObras();

        System.out.println("*******************************************");
        System.out.println("************** Estatísticas ***************");
        System.out.println("*******************************************");

        System.out.printf("Quantidade de obras no museu: %d\n",m.getQtd());
        System.out.printf("Quantidade de pinturas no museu: %d\n",m.qtdPinturas());
        System.out.printf("Quantidade de escultuas no museu: %d\n",m.qtdEsculturas());


        System.out.println("*****************************************");
        System.out.printf("Idade média das obras: %.2f anos\n", m.idadeMediaObras());
        System.out.printf("Altura média das obras: %.2f metros\n", m.alturaMediaObras());
        System.out.printf("Valor médio estimulado das obras: %.2f dólares\n", m.valorMedioObras());

        System.out.println("*****************************************");
        System.out.printf("Soma das idades das obras: %d anos\n", m.somatorioIdades());

        System.out.println("*****************************************");
        System.out.printf("Obras com mais de 300 anos:\n %s\n", m.obrasMais300Anos());
        System.out.printf("Obras que custam mais de 400 milhões de dólares:\n %s\n", m.obrasMais400milhoes());

        System.out.println("*****************************************");
        System.out.printf("Obra mais cara com menos de 200 anos:%s\n", m.obraMaisCaraComMenosDe200Anos());
        System.out.printf("Obra mais barata com mais de 300 anos:%s\n", m.obraMaisBarataComMaisDe300Anos());

        System.out.println("*****************************************");
        System.out.printf("Obra mais antiga: %s\n", m.obraMaisAntiga());
        System.out.printf("Obra mais recente: %s\n", m.obraMaisRecente());

        System.out.println("*****************************************");
        System.out.printf("Obra mais cara: %s\n", m.obraMaisCara());
        System.out.printf("Obra mais barata: %s\n", m.obrasMaisBarata());

    }
  


}
