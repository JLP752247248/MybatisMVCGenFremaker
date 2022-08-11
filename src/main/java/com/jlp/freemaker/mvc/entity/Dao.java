package com.jlp.freemaker.mvc.entity;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 数据库操作对象数据类
 * @date 2018年6月30日 下午10:57:56
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class Dao extends BaseEntity{

	private String modelName;
	
	private String packageName;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public String toString() {
		return "Dao [modelName=" + modelName + ", packageName=" + packageName + "]";
	}
}
