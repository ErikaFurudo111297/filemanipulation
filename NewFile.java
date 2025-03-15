import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class NewFile {
    public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            String choice;
            String FileName;
            String ChosenFile;
            String FileContent;
            String WriteChoice;
            String DeleteChoice;
            String ReadChoice;

            System.out.println("What would you like to name your file?");
            FileName = input.next();


            System.out.println("Would you like to create a new file?");
            choice = input.next();
            if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                try {
                    File NewFile = new File(FileName);
                    if (NewFile.createNewFile()) {
                        System.out.println("File successfully created: " + NewFile.getName());
                        System.out.println("File path: " + NewFile.getAbsolutePath());
                    }
                    else {
                        System.out.println("File already exists");
                    }
                } catch (IOException e) {
                    System.out.println("Something went wrong");
                    e.printStackTrace();
                }
            }
            System.out.println("Would you like to write to a file?");
            WriteChoice = input.next();

                if (WriteChoice.equalsIgnoreCase("yes") || WriteChoice.equalsIgnoreCase("y")) {
                    System.out.println("Which file do you wish to write to?");
                        ChosenFile = input.next();
                        input.nextLine();

                        try {
                            PrintWriter output = new PrintWriter(ChosenFile);

                                System.out.println("What would you like to write to your file?");
                                FileContent = input.nextLine();
                                output.println(FileContent);
                                output.close();
                        } catch (IOException e) {
                            System.out.println("Something went wrong. Please try again.");
                            e.printStackTrace();
                        }

                }
            System.out.println("Would you like to delete a file?");
                choice = input.next();
                input.nextLine();

                if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {

                    System.out.println("Which file do you wish to delete?");
                    DeleteChoice = input.nextLine();
                    File FileToDelete = new File(DeleteChoice);

                   if (FileToDelete.delete()) {
                       System.out.println("File " + DeleteChoice + " successfully deleted");
                   }
                   else {
                       System.out.println("Something went wrong. Please try again.");
                   }
                }
            System.out.println("Would you like to read a file?");
                choice = input.next();
                if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                try {
                    System.out.println("Which file do you wish to read?");
                    ReadChoice = input.next();
                    File FileToRead = new File(ReadChoice);
                    Scanner Reader = new Scanner(FileToRead);

                    while (Reader.hasNextLine()) {
                        String data = Reader.nextLine();
                        System.out.println(data);
                    }
                } catch (IOException e) {
                System.out.println("Something went wrong. Please try again.");
                e.printStackTrace();
                }
                }
        }
    }
