import com.nika.screenmatch.Filme;

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
    }
}