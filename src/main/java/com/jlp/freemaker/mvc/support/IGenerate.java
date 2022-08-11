package com.jlp.freemaker.mvc.support;

/**
 * 生成相关的泛型接口
 * @author 啃过雪糕的兔子
 * @to TODO
 * @date 2018年7月1日 下午12:25:17
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 * @param <T>
 */
@FunctionalInterface
public interface IGenerate <T>{
	/**
	 * 生成文件
	 * @param t
	 */
   void generateFile(T t) throws Exception;
}
