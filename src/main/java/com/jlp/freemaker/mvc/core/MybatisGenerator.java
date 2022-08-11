package com.jlp.freemaker.mvc.core;

import com.jlp.freemaker.mvc.core.GeneratorBuilder.Condition;
import com.jlp.freemaker.mvc.utils.common.DbMetaDataUtils;
 
public class MybatisGenerator {
public static void main(String[] args) {
	
		Condition condition = GeneratorBuilder.getCondition()
													.setDao(false)
														.setiService(false)
															.setMapper(false)
																.setModel(false)
																	.setServiceImpl(false)
				.setVo(true);
		new GeneratorBuilder("", "UserInfo", DbMetaDataUtils.getTable("sys_user"), "用户表").builder(condition);
	}
} 
