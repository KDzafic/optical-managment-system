package optic.service.optic.pdf.controller;

import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import optic.service.optic.pdf.service.PdfService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequestMapping("pdf")
@RequiredArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @GetMapping("/generate")
    public String generatePdf() throws DocumentException, ParserConfigurationException, IOException {
        pdfService.generatePDFFromHTML();
        return "PDF succsesfully generated.";
    }
}
