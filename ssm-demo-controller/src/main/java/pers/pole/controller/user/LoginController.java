package pers.pole.controller.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pers.pole.common.CaptchaUtil;

@RestController
public class LoginController {
	
	/** 
	 * 生成验证码
	 * @param random
	 * @param requestEntity
	 * @return    
	 * @date 2018年5月11日
	 * @author guohaibing 
	 */
	@RequestMapping("/captcha")
	public ResponseEntity<byte[]> captcha(@RequestParam("random") String random, HttpEntity<byte[]> requestEntity) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setCacheControl("no-cache,no-store,must-revalidate");
	    responseHeaders.setPragma("no-cache");
	    responseHeaders.setExpires(0);
	    responseHeaders.setContentType(MediaType.IMAGE_JPEG);
		String captchaCode = "1234";
		byte[] imageByte = CaptchaUtil.createImage(captchaCode);
		return new ResponseEntity<byte[]>(imageByte, responseHeaders, HttpStatus.OK);
	}

}
