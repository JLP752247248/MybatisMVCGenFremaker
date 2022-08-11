
package ${packageName};

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.sql.*;

/**
* 描述： ${tableComment} 实体类
* @author 
* @date 
*/

@TableName("${tableName}")
public class ${modelName}  {

    <#if columnList?exists>
        <#list columnList as model>
    /**${model.comment}*/
    private ${model.type!} ${model.name!};
        </#list>
    </#if>

<#if columnList?exists>
	<#list columnList as model>
    public ${model.type!} get${model.nameUp!}() {
        return this.${model.name!};
    }
	<#if model.type! ="String">
    public void set${model.nameUp!}(${model.type!} ${model.name!}) {
        this.${model.name!} = ${model.name!}==null?null:${model.name!}.trim();
    }
    <#else>
     public void set${model.nameUp!}(${model.type!} ${model.name!}) {
        this.${model.name!} = ${model.name!};
    }
    </#if>
	</#list>
</#if>
}