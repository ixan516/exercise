package cn.ixan.example.utils;


import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by pacbj-dongchenglong on 2018年9月20日,0020.
 */
public class JXLUtil {
    //objIn数据内容放到二维数组中  excelColumnName 标题
    public static void exportExcelSetIsWrap(String[][] objIn, List excelColumnName, HttpServletResponse response) {
        try {
            OutputStream os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename=" + new String("legalService".getBytes("GB2312"), "8859_1") + ".xls");// 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型

            WritableWorkbook wwb = Workbook.createWorkbook(os); // 建立excel文件
            WritableSheet ws = wwb.createSheet("Sheet1", 0); // 创建一个工作表
            //标题样式
            WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);  // 设置单元格的文字格式
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置标题垂直对齐方式
            wcf.setAlignment(Alignment.CENTRE); //设置标题水平对齐方式
            //遍历标题
            for (int j = 0; j < excelColumnName.size(); j++) {
                ws.addCell(new Label(j, 0, (String) excelColumnName.get(j), wcf));
                ws.setColumnView(j,22);//设置列宽度
            }
            // 设置内容
            wcf = new WritableCellFormat();
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);// 指定单元格垂直居中对齐
            wcf.setAlignment(Alignment.CENTRE);// 指定单元格居中对齐
            wcf.setWrap(true);// 指定单元格自动换行
            for (int i = 0; i < objIn.length; i++) {
                for (int j = 0; j < excelColumnName.size(); j++) {
                    ws.addCell(new Label(j, i + 1, (objIn[i][j]), wcf));
                }
            }
            wwb.write();
            wwb.close();
        } catch (IOException | WriteException e) {
        }
    }


}
