package FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyTextFileIO
{
   // Writes the given string to a file with the given file name
   public void writeToFile(String fileName, String str) throws FileNotFoundException
   {
      write(fileName, str, false);  
   }
 
   // Appends the given string to a file with the given file name
   public void appendToFile(String fileName, String str) throws FileNotFoundException
   {
      write(fileName, str, true);    
   }
   
   // writeToFile and appendToFile are almost identical - only the boolean in the constructor
   // of the FileOutputStream differs. So I made this private method that both methods call
   private void write(String fileName, String str, boolean append) throws FileNotFoundException
   {
      PrintWriter writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
         writeToFile = new PrintWriter(fileOutStream);
         writeToFile.println(str);
      }
      finally
      {
         if (writeToFile != null)
         {
            writeToFile.close();
         }
      }
   }

   // Writes the strings in the given array to a file with the given file name
   public void writeToFile(String fileName, String[] strs) throws FileNotFoundException
   {
      write(fileName, strs, false);
   }

   // Appends the strings in the given array to a file with the given file name
   public void appendToFile(String fileName, String[] strs) throws FileNotFoundException
   {
      write(fileName, strs, true);
   }

   // Again the writeToFile and appendToFile with arrays are almost identical. 
   // So I made this private method that both methods call
   private void write(String fileName, String[] strs, boolean append) throws FileNotFoundException
   {
      PrintWriter writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
         writeToFile = new PrintWriter(fileOutStream);

         for (int i = 0; i < strs.length; i++)
         {
            writeToFile.println(strs[i]);
         }
      }
      finally
      {
         if (writeToFile != null)
         {
            writeToFile.close();
         }
      }
   }
  
   // Reads the first line from the file with the given file name and returns it as a String
   public String readStringFromFile(String fileName) throws FileNotFoundException
   {
      Scanner readFromFile = null;
      String str = "";

      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new Scanner(fileInStream);
         str = readFromFile.nextLine();
      }
      finally
      {
         if (readFromFile != null)
         {
            readFromFile.close();
         }
      }
      return str;
   }

   // Reads all lines from the file with the given file name and returns it as a String[]
   public String[] readArrayFromFile(String fileName) throws FileNotFoundException
   {
      Scanner readFromFile = null;
      ArrayList<String> strs = new ArrayList<String>();
  
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new Scanner(fileInStream);

         while (readFromFile.hasNext())
         {
            strs.add(readFromFile.nextLine());
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            readFromFile.close();
         }
      }

      String[] strsArray = new String[strs.size()];
      return strs.toArray(strsArray);
   }
}