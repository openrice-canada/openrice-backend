package ca.openricecan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClientController {
  @GetMapping
  public ModelAndView home(){
    return new ModelAndView("index");
  }
}
