package com.jlp.freemaker.mvc.utils.freemarker;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import com.jlp.freemaker.mvc.entity.BaseEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;


/**
 * 
 * @author 啃过雪糕的兔子
 * @to freemarker 模板工具类
 * @date 2018年7月1日 上午2:19:10
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class FreeMarkerTemplateUtils {
	
	private FreeMarkerTemplateUtils(){
		
	}
	
    private static final Configuration CONFIGURATION = new Configuration();

    static{
    	try {
    		//这里比较重要，用来指定加载模板所在的路径
			CONFIGURATION.setClassForTemplateLoading(FreeMarkerTemplateUtils.class,"/");
			//CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "D:\\test1\\"));
	        CONFIGURATION.setDefaultEncoding("UTF-8");
	        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	        CONFIGURATION.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * 获得模板
     * @param templateName
     * @return
     * @throws IOException
     */
    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 清除缓存
     */
    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }
    
    /**
     * 通过模板生成可以使用的文件
     * @param templateName
     * @param file
     * @param dataMap
     * @throws Exception
     */
    public static void generateFile(final String templateName,File file,BaseEntity entity) throws Exception{
        Template template = getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(entity,out);
    }
}
