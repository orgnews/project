package com.pojo;

public class RoomInFormation {
	/*
 	id String 这里使用的是uuid为主键
	room_number int   房间号对应客房标准表的房间号(room_number)
	room_name string 客房标准名称
	room_area double房间面积 
	air_conditioner int 是否有空调 0无空调  1有空调
	television int 是否有电视机  0 无   1有
	telephone  int 是否有电话   0 无   1有
	toilet  int 是否有卫生间   0  无  1 有
	room_status  int 客房状态 是否已经有人居住或者有人订单  0 空闲   1已订单  2已居住
	establish_date date  创建时间  系统当前时间
	 */
	
	private String id;
	private String room_number;
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	private String room_name;
	private String room_area;
	private String air_conditioner;
	private String television;
	private String telephone;
	private String toilet;
	private String room_status;
	private String establish_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoom_area() {
		return room_area;
	}
	public void setRoom_area(String room_area) {
		this.room_area = room_area;
	}
	public String getAir_conditioner() {
		return air_conditioner;
	}
	public void setAir_conditioner(String air_conditioner) {
		this.air_conditioner = air_conditioner;
	}
	public String getTelevision() {
		return television;
	}
	public void setTelevision(String television) {
		this.television = television;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getToilet() {
		return toilet;
	}
	public void setToilet(String toilet) {
		this.toilet = toilet;
	}
	public String getRoom_status() {
		return room_status;
	}
	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}
	public String getEstablish_date() {
		return establish_date;
	}
	public void setEstablish_date(String establish_date) {
		this.establish_date = establish_date;
	}
	
	
}
