
package ${packageName};

import lombok.Data;
import ${packageName}.entity.${modelName};
import javax.validation.constraints.NotNull;

/**
 * @Author: JLP
 * @CreateTime: 2022-08-10  13:50
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class ${modelName}Vo  {

    <#if columnList?exists>
        <#list columnList as model>
    /**${model.comment}*/
    @NotNull
    private ${model.type!} ${model.name!};
        </#list>
    </#if>

    public ${modelName} build${modelName}(){
        ${modelName} temp${modelName} =new ${modelName}();
        <#if columnList?exists>
            <#list columnList as model>
            /**${model.comment}*/
           temp${modelName}.set${model.name!}(${model.name!});
           </#list>
        </#if>
    }
}


