package jhilimili;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfBox {

	public static void main(String[] args) throws IOException {
		
		PDDocument helloPdf = new PDDocument();
		
		addCoverPage(helloPdf);
		

		helloPdf.save(new File("simple.pdf"));
		helloPdf.close();

	}

	private static void addCoverPage(PDDocument helloPdf) throws IOException {
		PDPage page = new PDPage(PDRectangle.LETTER);
		helloPdf.addPage(page);

		PDPageContentStream contentStream = new PDPageContentStream(helloPdf, page);
		
		 PDImageXObject pdImage = PDImageXObject.createFromFile("cover.jpeg", helloPdf);
		 contentStream.saveGraphicsState();
		 contentStream.drawImage(pdImage, 0, 0, PDRectangle.LETTER.getWidth(), PDRectangle.LETTER.getHeight());
		 contentStream.restoreGraphicsState();

		 /*
		contentStream.beginText();
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
		contentStream.newLineAtOffset(10, 100);
		contentStream.showText("Hello PDF World2!!!");
		contentStream.endText();*/
		 
		contentStream.close();
		
	}

}
