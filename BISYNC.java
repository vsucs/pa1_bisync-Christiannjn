import java.io.*;
import java.nio.file.*;

public class BISYNC {
  public static void printByteCodes(byte[] data) {
    int n = 0;
    for (byte b : data) {
      String st = String.format("%02X ", b);
      System.out.print(st);
      if(n % 16 == 7)
        System.out.print(" | ");
      if(n % 16 == 15)
        System.out.println();
      n++;
    }
  }
  
  public static byte[] bisync_body(byte[] data){
    byte[] body = {};
    // put your code here

    return body;
  }

  public static void main(String[] args){
    if(args.length < 2)
      System.out.println("Usage: java BISYNC [input path] [output path]");
    else{
      String inputPath = args[0];
      String outputPath = args[1];

      byte[] array = {};
      byte[] body = {};
      // Read data
      try{
        array = Files.readAllBytes(Paths.get(inputPath));
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("\nData");
      printByteCodes(array);

      // Convert data to BISYNC body
      body = bisync_body(array);
      
      System.out.println("\nBody");
      printByteCodes(body);

      // Write body
      try{
        Files.write(Paths.get(outputPath), body, StandardOpenOption.CREATE);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}