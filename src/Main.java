import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        // conexao http e buscar a API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();


        //extrair só os dados que interessam (titulo, poster e classificação)
        var parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //exibir
        for (Map<String,String> filme: listaDeFilmes
             ) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println("");
        }



    }
}