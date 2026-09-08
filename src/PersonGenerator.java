import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        boolean done = false;

        Person aPerson;
        String ID = "";
        String FirstName = "";
        String LastName = "";
        String Title = "";
        int YearOfBirth = 0;

        Scanner in = new Scanner(System.in);

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter ID (6 digits)");
            FirstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            LastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            Title = SafeInput.getNonZeroLenString(in, "Enter Title");
            YearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1940, 2010);


            aPerson = new Person(ID, FirstName, LastName, Title, YearOfBirth);
            people.add(aPerson);

            done = SafeInput.getYNConfirm(in, "Are you finished? ");
        }
        while (!done);
        for (Person p : people) {
            System.out.println(p.toCSV());
        }
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Person rec : people)
            {
                writer.write(rec.toCSV(), 0, rec.toCSV().length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

