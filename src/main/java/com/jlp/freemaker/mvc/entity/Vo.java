package com.jlp.freemaker.mvc.entity;

import java.util.List;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 实体数据类
 * @date 2018年6月30日 下午10:45:20
 * @see:<p>www.aixuegao.cn</p>
 */
public class Vo extends BaseEntity{

	private String modelName;

	private String packageName;

	private List<Column> columnList = null;

	private String tableName;

	public Vo() {
		super();
	}

	public Vo(String modelName, String packageName, List<Column> columnList) {
		super();
		this.modelName = modelName;
		this.packageName = packageName;
		this.columnList = columnList;
	}

	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

	@Override
	public String toString() {
		return "Model [modelName=" + modelName + ", packageName=" + packageName + ", columnList=" + columnList
				+ ", tableName=" + tableName + "]";
	}
}
