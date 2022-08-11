package com.jlp.freemaker.mvc.utils.generate;

import java.io.File;
import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;
import com.jlp.freemaker.mvc.entity.IService;
import com.jlp.freemaker.mvc.support.IGenerate;
import com.jlp.freemaker.mvc.utils.common.StrUtils;
import com.jlp.freemaker.mvc.utils.freemarker.FreeMarkerTemplateUtils;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to TODO
 * @date 2018年7月1日 下午1:56:54
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class GenerateIService implements IGenerate<IService> {

	@Override
	public void generateFile(IService iService) throws Exception {
		final String path = StrUtils.getAbsolutePath()
					+GenerateConfiguration.SRC_PATH
					+StrUtils.package2path(iService.getPackageName()
					+StrUtils.DOT
					+GenerateConfiguration.PKG_SUFFIX_SERVICE+StrUtils.DOT);
		final String templateName = "templates/IService.ftl";
	    File pat = new File(path);
	    if(!pat.exists()) {
	    	pat.mkdirs();
	    }
	    String filePath = path+"I"+iService.getModelName()+"Service"+GenerateConfiguration.JAVA_SUFFIX;
	    File file = new File(filePath);
		FreeMarkerTemplateUtils.generateFile(templateName, file, iService);

	}

}
