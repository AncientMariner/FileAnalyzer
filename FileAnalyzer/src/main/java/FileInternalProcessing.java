import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FileInternalProcessing {
    private String fileName;
    private String delimiterForSeparatingWords = "[ .,;:?!\\|\\-~'\\\\\"*/\\^()_+=@#$%&*`{}\\[\\]]+";
    private String[] wordsInLine;
    private Map<String, Integer> wordsMap = new TreeMap<String, Integer>();

    public String[] getWordsInLine() {
        return wordsInLine;
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
            wordsInLine = line.split(delimiterForSeparatingWords);
            for (int i =0; i < wordsInLine.length; i++) {
                if(wordsMap.containsKey(wordsInLine[i])) {
                    wordsMap.put(wordsInLine[i], wordsMap.get(wordsInLine[i]) + 1);
                } else {
                    wordsMap.put(wordsInLine[i], 1);
                }
            }
        }
        removeUnnecessarySymbols();
    }

    private void removeUnnecessarySymbols() {
        wordsMap.remove("");
    }

    public String buildAStringFromMap() {
        StringBuilder sb = new StringBuilder();
        sb.append("Word frequency :\n");
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            sb.append(" " + entry.getKey() + "\t -- \t" + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}