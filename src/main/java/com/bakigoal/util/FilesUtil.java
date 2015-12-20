package com.bakigoal.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ilmir on 19.12.15.
 */
public class FilesUtil {

  public static void writeBytesToFile(byte[] data, String fileName) throws IOException {
    File file = new File(fileName);
    FileOutputStream fileOuputStream = new FileOutputStream(file);
    fileOuputStream.write(data);
    fileOuputStream.close();
  }

  public static void deleteAllFilesInDirectory(String filesDir) {
    File directory = new File(filesDir);

    // Get all files in directory
    File[] files = directory.listFiles();
    for (File file : files) {
      // Delete each file
      if (!file.delete()) {
        // Failed to delete file
        System.out.println("Failed to delete " + file);
      }
    }
  }
}
