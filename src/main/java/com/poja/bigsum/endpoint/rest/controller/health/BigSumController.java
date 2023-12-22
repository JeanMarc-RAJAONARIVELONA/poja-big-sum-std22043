package com.poja.bigsum.endpoint.rest.controller.health;

import com.poja.bigsum.PojaGenerated;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@PojaGenerated
@RestController
@AllArgsConstructor
public class BigSumController {
  @GetMapping("/big-sum")
  public ResponseEntity<String> calculateBigSum(@RequestParam("a") String aStr, @RequestParam("b") String bStr) {
    try {
      BigInteger a = new BigInteger(aStr);
      BigInteger b = new BigInteger(bStr);
      BigInteger result = a.add(b);
      return ResponseEntity.ok(result.toString());
    } catch (NumberFormatException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid numbers provided");
    }
  }
}
