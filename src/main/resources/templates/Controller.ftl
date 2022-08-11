package ${controller_package_name};
import ${service_package_name}.${table_name}Service;
import ${entity_package_name}.${table_name};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import xtq.json.common.output.Response;
import xtq.json.common.output.ResponseData;
import xtq.json.common.output.ResultMsg;
import xtq.config.basemvc.controller.BaseController;
import io.swagger.annotations.Api;

/**
* 描述：${table_annotation}控制层
* @author ${author}
* @date ${date}
*/
@Controller
@RequestMapping(value = "/${table_name?uncap_first}")
@Api(tags="${table_annotation}接口")
public class ${table_name}Controller extends BaseController{

    @Autowired
    private ${table_name}Service ${table_name?uncap_first}Service;

    /**
    * 描述：根据Id 查询
    * @param id  ${table_annotation}id
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData findById(@PathVariable("id") Integer id)throws Exception {
        ${table_name} ${table_name?uncap_first} = ${table_name?uncap_first}Service.selectById(id);
        return resultData(ResultMsg.SUCCESS, ${table_name?uncap_first});
    }

    /**
    * 描述:创建${table_annotation}
    * @param ${table_name?uncap_first}  ${table_annotation}
    */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Response create(@RequestBody ${table_name} ${table_name?uncap_first}) throws Exception {
    	${table_name?uncap_first}Service.insert(${table_name?uncap_first});
        return resultMsg(ResultMsg.SUCCESS);
    }

    /**
    * 描述：删除${table_annotation}
    * @param id ${table_annotation}id
    */
    @RequestMapping(value = "/{id}/bulk", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Response deleteById(@PathVariable("id") Integer id) throws Exception {
        ${table_name?uncap_first}Service.deleteById(id);
        return resultMsg(ResultMsg.SUCCESS);
    }

    /**
    * 描述：更新${table_annotation}
    * @param id ${table_annotation}id
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Response update${table_name}(@PathVariable("id") Integer id,@RequestBody ${table_name} ${table_name?uncap_first}) throws Exception {
        ${table_name?uncap_first}.set${primaryKey}(id);
        ${table_name?uncap_first}Service.updateById(${table_name?uncap_first});
        return resultMsg(ResultMsg.SUCCESS);
    }

}