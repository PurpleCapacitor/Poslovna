package ftn.poslovna.inf.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.domain.InvoiceReport;
import ftn.poslovna.inf.domain.InvoiceType;
import ftn.poslovna.inf.domain.ReportCatalog;
import ftn.poslovna.inf.dto.CatalogReportDTO;
import ftn.poslovna.inf.services.InvoiceService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
	
	@Autowired
	InvoiceService invoiceService;
	
	@RequestMapping(value="/generateReportDate", method=RequestMethod.POST)
	public ResponseEntity<CatalogReportDTO> generateReportDate(@RequestBody CatalogReportDTO catalogReportDTO) throws FileNotFoundException, JRException{
		generateCatalogReport(catalogReportDTO);
		return new ResponseEntity<>(catalogReportDTO, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/generateInvoiceReport/{id}", method=RequestMethod.POST)
	public ResponseEntity<CatalogReportDTO> generateInvoiceReport(@PathVariable Long id) throws FileNotFoundException, JRException{
		generateInvoiceReportMethod(id);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	private void generateCatalogReport(CatalogReportDTO catalogReportDTO) throws FileNotFoundException, JRException {
			InputStream inputStream = new FileInputStream("KIF.jrxml");
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			@SuppressWarnings("rawtypes")
			HashMap parameters = new HashMap();
			List<ReportCatalog> reportCatalogList = getAllReportCatalogs(catalogReportDTO);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(reportCatalogList);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "kif.pdf");
			

	}
	
	private void generateInvoiceReportMethod(Long id) throws FileNotFoundException, JRException{
		InputStream inputStream = new FileInputStream("Faktura.jrxml");
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

		@SuppressWarnings("rawtypes")
		HashMap parameters = new HashMap();
		List<InvoiceReport> InvoiceReportList = getAllInvoiceReports(id);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(InvoiceReportList);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, "Invoice"+id+".pdf");
	}
	
	private List<InvoiceReport> getAllInvoiceReports(Long id) {
		Invoice invoice = invoiceService.findOne(id);
		List<InvoiceReport> InvoiceReportList = new ArrayList<InvoiceReport>();
		for(InvoiceItem invoiceItem : invoice.getInvoiceItems()){
			InvoiceReport invoiceReport = new InvoiceReport();
			invoiceReport.setAccountNum(invoice.getAccountNum());
			invoiceReport.setInvoiceNum(invoice.getInvoiceNum());
			invoiceReport.setBuyerName(invoice.getBuyer().getName());
			invoiceReport.setCurrencyDate(invoice.getCurrencyDate());
			invoiceReport.setDiscount(invoiceItem.getDiscount());
			invoiceReport.setDiscountTotal(invoice.getDiscount());
			invoiceReport.setGoodsTotal(invoice.getGoodsTotal());
			invoiceReport.setInvoiceDate(invoice.getInvoiceDate());
			invoiceReport.setInvoiceItemName(invoiceItem.getName());
			invoiceReport.setInvoiceNum(invoice.getInvoiceNum());
			invoiceReport.setItemAmount(invoiceItem.getAmount());
			invoiceReport.setItemBase(invoiceItem.getItemBase());
			invoiceReport.setPrice(invoiceItem.getPrice());
			invoiceReport.setTax(invoiceItem.getTax());
			invoiceReport.setTaxTotal(invoice.getTax());
			invoiceReport.setTotal(invoice.getTotalAmount());
			invoiceReport.setTotalAmount(invoiceItem.getTotalAmount());
			invoiceReport.setValue(invoiceItem.getValue());
			InvoiceReportList.add(invoiceReport);
		}
		return InvoiceReportList;
	}

	private List<ReportCatalog> getAllReportCatalogs(CatalogReportDTO catalogReportDTO) {
		List<Invoice> invoiceList = invoiceService.findAll();
		List<ReportCatalog> reportCatalogList = new ArrayList<ReportCatalog>();
		Date startingDate = catalogReportDTO.getStartingDate();
		Date endingDate = catalogReportDTO.getEndingDate();
		
		for(Invoice inv : invoiceList) {
			if((inv.getInvoiceDate().after(startingDate)) && (inv.getInvoiceDate().before(endingDate)) && (inv.getInvoiceType()!=InvoiceType.formating)) {
				ReportCatalog reportCatalog = new ReportCatalog();
				reportCatalog.setStartDate(startingDate);
				reportCatalog.setEndDate(endingDate);
				reportCatalog.setBuyerName(inv.getBuyer().getName());
				reportCatalog.setSellerName(inv.getSeller().getName());
				reportCatalog.setInvoiceDate(inv.getInvoiceDate());
				reportCatalog.setInvoiceNum(inv.getInvoiceNum());
				reportCatalog.setTotalAmount(inv.getTotalAmount());
				reportCatalogList.add(reportCatalog);
			}
		}
		
		return reportCatalogList;
	}
	

}
