
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;

public class ItemResources {
    private ItemService itemService;
    private final ObjectMapper mapper;

    public ItemResources(ObjectMapper jsonObjectMapper, ItemService itemService) {
        this.mapper = jsonObjectMapper;
        this.itemService = itemService;
    }
}
