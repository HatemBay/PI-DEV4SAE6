package tn.esprit.spring.surveillance;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;

import tn.esprit.spring.contract.ContractService;
import tn.esprit.spring.exception.NotSubscribedException;
import tn.esprit.spring.insurance.Insurance;

@Service
public class DetectMotion implements WebcamMotionListener {

	@Autowired
	SurveillanceRepository sr;
	
	@Autowired
	ContractService cs;

	static WebcamMotionDetector detector;

	private static final Logger LOG = LoggerFactory.getLogger("LOG");

	// static List<WebcamMotionDetector> detectors;
	
	public List<String> findWebcams(int contractId) {
		if (cs.findContract(contractId).getSurveillance() == 0){
			throw new NotSubscribedException("In order to use this feature please consider buying Surveillance!");
		}
		List<String> webcams = new ArrayList<>();
		webcams.add("");
		for (Webcam webcam : Webcam.getWebcams()) {
			LOG.info("Webcam detected: " + webcam.getName());
			webcams.add(webcam.getName());// .replace(" ", "-") eliminating space
		}
		if (ObjectUtils.isEmpty(webcams))
			webcams.add("no cameras detected");
		System.out.println(webcams);
		return webcams;
	}

	@Override
	public void motionDetected(WebcamMotionEvent wme) {

		SurveillanceImages si = new SurveillanceImages();
		// message
		LOG.info("Detected motion from: " + detector.getWebcam().getName());

		// get image
		BufferedImage image = detector.getWebcam().getImage();

		// name generation
		String name = String.format("test-%d.jpg", System.currentTimeMillis());

		ByteArrayOutputStream pngContent = new ByteArrayOutputStream();

		//save image to PNG file
		try {
			ImageIO.write(image, "png", pngContent);
			si.setContent(pngContent.toByteArray());
			
			sr.save(si);
			
			ImageIO.write(image, "PNG", new File("surveillancePictures/" + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//stopping camera after 20 seconds
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				detector.stop();
			}
		}, 20000);

	}

	public void captureDefault(int contractId) throws IOException, InterruptedException {
		if (cs.findContract(contractId).getSurveillance() == 0){
			throw new NotSubscribedException("In order to use this feature please consider buying Surveillance!");
		}
		detector = new WebcamMotionDetector(Webcam.getDefault());
		detector.setInterval(5000); // one check per 5 seconds
		//detector.addMotionListener(this);
		detector.start();
		Thread t = new Thread("motion-printer") {

			@Override
			public void run() {

				boolean motion = false;
				long now = 0;

				while (true) {
					now = System.currentTimeMillis();
					if (detector.isMotion()) {
						if (!motion) {
							motion = true;
							System.out.println(now + " MOTION STARTED");
						}
					} else {
						if (motion) {
							motion = false;
							System.out.println(now + " MOTION STOPPED");
						}
					}
					try {
						Thread.sleep(4900); // must be smaller than interval
						SurveillanceImages si = new SurveillanceImages();
						// message
						LOG.info("Detected motion from: " + detector.getWebcam().getName());

						// get image
						BufferedImage image = detector.getWebcam().getImage();

						// name generation
						String name = String.format("test-%d.jpg", System.currentTimeMillis());

						ByteArrayOutputStream pngContent = new ByteArrayOutputStream();

						//save image to PNG file
						try {
							ImageIO.write(image, "png", pngContent);
							si.setContent(pngContent.toByteArray());
							cs.affectImageToContract(si, contractId);

							ImageIO.write(image, "PNG", new File("surveillancePictures/" + name));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//stopping camera after 20 seconds
//						new Timer().schedule(new TimerTask() {
//							@Override
//							public void run() {
//								// TODO Auto-generated method stub
//								detector.stop();
//							}
//						}, 20000);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t.setDaemon(true);
		t.start();
	}

		// System.in.read(); // keep program open
	

	public void captureChosen(int contractId, String camName) throws IOException {
		if (cs.findContract(contractId).getSurveillance() == 0){
			throw new NotSubscribedException("In order to use this feature please consider buying Surveillance!");
		}
		List<Webcam> webcams = Webcam.getWebcams();

		// open all cameras
		for (Webcam webcam : webcams) {
			if (webcam.getName().equals(camName)) {
				detector = new WebcamMotionDetector(webcam);
				detector.setInterval(5000); // one check per 5 seconds
				//detector.addMotionListener(this);
				detector.start();
				Thread t = new Thread("motion-printer") {

					@Override
					public void run() {

						boolean motion = false;
						long now = 0;

						while (true) {
							now = System.currentTimeMillis();
							if (detector.isMotion()) {
								if (!motion) {
									motion = true;
									System.out.println(now + " MOTION STARTED");
								}
							} else {
								if (motion) {
									motion = false;
									System.out.println(now + " MOTION STOPPED");
								}
							}
							try {
								Thread.sleep(4900); // must be smaller than interval
								SurveillanceImages si = new SurveillanceImages();
								// message
								LOG.info("Detected motion from: " + detector.getWebcam().getName());

								// get image
								BufferedImage image = detector.getWebcam().getImage();

								// name generation
								String name = String.format("test-%d.jpg", System.currentTimeMillis());

								ByteArrayOutputStream pngContent = new ByteArrayOutputStream();

								//save image to PNG file
								try {
									ImageIO.write(image, "png", pngContent);
									si.setContent(pngContent.toByteArray());
									cs.affectImageToContract(si, contractId);

									ImageIO.write(image, "PNG", new File("surveillancePictures/" + name));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								//stopping camera after 20 seconds
//								new Timer().schedule(new TimerTask() {
//									@Override
//									public void run() {
//										// TODO Auto-generated method stub
//										detector.stop();
//									}
//								}, 20000);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};

				t.setDaemon(true);
				t.start();
				break;
			}
		}
	}

	/********** not totally functionable **********/
	public void captureAll() throws IOException {

		List<Webcam> webcams = Webcam.getWebcams();

		// open all cameras
		for (Webcam webcam : webcams) {
			detector = new WebcamMotionDetector(webcam);
			detector.setInterval(5000); // one check per 5 seconds
			detector.addMotionListener(this);
			detector.start();
		}
	}
	/**********************************************/

	public void stop() {
		detector.stop();
	}

	public List<SurveillanceImages> getAllImages() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}
}
