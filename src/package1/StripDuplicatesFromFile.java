package package1;

import java.io.*;
import java.util.*;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.*;
import org.supercsv.*;
import org.supercsv.prefs.CsvPreference;

/**
 * @author tkmaen6
 *
 */
public class StripDuplicatesFromFile
{
  public static void main(final String[] args) throws IOException
  {
    ICsvMapReader mapReader = new CsvMapReader(new FileReader("E:\\Cognos\\KohStageConversionRate\\a.csv"), CsvPreference.EXCEL_PREFERENCE);
    try {
         final String[] headers = mapReader.getHeader(true);
         String[] FileHeader= {"Promise Date","Agent ID","Dun Lvl","LOB"};
         String FileName="E:\\Cognos\\OutputFile\\ab.csv";
         BufferedReader reader = new BufferedReader(new FileReader("E:\\Cognos\\KohStageConversionRate\\a.csv"));
        String DuplicateFileName="E:\\Cognos\\Duplicates\\PromisesSe_Duplicates_098.csv";
         BufferedWriter writer = new BufferedWriter(new FileWriter(FileName));
         BufferedWriter DuplicateWriter=new BufferedWriter(new FileWriter(DuplicateFileName));
         String Header=reader.readLine();
         writer.write(Header);
         System.out.println(Header);
         Set<String> lines = new LinkedHashSet<String>(10000);
         Map<String, String> row;
         String Line;
        
         LinkedHashMap<String,String> rows;
         while( ( row=mapReader.read(headers)) != null && ( Line=reader.readLine()) != null)
         {
           StringBuffer DuplicateLine=new StringBuffer();
          for (String header : FileHeader) 
          {
            //System.out.println(header);
           DuplicateLine.append(row.get(header));
          }
          String DuplicateRow=DuplicateLine.toString();
          //System.out.println(Line);
          if(lines.add(DuplicateRow))
          {
            System.out.println(Line);
            writer.write(Line);
          }
          else
          {
            DuplicateWriter.write(DuplicateRow);
          }
         }
         writer.close();
         DuplicateWriter.close();
        } 
   
    finally 
    {
     //System.out.println(i);
     
     mapReader.close();
    }
  }

}
   
    
    
    //Reader reader1 = new FileReader("persons.csv");

    //CSVReader csvPersonReader = CSVReader.
   /// List<String[]> persons = csvPersonReader.readAll();
    
   /* String filename ="//test//apps//File//HRPFPExceptions-February2015.csv";
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    Set<String> lines = new LinkedHashSet<String>(10000); // maybe should be bigger
    String line;
    while ((line = reader.readLine()) != null) 
    {
        lines.add(line);
    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    for (String unique : lines)
    {
        writer.write(unique);
        writer.newLine();
    }
    writer.close();*/
  //}

//}
