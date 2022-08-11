package com.jlp.freemaker.mvc.entity;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 业务实现类数据类
 * @date 2018年6月30日 下午10:41:36
 * @see<p>:www.aixuegao.cn</p>
 */
public class ServiceImpl extends BaseEntity{
	
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
		return "ServiceImpl [modelName=" + modelName + ", packageName=" + packageName + "]";
	}
}
