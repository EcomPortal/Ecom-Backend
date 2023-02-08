package com.ecom.app.serviceImpl;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.OrderDetailsDto;
import com.ecom.app.model.OrderDetails;
import com.ecom.app.model.Product;
import com.ecom.app.repository.OrderDetailsRepository;
import com.ecom.app.service.EmailServiceVM;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class InvoiceGenerationServiceImpl {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private EmailServiceVM emailServiceVM;

	private String path = "/home/rapidsoft/invoice.pdf";

	@Transactional
	public CustomResponse pdfGen(Long id) throws Exception {

		Optional<OrderDetails> order = orderDetailsRepository.findById(id);
		OrderDetailsDto orderDetailsDto = order.get().convertToOrderDetailsDtoV2();
		Document document = new Document(PageSize.A4.rotate());

		String file_name = path;

		PdfWriter.getInstance(document, new FileOutputStream(file_name));

		document.open();

		System.out.println(document.isOpen());

		if (document.isOpen() == false) {
			document.open();
		}

		Font font = new Font(Font.HELVETICA, 14, Font.BOLDITALIC);

		Font font1 = new Font(Font.NORMAL, 12, Font.BOLDITALIC);

		PdfPTable table = new PdfPTable(6);

		table.setWidthPercentage(100);
		table.setWidths(new float[] { 12.0f, 13.0f, 13.0f, 10.0f, 10.0f, 10.0f });

		document.add(new Paragraph(
				"\n                                                                                                     "
						+ "INVOICE",
				font));

		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase("ORDER ID.", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PRODUCT NAME", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("QUANTITY", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PRICE", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("ORDER DATE", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("DELIVERY DATE", font));
		table.addCell(cell);
//		cell.setPhrase(new Phrase("TOTAL ", font));
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("AMOUNT PAID", font));
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("AMOUNT PENDING", font));
//		table.addCell(cell);

		if (orderDetailsDto != null) {
			document.add(new Paragraph(
					"\n\nHello " + orderDetailsDto.getUser().getUserName() + ",\nHere is your order details.\n\n",
					font1));

//				table.addCell(String.valueOf(transaction.getId()));
			table.addCell(orderDetailsDto.getUuid());
			table.addCell(
					orderDetailsDto.getProduct().getProductName() + " " + orderDetailsDto.getProduct().getModelName());
			table.addCell("1");
			table.addCell(orderDetailsDto.getProduct().getPrice().toString());
			table.addCell(orderDetailsDto.getOrderAt());
			table.addCell(orderDetailsDto.getExpectedDelivered());
//				table.addCell(String.valueOf(transaction.getTotalAmount()));
//				table.addCell(String.valueOf(transaction.getAmountPaid()));
//				table.addCell(String.valueOf(transaction.getPendingAmount()));

		}

		// document.close();

//		document.add(table);
		document.add(table);

		document.close();

		DateFormat dateonly = new SimpleDateFormat("dd-MM-yyyy");
		emailServiceVM.sendInvoice("Invoice " + dateonly.format(new Date()), order.get().getUserId().getEmail(), path);

		return new CustomResponse(HttpStatus.OK.value(), null, "pdf generated");

	}

}
