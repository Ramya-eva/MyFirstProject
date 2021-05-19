package package1;

import java.io.*;
import java.util.*;
import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;

public class CheckSampleFolder
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    CheckSampleFolder object=new  CheckSampleFolder();
    //Pass the root folder 
    String InputRoot="E:\\Cognos\\kohStageGenericMetric";
    String OutputRoot="E:\\Cognos\\OutputFile";
    //Retrieve the Input File Path and Output File Path
    Map<String, String> data=object.RetrieveFilePath(InputRoot,OutputRoot);
    for (Map.Entry<String, String> entry : data.entrySet()) 
    {
      String key = entry.getKey();
      Object value = entry.getValue();
      System.out.println("FileNAME:"+key+"     Output Filename:"+value);
    }
    
  }


  private void RemoveDuplicatesGenericMetric(String CSVFile, String outputFileName) throws IOException
  {
    String FileName=CSVFile;
    ICsvMapReader mapReader = new CsvMapReader(new FileReader(FileName), CsvPreference.EXCEL_PREFERENCE);
    final String[] headers = mapReader.getHeader(true);
    BufferedReader reader = new BufferedReader(new FileReader(FileName));
    String[] FileHeader= {"MetricDate","PayeeID","LineOfBusiness","MetricType","Category","Channel","Status","CallID"};
    StringBuffer buffer =new StringBuffer(CSVFile);
    
    
  }
  
  
  private Map<String, String> RetrieveFilePath(String inputRoot, String outputRoot)
  {
    File Folder=new File(inputRoot);
    //FileList array will contain all the files in the root folder
    File[] ListOfFiles=Folder.listFiles();
    Map<String, String> Maps = new HashMap<String, String>();
    for(int i=0;i<ListOfFiles.length;i++)
    {
      //Inserting both file name and output file in the Map
      StringBuffer OutputFilepath=new StringBuffer(outputRoot);
      OutputFilepath.append('\\');
      String FilePath = ListOfFiles[i].getAbsolutePath();
      String FileName=ListOfFiles[i].getName();
      String OutputFileName=OutputFilepath.append(FileName).toString();
      Maps.put(FilePath, OutputFileName);
      OutputFilepath.delete(0, OutputFilepath.length());
    }
    return Maps;
  }

}
