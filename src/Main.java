import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nika.screenmatch.calculos.FiltroRecomendacao;
import com.nika.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.nika.screenmatch.modelos.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();



        while (!busca.equalsIgnoreCase("sair")){
            System.out.println("Digite o nome do filme para busca ou digite 'sair' para encerrar a busca:");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String chave = "";
            String endereco = "https://www.omdbapi.com/?t=" +busca.replace(" ", "+") + "&apikey=" + chave;

            try{

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);

                titulos.add(meuTitulo);

            }catch (NumberFormatException e){
                System.out.println("An error ocurred - " + e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Erro! Verifique o endereço de busca!");
            }catch (ErroDeConversaoDeAnoException e){
                System.out.println(e.getMessage());
            }

        }

        System.out.println(titulos);

        FileWriter arquivo = new FileWriter("filmes.json");
        arquivo.write(gson.toJson(titulos));
        arquivo.close();
        System.out.println("O programa finalizou corretamente!");
            }
}