import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.DataInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FileInputProcessingTest {
    @Mock DataInputStream dataInputStream;
    @InjectMocks
    FileInternalProcessing fileInternalProcessing = new FileInternalProcessing("animalsTest.txt");

    @Test
    public void readLineTest() throws IOException {
        fileInternalProcessing.workWithFile();

        assertEquals(fileInternalProcessing.getWordsInLine()[0], "leo");
        assertEquals(fileInternalProcessing.getWordsInLine()[1], "tiger");
        assertEquals(fileInternalProcessing.getWordsInLine()[2], "cat");
        assertEquals(fileInternalProcessing.getWordsInLine()[3], "dog");
    }
}
