package com.jlp.freemaker.mvc.entity;

import java.util.List;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to xml 文件数据实体
 * @date 2018年6月30日 下午10:43:40
 * @see<p>:www.aixuegao.cn</p>
 */
public class Mapper extends BaseEntity{
  
	private String modelName;
	
	private String packageName;
	
	private List<Column> columnList = null;

	
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
		return "Mapper [modelName=" + modelName + ", packageName=" + packageName + ", columnList=" + columnList + "]";
	}
}
