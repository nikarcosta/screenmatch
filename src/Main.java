import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nika.screenmatch.calculos.FiltroRecomendacao;
import com.nika.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.nika.screenmatch.modelos.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para busca: ");
        var busca = leitura.nextLine();

        String chave = "9c2bac17";
        String endereco = "https://www.omdbapi.com/?t=" +busca.replace(" ", "+") + "&apikey=" + chave;

        try{

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);

            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        }catch (NumberFormatException e){
            System.out.println("An error ocurred - " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Erro! Verifique o endereço de busca!");
        }catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }



    }
}