package ${packageName}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${packageName}.model.${modelName};
import ${packageName}.dao.${modelName}Dao;
import ${packageName}.service.I${modelName}Service;
import xtq.config.basemvc.service.impl.BaseServiceImpl;

/**
* 描述：服务实现层
* @author 
* @date 
*/
@Service
public class ${modelName}ServiceImpl  extends BaseServiceImpl<${modelName}Dao,${modelName}> implements I${modelName}Service{
	
	//此处编写业务逻辑的方法
}
    