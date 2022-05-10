package com.bootcamp.Templates.ReporsConfigure.Excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.bootcamp.Templates.Model.Students;




public class ExportExcelStudents {
	
	private XSSFSheet sheet;
	
	private XSSFWorkbook workbook;
	
	private List<Students> students;
	
	public ExportExcelStudents(List<Students> s){
		this.students = s;
		workbook = new XSSFWorkbook();
	}
	
	public void readHeader() {
		sheet = workbook.createSheet("Students list");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(16);
		font.setBold(true);
		style.setFont(font);
		createCell(row, 0, "id", style);
		createCell(row, 1, "name", style);
		createCell(row, 2, "lastName", style);
		createCell(row, 3, "dni", style);
		createCell(row, 4, "phone", style);
	}

	private void createCell(Row row, int i, Object string, CellStyle style) {
		sheet.autoSizeColumn(i);
		Cell cell =  row.createCell(i);
		if(string instanceof Integer) cell.setCellValue((Integer) string);
		else if (string instanceof Boolean) cell.setCellValue((Boolean) string);
		else if (string instanceof Long) cell.setCellValue((Long) string);
		else cell.setCellValue((String) string);
		cell.setCellStyle(style);
	}
	
	private void readBody() {
		int rowCounter = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(12);
		style.setFont(font);
		for(Students student: students) {
			Row row = sheet.createRow(rowCounter);
			int counterColumn = 0;
			createCell(row, counterColumn++, student.getId(), style);
			createCell(row, counterColumn++, student.getName(), style);
			createCell(row, counterColumn++, student.getLastName(), style);
			createCell(row, counterColumn++, student.getDni(), style);
			createCell(row, counterColumn++, student.getPhone(), style);
			rowCounter++;
		}
	}
	
	public void CreateXcelFile(HttpServletResponse response) throws IOException {
		readHeader();
		readBody();
		ServletOutputStream stream = response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		stream.close();
	}
}
