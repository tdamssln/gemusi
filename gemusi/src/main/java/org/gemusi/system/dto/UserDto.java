package org.gemusi.system.dto;

import org.gemusi.common.frame.dto.BaseDto;
import org.gemusi.system.model.UserInfo;

public class UserDto extends BaseDto {

	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
