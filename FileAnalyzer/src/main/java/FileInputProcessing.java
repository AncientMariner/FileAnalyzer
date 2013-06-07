import java.util.HashMap;
import java.util.Map;

public class FileInputProcessing {
    public static void main(String[] args) {
        if (args != null && args.length == 2) {
            String fileToOpen = args[0];
            String outputDataGoesTo = args[1];

            Output output = selectOutputSource(outputDataGoesTo);

            FileInternalProcessing fileInternalProcessing = new FileInternalProcessing(fileToOpen);
            fileInternalProcessing.workWithFile();

            String resultToPrint = fileInternalProcessing.buildString();

            printTheResults(output, resultToPrint);
        } else {
            System.out.println("Be sure to specify filename then parameter for output, such as \"<name of the executable class> <input_file> <parameter> (console or file)\"");
        }
    }

    private static Output selectOutputSource(String outputDataGoesTo) {
        Map<String, Output> outPutSources = new HashMap<String, Output>();
        outPutSources.put("console", new ConsoleOutputProcessing());
        outPutSources.put("file", new FileOutputProcessing());

        Output outputProcessing = outPutSources.get(outputDataGoesTo);
        if(outputProcessing == null) throw new FileException("Please specify the output destination correctly");

        return outputProcessing;
    }

    private static void printTheResults(Output outputProcessing, String result) {
        outputProcessing.print(result);
    }
}