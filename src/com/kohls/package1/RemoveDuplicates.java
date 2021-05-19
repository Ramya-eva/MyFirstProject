package com.kohls.package1;
import java.io.*;
import java.util.*;
public class RemoveDuplicates
{
  /**
   * @param args
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException
  {
      RemoveDuplicates object=new RemoveDuplicates();
      File Folder=new File("E:\\Cognos\\KohStageConversionRate");
      String[] FileList=object.CollectAllFiles(Folder);
/*      for(int i=0;i<FileList.length;i++)
      {
        object.RemoveDuplicates(FileList[i]);
      }*/
  }
  private void RemoveDuplicates(String CsvFile) throws IOException
  {
    String NameOfFile = CsvFile;
    BufferedReader br = new BufferedReader(new FileReader(NameOfFile));
    BufferedWriter writer = new BufferedWriter(new FileWriter(NameOfFile));
    BufferedWriter DuplicateWriter=new BufferedWriter(new FileWriter(NameOfFile));
    Set<String> lines = new LinkedHashSet<String>(10000);
    String DuplicateLine;
    String line;
    while ((line = br.readLine()) != null) 
    {
      DuplicateLine=line;
      DuplicateLine = line.substring(0, DuplicateLine.lastIndexOf(","));
      DuplicateLine= DuplicateLine.substring(0, line.lastIndexOf(","));
      DuplicateLine=DuplicateLine.substring(0,line.lastIndexOf(","));
      if(lines.add(DuplicateLine))
      {
        writer.write(line);
      }
      else
      {
        DuplicateWriter.write(DuplicateLine);
      }
    }

    
  }

  private String[] CollectAllFiles(File folder)
  {
    File[] ListOfFiles=folder.listFiles();
    String[] FileList=new String[5];
    for(int i=0;i<ListOfFiles.length;i++)
    {
      String FileNames = ListOfFiles[i].getName();
      FileList[i]=FileNames;
    }
    return FileList;
  }
}
