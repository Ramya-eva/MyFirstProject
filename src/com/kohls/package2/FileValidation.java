package com.kohls.package2;

import com.kohls.package1.TrialClass;

public class FileValidation
{
  public void Validate_Method(String FileName,String TableName)
  {
    FileValidation obj=new FileValidation();
    String PrimaryHeader=obj.GetPrimaryKeys(TableName);
    obj.removeduplictaes(FileName,PrimaryHeader);
    obj.removeNulls(FileName,PrimaryHeader);
  }

  private void removeNulls(String FileName,String TableName)
  {
    // TODO Auto-generated method stub
    
  }

  private void removeduplictaes(String FileName,String TableName)
  {
    // TODO Auto-generated method stub
    
  }
  private String GetPrimaryKeys(String TableName)
  {
    String TableHeader = null;
    return TableHeader;
  }
}
