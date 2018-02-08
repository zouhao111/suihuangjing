package com.erich.saleticket.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 菜单
 * @author Lv
 *
 */
public class SysMenu extends BaseModel {

	private static final long serialVersionUID = 1L;

	private Integer menuId;

	private Integer parentId;

	private String code;

	private String fullName;

	private String parentName;

	private String description;

	private String img;

	private String category;

	private String navigateUrl;

	private String formName;

	private String target;

	private Integer isUnfold;

	private Integer allowEdit;

	private Integer allowDelete;

	private Integer enabled;

	private Integer sortCode;

	private Integer deleteMark;

	private Date createDate;

	private Integer createUserId;

	private String createUserName;

	private Date modifyDate;

	private Integer modifyUserId;

	private String modifyUserName;

	private Map<String, Object> children;

	private List<SysMenu> childMenuList;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName == null ? null : fullName.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category == null ? null : category.trim();
	}

	public String getNavigateUrl() {
		return navigateUrl;
	}

	public void setNavigateUrl(String navigateUrl) {
		this.navigateUrl = navigateUrl == null ? null : navigateUrl.trim();
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName == null ? null : formName.trim();
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	public Integer getIsUnfold() {
		return isUnfold;
	}

	public void setIsUnfold(Integer isUnfold) {
		this.isUnfold = isUnfold;
	}

	public Integer getAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(Integer allowEdit) {
		this.allowEdit = allowEdit;
	}

	public Integer getAllowDelete() {
		return allowDelete;
	}

	public void setAllowDelete(Integer allowDelete) {
		this.allowDelete = allowDelete;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	public Integer getDeleteMark() {
		return deleteMark;
	}

	public void setDeleteMark(Integer deleteMark) {
		this.deleteMark = deleteMark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName == null ? null : modifyUserName.trim();
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Map<String, Object> getChildren() {
		if (children == null) {
			children = new HashMap<String, Object>();
		}
		return children;
	}

	public void setChildren(Map<String, Object> children) {
		this.children = children;
	}

	public List<SysMenu> getChildMenuList() {
		if (childMenuList == null) {
			childMenuList = new ArrayList<SysMenu>();
		}
		return childMenuList;
	}

	public void setChildMenuList(List<SysMenu> childMenuList) {
		this.childMenuList = childMenuList;
	}

}