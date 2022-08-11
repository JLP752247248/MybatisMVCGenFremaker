package com.jlp.freemaker.mvc.core;

import com.jlp.freemaker.mvc.core.GeneratorBuilder.Condition;
import com.jlp.freemaker.mvc.utils.common.DbMetaDataUtils;
 
public class MybatisGenerator {
public static void main(String[] args) {
	
		Condition condition = GeneratorBuilder.getCondition()
													.setDao(true)
														.setiService(true)
															.setMapper(true)
																.setModel(true)
																	.setServiceImpl(true);
		new GeneratorBuilder("a", "b", DbMetaDataUtils.getTable("sys_user"), "用户表").builder(condition);
	}
} 
