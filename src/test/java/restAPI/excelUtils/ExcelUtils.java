package restAPI.excelUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;

    public ExcelUtils(String exelPath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(exelPath);
        sheet = workbook.getSheet(sheetName);
    }

    public Object getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        return value;

//        This code doesn't work properly (In out put Null pointer exception??)
//        cell = sheet.getRow(rowNum).getCell(colNum);
//        Object value = null;
//        if(cell.getCellType() == CellType.STRING){
//            value = cell.getStringCellValue();
//        } else if(cell.getCellType() == CellType.NUMERIC){
//            value = cell.getNumericCellValue();
//        }
//        return value;
    }

    public int getRowCount() {
        int rowCount = 0;
        return rowCount = sheet.getPhysicalNumberOfRows();
    }

    public int getColCount() {
        int colCount = 0;
        return colCount = sheet.getRow(0).getPhysicalNumberOfCells();
    }

}
