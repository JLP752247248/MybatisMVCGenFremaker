package com.jlp.freemaker.mvc.common.configuration;

import com.jlp.freemaker.mvc.utils.common.StrUtils;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 全局配置
 * @date 2018年7月1日 下午12:51:54
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class GenerateConfiguration {
	/**工程的名称*/
	public static final String PROJECT_PATH = "/generatecode";
	/**包前缀*/
	public static String PKG_PREFIX = "com.panda.auth";
	/**实体包后缀*/
	public final static String PKG_SUFFIX_MODEL = ".model";
	/**dao包后缀*/
	public final static String PKG_SUFFIX_Dao = ".dao";
	/**dao包后缀*/
	public final static String PKG_SUFFIX_Vo = ".vo";
	/**服务包后缀*/
	public final static String PKG_SUFFIX_SERVICE = ".service";
	/**服务实现层*/
	public final static String PKG_SUFFIX_SERVICE_IMPL = ".service.impl";
	/**连接名*/
	public final static String CONNECTION_NAME = "jdbc:mysql://127.0.0.1:3306/panda-auth?useUnicode=true&amp;characterEncoding=utf-8";
	/**数据库用户名*/
	public final static String DB_USER = "root";
	/**用户密码*/
	public final static String DB_PASSWORD = "1234";
	/**驱动*/
	public final static String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	
	/*#############################################################*/
	/*###############如果是maven工程的话,以下配置一般默认不用更改##############*/
	/*#############################################################*/
	
	/**主工程文件*/
	public final static String SRC_PATH = "/src/" + StrUtils.FILE_SEPARATOR;
	/**mapper存放的路径*/
	public final static String Mapper_PATH = "/src/main/resources/mappers/" + StrUtils.FILE_SEPARATOR;
	/**单元测试的路径*/
	public final static String TEST_PATH = "/src/test/java" + StrUtils.FILE_SEPARATOR;
	/**java文件的后缀*/
	public static final String JAVA_SUFFIX = ".java";
	/**xml文件的后缀*/
	public static final String MAPPINGS_SUFFIX = ".xml";
}
