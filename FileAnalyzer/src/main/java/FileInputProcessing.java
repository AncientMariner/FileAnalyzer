public class FileInputProcessing {

    public static void main(String[] args) {
        if (args != null && args.length == 2) {
            String fileToOpen = args[0];
            String outputDataGoesTo = args[1];

            Output output = selectOutputSource(outputDataGoesTo);

            FileInternalProcessing fileInternalProcessing = new FileInternalProcessing(fileToOpen);
            fileInternalProcessing.workWithFile();
            String resultToPrint = fileInternalProcessing.buildStringFromMap();

            printTheResults(output, resultToPrint);
        } else {
            System.out.println("Be sure to specify filename then parameter for output, such as \"<name of the executable class> <input_file> <parameter> (console or file)\"");
        }
    }

    private static Output selectOutputSource(String outputDataGoesTo) {
        if (outputDataGoesTo.equals("console") || outputDataGoesTo.equals("file")) {
            Output outputProcessing = null;
            if (outputDataGoesTo.equals("console")) {
                outputProcessing = new FileOutputProcessing();
            } else if (outputDataGoesTo.equals("file")) {
                outputProcessing = new ConsoleOutputProcessing();
            }
            return outputProcessing;
        } else {
            System.out.println("Please specify the output destination correctly\n");
            throw new RuntimeException();
        }
    }

    private static void printTheResults(Output outputProcessing, String result) {
        outputProcessing.print(result);
    }
}