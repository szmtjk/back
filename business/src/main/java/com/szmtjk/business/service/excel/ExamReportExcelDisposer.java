package com.szmtjk.business.service.excel;

import com.szmtjk.business.model.Exam;
import com.szmtjk.business.model.ExamCategory;
import com.szmtjk.business.model.ExamDetailReport;
import com.szmtjk.business.model.ExamWrapper;
import com.szmtjk.business.service.ExamCategoryService;
import com.szmtjk.business.service.ExamDetailReportService;
import com.szmtjk.business.service.ExamService;
import com.szmtjk.business.service.excel.base.BaseComplicatedExcelDisposer;
import com.szmtjk.business.util.BizUtil;
import com.xxx.common.bean.JsonRet;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ExamReportExcelDisposer extends BaseComplicatedExcelDisposer {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamCategoryService examCategoryService;

    @Autowired
    private ExamDetailReportService examDetailReportService;

    @Override
    protected boolean disposeComplicatedSheetData(Sheet sheet) {
        ExamWrapper examWrapper = new ExamWrapper();
        examWrapper.setExam(getExam(sheet));
        examWrapper.setExamCategoryList(getExamCategoryList(sheet));
        return saveExamReport(examWrapper);
    }

    private boolean saveExamReport(ExamWrapper examWrapper) {
        JsonRet<Long> addRet = examService.add(examWrapper.getExam());
        if (addRet.isSuccess() && addRet.getData() != null) {
            Long examId = addRet.getData();
            examWrapper.getExam().setId(examId);
            if (!saveCategory(examWrapper)) {// 保存失败  todo rollback
                return false;
            }
        }
        return true;
    }

    private boolean saveCategory(ExamWrapper examWrapper) {
        for (ExamCategory category : examWrapper.getExamCategoryList()) {
            category.setExamId(examWrapper.getExam().getId());
            JsonRet<Long> addRet = examCategoryService.add(category);
            if (addRet.isSuccess() && addRet.getData() != null) {
                category.setId(addRet.getData());
                if (!saveDetail(category)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean saveDetail(ExamCategory category) {
        for (ExamDetailReport detail : category.getItems()) {
            detail.setCategoryId(category.getId());
            JsonRet<Long> addRet = examDetailReportService.add(detail);
            if (!addRet.isSuccess()) {
                return false;
            }
        }
        return true;
    }

    private Exam getExam(Sheet sheet) {
        Exam exam = new Exam();
        int lastRowNum = sheet.getLastRowNum();
        exam.setExamNo(getStrCellValue(sheet, 24, 3));
        exam.setFullName(getStrCellValue(sheet, 26, 3));
        exam.setGender(BizUtil.getGender(getStrCellValue(sheet, 28, 3)));
        exam.setAge(Integer.parseInt(getStrCellValue(sheet, 30, 3)));
        exam.setCompany(getStrCellValue(sheet, 32, 3));
        exam.setExamDate(getDateCellValue(sheet, 34, 3));
        exam.setSummaryDoctor(getStrCellValue(sheet, lastRowNum - 1, 2));
        exam.setSummaryDate(getDateFromSummary(getStrCellValue(sheet, lastRowNum - 1, 4)));// to be checked
        exam.setSummary(getStrCellValue(sheet, lastRowNum, 1));
        return exam;
    }

    private List<ExamCategory> getExamCategoryList(Sheet sheet) {
        List<ExamCategory> categoryList = new ArrayList<>();
        ExamCategory category = null;
        Iterator<Row> rowIterator = sheet.rowIterator();
        int examCategorySeq = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (isExamCategoryStarted(row)) {
                category = createNewWrapper(++ examCategorySeq);
                continue;
            }
            if (category == null) {//检查项目类别为空，则跳过，说明没有检测到具体的检查项目
                continue;
            }

            if (isInvalidRow(row, 5)) {
                continue;
            }

            if (isSummaryRow(row, category)) {
                continue;
            }
            if (isSummaryDoctor(row, category)) {
                addNotNullExamCategory(categoryList, category);
                category = null;
                continue;
            }

            if (StringUtils.isNotEmpty(getStrCellValue(row, 0))) {
                addExamDetail(row, category);
            }
        }
        return categoryList;
    }

    private void addExamDetail(Row row, ExamCategory category) {
        ExamDetailReport detail = new ExamDetailReport();
        detail.setItemName(getStrCellValue(row, 0));
        detail.setResult(getStrCellValue(row, 1));
        detail.setItemUnit(getStrCellValue(row, 3));
        detail.setReferenceRange(getStrCellValue(row, 4));
        detail.setTip(getStrCellValue(row, 5));
        category.getItems().add(detail);
    }

    private ExamCategory createNewWrapper(int examCategorySeq) {
        ExamCategory category = new ExamCategory();
        category.setName("项目" + examCategorySeq);
        category.setItems(new ArrayList<>());
        return category;
    }

    private boolean isSummaryDoctor(Row row, ExamCategory category) {
        if ("小结医生：".equals(getStrCellValue(row, 0))) {
            category.setSummaryDoctor(getStrCellValue(row, 1));
            category.setSummaryDate(getDateFromSummary(getStrCellValue(row, 4)));
            return true;
        }
        return false;
    }

    private boolean isSummaryRow(Row row, ExamCategory category) {
        if ("小结：".equals(getStrCellValue(row, 0))) {
            String summary = getStrCellValue(row, 1);
            category.setSummary(summary);
            return true;
        }
        return false;
    }

    private void addNotNullExamCategory(List<ExamCategory> categoryList, ExamCategory category) {
        if (category != null) {
            categoryList.add(category);
        }
    }

    private Date getDateFromSummary(String summaryDate) {
        String sDate = summaryDate.substring(summaryDate.length() - 10);
        try {
            return DateUtils.parseDate(sDate, "yyyy-MM-dd");
        } catch (ParseException e) {
            return null;
        }
    }

    private boolean isExamCategoryStarted(Row row) {
        if (!"项目名称".equals(getStrCellValue(row, 0))) {
            return false;
        }
        if (!"检查结果".equals(getStrCellValue(row, 1))) {
            return false;
        }
        if (!"单位".equals(getStrCellValue(row, 3))) {
            return false;
        }
        if (!"参考范围".equals(getStrCellValue(row, 4))) {
            return false;
        }
        if (!"提示".equals(getStrCellValue(row, 5))) {
            return false;
        }
        return true;
    }

    /**
     * 检验某一行是否是无效行
     * @param row
     * @param cellCount 前多少个单元格
     * @return true: row为null或指定的前N个单元格都为空
     */
    private boolean isInvalidRow(Row row, int cellCount) {
        if (row == null) {
            return true;
        }
        for (int i = 0; i < cellCount; i++) {
            if (StringUtils.isNotEmpty(getStrCellValue(row, i))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public String getDisposerKey() {
        return EXAM_REPORT;
    }
}
