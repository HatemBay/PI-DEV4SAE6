package tn.esprit.spring.surveillance;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveillanceController{

	@Autowired
	DetectMotion detectMotion;

	@GetMapping("contract/{contractId}/surveillance/detect-all")
	public List<String> detectAll(@PathVariable int contractId) throws Throwable {
		return detectMotion.findWebcams(contractId);
	}

	@GetMapping("contract/{contractId}/surveillance/capture/default")
	public void capture(@PathVariable int contractId) throws IOException, InterruptedException {
		detectMotion.captureDefault(contractId);
	}
	
	@GetMapping("contract/{contractId}/surveillance/capture/{camName}")
	public void captureChosen(@PathVariable int contractId, @PathVariable String camName) throws IOException {
		String newName = camName.replace("-", " ");
		detectMotion.captureChosen(contractId, newName);
	}
	
	@GetMapping("contract/{contractId}/surveillance/capture/stop")
	public void stop() {
		detectMotion.stop();
	}
	
	@GetMapping("contract/{contractId}/surveillance/get-all")
	public List<SurveillanceImages> getAllImages() {
		return detectMotion.getAllImages();
	}
}
