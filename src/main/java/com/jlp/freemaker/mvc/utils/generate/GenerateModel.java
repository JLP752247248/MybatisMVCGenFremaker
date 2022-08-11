package com.jlp.freemaker.mvc.utils.generate;

import java.io.File;
import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;
import com.jlp.freemaker.mvc.entity.Model;
import com.jlp.freemaker.mvc.support.IGenerate;
import com.jlp.freemaker.mvc.utils.common.StrUtils;
import com.jlp.freemaker.mvc.utils.freemarker.FreeMarkerTemplateUtils;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to TODO
 * @date 2018年7月1日 上午1:56:35
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class GenerateModel implements IGenerate<Model>{

	@Override
	public void generateFile(Model model) throws Exception  {
		
        final String path = StrUtils.getAbsolutePath()
        					+GenerateConfiguration.SRC_PATH
        					+StrUtils.package2path(model.getPackageName()+StrUtils.DOT);
        final String templateName = "templates/Model.ftl";
        File pat = new File(path);
        if(!pat.exists()) {
        	pat.mkdirs();
        }
        String filePath = path+model.getModelName()+GenerateConfiguration.JAVA_SUFFIX;
        File file = new File(filePath);
        FreeMarkerTemplateUtils.generateFile(templateName,file,model);
        System.out.println("生成实体类");
	}

	
}
