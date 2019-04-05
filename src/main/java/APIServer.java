import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import javaslang.control.Try;

public class APIServer {
    private static ObjectMapper jsonObjectMapper = new ObjectMapper();
    private static ItemService itemService = new ItemService();
    private static ItemResources itemResources = new ItemResources(jsonObjectMapper, itemService);

    public APIServer() {
    }

    public static void main(String[] args) {
        Integer portNumber = Try.of(() -> Integer.valueOf(System.getenv("PORT"))).orElseGet((t) -> {
            System.out.println("WARNING: The server port could not be found with 'PORT' env var. Using the " +
                    "default one (9090)");
            return 9090;
        });

        port(portNumber);

        get("/", (request, response) -> "Hello World!");

        get("/ping", (request, response) -> "pong");

        get("/felix", ((request, response) -> "Bienvenue sur Félix Boutin.com"));

        post("/flea/:id", (request, response) -> itemResources.postFlea(request, response));


        enableCORS("*", "*", "*");
    }

    private static void enableCORS(final String origin, final String methods, final String headers) {

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            response.type("application/json");
        });
    }
}
