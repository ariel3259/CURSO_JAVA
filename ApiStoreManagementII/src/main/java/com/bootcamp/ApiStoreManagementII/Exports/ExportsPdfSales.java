package com.bootcamp.ApiStoreManagementII.Exports;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.bootcamp.ApiStoreManagementII.Model.Clients;
import com.bootcamp.ApiStoreManagementII.Model.Sales;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ExportsPdfSales {
	
	private final List<Sales> sales;
	
	public ExportsPdfSales(List<Sales> s) {
		sales = s;
	}
	
	
	private void ReadHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		
		cell.setPadding(5);
		cell.setPhrase(new Phrase("Id"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Ticket"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Client dni"));
		table.addCell(cell);
		
	}
	
	
	private void ReadBody(PdfPTable table) {
		for(Sales sale: sales) {
			Clients client = sale.getClient();
			table.addCell(String.valueOf(sale.getId()));
			table.addCell(String.valueOf(sale.getTicket()));
			table.addCell(String.valueOf(client.getDni()));
		}
	}
	
	public void createPdfFile(HttpServletResponse response) throws IOException, DocumentException {
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();
		Paragraph paragraph = new Paragraph("Sales list");
		paragraph.setSpacingAfter(5);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		doc.add(paragraph);
		PdfPTable table = new PdfPTable(5);
		ReadHeader(table);
		ReadBody(table);
		doc.add(table);
		doc.close();
	}
}
