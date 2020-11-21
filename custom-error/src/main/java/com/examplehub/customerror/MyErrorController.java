package com.examplehub.customerror;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

  @Override
  public String getErrorPath() {
    return "/error";
  }

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request) {
    // get error status
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    // TODO: log error details here

    if (status != null) {
      int statusCode = Integer.parseInt(status.toString());

      // display specific error page
      if (statusCode == HttpStatus.NOT_FOUND.value()) {
        System.out.println("404");
        return "404";
      } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
        System.out.println("500");
        return "500";
      } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
        System.out.println("403");
        return "403";
      }
    }

    // display generic error
    return "error";
  }
}
