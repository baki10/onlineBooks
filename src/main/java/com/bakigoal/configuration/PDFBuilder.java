package com.bakigoal.configuration;

import com.bakigoal.model.Book;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by ilmir on 19.12.15.
 */
public class PDFBuilder extends AbstractITextPdfView {
  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                  PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // get data model which is passed by the Spring container
    List<Book> listBooks = (List<Book>) model.get("listBooks");

    doc.add(new Paragraph("Recommended books for Spring framework"));

    PdfPTable table = new PdfPTable(3);
    table.setWidthPercentage(100.0f);
    table.setWidths(new float[] {3.0f, 2.0f, 1.0f});
    table.setSpacingBefore(10);

    // define font for table header row
    Font font = FontFactory.getFont(FontFactory.HELVETICA);
    font.setColor(BaseColor.WHITE);

    // define table header cell
    PdfPCell cell = new PdfPCell();
    cell.setBackgroundColor(BaseColor.BLUE);
    cell.setPadding(5);

    // write table header
    cell.setPhrase(new Phrase("Book Title", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Id", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Published Date", font));
    table.addCell(cell);


    // write table row data
    for (Book aBook : listBooks) {
      table.addCell(aBook.getTitle());
      table.addCell(aBook.getId().toString());
      table.addCell(aBook.getPublished().toString());
    }

    doc.add(table);
  }
}
