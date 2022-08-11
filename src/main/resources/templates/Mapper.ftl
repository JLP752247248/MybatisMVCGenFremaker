<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dao.${modelName}Dao">
  <resultMap id="BaseResultMap" type="${packageName}.model.${modelName}">
        <#list columnList as model>
        <#if model.isPrimaryKey?string("true","false")! ="true">
        	<id column="${model.originalName!}" jdbcType="${model.type!}" property="${model.name!}" />
        <#else>
        	<result column="${model.originalName!}" jdbcType="${model.type!}" property="${model.name!}" />
        </#if>
        </#list>
  </resultMap>
  <sql id="Base_Column_List">
    <#if columnList?exists>
        <#list columnList as model>
        	<#if model_has_next!=true>
				${model.originalName!} AS ${model.name!}
			<#else>
				${model.originalName!} AS ${model.name!},
			</#if>
        </#list>
    </#if>
  </sql>
</mapper>