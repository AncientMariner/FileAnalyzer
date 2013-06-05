import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FileInternalProcessing {
    private String fileName;
    private String delimiterForSeparatingWords = "[ .,;:?!\\|\\-~'\\\\\"*/\\^()_+=@#$%&*`{}\\[\\]]+";
    private String[] wordInLine;
    private Map<String, Integer> wordsMap = new TreeMap<String, Integer>();

    public String[] getWordInLine() {
        return wordInLine;
    }

    public FileInternalProcessing(String fileName) {
        this.fileName = fileName;
    }

    public void workWithFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            readFileLineByLine(br);
        } catch (IOException e) {
            System.out.println("Something went wrong with the file opening, please try again\n");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readFileLineByLine(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            wordInLine = line.split(delimiterForSeparatingWords);
            for (int i =0; i < wordInLine.length; i ++) {
                if(wordsMap.containsKey(wordInLine[i])) {
                    wordsMap.put(wordInLine[i], wordsMap.get(wordInLine[i]) + 1);
                } else {
                    wordsMap.put(wordInLine[i], 1);
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

