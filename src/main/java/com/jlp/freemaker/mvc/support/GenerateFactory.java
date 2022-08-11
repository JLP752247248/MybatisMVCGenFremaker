package com.jlp.freemaker.mvc.support;

import com.jlp.freemaker.mvc.entity.*;
import com.jlp.freemaker.mvc.utils.generate.*;

/**
 * 生成工厂
 * @author 啃过雪糕的兔子
 * @to 用于创建要生成的文件
 * @date 2018年7月5日 下午11:52:36
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.2
 */
public class GenerateFactory {

	 public static IGenerate<Model> createModel() {
		 return new GenerateModel();
	 }
	 
	 public static IGenerate<Dao> createDao() {
		 return new GenerateDao();
	 }
	 
	 public static IGenerate<IService> createIService() {
		 return new GenerateIService();
	 }
	 
	 public static IGenerate<Mapper> createMapper() {
		 return new GenerateMapper();
	 }

	public static IGenerate<Vo> createVo() {
		return new GenerateVo();
	}
	 
	 public static IGenerate<ServiceImpl> createServiceImpl() {
		 return new GenerateServiceImpl();
	 }
	 
}
