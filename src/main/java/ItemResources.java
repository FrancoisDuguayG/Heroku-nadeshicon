
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

    public Object postFlea(Request request, Response response) throws Exception {
        Flea listing = mapper.readValue(request.body(), Flea.class);
        //itemService.addListing(listing);
        //response.header("Location", "listingService/:" + listing.getId());
        //response.status(201);
        return mapper.writeValueAsString(listing);
    }

}
