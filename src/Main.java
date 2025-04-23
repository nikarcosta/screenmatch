import com.nika.screenmatch.calculos.FiltroRecomendacao;
import com.nika.screenmatch.modelos.Episodio;
import com.nika.screenmatch.modelos.Filme;
import com.nika.screenmatch.modelos.Serie;
import com.nika.screenmatch.modelos.Titulo;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme("Her", 2014);

        filme.setDuracaoEmMinutos(120);
        filme.setIncluidoNoPlano(true);

        filme.exibeFichaTecnica();

        filme.avalia(10);

        Serie serie = new Serie("Friends", 1994);

        serie.setTemporadas(10);
        serie.setEpisodiosPorTemporada(20);
        serie.setIncluidoNoPlano(true);
        serie.setMinutosPorEpisodio(20);

        serie.exibeFichaTecnica();
        serie.avalia(10);

        System.out.println("Tempo total da série: " + serie.getDuracaoEmMinutos());

        Episodio primeiro = new Episodio();
        primeiro.setNumero(1);
        primeiro.setSerie(serie);
        primeiro.setTotalVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(primeiro);

        //ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        List<Titulo> lista = new LinkedList<>();
        lista.add(filme);
        lista.add(serie);

        for (Titulo item : lista){
            System.out.println("Nome: " + item.getNome());
            if (item instanceof Filme movie && movie.getClassificacao() > 2){
                System.out.println("Classificação: " + movie.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);

    }
}