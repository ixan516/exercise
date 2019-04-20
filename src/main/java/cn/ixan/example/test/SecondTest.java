package cn.ixan.example.test;

import cn.ixan.example.domain.Score;
import cn.ixan.example.domain.Student;
import cn.ixan.example.domain.Subject;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月10日, 0010
 */
public class SecondTest {
	public static void main(String[] args) {
		export();
	}

	/**
	 * 简单的jxl合并单元格
	 */
	private static void export() {
		try {
			WritableWorkbook wwb = Workbook.createWorkbook(new File("D:\\aa.xls")); // 建立excel文件
			WritableSheet ws = wwb.createSheet("Sheet1", 0); // 创建一个工作表
			//标题样式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);  // 设置单元格的文字格式
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置标题垂直对齐方式
			wcf.setAlignment(Alignment.CENTRE); //设置标题水平对齐方式
			List<String> excelColumnName = Arrays.asList("姓名","所选课程","成绩");
			//遍历标题
			for (int j = 0; j < excelColumnName.size(); j++) {
				ws.addCell(new Label(j, 0, excelColumnName.get(j), wcf));
				ws.setColumnView(j,22);//设置列宽度
			}
			// 设置内容
			wcf = new WritableCellFormat();
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);// 指定单元格垂直居中对齐
			wcf.setAlignment(Alignment.CENTRE);// 指定单元格居中对齐
			wcf.setWrap(true);// 指定单元格自动换行
			List<Student> studentList = getStudents();
			//偏移量
			int offset = 3;
			for (int m = 0; m < studentList.size(); m++) {
				Student student = studentList.get(m);
				for (int n = 0; n < excelColumnName.size(); n++) {
					if(n == 0){
						String userName = student.getUserName();
						//参数1:左上列数,参数2:左上行数,参数3:右列数,参数4:右下行数
						ws.mergeCells(0, 1 + offset * m , 0, offset * (m+1));
						//参数1:列数,参数2:行数,参数3:数据,参数4:样式
						ws.addCell(new Label(0,1 + 3 * m, userName,wcf));
					} else {
						List<Score> scoreList = student.getScoreList();
						//转换二维数组
						String[][] arr = new String[3][2];
						for(int i=0; i<scoreList.size(); i++){
							Score score = scoreList.get(i);
							arr[i][0] = score.getSubject();
							arr[i][1] = String.valueOf(score.getScore());
						}
						for(int k=0; k<arr.length;k++){
							for(int t=0; t<arr[k].length;t++){
								ws.addCell(new Label(1+t,1+k+offset*m, arr[k][t],wcf));
							}
						}
					}
				}
			}
			wwb.write();
			wwb.close();
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}
	}

	private static List<Student> getStudents() {
		Student student1 = new Student();
		student1.setUserName("张三");
		student1.setScoreList(Arrays.asList(new Score(Subject.CHINESE.getSubject(),78),
				new Score(Subject.MATH.getSubject(),90),
				new Score(Subject.ENGLISH.getSubject(),59)));
		Student student2 = new Student();
		student2.setUserName("李四");
		student2.setScoreList(Arrays.asList(new Score(Subject.CHINESE.getSubject(),66),
				new Score(Subject.MATH.getSubject(),77),
				new Score(Subject.ENGLISH.getSubject(),49)));
		Student student3 = new Student();
		student3.setUserName("王五");
		student3.setScoreList(Arrays.asList(new Score(Subject.CHINESE.getSubject(),100),
				new Score(Subject.MATH.getSubject(),95),
				new Score(Subject.ENGLISH.getSubject(),19)));
		Student student4 = new Student();
		student4.setUserName("赵六");
		student4.setScoreList(Arrays.asList(new Score(Subject.CHINESE.getSubject(),62),
				new Score(Subject.MATH.getSubject(),73),
				new Score(Subject.ENGLISH.getSubject(),16)));
		return Arrays.asList(student1,student2,student3,student4);
	}
}
