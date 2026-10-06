
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesApp {

    static Scanner sc = new Scanner(System.in);
    String file_name = "notes.txt";

    //Write Notes
    public void writeNotes() {
        System.out.println("Write Notes: ");
        String notes = sc.nextLine();
        try (FileWriter fw = new FileWriter(file_name, true)) {
            fw.write(notes);
            fw.write(System.lineSeparator());

            System.out.println("---Note Successfully Saved---");

        } catch (IOException e) {
            System.out.println("---Error occurred while saving the note---");
        }
    }

    //Read or View Notes
    public void viewNotes() {
        try (BufferedReader b = new BufferedReader(new FileReader(file_name))) {
            String line;
            boolean hasNotes = false;

            System.out.println("\n===Your Notes===");
            while ((line = b.readLine()) != null) {
                System.out.println("- " + line);
                hasNotes = true;
            }
            if (!hasNotes) {
                System.out.println("---No Notes Found---");
            }
        } catch (IOException e) {
            System.out.println("---No Notes File Found---");
        }
    }

    public static void main(String[] args) {
        NotesApp n = new NotesApp();
        boolean running = true;
        while (running) {
            System.out.println("\n====File I/O Menu===");
            System.out.println("1.Write Notes");
            System.out.println("2.Read Notes");
            System.out.println("3.Exit");

            System.out.print("\nEnter the Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    n.writeNotes();
                    break;
                case 2:
                    n.viewNotes();
                    break;
                case 3:
                    running = false;
                    System.out.println("---Notes App is Closed---");
                    break;
                default:
                    System.out.println("---Invalid Choice, Please try again---");
            }
        }
        sc.close();
    }
}
