package com.bootcamp.ApiStoreManagementII.Exports;

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

import com.bootcamp.ApiStoreManagementII.Model.Clients;
import com.bootcamp.ApiStoreManagementII.Model.Sales;




public class ExportsExcelSales {
	
	private final XSSFWorkbook workbook;
	private final List<Sales> sales;
	private final XSSFSheet sheet;
	
	public ExportsExcelSales(List<Sales> s) {
		sales = s;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sales list");
	}
	
	private void readHeader() {
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(24);
		font.setBold(true);
		style.setFont(font);
		createCell(row, 0, "Id", style);
		createCell(row, 1, "Ticket", style);
		createCell(row, 2, "Client dni", style);
	}

	private void createCell(Row row, int i, Object field, CellStyle style) {
		sheet.autoSizeColumn(i);
		Cell cell = row.createCell(i);
		if(field instanceof Integer) cell.setCellValue((Integer) field);
		if(field instanceof Long) cell.setCellValue((Long) field);
		if(field instanceof Double) cell.setCellValue((Double) field);
		if(field instanceof Boolean) cell.setCellValue((Boolean) field);
		else cell.setCellValue((String) field);
		cell.setCellStyle(style);
	}
	
	private void readBody(){
		int rowCounter = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(16);
		style.setFont(font);
		for(Sales sale: sales) {
			Clients client = sale.getClient();
			Row row = sheet.createRow(rowCounter);
			int columnCounter = 0;
			createCell(row, columnCounter++, String.valueOf(sale.getId()), style);
			createCell(row, columnCounter++, String.valueOf(sale.getTicket()), style);
			createCell(row, columnCounter++, String.valueOf(client.getDni()), style);
			rowCounter++;
		}
	}
	
	public void CreateExcelFile(HttpServletResponse response) throws IOException {
		readHeader();
		readBody();
		ServletOutputStream stream = response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		stream.close();
	}
}
