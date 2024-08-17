package com.nit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebOperationRestController {

	@GetMapping("/find/{ssn}")
	public ResponseEntity<String> getStateBySSN(@PathVariable Integer ssn) {
	    // Check if the SSN is 9 digits long
	    if (ssn.toString().length() != 9) {
	        return new ResponseEntity<String>("Invalid SSN", HttpStatus.BAD_REQUEST);
	    }
	    
	    // Extract the last two digits to get the state code
	    int stateCode = ssn % 100;
	    String stateName = null;
	    
	    // Determine the state name based on the state code
	    switch (stateCode) {
	        case 01:
	            stateName = "Washington DC";
	            break;
	        case 02:
	            stateName = "Ohio";
	            break;
	        case 03:
	            stateName = "Texas";
	            break;
	        case 04:
	            stateName = "California";
	            break;
	        case 05:
	            stateName = "Florida";
	            break;
	        default:
	            stateName = "Invalid SSN";
	            break;
	    }
	    
	    // Return the state name as the response
	    return new ResponseEntity<String>(stateName, HttpStatus.OK);
	}

}
