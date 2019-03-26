package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.TestBase;

public class Utility extends TestBase {

	
	public static  Workbook wb;
	public static  Sheet s;
	public static String getDataFromExcel(String SheetName,String Column){
		String data = null;	
	
		
		
		try {
			FileInputStream fa = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\Data.xlsx");
			wb=WorkbookFactory.create(fa);
			s=wb.getSheet(SheetName);
			Row row=s.getRow(0);
			Cell cell=null;
			int colnum=-1;
			for(int i=0;i<row.getLastCellNum();i++){
				
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(Column))
					colnum=i;	
			}
			row=s.getRow(1);
			cell=row.getCell(colnum);
			
			
			if(cell.getCellTypeEnum()==CellType.STRING){
				data=cell.getStringCellValue();	
			}
			else if(cell.getCellTypeEnum()==CellType.NUMERIC){
				data=String.valueOf(cell.getNumericCellValue());
			}
			
			
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	return data;	
}
	
	



	public static void takeScreenshotAtEndOfTest() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdirectory= System.getProperty("user.dir");
		Date d = new Date();
		DateFormat date= new SimpleDateFormat("dd/mm/YYYY");
		String todaydate=date.format(d);
		FileUtils.copyFile(src, new File(currentdirectory+"/screenshots/"+todaydate+".png"));
	}
	
	
	
	
	
	
}
