package com.jlp.freemaker.mvc.utils.generate;

import java.io.File;

import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;
import com.jlp.freemaker.mvc.entity.Mapper;
import com.jlp.freemaker.mvc.support.IGenerate;
import com.jlp.freemaker.mvc.utils.common.StrUtils;
import com.jlp.freemaker.mvc.utils.freemarker.FreeMarkerTemplateUtils;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to TODO
 * @date 2018年7月1日 下午1:59:40
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class GenerateMapper implements IGenerate<Mapper> {

	@Override
	public void generateFile(Mapper mapper) throws Exception {
		final String path = StrUtils.getAbsolutePath()
					+GenerateConfiguration.Mapper_PATH;
		final String templateName = "templates/Mapper.ftl";
	    File pat = new File(path);
	    if(!pat.exists()) {
	    	pat.mkdirs();
	    }
	    String filePath = path+mapper.getModelName()+"Mapper"+GenerateConfiguration.MAPPINGS_SUFFIX;
	    File file = new File(filePath);
		FreeMarkerTemplateUtils.generateFile(templateName, file, mapper);
	}
}
