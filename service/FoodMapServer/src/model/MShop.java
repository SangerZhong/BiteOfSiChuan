package model;

import dao.pojo.User;

public class MShop {
	
	//升序
	public final static int ASCENDING=0;
	//降序
	public final static int DESCENDING =1;
	//排序类型
	public final static int ORDERBY_GRADE =0;
	public final static int ORDERBY_PRICE =1;
	
	//距离某点的距离
	private int distance;
	
	
	//请求页数
	private int pageNumber;
	private String userId;
	private String iconData,imgData;
	public String getImgData() {
		return imgData;
	}
	public void setImgData(String imgData) {
		this.imgData = imgData;
	}

	//描述
	private String createDate;
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	//请求者坐标
	private Double requesterLat,requesterLng;
	//0升序 1降序
	private int orderType=DESCENDING;
	//排序类型
	private int orderBy=ORDERBY_GRADE;
	

	

	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public Double getRequesterLat() {
		return requesterLat;
	}
	public void setRequesterLat(Double requesterLat) {
		this.requesterLat = requesterLat;
	}
	public Double getRequesterLng() {
		return requesterLng;
	}
	public void setRequesterLng(Double requesterLng) {
		this.requesterLng = requesterLng;
	}

	public String getIconData() {
		return iconData;
	}
	public void setIconData(String iconData) {
		this.iconData = iconData;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	private Integer shopId;
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	private String shopName;
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public Double getGradeAvg() {
		return gradeAvg;
	}
	public void setGradeAvg(Double gradeAvg) {
		this.gradeAvg = gradeAvg;
	}
	public Double getCostAvg() {
		return costAvg;
	}
	public void setCostAvg(Double costAvg) {
		this.costAvg = costAvg;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	private String iconUrl;
	private Double lng;
	private Double lat;
	private String address;
	private String feature;
	private Double gradeAvg;
	private Double costAvg;
	private Integer typeId=-1;
	

}
