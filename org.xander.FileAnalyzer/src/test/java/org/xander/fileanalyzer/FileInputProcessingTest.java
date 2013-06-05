package org.xander.fileanalyzer;

import java.io.IOException;

import org.junit.Test;

public class FileInputProcessingTest {
    @Test
    public void fileInputProcessingTest() throws IOException {
        FileInternalProcessing fileInternalProcessing = new FileInternalProcessing("animalsTest.txt");
        fileInternalProcessing.workWithFile();
    }
}
