package com.facturacion.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.dto.LoginRequest;
import com.facturacion.app.dto.User;
import com.facturacion.app.service.LoginService;
import com.facturacion.app.utils.Utils;






@RestController
@RequestMapping("/api")
public class authController {
	
private final  LoginService loginService;
	private Utils utils = new Utils();


    authController(LoginService loginService) {
        this.loginService = loginService;
    }
	
	 
    @PostMapping("/login")
    public GenericaResponse login(@RequestBody LoginRequest loginRequest) {
        try {

        	String ruc = loginRequest.getUsername();
        	User user = loginService.devolverUsuario(ruc);
        	
	  if(loginRequest.getUsername().equals(user.getUsername()) &&
			  loginRequest.getPassword().equals(user.getPassword())) {
	       return utils.OkResponse(user.getIdUser());
	  }else {
			 return utils.UnauthorizedResponse();
	  }
        	
 
            
        } catch (Exception e) {
        	 return utils.UnauthorizedResponse();
        }
    }
    

}
