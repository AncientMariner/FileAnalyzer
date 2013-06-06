public class FileInputProcessing {
    public static void main( String[] args ) {
        if(args != null && args.length == 2) {
            String fileToOpen = args[0];
            String outputDataGoesTo = args[1];

            FileInternalProcessing fileInternalProcessing = new FileInternalProcessing(fileToOpen);
            fileInternalProcessing.workWithFile();

            String resultToPrint = fileInternalProcessing.buildAStringFromMap();
            printTheResults(outputDataGoesTo, resultToPrint);
        } else {
            System.out.println("Be sure to specify filename than parameter for output, such as \"<name of the executable class> <input_file> <parameter> (console or file)\"");
        }
    }

    private static void printTheResults(String outputDataGoesTo, String result) {
        FileOutputProcessing fileOutputProcessing = new FileOutputProcessing();
        if(outputDataGoesTo.equals("console")) {
            fileOutputProcessing.printTheFrequencyResultToConsole(result);
        } else if (outputDataGoesTo.equals("file")){
            fileOutputProcessing.printTheFrequencyResultToFile(result);
        } else {
            System.out.println("Please specify the output destination correctly");
        }
    }
}