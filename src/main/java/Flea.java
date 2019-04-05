public class Flea {
    private String _id;
    private String name;
    private Float cost;
    private String description;

    public Flea() {
    }

    public Flea(String _id, String name, Float cost, String description) {
        this._id = _id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public Float getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
}
