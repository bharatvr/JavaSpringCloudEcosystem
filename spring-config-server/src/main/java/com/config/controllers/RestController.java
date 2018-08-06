package com.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.model.ValueResult;

/**
 * @author bharat
 *
 */
@Controller
public class RestController {

	@RequestMapping("/healthCheck")
	public ValueResult<String> healthCheck() {
		return new ValueResult<>("Great! Spring Config Server is up");
	}

}
