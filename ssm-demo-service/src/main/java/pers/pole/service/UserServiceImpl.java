package pers.pole.service;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.pole.common.ResponseUtil;
import pers.pole.mapper.user.IUserMapper;
import pers.pole.pojo.user.User;
import pers.pole.service.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	private Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserMapper userMapper;

	/** 添加用户
	* @return    
	* @date 2017年12月10日
	* @author guohaibing 
	*/
	@Override
	public Map<String,Object> insertUser() {
		User record = new User();
		record.setName("zhangsan");
		record.setCreateTime(new Date());
		record.setPhone("18711111111");
		record.setIsDeleted((byte)0);
		int count = this.userMapper.insertSelective(record);
		if (count <= 0) {
			return ResponseUtil.error();
		}
		logger.info("用户添加成功");
		logger.error("用户添加成功");
		return ResponseUtil.success();
	}

}
