package com.bs.career.service.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.career.service.model.ValueResult;

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
