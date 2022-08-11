package com.jlp.freemaker.mvc.utils.generate;

import java.io.File;
import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;
import com.jlp.freemaker.mvc.entity.Dao;
import com.jlp.freemaker.mvc.support.IGenerate;
import com.jlp.freemaker.mvc.utils.common.StrUtils;
import com.jlp.freemaker.mvc.utils.freemarker.FreeMarkerTemplateUtils;

/**
 * DAO 工具类
 * 
 * @author hxy
 * @version 1.0.0
 */ 
public class GenerateDao implements IGenerate<Dao> {

	@Override 
	public void generateFile(Dao dao) throws Exception {
		final String path = StrUtils.getAbsolutePath()
					+GenerateConfiguration.SRC_PATH
					+StrUtils.package2path(dao.getPackageName()
					+StrUtils.DOT
					+GenerateConfiguration.PKG_SUFFIX_Dao+StrUtils.DOT);
		final String templateName = "templates/DAO.ftl";
        File pat = new File(path);
        if(!pat.exists()) {
        	pat.mkdirs();
        }
        String filePath = path+dao.getModelName()+"Dao"+GenerateConfiguration.JAVA_SUFFIX;
        File file = new File(filePath);
		FreeMarkerTemplateUtils.generateFile(templateName, file, dao);

	}

}
