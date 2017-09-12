package ba.biggy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.biggy.model.Fault;
import ba.biggy.service.FaultService;

@RestController
public class FaultsController {
	
	FaultService faultService = new FaultService();
	
	@RequestMapping (value = "/getAllFaults", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Fault> getFaults(){
		List<Fault> faults = faultService.getFaults();
		return faults;
	}

}
