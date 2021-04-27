package tn.esprit.spring.contract;

import javax.servlet.ServletContext;

import org.springframework.http.MediaType;

public class PdfContractModel {
	
    public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {

        String mineType = servletContext.getMimeType(fileName);
        try {
            MediaType mediaType = MediaType.parseMediaType(mineType);
            return mediaType;
        } catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
	
}
