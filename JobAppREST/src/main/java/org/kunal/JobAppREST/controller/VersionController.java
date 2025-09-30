package org.kunal.JobAppREST.controller;

import org.kunal.JobAppREST.model.User;
import org.kunal.JobAppREST.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	@GetMapping("version")
	public String version() {
		return "1.0.1";
	}

}
