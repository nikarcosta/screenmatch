import com.google.gson.Gson;
import com.nika.screenmatch.calculos.FiltroRecomendacao;
import com.nika.screenmatch.modelos.Episodio;
import com.nika.screenmatch.modelos.Filme;
import com.nika.screenmatch.modelos.Serie;
import com.nika.screenmatch.modelos.Titulo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para busca: ");
        var busca = leitura.nextLine();

        String chave = "";
        String endereco = "https://www.omdbapi.com/?t=" +busca + "&apikey=" + chave;


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        System.out.println("Título: " + meuTitulo.getNome());


    }
}