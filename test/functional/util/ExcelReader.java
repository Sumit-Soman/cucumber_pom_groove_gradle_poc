package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	
	POIFSFileSystem fs = null;
    FileOutputStream oStream = null;
    Workbook wb = null;
    Sheet sheet;
    Row row;
    Cell cell;		
    
	public int getRowCount(String sheetName){
		try{	
			// sleep added for Jenkins execution...
			Thread.sleep(15000);
			reader(sheetName);
			return sheet.getLastRowNum();
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}

	private void reader(String path) throws Exception {
		try {
			File f = new File(path);
			System.out.println("----------------------------------");
			System.out.println(f.canRead());
			System.out.println(f.exists());
			System.out.println(f.length());
			
			System.out.println("----------------------------------");
			
			fs = new POIFSFileSystem(new FileInputStream(path));
		    wb = new HSSFWorkbook(fs);
		    sheet = wb.getSheetAt(0);
		} catch (Exception e) {
			throw e;
		}
	}
}
