
package ${packageName};

import lombok.Data;
import ${packageName}.entity.${modelName};
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: JLP
 * @CreateTime: 2022-08-10  13:50
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ApiModel
public class ${modelName}Vo  {

    <#if columnList?exists>
        <#list columnList as model>
    /**${model.comment}*/
    @NotNull
    @ApiModelProperty(name="${model.name!}", notes="${model.comment}", example="")
    private ${model.type!} ${model.name!};
        </#list>
    </#if>

    public ${modelName} build${modelName}(){
        ${modelName} temp${modelName} =new ${modelName}();
        <#if columnList?exists>
            <#list columnList as model>
            /**${model.comment}*/
           temp${modelName}.set${model.name?cap_first}(${model.name!});
           </#list>
        </#if>
        return temp${modelName};
    }
}


