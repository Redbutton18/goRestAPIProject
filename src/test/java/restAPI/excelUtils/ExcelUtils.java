package restAPI.excelUtils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String exelPath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(exelPath);
        sheet = workbook.getSheet(sheetName);
    }

    public Object getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        return value;
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
