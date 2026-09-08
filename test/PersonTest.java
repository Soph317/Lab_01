import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person p1;

    @BeforeEach
    void setUp() {
        p1 = new Person("123456", "John", "Doe", "Mr.", 1990);
    }

    @Test
    void setID() {
        p1.setID("999999");
        assertEquals("999999", p1.getID());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Johnny");
        assertEquals("Johnny", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Doe");
        assertEquals("Doe", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Dr.");
        assertEquals("Dr.", p1.getTitle());
    }

    @Test
    void setYearOfBirth() {
        p1.setYearOfBirth(1995);
        assertEquals(1995, p1.getYearOfBirth());
    }

    @Test
    void testToString() {
        p1.setID("999999");
        p1.setFirstName("Johnny");
        p1.setLastName("Doe");
        p1.setTitle("Dr.");
        p1.setYearOfBirth(1995);
        String expected = "Person{ID='999999', firstName='Johnny', lastName='Doe', title='Dr.', YearOfBirth=1995}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void toCSV() {
        p1.setID("999999");
        p1.setFirstName("Johnny");
        p1.setLastName("Doe");
        p1.setTitle("Dr.");
        p1.setYearOfBirth(1995);
        assertEquals("999999, Johnny, Doe, Dr., 1995", p1.toCSV());
    }

    @Test
    void fullName() {
        p1.setFirstName("Johnny");
        p1.setLastName("Doe");
        assertEquals("Johnny Doe", p1.fullName());
    }

    @Test
    void formalName() {
        p1.setTitle("Dr.");
        p1.setFirstName("Johnny");
        p1.setLastName("Doe");
        assertEquals("Dr. Johnny Doe", p1.formalName());
    }

    @Test
    void getAge() {
        p1.setYearOfBirth(1990);
        assertEquals(33, p1.getAge(2023));
    }

    @Test
    void testGetAge() {
        p1.setYearOfBirth(1990);
        assertEquals(33, p1.getAge(2023));
    }

    @Test
    void toJSON() {
        p1.setID("999999");
        p1.setFirstName("Johnny");
        p1.setLastName("Doe");
        p1.setTitle("Dr.");
        p1.setYearOfBirth(1990);
        String expected = "{\n" +
                "  \"ID\": \"999999\",\n" +
                "  \"firstName\": \"Johnny\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"title\": \"Dr.\",\n" +
                "  \"YearOfBirth\": 1990\n" +
                "}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void toXML() {
        p1.setID("999999");
        p1.setFirstName("Johnny");
        p1.setLastName("Doe");
        p1.setTitle("Dr.");
        p1.setYearOfBirth(1990);
        String expected = "<Person>\n" +
                "  <ID>999999</ID>\n" +
                "  <FirstName>Johnny</FirstName>\n" +
                "  <LastName>Doe</LastName>\n" +
                "  <Title>Dr.</Title>\n" +
                "  <YearOfBirth>1990</YearOfBirth>\n" +
                "</Person>";
        assertEquals(expected, p1.toXML());
    }
    @Test
    void testEquals() {
        p1.setID("999999");
        p1.setFirstName("Johnny");
        p1.setLastName("Doe");
        p1.setTitle("Dr.");
        p1.setYearOfBirth(1990);
        Person p2 = new Person("999999", "Johnny", "Doe", "Dr.", 1990);
        assertEquals(p1, p2);
    }
}