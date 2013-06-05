package org.xander.FileAnalyzer;

public class FileInputProcessing {
    public static void main( String[] args ) {
        String fileToOpen = args[0];
        FileInternalProcessing fileInternalProcessing = new FileInternalProcessing(fileToOpen);
        fileInternalProcessing.workWithFile();
    }
}