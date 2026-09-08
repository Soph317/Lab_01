import java.util.Objects;

public class Product {
    private String ID;
    private String name;
    private String description;
    private double cost;

    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String toCSV() {
        String ret = this.ID + ", " + this.name + ", " + this.description + ", " + this.cost;
        return ret;
    }

    public String toJSON() {
        String ret = "{\n" +
                "  \"ID\": \"" + this.ID + "\",\n" +
                "  \"name\": \"" + this.name + "\",\n" +
                "  \"description\": \"" + this.description + "\",\n" +
                "  \"cost\": " + this.cost + "\n" +
                "}";
        return ret;
    }

    public String toXML() {
        String ret = "<Product>\n" +
                "  <ID>" + this.ID + "</ID>\n" +
                "  <name>" + this.name + "</name>\n" +
                "  <description>" + this.description + "</description>\n" +
                "  <cost>" + this.cost + "</cost>\n" +
                "</Product>";
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(ID, product.ID) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, description, cost);
    }
}
