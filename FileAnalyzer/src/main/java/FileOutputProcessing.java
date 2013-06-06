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
        BufferedWriter bw = null;
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(resultToFile);
        } catch (IOException e) {
            System.out.println("Something went wrong with the file creation, please try again");
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
