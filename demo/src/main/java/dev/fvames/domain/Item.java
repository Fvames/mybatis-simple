package dev.fvames.domain;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/28 17:48
 */

public class Item {
	private Integer id;
	private String itemName;
	private Float itemPrice;
	private String itemDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", itemName='" + itemName + '\'' +
				", itemPrice=" + itemPrice +
				", itemDetail='" + itemDetail + '\'' +
				'}';
	}
}
