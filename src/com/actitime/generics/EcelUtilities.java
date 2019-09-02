package com.actitime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Aruna
 * reviewed by aruna
 * Created on 10/7/2018at 18.14pm

*/
public class EcelUtilities

{
	/**
	 * 
	 * @param filePath
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
       public static String readData(String filePath, String sheet, int row, int cell) 
       {   
    	  
       
    	   String value = null;
    	   
    	   try 
    	   {
    		   Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));
    		   value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
    	   }
    	   
    	   catch(EncryptedDocumentException e) 
    	   {
    		   e.printStackTrace();
    	   }
    	   
    	   catch(InvalidFormatException e) 
    	   {
    		   e.printStackTrace();
    	   }
    	   
    	   catch(FileNotFoundException e)
    	   { 
    		   e.printStackTrace();
    	   }
    	   
    	   catch(IOException e)
    	   { 
    		   e.printStackTrace();
    	   }
    	   
    	   return value;
       }
}
