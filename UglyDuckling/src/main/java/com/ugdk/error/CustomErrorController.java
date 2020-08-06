package com.ugdk.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

public class CustomErrorController implements ErrorController {
	private String VIEW_PATH = "/error/";

	@RequestMapping(value = "/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			int statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return VIEW_PATH + "404";
			}
			if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return VIEW_PATH + "500";
			}
		}
		return "/error/default";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
