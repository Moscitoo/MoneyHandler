import java.io.File;
import java.io.IOException;

public class FileManager {

    File taskFile = new File("resources/taskfile.txt");

    public void readTaskFile() {
        try {
            if (taskFile.createNewFile()) {
                System.out.println("Sikeres");
            } else {
                System.out.println("A file már létezik.");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    File categoryFile = new File("resources/categoryfile.txt");
    public void categoryFile() {
        try {
            if (categoryFile.createNewFile()) {
                System.out.println("Sikeres");
            } else {
                System.out.println("A file már létezik.");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
