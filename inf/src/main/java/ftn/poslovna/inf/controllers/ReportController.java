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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ftn.poslovna.inf.domain.Invoice;
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
	
	private void generateCatalogReport(CatalogReportDTO catalogReportDTO) throws FileNotFoundException, JRException {
			InputStream inputStream = new FileInputStream("KIF.jrxml");
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			@SuppressWarnings("rawtypes")
			HashMap parameters = new HashMap();
			List<ReportCatalog> reportCatalogList = getAllReportCatalogs(catalogReportDTO);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(reportCatalogList);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "report1.pdf");
			

	}
	
	private List<ReportCatalog> getAllReportCatalogs(CatalogReportDTO catalogReportDTO) {
		List<Invoice> invoiceList = invoiceService.findAll();
		List<ReportCatalog> reportCatalogList = new ArrayList<ReportCatalog>();
		Date startingDate = catalogReportDTO.getStartingDate();
		Date endingDate = catalogReportDTO.getEndingDate();
		
		for(Invoice inv : invoiceList) {
			if((inv.getInvoiceDate().after(startingDate)) && (inv.getInvoiceDate().before(endingDate))) {
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
