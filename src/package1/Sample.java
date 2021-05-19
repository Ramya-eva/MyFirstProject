package package1;

import java.io.*;
import java.util.*;
import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;

/**
 * @author tkmaen6
 *
 */
public class Sample
{

  /**
   * @param args
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException
  {
    //Input Folder
     String FileName="E:\\Cognos\\KohStageConversionRate\\SampleFile.csv";
     //Output Destination Path
     String FileName1="E:\\Cognos\\OutputFile\\SampleFile_Output.csv";
     BufferedReader reader = new BufferedReader(new FileReader(FileName));
     //Primary Keys
     String[] FileHeader= {"Promise Date","Agent ID","Dun Lvl","Trxn Cnt"};
     //Duplicate File created
     String DuplicateFileName="E:\\Cognos\\Duplicates\\Duplicate_SampleFile.csv";
     
     BufferedWriter writer = new BufferedWriter(new FileWriter(FileName1));
     BufferedWriter DuplicateWriter=new BufferedWriter(new FileWriter(DuplicateFileName));
    //Write Header in Output file and Duplicate File
     String Header=reader.readLine();
     writer.write(Header);
     writer.newLine();
     DuplicateWriter.write(Header);
     DuplicateWriter.newLine();
     
     
     ICsvMapReader mapReader = new CsvMapReader(new FileReader(FileName), CsvPreference.EXCEL_PREFERENCE);
     final String[] headers = mapReader.getHeader(true);
     Set<String> lines = new LinkedHashSet<String>(10000);
     Map<String, String> row;
     String Line;
     //Duplicate Program
       while( ( row=mapReader.read(headers)) != null && ((Line=reader.readLine())!=null) )
       {
         StringBuffer DuplicateLine=new StringBuffer();
         for (String header : FileHeader) 
         {
             DuplicateLine.append(row.get(header));
         }
         String DuplicateRow=DuplicateLine.toString();
         if(lines.add(DuplicateRow))
         {
            writer.write(Line);
            writer.newLine();
         }
         else
         {
           DuplicateWriter.write(Line);
           DuplicateWriter.newLine();
         }
       }
     writer.close();
     DuplicateWriter.close();
  }
}
   






















/*String filename ="E:\\Cognos\\KohStageConversionRate\\PromisesSe.csv";
   CSVReader reader;
   reader = new CSVReader(new FileReader(filename));
   String[] row;

   while ((row = reader.readNext()) != null) 
   {
           for (int i = 0; i < row.length; i++) 
           {
                   // display CSV values
                   System.out.println("Cell column index: " + i);
                   System.out.println("Cell Value: " + row[i]);
                   System.out.println("-------------");
           }
   }
      
        
  }*/
  


