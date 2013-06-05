import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnit44Runner;

import java.io.DataInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnit44Runner.class)
public class FileInputProcessingTest {
    @Mock DataInputStream dataInputStream;
    @InjectMocks
    FileInternalProcessing fileInternalProcessing = new FileInternalProcessing("animalsTest.txt");

    @Test
    public void readLineTest() throws IOException {
        fileInternalProcessing.workWithFile();

        assertEquals(fileInternalProcessing.getTokens()[0], "leo");
        assertEquals(fileInternalProcessing.getTokens()[1], "tiger");
        assertEquals(fileInternalProcessing.getTokens()[2], "cat");
        assertEquals(fileInternalProcessing.getTokens()[3], "dog");
    }
}
