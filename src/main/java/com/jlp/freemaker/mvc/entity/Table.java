package com.jlp.freemaker.mvc.entity;

import java.util.List;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 数据表数据类
 * @date 2018年6月30日 下午10:37:27
 * @see<p>:www.aixuegao.cn</p>
 */
public class Table {
	/**表名*/
	private String table;
	/**表的字段数据集合*/
	private List<Column> columnList = null;
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

	@Override
	public String toString() {
		return "Table [table=" + table + ", columnList=" + columnList + "]";
	}
}
