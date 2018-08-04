package pers.pole.controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pers.pole.service.user.IUserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	/** 添加用户
	* @return    
	* @date 2017年12月10日
	* @author guohaibing 
	*/
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Map<String,Object> insertUser() {
		return this.userService.insertUser();

	}
}
