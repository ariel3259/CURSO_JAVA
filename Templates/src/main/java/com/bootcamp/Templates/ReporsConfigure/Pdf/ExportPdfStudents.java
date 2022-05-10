package com.bootcamp.Templates.ReporsConfigure.Pdf;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.bootcamp.Templates.Model.Students;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ExportPdfStudents {
	
	private final List<Students> students;
	
	public ExportPdfStudents(List<Students> students) {
		this.students = students;
	}
	
	private void HeaderTable(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		
		cell.setPadding(5);
		cell.setPhrase(new Phrase("Id"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Nombre"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Apellido"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Dni"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Celular"));
		table.addCell(cell);
	}
	
	private void BodyTable(PdfPTable table) {
		for(Students student: students) {
			table.addCell(String.valueOf(student.getId()));
			table.addCell(student.getName());
			table.addCell(student.getLastName());
			table.addCell(String.valueOf(student.getDni()));
			table.addCell(String.valueOf(student.getPhone()));
		}
	}
	
	public void createPdfFile(HttpServletResponse response) throws IOException, DocumentException {
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();
		Paragraph paragraph = new Paragraph("Students list");
		paragraph.setSpacingAfter(5);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		doc.add(paragraph);
		PdfPTable table = new PdfPTable(5);
		HeaderTable(table);
		BodyTable(table);
		doc.add(table);
		doc.close();
 	}
}
