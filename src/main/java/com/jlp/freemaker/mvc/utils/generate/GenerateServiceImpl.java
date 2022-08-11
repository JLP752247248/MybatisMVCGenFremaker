package com.jlp.freemaker.mvc.utils.generate;

import java.io.File;
import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;
import com.jlp.freemaker.mvc.entity.ServiceImpl;
import com.jlp.freemaker.mvc.support.IGenerate;
import com.jlp.freemaker.mvc.utils.common.StrUtils;
import com.jlp.freemaker.mvc.utils.freemarker.FreeMarkerTemplateUtils;

/**
 * ServiceImpl 服务实现层工具类
 * 
 * @author hxy
 * @version 1.0.0
 */
public class GenerateServiceImpl implements IGenerate<ServiceImpl> {

	@Override
	public void generateFile(ServiceImpl serviceImpl) throws Exception {
	final String path = StrUtils.getAbsolutePath()
				+GenerateConfiguration.SRC_PATH
				+StrUtils.package2path(serviceImpl.getPackageName()
				+StrUtils.DOT
				+GenerateConfiguration.PKG_SUFFIX_SERVICE_IMPL+StrUtils.DOT);
	final String templateName = "templates/ServiceImpl.ftl";
    File pat = new File(path);
    if(!pat.exists()) {
    	pat.mkdirs();
    }
    String filePath = path+serviceImpl.getModelName()+"Impl"+GenerateConfiguration.JAVA_SUFFIX;
    File file = new File(filePath);
	FreeMarkerTemplateUtils.generateFile(templateName, file, serviceImpl);
	}

}
