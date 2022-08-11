package com.jlp.freemaker.mvc.utils.generate;

import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;
import com.jlp.freemaker.mvc.entity.Model;
import com.jlp.freemaker.mvc.entity.Vo;
import com.jlp.freemaker.mvc.support.IGenerate;
import com.jlp.freemaker.mvc.utils.common.StrUtils;
import com.jlp.freemaker.mvc.utils.freemarker.FreeMarkerTemplateUtils;

import java.io.File;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to TODO
 * @date 2018年7月1日 上午1:56:35
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class GenerateVo implements IGenerate<Vo>{

	@Override
	public void generateFile(Vo model) throws Exception  {
		
        final String path = StrUtils.getAbsolutePath()
        					+GenerateConfiguration.SRC_PATH
        					+StrUtils.package2path(model.getPackageName()
                +StrUtils.DOT
                +GenerateConfiguration.PKG_SUFFIX_Dao+StrUtils.DOT);
        final String templateName = "templates/Vo.ftl";
        File pat = new File(path);
        if(!pat.exists()) {
        	pat.mkdirs();
        }
        String filePath = path+model.getModelName()+GenerateConfiguration.JAVA_SUFFIX;
        File file = new File(filePath);
        FreeMarkerTemplateUtils.generateFile(templateName,file,model);
        System.out.println("生产VO");
	}

	
}
