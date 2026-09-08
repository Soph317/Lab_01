public class ObjInputTest {

    public static void main(String[] args) {

        SafeInputObj safeInputs = new SafeInputObj();

        String name = safeInputs.getNonZeroLenString("Enter your name");
        System.out.println("Name: " + name);

        int age = safeInputs.getRangedInt("Enter your age", 1, 120);
        System.out.println("Age: " + age);

        int number = safeInputs.getInt("Enter a number");
        System.out.println("Number: " + number);

        double price = safeInputs.getRangedDouble("Enter price", 0, 1000);
        System.out.println("Price: " + price);

        double price2 = safeInputs.getDouble("Enter price");
        System.out.println("Price: " + price2);

       boolean confirm = safeInputs.getYNConfirm("Do you want to continue");
        System.out.println("Confirmation: " + confirm);

        String email = safeInputs.getRegExString("Enter your email", "^[A-Za-z0-9+_.-]+@(.+)$");
        System.out.println("Email: " + email);
    }
}