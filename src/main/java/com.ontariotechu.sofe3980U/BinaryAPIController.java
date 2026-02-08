package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	//Multiply 
    @GetMapping("/multiply")
    public String multiplyString(
            @RequestParam String operand1,
            @RequestParam String operand2) {

        return Binary.multiply(new Binary(operand1), new Binary(operand2)).getValue();
    }

    @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJSON(
            @RequestParam String operand1,
            @RequestParam String operand2) {

        Binary n1 = new Binary(operand1);
        Binary n2 = new Binary(operand2);
        return new BinaryAPIResult(n1, "multiply", n2,
                Binary.multiply(n1, n2));
    }

    //And
    @GetMapping("/and")
    public String andString(
            @RequestParam String operand1,
            @RequestParam String operand2) {

        return Binary.and(new Binary(operand1), new Binary(operand2)).getValue();
    }

    @GetMapping("/and_json")
    public BinaryAPIResult andJSON(
            @RequestParam String operand1,
            @RequestParam String operand2) {

        Binary n1 = new Binary(operand1);
        Binary n2 = new Binary(operand2);
        return new BinaryAPIResult(n1, "and", n2,
                Binary.and(n1, n2));
    }

    //Or
    @GetMapping("/or")
    public String orString(
            @RequestParam String operand1,
            @RequestParam String operand2) {

        return Binary.or(new Binary(operand1), new Binary(operand2)).getValue();
    }

    @GetMapping("/or_json")
    public BinaryAPIResult orJSON(
            @RequestParam String operand1,
            @RequestParam String operand2) {

        Binary n1 = new Binary(operand1);
        Binary n2 = new Binary(operand2);
        return new BinaryAPIResult(n1, "or", n2,
                Binary.or(n1, n2));
    }

}