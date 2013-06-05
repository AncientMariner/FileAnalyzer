package org.xander.FileAnalyzer;


import org.junit.Test;

public class FileInputProcessingTest {
    @Test
    public void fileInputProcessingTest() {
        FileInternalProcessing fileInternalProcessing = new FileInternalProcessing("animalsTest.txt");
        fileInternalProcessing.workWithFile();
    }
}
