package tn.esprit.spring.contract;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ContractController {

	private static final Logger LOG = LoggerFactory.getLogger("LOG");

	@Autowired
	ContractServiceImpl cs;
	@Autowired
	private ServletContext servletContext;

	private static final String DIRECTORY = "C:/Users/ASUS/Downloads/Documents";
	private static final String DEFAULT_FILE_NAME = "real-estate-purchase-agreement.pdf";

	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> downloadFile2(
			@RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {

		MediaType mediaType = PdfContractModel.getMediaTypeForFileName(this.servletContext, fileName);
		System.out.println("fileName: " + fileName);
		System.out.println("mediaType: " + mediaType);

		Path path = Paths.get(DIRECTORY + "/" + DEFAULT_FILE_NAME);
		byte[] data = Files.readAllBytes(path);
		ByteArrayResource resource = new ByteArrayResource(data);

		return ResponseEntity.ok()
				// Content-Disposition
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + path.getFileName().toString())
				// Content-Type
				.contentType(mediaType) //
				// Content-Length
				.contentLength(data.length) //
				.body(resource);
	}

	@PostMapping("/contracts/add")
	public int newContract(@RequestBody Contract contract) {
		return cs.addContract(contract);
	}

	@GetMapping("/contracts/get/{contractId}")
	public Contract getContract(@PathVariable int contractId) {
		return cs.findContract(contractId);
	}

	@GetMapping("/contracts/get-all")
	public List<Contract> getAllContracts() {
		return cs.getAllContracts();
	}

	@PutMapping("/contracts/update-price/{contractId}/{price}")
	public void updateContractPrice(@PathVariable int contractId, @PathVariable float price) {
		LOG.info("Price updated");
		cs.updateContractPrice(contractId, price);
	}
	
	@PutMapping("/contracts/update-start-date/{contractId}/{date}")
	public void updateContractStartDate(@PathVariable int contractId, @PathVariable String date) {
		LOG.info("Start date updated");
		cs.updateContractStartDate(contractId, date);
	}
	
	@PutMapping("/contracts/update-surveillance/{contractId}/{surveillance}")
	public void updateContractSurveillance(@PathVariable int contractId, @PathVariable int surveillance) {
		LOG.info("Surveillance updated");
		cs.updateContractSurveillance(contractId, surveillance);
	}

	@PutMapping("/contracts/update-duration/{contractId}/{duration}")
	public void updateContractDuration(@PathVariable int contractId, @PathVariable int duration) {
		LOG.info("Duration updated");
		cs.updateContractDuration(contractId, duration);
	}

	@DeleteMapping("/contracts/delete/{contractId}")
	public void deleteContract(@PathVariable int contractId) {
		cs.deleteContract(contractId);
	}

}
