package service.impl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import model.MComment;
import service.interf.IComment;
import utils.StorageUtil;
import dao.impl.CommentDAO;
import dao.impl.PictureDAO;
import dao.impl.ShopDao;
import dao.impl.UserDAO;
import dao.interf.ICommentDAO;
import dao.interf.IPictureDAO;
import dao.interf.IShopDAO;
import dao.interf.IUserDAO;
import dao.pojo.Comment;
import dao.pojo.Picture;
import dao.pojo.Shop;
import dao.pojo.User;


public class CommentImpl implements IComment{
	
	private final int TYPE_COMMMET = 1;
	
	private ICommentDAO cDao = new CommentDAO();
	private IPictureDAO pDao = new PictureDAO();

	private IUserDAO uDao = new UserDAO();
	private IShopDAO sDao = new ShopDao();
	
	
	public Boolean upImg(MComment model)throws Exception {
		Picture pic = new Picture();
		pic.setType(TYPE_COMMMET);
		pic.setId(model.getShopId());
		pic.setUserId(model.getUserId());
		pic.setDatetime(model.getDatetime());
		if (model.getImageData() != null) {
			pic.setPicUrl(StorageUtil.PIC_PATH_SQLDATA
					+ StorageUtil.loadPic(model.getImageData(), StorageUtil.PIC_PATH));
		}
		pDao.save(pic);	
		return true;
	}

	public Boolean add(MComment model) throws Exception {

		Comment comment = new Comment();
		comment.setComment(model.getComment());
		comment.setGrade(model.getGrade());
		comment.setShop(new Shop(model.getShopId()));
		comment.setUser(new User(model.getUserId()));
		comment.setDatetime(model.getDatetime());
		comment.setCost(model.getCost().intValue());
        cDao.save(comment);
		return true;
	}
	
	
	public Boolean check(MComment model) throws Exception {
		Comment comment = cDao.findById(model.getUserId());
		cDao.addxxx();
		if(comment == null)
			throw new Exception("该评论不存在");
		
		return true;
	}
	//根据id寻找特定评论
	public JSONObject searchById(MComment model) throws Exception {
		
		// TODO Auto-generated method stub
		JSONObject jsonObject= new JSONObject();
		//User user = uDao.findById(model.getUserId());
		
		Shop shop = sDao.findById(model.getShopId());
		int pageNumber = model.getPageNumber();
		int start = (pageNumber - 1) * 10;
		int limit = pageNumber * 10;
		//String rule = "model.user.userId = " + "'" + model.getUserId() + "'" + " and " +
		//"model.shop.shopId = " + "'" + model.getShopId() + "'";
		String rule = "model.shop.shopId = " + "'" + model.getShopId() + "'";
		String sortfield = "model.datetime" + " desc";
		List<Comment> commentList = cDao.findAll(start, limit, rule, sortfield);
		if(commentList==null)
		{
			jsonObject.put("isExist", false);
		}
		else
		{
			jsonObject.put("isExist", true);
	
			jsonObject.element("commentList", getJSonArray(commentList));
		
		}
		return jsonObject;
	}
	

	// 将获得的comment列表组装成带有详细信息的列表
	protected JSONArray getJSonArray(List<Comment> list) throws Exception {
		JSONArray jsonArray = new JSONArray();
		for (Comment comment : list) {
			JSONObject commentItem = getCommentData(comment);
			jsonArray.add(commentItem);
		}
		return jsonArray;
	}

	// 某一评论详细信息
	public JSONObject getCommentData(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		JSONObject jsonData = new JSONObject();
		IPictureDAO pDAO=new PictureDAO();

		// 图片
		JSONArray picArray = new JSONArray();
		jsonData.put("id", comment.getCommentId());
		jsonData.put("shopId", comment.getShop().getShopId());
		jsonData.put("grade", comment.getGrade());
		jsonData.put("userId", comment.getUser().getUserId());
		jsonData.put("datetime", comment.getDatetime());
		jsonData.put("comment", comment.getComment());
		jsonData.put("cost", comment.getCost());		
		//评论图片
		String rule="model.id =" +comment.getShop().getShopId()+" AND model.type="+TYPE_COMMMET +
		" AND model.userId = " +  "'" + comment.getUser().getUserId() + "'" + 
		"AND model.datetime = " + "'" + comment.getDatetime() + "'";
		System.out.print(rule);
		List<Picture> picList=pDAO.findAll(0, 10, rule, null);
		for(Picture p:picList)
		{
			picArray.add(StorageUtil.SERVICE_ADDRESS+p.getPicUrl());
		}
		jsonData.element("picUri", picArray);
		
		return jsonData;
	}

	
}
