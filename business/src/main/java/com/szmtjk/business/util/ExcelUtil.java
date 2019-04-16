package com.szmtjk.business.util;

import com.szmtjk.business.service.excel.ExamReportExcelDisposer;
import com.xxx.common.bean.JsonRet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by xiaohu on 2018/12/29.
 */
public class ExcelUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelUtil.class);

    private static final String SUFFIX_2003 = ".xls";
    private static final String SUFFIX_2007 = ".xlsx";

//    public static List<String> getItemListFromExcel (final MultipartFile excelFile) throws Exception {
//        // 入参检查
//        if(null == excelFile){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][excelFile is null]");
//            throw new IllegalArgumentException("excel文件未上传成功,请检查重试");
//        }
//        // 获得Workbook工作薄对象
//        Workbook workbook = getWorkBook(excelFile);
//        //  创建返回对象，部分商品优惠只有一行,行数据为items,顾解析后用list直接返回
//        if(null == workbook){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][get workbook failure][fileName={}]", excelFile.getOriginalFilename());
//            throw new IllegalArgumentException("excel文件解析失败,请检查模版");
//        }
//        if(workbook.getNumberOfSheets() != 1){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][workbook.getNumberOfSheets() != 1][fileName={},numberOfSheets={}]",
//                    excelFile.getOriginalFilename(), workbook.getNumberOfSheets());
//            throw new IllegalArgumentException("excel文件解析失败(sheet必须为1),请检查模版");
//        }
//        // 获得当前sheet工作表,仅获取
//        Sheet sheet = workbook.getSheetAt(0);
//        // 只识别第1行开始的第0列
//        List<String> result = Lists.newArrayList();
//        // 循环除了第一行的所有行
//        for(int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
//            //获得当前行
//            Row row = sheet.getRow(rowNum);
//            if(row == null){
//                continue;
//            }
//            // 获取第一列数据
//            String cellValue = getCellValue(row.getCell(0));
//            if(StringUtils.isNotBlank(cellValue)){
//                result.add(cellValue);
//            }
//        }
//        if(result.size() > 1000){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][sheet.getPhysicalNumberOfRows() > 1001][fileName={},physicalNumberOfRows={}]",
//                    excelFile.getOriginalFilename(), sheet.getPhysicalNumberOfRows());
//            throw new IllegalArgumentException("excel文件解析失败,最大支持1000条内容数据");
//        }
//        // 返回结果
//        return result;
//    }

//    public static List<DiscountExcelWrapper> getDiscountWrapperListFromExcel (final MultipartFile excelFile) throws Exception {
//        // 入参检查
//        if(null == excelFile){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][excelFile is null]");
//            throw new IllegalArgumentException("excel文件未上传成功,请检查重试");
//        }
//        // 获得Workbook工作薄对象
//        Workbook workbook = getWorkBook(excelFile);
//        // 创建返回对象，模版包含4列,分别为商品ID,优惠类型,优惠值,抹角抹分
//        if(null == workbook){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][get workbook failure][fileName={}]", excelFile.getOriginalFilename());
//            throw new IllegalArgumentException("excel文件解析失败,请检查模版");
//        }
//        if(workbook.getNumberOfSheets() != 1){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][workbook.getNumberOfSheets() != 1][fileName={},numberOfSheets={}]",
//                    excelFile.getOriginalFilename(), workbook.getNumberOfSheets());
//            throw new IllegalArgumentException("excel文件解析失败(sheet必须为1),请检查模版");
//        }
//        // 获得当前sheet工作表,仅获取
//        Sheet sheet = workbook.getSheetAt(0);
//        // 解析结果
//        List<DiscountExcelWrapper> result = Lists.newArrayList();
//        // 循环除了第一行的所有行
//        for(int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
//            //获得当前行
//            Row row = sheet.getRow(rowNum);
//            if(row == null){
//                continue;
//            }
//            // 获取第1,2,3,4列数据
//            String cellValue1 = getCellValue(row.getCell(0));
//            String cellValue2 = getCellValue(row.getCell(1));
//            String cellValue3 = getCellValue(row.getCell(2));
//            String cellValue4 = getCellValue(row.getCell(3));
//            if(StringUtils.isBlank(cellValue1) || StringUtils.isBlank(cellValue2) || StringUtils.isBlank(cellValue3)){
//                LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][cellValue is blank][fileName={},rowNum={},cellValue1={},cellValue2={},cellValue3={},cellValue4={}]",
//                        excelFile.getOriginalFilename(), rowNum, cellValue1, cellValue2, cellValue3, cellValue4);
//                continue;
//            }
//            result.add(new DiscountExcelWrapper(cellValue1.trim(), cellValue2.trim(), cellValue3.trim(), cellValue4 == null ? String.valueOf(FordConstant.DiscountPrecision.FEN) : cellValue4.trim()));
//        }
//        if(result.size() > 1000){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][sheet.getPhysicalNumberOfRows() > 1001][fileName={},physicalNumberOfRows={}]",
//                    excelFile.getOriginalFilename(), sheet.getPhysicalNumberOfRows());
//            throw new IllegalArgumentException("excel文件解析失败,最大支持1000条内容数据");
//        }
//        // 返回结果
//        return result;
//    }

//    private static  Workbook getWorkBook(final MultipartFile excelFile) throws Exception {
//        // 获得文件名
//        String fileName = excelFile.getOriginalFilename();
//        // 入参检查
//        if(StringUtils.isEmpty(fileName)){
//            LOGGER.error("[ExcelUtils.getWorkBook][fileName is empty]");
//            throw new IllegalArgumentException("filename is empty");
//        }
//        // 判断文件是否是excel文件
//        if(!fileName.endsWith(SUFFIX_2003) && !fileName.endsWith(SUFFIX_2007)){
//            LOGGER.error("[ExcelUtils.getWorkBook][file name is not excel file][fileName={}]", fileName);
//            throw new IllegalArgumentException("not a excel file");
//        }
//        //获取excel文件的io流
//        InputStream is = excelFile.getInputStream();
//        //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
//        if(fileName.endsWith(SUFFIX_2003)) {
//            //2003
//            return new HSSFWorkbook(is);
//        }else {
//            //2007 及2007以上
//            return new XSSFWorkbook(is);
//        }
//    }

    public static String getStrValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        return getCellValue(cell);
    }

    public static String getCellValue(Cell cell) {
        if(cell == null){
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return DateUtils.format(cell.getDateCellValue(), "yyyyy-MM-dd");
                }
                return String.valueOf(cell.getNumericCellValue());
            case STRING:
                return cell.getRichStringCellValue().getString();
            case BLANK:
                return "";
            default:
                LOG.error("ExcelUtil getCellValue, not supported cell type:{}", cell.getCellTypeEnum());
                throw new IllegalArgumentException("cell type not supported");
        }
    }

    public static void main(String[] args) {
        Workbook workbook = null;
        try {
            ExamReportExcelDisposer disposer = new ExamReportExcelDisposer();
            JsonRet<Boolean> ret = disposer.disposeExcel(new File("/Users/xiaohu/exam.xlsx"));
            System.out.println(ret);
            workbook = WorkbookFactory.create(new File("/Users/xiaohu/exam.xlsx"));
            Sheet sheet = workbook.getSheetAt(0);// 只获取第一个sheet作解析
            sheet.forEach(row -> {
                System.out.println(row.getCell(0));
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
