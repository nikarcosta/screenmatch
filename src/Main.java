import com.nika.screenmatch.calculos.FiltroRecomendacao;
import com.nika.screenmatch.modelos.Episodio;
import com.nika.screenmatch.modelos.Filme;
import com.nika.screenmatch.modelos.Serie;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme();

        filme.setNome("Her");
        filme.setAnoDeLancamento(2014);
        filme.setDuracaoEmMinutos(120);
        filme.setIncluidoNoPlano(true);

        filme.exibeFichaTecnica();

        Serie serie = new Serie();

        serie.setNome("Friends");
        serie.setTemporadas(10);
        serie.setEpisodiosPorTemporada(20);
        serie.setIncluidoNoPlano(true);
        serie.setMinutosPorEpisodio(20);

        serie.exibeFichaTecnica();

        System.out.println("Tempo total da série: " + serie.getDuracaoEmMinutos());

        Episodio primeiro = new Episodio();
        primeiro.setNumero(1);
        primeiro.setSerie(serie);
        primeiro.setTotalVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(primeiro);

    }
}