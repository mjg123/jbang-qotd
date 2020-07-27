//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.fasterxml.jackson.core:jackson-databind:2.11.1
//JAVA 11+

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.System.out;

public class qotd {

    public static void main(String... args) {

        out.println(new Helper().getMessage());

    }


    public static class Helper {

        private final HttpClient httpClient;
        private final ObjectMapper mapper;

        public Helper() {
            this.httpClient = HttpClient.newHttpClient();
            this.mapper = new ObjectMapper();
        }

        public String getMessage(){

            var request = HttpRequest.newBuilder(
                URI.create("https://quotes.rest/qod"))
                .header("accept", "application/json")
                .build();

            try {
                var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                var jsonNode = mapper.readTree(response.body());

                var quoteObj = jsonNode.get("contents").get("quotes").get(0);

                var quote = quoteObj.get("quote").asText();
                var author = quoteObj.get("author").asText();

                return quote + "\n  - " + author;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return "Oh no I didn't get a quote";

        }

    }

}
