package org.xander.FileAnalyzer;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInternalProcessing {
    public String fileName;
    public FileInternalProcessing(String fileName) {
        this.fileName = fileName;
    }

  public void workWithFile () {
      try {
        FileInputStream fis = new FileInputStream(fileName);
        DataInputStream in = new DataInputStream(fis);
        String line;
        while((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    } catch (IOException e) {
        System.out.println("Something went wrong with the file opening, please try again");
        e.printStackTrace();
    }
  }
}