package com.jlp.freemaker.mvc.support;

import com.jlp.freemaker.mvc.entity.Dao;
import com.jlp.freemaker.mvc.entity.IService;
import com.jlp.freemaker.mvc.entity.Mapper;
import com.jlp.freemaker.mvc.entity.Model;
import com.jlp.freemaker.mvc.entity.ServiceImpl;
import com.jlp.freemaker.mvc.utils.generate.GenerateDao;
import com.jlp.freemaker.mvc.utils.generate.GenerateIService;
import com.jlp.freemaker.mvc.utils.generate.GenerateMapper;
import com.jlp.freemaker.mvc.utils.generate.GenerateModel;
import com.jlp.freemaker.mvc.utils.generate.GenerateServiceImpl;

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
	 
	 public static IGenerate<ServiceImpl> createServiceImpl() {
		 return new GenerateServiceImpl();
	 }
	 
}
