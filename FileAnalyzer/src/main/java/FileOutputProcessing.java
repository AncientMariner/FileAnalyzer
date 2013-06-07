import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputProcessing implements  Output{
    @Override
    public void print(String output) {
        String outputResultFile = "result.txt";

        File outputFile = new File(outputResultFile);
        BufferedWriter bw = null;
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(output);
        } catch (IOException e) {
            throw new FileProcessingException("There is an error with the output file creation, please try again");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new FileProcessingException("There is an error with the output file closing, please try again");
            }
        }
    }
}
