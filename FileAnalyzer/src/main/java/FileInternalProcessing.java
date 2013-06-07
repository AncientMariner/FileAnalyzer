import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FileInternalProcessing {
    private String fileName;
    private String delimitersForSeparatingWords = "[ .,;:?!\\|\\-~'\\\\\"*/\\^()_+=@#$%&*`{}\\[\\]]+";
    private String[] wordsInLine;
    private Map<String, Integer> wordsMap = new TreeMap<String, Integer>();

    public FileInternalProcessing(String fileName) {
        this.fileName = fileName;
    }

    public String[] getWordsInLine() {
        return wordsInLine;
    }

    public void workWithFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            readFileLineByLine(br);
        } catch (IOException e) {
            throw new FileException("There is an error with the file opening, please try again");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new FileException("There is an error with the file closing, please try again");
            }
        }
    }

    private void readFileLineByLine(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            wordsInLine = line.split(delimitersForSeparatingWords);
            for (int i = 0; i < wordsInLine.length; i++) {
                if (wordsMap.containsKey(wordsInLine[i])) {
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

    public String buildString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Word frequency :\n");
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            sb.append(" " + entry.getKey() + "\t -- \t" + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}