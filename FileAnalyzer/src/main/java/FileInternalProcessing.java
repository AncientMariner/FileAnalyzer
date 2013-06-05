import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FileInternalProcessing {
    public String fileName;
    private String delimiterForSeparatingWords = "[ .,;:?!\\|\\-~'\\\\\"*/\\^()_+=@#$%&*`{}\\[\\]]+";
    private String[] tokens;
    Map<String, Integer> wordsMap = new TreeMap<String, Integer>();

    public String[] getTokens() {
        return tokens;
    }

    public FileInternalProcessing(String fileName) {
        this.fileName = fileName;
    }

    public void workWithFile() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fis);

            readFileLineByLine(in);

            in.close();
        } catch (IOException e) {
            System.out.println("Something went wrong with the file opening, please try again\n");
            e.printStackTrace();
        }
    }

    private void readFileLineByLine(DataInputStream in) throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            tokens = line.split(delimiterForSeparatingWords);
            for (int i =0; i < tokens.length; i ++) {
                if(wordsMap.containsKey(tokens[i])) {
                    wordsMap.put(tokens[i], wordsMap.get(tokens[i]) + 1);
                } else {
                    wordsMap.put(tokens[i], 1);
                }
            }
        }
        removeUnnecessarySymbols();
    }

    private void removeUnnecessarySymbols() {
        wordsMap.remove("");
    }

    public void showTheResults(String outputDataGoesTo) {
        if(outputDataGoesTo.equals("console")) {
            printTheFrequencyResultToConsole();
        } else if (outputDataGoesTo.equals("file")){
            printTheFrequencyResultToFile();
        } else {
            System.out.println("Please specify the output destination correctly");
        }
    }


    public void printTheFrequencyResultToConsole() {
        System.out.println("Word frequency :");
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(" " + entry.getKey() + "\t -- \t" + entry.getValue());
        }
    }

    private void printTheFrequencyResultToFile() {
        File outputFile = new File("result.txt");
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(buildAStringFromMap());
            bw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong with the file creation, please try again");
            e.printStackTrace();
        }
    }

    private String buildAStringFromMap() {
        StringBuilder sb = new StringBuilder();
        sb.append("Word frequency :\n");
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            sb.append(" " + entry.getKey() + "\t -- \t" + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}

