package com.bs.door.service.restcontrollers;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.door.service.model.ValueResult;

/**
 * @author bharat
 *
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/healthCheck")
	public ValueResult<String> healthCheck() {
		System.out.println("Request at : " + new Date());
		return new ValueResult<>("Great!, your service running through zuul server");
	}

}
