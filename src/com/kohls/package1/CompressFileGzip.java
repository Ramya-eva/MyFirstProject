package com.kohls.package1;
import java.io.*;
import java.util.zip.GZIPInputStream;
/**
 * @author tkmaen6
 *
 */
public class CompressFileGzip 
{
    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException 
    {
        final File folder = new File("E:\\Cognos");
        listFilesForFolder(folder);
    }
    /**
     * @param folder
     * @throws IOException 
     */
    public static void listFilesForFolder(final File folder) throws IOException 
    {
      for (final File fileEntry : folder.listFiles())
      {
          if (fileEntry.isDirectory())
          {
           listFilesForFolder(fileEntry);
          }
          else
          {
            byte[] buffer = new byte[1024];
            String FileName=fileEntry.getAbsolutePath();
            if(FileName.endsWith(".csv"))
            {
              //System.out.println(FileName);
            }
            else
            {
              StringBuffer BufferName=new StringBuffer(FileName);
              String FinalFileName=BufferName.substring(0, BufferName.length()-3);
              FileInputStream fileIn = new FileInputStream(fileEntry);
              GZIPInputStream gZIPInputStream = new GZIPInputStream(fileIn);
              FileOutputStream fileOutputStream = new FileOutputStream(FinalFileName);
              int bytes_read;
              while ((bytes_read = gZIPInputStream.read(buffer)) > 0)
              {
                fileOutputStream.write(buffer, 0, bytes_read);
              }
              gZIPInputStream.close();
              fileOutputStream.close();
              fileEntry.delete();
            }
          }
      }
  }
}