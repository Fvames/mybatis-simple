package dev.fvames.domain;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/28 15:07
 */

public class OrderDetail {
	private Integer id;
	private Integer orderId;
	private Double totalPrice;
	private Integer status;
	private Integer itemId;
	private Item item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "OrderDetail{" +
				"id=" + id +
				", orderId=" + orderId +
				", totalPrice=" + totalPrice +
				", status=" + status +
				", itemId=" + itemId +
				", item=" + item +
				'}';
	}
}
