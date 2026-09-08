import java.util.Objects;

public class Person {
        private String ID;
        private String firstName;
        private String lastName;
        private String title;
        private int YearOfBirth;

    public Person(String ID, String firstName, String lastName, String title, int yearOfBirth){
            this.ID = ID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.title = title;
            YearOfBirth = yearOfBirth;
        }

        public String getID () {
            return ID;
        }

        public void setID (String ID){
            this.ID = ID;
        }

        public String getFirstName () {
            return firstName;
        }

        public void setFirstName (String firstName){
            this.firstName = firstName;
        }

        public String getLastName () {
            return lastName;
        }

        public void setLastName (String lastName){
            this.lastName = lastName;
        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public int getYearOfBirth () {
            return YearOfBirth;
        }

        public void setYearOfBirth ( int yearOfBirth){
            YearOfBirth = yearOfBirth;
        }

        @Override
        public String toString () {
            return "Person{" +
                    "ID='" + ID + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", title='" + title + '\'' +
                    ", YearOfBirth=" + YearOfBirth +
                    '}';
        }

        public String toCSV() {
            String ret = this.ID + ", " + this.firstName + ", " + this.lastName + ", " + this.title + ", " + this.YearOfBirth;
            return ret;
        }

        public String fullName() {
            String ret = this.firstName + " " + this.lastName;
            return ret;
        }

        public String formalName() {
            String ret = this.title + " " + this.firstName + " " + this.lastName;
            return ret;
        }

        public int getAge(){
            int currentYear = 2026 - this.YearOfBirth;
            return currentYear;
        }

        public int getAge(int year) {
        int currentYear = year - this.YearOfBirth;
        return currentYear;
        }

        public String toJSON() {
            String ret = "{\n" +
                    "  \"ID\": \"" + this.ID + "\",\n" +
                    "  \"firstName\": \"" + this.firstName + "\",\n" +
                    "  \"lastName\": \"" + this.lastName + "\",\n" +
                    "  \"title\": \"" + this.title + "\",\n" +
                    "  \"YearOfBirth\": " + this.YearOfBirth + "\n" +
                    "}";
            return ret;
        }

        public String toXML() {
            String ret = "<Person>\n" +
                    "  <ID>" + this.ID + "</ID>\n" +
                    "  <FirstName>" + this.firstName + "</FirstName>\n" +
                    "  <LastName>" + this.lastName + "</LastName>\n" +
                    "  <Title>" + this.title + "</Title>\n" +
                    "  <YearOfBirth>" + this.YearOfBirth + "</YearOfBirth>\n" +
                    "</Person>";
            return ret;
        }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YearOfBirth == person.YearOfBirth && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YearOfBirth);
    }
}