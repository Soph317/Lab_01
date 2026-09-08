import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        ArrayList<Product> products = new ArrayList<>();

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));


            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                System.out.printf("%-8s %-15s %-28s %-10s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("==========================================================");

                while (reader.ready()) {
                    rec = reader.readLine();
                    String[] fields = rec.split(",");
                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    String description = fields[2].trim();
                    double cost = Double.parseDouble(fields[3].trim());

                    Product product = new Product(id, name, description, cost);
                    products.add(product);
                }
                for (Product p : products) {
                    System.out.printf("%-8s %-15s %-28s %-10.2f%n", p.getID(), p.getName(), p.getDescription(), p.getCost());
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

