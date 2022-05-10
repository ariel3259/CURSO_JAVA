package com.bootcamp.Templates.ReporsConfigure.Excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bootcamp.Templates.Model.Subjects;

public class ExportExcelSubjects {
	private XSSFSheet sheet;
	private final XSSFWorkbook workbook;
	private final List<Subjects> subjects;
	
	public ExportExcelSubjects(List<Subjects> s) {
		this.subjects = s;
		workbook = new XSSFWorkbook();
	}
	
	public void readHeader() {
		sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(24);
		font.setBold(true);
		style.setFont(font);
		createCell(row, 0, "id", style);
		createCell(row, 1, "code", style);
		createCell(row, 2, "name", style);
	}

	private void createCell(Row row, int i, Object field, CellStyle style) {
		sheet.autoSizeColumn(i);
		Cell cell = row.createCell(i);
		if(field instanceof Integer) cell.setCellValue((Integer) field);
		else if(field instanceof Double) cell.setCellValue((Double) field);
		else if (field instanceof Long) cell.setCellValue((Long) field);
		else if (field instanceof Boolean) cell.setCellValue((Boolean) field);
		else cell.setCellValue((String) field);
		cell.setCellStyle(style);		
	}
	
	private void readBody() {
		int rowCounter = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(16);
		style.setFont(font);
		for(Subjects subject: subjects) {
			Row row = sheet.createRow(rowCounter);
			createCell(row, rowCounter++, subject.getId(), style);
			createCell(row, rowCounter++, subject.getCode(), style);
			createCell(row, rowCounter++, subject.getName(), style);
			rowCounter++;
		}
	}
	
	public void CreateXcelFile(HttpServletResponse response) throws IOException{
		readHeader();
		readBody();
		ServletOutputStream stream = response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		stream.close();
	}
}
