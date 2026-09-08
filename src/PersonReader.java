import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Person> people = new ArrayList<>();
        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));


            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));



                System.out.printf("%-8s %-15s %-15s %-8s %-6s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==========================================================");

                while(reader.ready())
                {
                    rec = reader.readLine();

                    String[] fields = rec.split(",");

                    String id = fields[0].trim();
                    String firstName = fields[1].trim();
                    String lastName = fields[2].trim();
                    String title = fields[3].trim();
                    int YearOfBirth = Integer.parseInt(fields[4].trim());

                    Person person = new Person(id, firstName, lastName, title, YearOfBirth);
                    people.add(person);
                    }
                for (Person p : people) {
                    System.out.printf("%-8s %-15s %-15s %-8s %-6d%n",
                            p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYearOfBirth());
                }

                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}