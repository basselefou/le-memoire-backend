package org.glsid.controller;

import org.glsid.entitie.CompteEmploye;
import org.glsid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	@PostMapping("/register")
	public CompteEmploye register(@RequestBody RegisterForm compteEmployeForm) {
		if(!compteEmployeForm.getPassword().equals(compteEmployeForm.getRepassword()))
			throw new RuntimeException("you must confirm your password ");
		CompteEmploye user=accountService.findCompteEmployeByUsername(compteEmployeForm.getUsername());
			if(user!=null) throw new RuntimeException("this user already exists ");
			CompteEmploye compteemploye=new CompteEmploye();
			compteemploye.setUsername(compteEmployeForm.getUsername());
			compteemploye.setPassword(compteEmployeForm.getPassword());
		accountService.saveCompteEmploye(compteemploye);
		accountService.addAppRoleToCompteEmploye((compteEmployeForm.getUsername()), "USER"); 
		return compteemploye;
	}

}
