package com.pojo;

public class RoomStandard {
	private String id;
	/**
	 * 楼层
	 */
	private int floor;
	/**
	 * 房间号
	 */
	private int room_number;
	/**
	 * 居室:一居室、二居室、三居室
	 */
	private String bed_room;
	/**
	 * 朝向
	 */
	private String orientation;
	/**
	 * 房间价钱
	 */
	private String room_money;
	/**
	 * 创建时间   系统当前时间
	 */
	private String establish_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public String getBed_room() {
		return bed_room;
	}
	public void setBed_room(String bed_room) {
		this.bed_room = bed_room;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getRoom_money() {
		return room_money;
	}
	public void setRoom_money(String room_money) {
		this.room_money = room_money;
	}
	public String getEstablish_date() {
		return establish_date;
	}
	public void setEstablish_date(String establish_date) {
		this.establish_date = establish_date;
	}
	
}
