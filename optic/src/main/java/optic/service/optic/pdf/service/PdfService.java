package optic.service.optic.pdf.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PdfService {

    private static final String FILENAME = "src/main/resources/example.html";
    private static final String PDF_OUTPUT = "src/main/resources/html2pdf.pdf";

    public void generatePDFFromHTML() throws IOException {
        File inputHTML = new File(FILENAME);
        Document doc = createWellFormedHtml(inputHTML);
        xhtmlToPdf(doc, PDF_OUTPUT);
    }

    private Document createWellFormedHtml(File inputHTML) throws IOException {
        Document document = Jsoup.parse(inputHTML, "UTF-8");
//        document = insertInformation(document.html());
        document.outputSettings()
                .syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

//    private Document insertInformation(String html) {
//    }

    private void xhtmlToPdf(Document doc, String outputPdf) throws IOException {
        try (OutputStream os = new FileOutputStream(outputPdf)) {
            String baseUri = FileSystems.getDefault()
                    .getPath("src/main/resources/")
                    .toUri()
                    .toString();
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withUri(outputPdf);
            builder.toStream(os);
            builder.withW3cDocument(new W3CDom().fromJsoup(doc), baseUri);
            builder.run();
        }
    }

}
