package dev.fvames.domain;

import lombok.Data;

import java.time.LocalDate;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/26 11:14
 */
@Data
public class UserInfo {
	private Long id;
	private String userName;
	private Integer age;
	private Integer sex;
	private LocalDate birthday;
	private String password;
	private String userType;
	private Integer enabled;
	private String realName;
	private String qq;
	private String email;
	private String tel;
	private Long created;
	private Long updated;
}
