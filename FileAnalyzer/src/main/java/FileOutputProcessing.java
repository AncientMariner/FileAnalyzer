import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputProcessing {
    private String outputResultFile = "result.txt";
    public void printTheFrequencyResultToConsole(String resultToConsole) {
        System.out.println(resultToConsole);
    }

    public void printTheFrequencyResultToFile(String resultToFile) {
        File outputFile = new File(outputResultFile);
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultToFile);
            bw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong with the file creation, please try again");
            e.printStackTrace();
        }
    }
}
