package Testcases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    // Method to get data from a specific sheet by name
    public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        if (sheet == null) {
            System.out.println("Sheet not found: " + sheetName);
            throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist.");
        }
        return readSheet(sheet);
    }

    // Method to get data from a specific sheet by index
    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber) throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet);
    }

    // New method to get data from all sheets in the workbook
    public Map<String, List<Map<String, String>>> getAllData(String excelFilePath) throws InvalidFormatException, IOException {
        Workbook workbook = getWorkbook(excelFilePath);
        Map<String, List<Map<String, String>>> allData = new HashMap<>();

        // Iterate over all sheets in the workbook
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            String sheetName = sheet.getSheetName();
            List<Map<String, String>> sheetData = readSheet(sheet); // Read the data from the sheet
            allData.put(sheetName, sheetData); // Store data by sheet name
        }

        workbook.close(); // Close the workbook after use
        return allData; // Return the map containing all sheet data
    }

    // Helper method to get a sheet by name
    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        return getWorkbook(excelFilePath).getSheet(sheetName);
    }

    // Helper method to get a sheet by index
    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        return getWorkbook(excelFilePath).getSheetAt(sheetNumber);
    }

    // Helper method to create a Workbook instance
    private Workbook getWorkbook(String excelFilePath) throws IOException, InvalidFormatException {
    	   Workbook workbook = WorkbookFactory.create(new File(excelFilePath));

    	    // Print out all sheet names for debugging purposes
    	    System.out.println("Available sheets in the workbook:");
    	    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
    	        System.out.println(workbook.getSheetName(i));
    	    }

    	    return workbook;
    }

    // Method to read data from a sheet and return it as a list of maps
    private List<Map<String, String>> readSheet(Sheet sheet) {
        List<Map<String, String>> data = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();
        
        
        if (!rowIterator.hasNext()) {
            System.out.println("Sheet is empty " + sheet.getSheetName() + " does not contain any rows.");
            return data; // Return empty data if no rows found
        }

        
        // Assuming the first row contains headers
        Row headerRow = rowIterator.next();
        List<String> headers = new ArrayList<>();
        headerRow.forEach(cell -> headers.add(cell.getStringCellValue()));

        // Iterate through the remaining rows
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Map<String, String> rowData = new LinkedHashMap<>();

            // For each header, get the corresponding cell value in the row
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                rowData.put(headers.get(i), getCellValueAsString(cell));
            }

            data.add(rowData);
        }

        return data;
    }

    // Helper method to convert cell value to string
    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}

