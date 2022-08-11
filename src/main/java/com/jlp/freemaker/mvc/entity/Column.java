package com.jlp.freemaker.mvc.entity;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 数据表字段数据类
 * @date 2018年6月30日 下午10:48:36
 * @see:<p>www.aixuegao.cn</p>
 */
public class Column {
	/**主键*/
	private Boolean isPrimaryKey;
	/** 数据库字段名称 **/
    private String name;
    /** 数据库字段类型 **/
    private String type;
    /** 数据库字段首字母小写且去掉下划线字符串 **/
    private String nameUp;
    /** 数据库字段注释 **/
    private String comment;
    /**原始字段名*/
    private String originalName;
    
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public Boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}
	public void setIsPrimaryKey(Boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNameUp() {
		return nameUp;
	}
	public void setNameUp(String nameUp) {
		this.nameUp = nameUp;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Column [isPrimaryKey=" + isPrimaryKey + ", name=" + name + ", type=" + type + ", nameUp=" + nameUp
				+ ", comment=" + comment + ", originalName=" + originalName + "]";
	}
}
