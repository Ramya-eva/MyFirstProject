package com.kohls.package2;

import java.io.*;
import java.util.*;

public class FileCollection
{
  Map<String,String> FileDictionary=new HashMap<String,String>(200);
  Properties loc_props = new Properties();
  public String GetTargetTableName(String FileName) throws IOException
  {
    FileCollection object=new FileCollection();
    //object.ReadThePropertyFile();
    String TableName = object.FindTableName(FileName);
    return TableName;
    
  }

  private String FindTableName(String fileName)
  {
    // TODO Auto-generated method stub
    return null;
  }

  private void ReadThePropertyFile() throws IOException
  {
    loc_props.load(new FileInputStream("config.property"));
    String props_path = loc_props.getProperty("Properties_Location");
    ResourceBundle props = new PropertyResourceBundle(new FileInputStream(props_path + "FileIndex.Properties"));
    Enumeration<String> en=props.getKeys();
    while(en.hasMoreElements())
    {
      String key=en.nextElement();
      String[] splitthekey=key.split("_");
      String tableIdentifier=splitthekey[0];
      String fileName=props.getString(key); 
      AddKeyInCollection(tableIdentifier,fileName);
    }  
  }

  private void AddKeyInCollection(String tableIdentifier, String fileName)
  {
    FileDictionary.put(tableIdentifier, fileName);
  }

  public File FetchFileinpath() throws FileNotFoundException, IOException
  {
    loc_props.load(new FileInputStream("config.property"));
    String props_path = loc_props.getProperty("Properties_Location");
    ResourceBundle props1 = new PropertyResourceBundle(new FileInputStream(props_path + "Path.properties"));
    String inputRoot=props1.getString("Source");
    File folder=new File(inputRoot);
    File[] listOfFiles=folder.listFiles();
    for(int i=0;i<listOfFiles.length;i++)
    {
      System.out.println(listOfFiles[i]);
    }
    return null;
  }
  
}
