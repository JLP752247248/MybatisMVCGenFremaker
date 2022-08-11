package com.jlp.freemaker.mvc.entity;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 接口实数据类
 * @date 2018年6月30日 下午10:42:19
 * @see<p>:www.aixuegao.cn</p>
 */
public class IService extends BaseEntity{

	private String modelName;

	private String packageName;
	
	
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

	@Override
	public String toString() {
		return "IService [modelName=" + modelName + ", packageName=" + packageName + "]";
	}
}
