package com.bootcamp.ApiStoreManagementII.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.ApiStoreManagementII.Exports.ExportsExcelSales;
import com.bootcamp.ApiStoreManagementII.Exports.ExportsPdfSales;
import com.bootcamp.ApiStoreManagementII.Model.Clients;
import com.bootcamp.ApiStoreManagementII.Model.Sales;
import com.bootcamp.ApiStoreManagementII.Services.ClientsService;
import com.bootcamp.ApiStoreManagementII.Services.SalesService;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
	
	@Autowired
	private SalesService service;
	
	@Autowired
	private ClientsService serviceC;
	
	@GetMapping
	public ResponseEntity<List<Sales>> getAll(){
		return ResponseEntity.status(200).body(service.getAll());
	}
	
	@PostMapping("/{dni}")
	public ResponseEntity<String> save(@Validated @RequestBody Sales sale, BindingResult result, @PathVariable("dni") int dni){
		if(result.hasErrors()) return ResponseEntity.status(400).body("Incomplete data");
		Clients client = serviceC.getOne(dni);
		sale.setClient(client);
		if(!service.save(sale)) return ResponseEntity.status(400).body("Sale already exists");
		return ResponseEntity.status(200).body("Created sale");
	}
	
	@GetMapping("/excel")
	public void getExcelReport(HttpServletResponse response) throws IOException {
		List<Sales> sales = service.getAll();
		ExportsExcelSales excelSales = new ExportsExcelSales(sales);
		response.setHeader("Content-Type", "appliction/octet-string");
		response.setHeader("Content-Disposition", "attachment;filename=sales.xlsx");
		excelSales.CreateExcelFile(response);
	}
	
	@GetMapping("/pdf")
	public void getPdfReport(HttpServletResponse response) throws IOException{
		List<Sales> sales = service.getAll();
		ExportsPdfSales pdfSales = new ExportsPdfSales(sales);
		response.setHeader("Content-Type", "application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=sales.pdf");
		pdfSales.createPdfFile(response);
	}
	
	@GetMapping("/byTicket/excel/{ticket}")
	public void getByIdExcelReport(HttpServletResponse response, @PathVariable("ticket") int ticket) throws IOException {
		Sales sales = service.getByTicket(ticket);
		ExportsExcelSales excelSales = new ExportsExcelSales(Arrays.asList(sales));
		response.setHeader("Content-Type", "appliction/octet-string");
		response.setHeader("Content-Disposition", "attachment;filename=sales_ticket.xlsx");
		excelSales.CreateExcelFile(response);
	}
	
	@GetMapping("/byTicket/pdf/{ticket}")
	public void getByIdPdfReport(HttpServletResponse response, @PathVariable("ticket") int ticket) throws IOException{
		Sales sales = service.getByTicket(ticket);
		ExportsPdfSales pdfSales = new ExportsPdfSales(Arrays.asList(sales));
		response.setHeader("Content-Type", "application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=sales_ticket.pdf");
		pdfSales.createPdfFile(response);
	}
	
	@GetMapping("/byClientDni/excel/{dni}")
	public void getByClientDniExcelReport(HttpServletResponse response, @PathVariable("dni") int dni) throws IOException {
		List<Sales> sales = service.getByClient(dni);
		ExportsExcelSales excelSales = new ExportsExcelSales(sales);
		response.setHeader("Content-Type", "appliction/octet-string");
		response.setHeader("Content-Disposition", "attachment;filename=sales_client_dni.xlsx");
		excelSales.CreateExcelFile(response);
	}
	
	@GetMapping("/byClientDni/pdf/{dni}")
	public void getByDniPdfReport(HttpServletResponse response, @PathVariable("dni") int dni) throws IOException{
		List<Sales> sales = service.getByClient(dni);
		ExportsPdfSales pdfSales = new ExportsPdfSales(sales);
		response.setHeader("Content-Type", "application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=sales_client_dni.pdf");
		pdfSales.createPdfFile(response);
	}
	
}
