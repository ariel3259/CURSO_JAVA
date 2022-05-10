package com.bootcamp.Templates.ReporsConfigure.Pdf;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.bootcamp.Templates.Model.Subjects;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ExportPdfSubjects {
	
	private final List<Subjects> subjects;
	
	public ExportPdfSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	
	private void ReadHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		
		cell.setPadding(5);
		cell.setPhrase(new Phrase("Id"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Code"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Name"));
		table.addCell(cell);
	}
	
	private void ReadBody(PdfPTable table) {
		for(Subjects subject: subjects) {
			table.addCell(String.valueOf(subject.getId()));
			table.addCell(String.valueOf(subject.getCode()));
			table.addCell(subject.getName());
		}
	}
	
	public void CreatePdfFile(HttpServletResponse response) throws IOException, DocumentException {
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();
		Paragraph paragraph = new Paragraph("Subjects list");
		paragraph.setSpacingAfter(5);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		doc.add(paragraph);
		PdfPTable table = new PdfPTable(3);
		ReadHeader(table);
		ReadBody(table);
		doc.add(table);
		doc.close();
 	}
		
}

