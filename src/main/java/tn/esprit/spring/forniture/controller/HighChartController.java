package tn.esprit.spring.forniture.controller;

import java.util.Map;
import java.util.TreeMap;

import javax.activation.MimeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.forniture.entity.Livreur;

import tn.esprit.spring.forniture.service.ILivreurService;


@RestController
@RequestMapping("api/livreur")
public class HighChartController {
	
	@Autowired
	ILivreurService livser;
	 

 @GetMapping("/get-data")
    public ResponseEntity<Map<String, Integer>> getPieChart() {
        Map<String, Integer> graphData = new TreeMap<>();
        for(Livreur l : livser.findall())
        {
        graphData.put(l.getNom(), l.getNbMission());
        }
        return new ResponseEntity<>(graphData, HttpStatus.OK);
    } 
	
	
	/*@RequestMapping(value="findall", method=RequestMethod.GET,produces={MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Livreur>> findall(){
		try {
			return new ResponseEntity<Iterable<Livreur>>(livser.findalll(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Livreur>>(HttpStatus.BAD_REQUEST);
		}
	
	}*/
}
