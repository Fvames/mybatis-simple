package dev.fvames.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 16:53
 */

public class Order {
	private Integer id;
	private Long userId;
	private String orderNumber;
	private LocalDate createDate;
	private LocalDate updateDate;

	private UserInfo userInfo;
	private List<OrderDetail> detailList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<OrderDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", userId=" + userId +
				", orderNumber='" + orderNumber + '\'' +
				", created=" + createDate +
				", updated=" + updateDate +
				", userInfo=" + userInfo +
				'}';
	}
}
