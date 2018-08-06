package com.bs.oauth.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.oauth.server.model.ValueResult;

public class ControllerHealthCheck {

	/**
	 * @author bharat
	 *
	 */
	@Controller
	public class RestController {

		@RequestMapping("/healthcheck")
		public ValueResult<String> healthCheck() {
			return new ValueResult<>("Great! Spring auth server is up");
		}

	}

}
