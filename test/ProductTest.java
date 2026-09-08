import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product p1;

    @BeforeEach
    void setUp() {
        p1 = new Product("123456", "Widget", "A useful widget", 19.99);
    }

    @Test
    void setID() {
        p1.setID("654321");
        assertEquals("654321", p1.getID());
    }

    @Test
    void setName() {
        p1.setName("Gadget");
        assertEquals("Gadget", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("A useful gadget");
        assertEquals("A useful gadget", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(29.99);
        assertEquals(29.99, p1.getCost(), 0.01);
    }

    @Test
    void testToString() {
        p1.setID("654321");
        p1.setName("Gadget");
        p1.setDescription("A useful gadget");
        p1.setCost(29.99);
        String expected = "Product{ID='654321', name='Gadget', description='A useful gadget', cost=29.99}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void toCSV() {
        p1.setID("654321");
        p1.setName("Gadget");
        p1.setDescription("A useful gadget");
        p1.setCost(29.99);
        assertEquals("654321, Gadget, A useful gadget, 29.99", p1.toCSV());
    }

    @Test
    void toJSON() {
        p1.setID("654321");
        p1.setName("Gadget");
        p1.setDescription("A useful gadget");
        p1.setCost(29.99);
        String expectedJSON = "{\n" +
                "  \"ID\": \"654321\",\n" +
                "  \"name\": \"Gadget\",\n" +
                "  \"description\": \"A useful gadget\",\n" +
                "  \"cost\": 29.99\n" +
                "}";
        assertEquals(expectedJSON, p1.toJSON());
    }

    @Test
    void toXML() {
        p1.setID("654321");
        p1.setName("Gadget");
        p1.setDescription("A useful gadget");
        p1.setCost(29.99);
        String expectedXML = "<Product>\n" +
                "  <ID>654321</ID>\n" +
                "  <name>Gadget</name>\n" +
                "  <description>A useful gadget</description>\n" +
                "  <cost>29.99</cost>\n" +
                "</Product>";
        assertEquals(expectedXML, p1.toXML());
        }

    @Test
    void testEquals() {
        p1.setID("654321");
        p1.setName("Gadget");
        p1.setDescription("A useful gadget");
        p1.setCost(29.99);
        Product p2 = new Product("654321", "Gadget", "A useful gadget", 29.99);
        assertEquals(p1, p2);
    }
}