package edu.ucsb.cs156.example.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The FrontendController is used to serve the frontend of the application.
 * 
 * This is only enabled in the production profile, and is used to serve the frontend of the application.
 * For development, see the FrontendProxyController.
 * 
 * @See edu.ucsb.cs156.example.controllers.FrontendProxyController
 */

@Profile("!development")
@Controller
public class FrontendController {
  @GetMapping("/**/{path:[^\\.]*}")
  public String index() {
    return "forward:/index.html";
  }

  @GetMapping("/csrf")
  public ResponseEntity<String> csrf() {
    return ResponseEntity.notFound().build();
  }

}
