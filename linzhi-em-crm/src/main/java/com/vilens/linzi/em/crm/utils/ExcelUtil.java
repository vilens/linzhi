package com.vilens.linzi.em.crm.utils;

import javax.servlet.ServletOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.collections.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * Created by vilens on 2017/6/1.
 */
public class ExcelUtil {

    public static void exportExcel(InputStream input, OutputStream out, List<Map<String, Object>> list, LinkedHashMap<String, String> keys2titlesMap) throws Exception {
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet("data");
        Row rowHeader = sh.createRow(0);
        Iterator<String> keys = keys2titlesMap.keySet().iterator();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        List<String> keyList = new ArrayList<String>();
        while (keys.hasNext()) {
            String key = keys.next();
            keyList.add(key);
            String title = keys2titlesMap.get(key);
            Cell cellHeader = rowHeader.createCell(i++);
            cellHeader.setCellValue(title);
        }

        for (int rownum = 1; rownum <= list.size(); rownum++) {
            Row row = sh.createRow(rownum);
            Map<String, Object> dataMap = list.get(rownum - 1);
            i = 0;

//			while(keys.hasNext()) {
            for (String key : keyList) {
//				String key = keys.next();
                Cell cell = row.createCell(i++);
                if (dataMap.get(key) instanceof String) {
                    cell.setCellValue(MapUtils.getString(dataMap, key));
                } else if (dataMap.get(key) instanceof Date) {
                    cell.setCellValue(simpleDateFormat.format(MapUtil.getDate(dataMap, key)));
                } else if (dataMap.get(key) instanceof Number) {
                    cell.setCellValue(MapUtils.getDouble(dataMap, key));
                } else if (dataMap.get(key) instanceof Boolean) {
                    cell.setCellValue(MapUtils.getBooleanValue(dataMap, key));
                }
            }
            if (rownum % 100 == 0) {
                ((SXSSFSheet) sh).flushRows();
            }
        }
        wb.write(out);
        out.close();
    }

    public static void exportExcel(InputStream input, OutputStream out, List<Map<String, Object>> list, ArrayList<String> titleList, String sheetName) throws Exception {
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet(sheetName != null && sheetName.trim() != "" ? sheetName : "data");
        Row rowHeader = sh.createRow(0);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < titleList.size() - 1; i++) {
            Cell cellHeader = rowHeader.createCell(i);
            cellHeader.setCellValue(titleList.get(i));
        }

        for (int rownum = 0; rownum <= list.size() - 1; rownum++) {
            Row row = sh.createRow(rownum + 1);
            Map<String, Object> dataMap = list.get(rownum);
            Set<String> keySet = dataMap.keySet();
            int i = 0;
            for (String key : keySet) {
                Cell cell = row.createCell(i++);
                if (dataMap.get(key) instanceof String) {
                    cell.setCellValue(MapUtils.getString(dataMap, key));
                } else if (dataMap.get(key) instanceof Date) {
                    cell.setCellValue(simpleDateFormat.format(MapUtil.getDate(dataMap, key)));
                } else if (dataMap.get(key) instanceof Number) {
                    cell.setCellValue(MapUtils.getDouble(dataMap, key));
                } else if (dataMap.get(key) instanceof Boolean) {
                    cell.setCellValue(MapUtils.getBooleanValue(dataMap, key));
                }
            }
            if (rownum % 100 == 0) {
                ((SXSSFSheet) sh).flushRows();
            }
        }
        wb.write(out);
        out.close();
    }


    public void exportExcelInLocal(List<Map<String, Object>> list, LinkedHashMap<String, String> keys2titlesMap) throws Exception {
        OutputStream out = null;
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet("data");
        Row rowHeader = sh.createRow(0);
        Iterator<String> keys = keys2titlesMap.keySet().iterator();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        List<String> keyList = new ArrayList<String>();
        while (keys.hasNext()) {
            String key = keys.next();
            keyList.add(key);
            String title = keys2titlesMap.get(key);
            Cell cellHeader = rowHeader.createCell(i++);
            cellHeader.setCellValue(title);
        }

        for (int rownum = 1; rownum <= list.size(); rownum++) {
            Row row = sh.createRow(rownum);
            Map<String, Object> dataMap = list.get(rownum - 1);
            i = 0;

//			while(keys.hasNext()) {
            for (String key : keyList) {
//				String key = keys.next();
                Cell cell = row.createCell(i++);
                if (dataMap.get(key) instanceof String) {
                    cell.setCellValue(MapUtils.getString(dataMap, key));
                } else if (dataMap.get(key) instanceof Date) {
                    cell.setCellValue(simpleDateFormat.format(MapUtil.getDate(dataMap, key)));
                } else if (dataMap.get(key) instanceof Number) {
                    cell.setCellValue(MapUtils.getDouble(dataMap, key));
                } else if (dataMap.get(key) instanceof Boolean) {
                    cell.setCellValue(MapUtils.getBooleanValue(dataMap, key));
                }
            }
            if (rownum % 100 == 0) {
                ((SXSSFSheet) sh).flushRows();
            }
        }
        out = new FileOutputStream("D://data.xlsx");
        wb.write(out);
        out.close();
    }

    public static List<Map<String, Object>> importExcel(InputStream input, String[] keys) throws Exception {
        Workbook wb = WorkbookFactory.create(input);
        Sheet sheet = wb.getSheetAt(0);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int rownum = 1; rownum <= sheet.getLastRowNum(); rownum++) {
            Row row = sheet.getRow(rownum);
            if (row == null) {
                continue;
            }
            Map<String, Object> map = new HashMap<String, Object>();
            for (int cellnum = 0; cellnum < row.getLastCellNum(); cellnum++) {
                Cell cell = row.getCell(cellnum);
                int valType = cell.getCellType();
                if (valType == Cell.CELL_TYPE_STRING) {
                    map.put(keys[cellnum], cell.getStringCellValue());
                } else if (valType == Cell.CELL_TYPE_BOOLEAN) {
                    map.put(keys[cellnum], cell.getBooleanCellValue());
                } else if (valType == Cell.CELL_TYPE_NUMERIC) {
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        //用于转化为日期格式
                        Date d = cell.getDateCellValue();
                        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                        map.put(keys[cellnum], formater.format(d));
                    } else {
                        map.put(keys[cellnum], cell.getNumericCellValue());
                    }
                }
            }
            list.add(map);
        }
        return list;
    }


    public static void exportExcelLog(ServletOutputStream outputStream) throws Exception {
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet("data");
        Row rowHeader = sh.createRow(0);

        Cell cellHeader = rowHeader.createCell(1);
        cellHeader.setCellValue("查询信息失败!");
        wb.write(outputStream);
        outputStream.close();
    }
}
