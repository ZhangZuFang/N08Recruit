package main.java.util;

import java.io.IOException;      
import java.io.InputStream;      
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;        
     
import org.apache.poi.hssf.usermodel.HSSFCell;      
import org.apache.poi.hssf.usermodel.HSSFDateUtil;  
import org.apache.poi.hssf.usermodel.HSSFRow;      
import org.apache.poi.hssf.usermodel.HSSFSheet;      
import org.apache.poi.hssf.usermodel.HSSFWorkbook;      
import org.apache.poi.poifs.filesystem.POIFSFileSystem;   


/**    
 * 操作Excel表格的功能类    
 * @author：   
 * @version    
 */     
public class ExcelReader {      
    private POIFSFileSystem fs;      
    private HSSFWorkbook wb;      
    private HSSFSheet sheet;      
    private HSSFRow row;      
   

    /**    
     * 读取Excel表格表头的属性   
     * @param InputStream    
     * @return String 表头内容的数组    
     *     
     */     
    //参数is为输入流，是以excel文件为参数创建的输入流
    public String[] readExcelTitle(InputStream is) {      
        try {      
            //通过POIFSFileSystem对象可以对基于excel得到的数据流对象进行传入传出
            fs = new POIFSFileSystem(is);  
            //最终把excel读到wb里
            wb = new HSSFWorkbook(fs);      
        } catch (IOException e) {      
            e.printStackTrace();      
        }     
        //读取第一页,一般一个excel文件会有三个工作表，这里获取第一个工作表来进行操作
        sheet = wb.getSheetAt(0);      
        //创建一个行对象
        row = sheet.getRow(0);      
        //标题总列数      
        int colNum = row.getPhysicalNumberOfCells();      
        String[] title = new String[colNum];      
        for (int i=0; i<colNum; i++) {      
            title[i] = getTitleValue(row.getCell((short) i));      
        }      
        return title;      
    }      

          
    /**    
     * 获取单元格数据内容为字符串类型的数据    
     * @param cell Excel单元格    
     * @return String 单元格数据内容，若为字符串的要加单引号    
     */     
    public String getStringCellValue(HSSFCell cell) {      
        String strCell = ""; 
        if (cell != null) {
        switch (cell.getCellType()) {      
        case HSSFCell.CELL_TYPE_STRING:      
            strCell = "'" + cell.getStringCellValue() + "'";      
            break;      
        case HSSFCell.CELL_TYPE_NUMERIC:      
                
               strCell = String.valueOf(cell.getNumericCellValue());     
             
            break;      
        case HSSFCell.CELL_TYPE_BOOLEAN:      
            strCell = String.valueOf(cell.getBooleanCellValue());      
            break;      
        case HSSFCell.CELL_TYPE_BLANK:      
            strCell = "''";      
            break;     
        default:      
            strCell = "''";      
            break;      
        } 
        }
        if (strCell.equals("''") || strCell == null) {      
            return "";      
        }      
        if (cell == null) {      
            return "";      
        }      
        return strCell;      
    }      
      
    public String getTitleValue(HSSFCell cell) {      
        String strCell =  cell.getStringCellValue();      
        return strCell;      
    }      
          
}  