public class FileInputProcessing {
    public static void main( String[] args ) {
        String fileToOpen = args[0];
        String outputDataGoesTo = args[1];
        FileInternalProcessing fileInternalProcessing = new FileInternalProcessing(fileToOpen);
        fileInternalProcessing.workWithFile();
        fileInternalProcessing.showTheResults(outputDataGoesTo);
    }
}