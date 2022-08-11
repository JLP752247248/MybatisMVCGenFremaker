<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${dao_package_name}.${table_name}DAO">
  <resultMap id="BaseResultMap" type="${entity_package_name}.${table_name}">
    <id column="${primaryKey}" jdbcType="INTEGER" property="${primaryKey?uncap_first}" />
        <#list model_column as model>
        	<result column="${model.columnName}" jdbcType="${model.columnType}" property="${model.changeColumnName?uncap_first}" />
        </#list>
  </resultMap>
  <sql id="Base_Column_List">
    <#if model_column?exists>
        <#list model_column as model>
        	<#if model_has_next!=true>
				${model.columnName}
			<#else>
				${model.columnName},
			</#if>
        </#list>
    </#if>
  </sql>
  
  <select id="selectByPrimaryKey" parameterType="java.lang.Integer" resultMap="BaseResultMap">
    SELECT 
    	<include refid="Base_Column_List" />
    FROM ${table_name_small}
    WHERE ${primaryKey} = ${r'#'}{${primaryKey?uncap_first},jdbcType=INTEGER}
  </select>
  
  <select id="selectByPrimarys" parameterType="${entityPackage}.${table_name}" resultMap="BaseResultMap">
  	SELECT
  		<#if model_column?exists>
        <#list model_column as model>
        	<#if model_has_next!=true>
        		<if test="${model.columnName} != null">
				${model.columnName},
      			</if>
			<#else>
				<if test="${model.columnName} != null">
				${model.columnName}
      			</if>
			</#if>
        </#list>
    </#if>
  	FROM ${table_name_small}
  	<where>
  		<#if model_column?exists>
        <#list model_column as model>
        	<#if model_index!=0>
	        	<if test="${model.changeColumnName?uncap_first} !=null">
					AND	${model.columnName} = ${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}}
				</if>
				<#else>
	        	<if test="${model.changeColumnName?uncap_first} !=null">
					AND	${model.columnName} = ${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}}
				</if>
			</#if>
        </#list>
    </#if>
  	</where>
  </select>
  
  <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer">
    DELETE FROM ${table_name_small}
    WHERE ${primaryKey} = ${r'#'}{${primaryKey?uncap_first},jdbcType=INTEGER}
  </delete>
  
  <insert id="insert" parameterType="${entityPackage}.${table_name}">
    INSERT INTO ${table_name_small} (
    	<include refid="Base_Column_List" />
      )
    values (
    <#if model_column?exists>
        <#list model_column as model>
        	<#if model_has_next!=true>
				${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}} 
			<#else>
				${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}}, 
			</#if>
        </#list>
    </#if>
      )
  </insert>
  
  <insert id="insertSelective" parameterType="${entityPackage}.${table_name}">
    INSERT INTO ${table_name_small}
    <trim prefix="(" suffix=")" suffixOverrides=",">
    <#if model_column?exists>
        <#list model_column as model>
    		<if test="${model.changeColumnName?uncap_first} != null">
				${model.columnName},
      		</if>
        </#list>
    </#if>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides=",">
    <#if model_column?exists>
        <#list model_column as model>
    		<if test="${model.changeColumnName?uncap_first} != null">
        		${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}},
      		</if>
        </#list>
    </#if>
    </trim>
  </insert>
  
  <update id="updateByPrimaryKeySelective" parameterType="${entityPackage}.${table_name}">
    UPDATE ${table_name_small}
    <set>
	    <#if model_column?exists>
	        <#list model_column as model>
	    		<if test="${model.changeColumnName?uncap_first} != null">
	        		${model.columnName} = ${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}},
      			</if>
	        </#list>
	    </#if>
    </set>
    WHERE ${primaryKey} = ${r'#'}{${primaryKey?uncap_first},jdbcType=INTEGER}
  </update>
  <update id="updateByPrimaryKey" parameterType="${entityPackage}.${table_name}">
    UPDATE ${table_name_small}
    SET 
      <#if model_column?exists>
	        <#list model_column as model>
	        	<#if model_has_next!=true>
						${model.columnName} = ${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}}
				<#else>
	        			${model.columnName} = ${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}},
				</#if>
	        </#list>
	    </#if>
    WHERE ${primaryKey} = ${r'#'}{${primaryKey?uncap_first},jdbcType=INTEGER}
  </update>
  
  <select id="countTotal" parameterType="${entityPackage}.${table_name}" >
  	SELECT 
  		COUNT(*) 
  	FROM ${table_name_small} 
  	<where>
  		<#if model_column?exists>
	        <#list model_column as model>
	        	<#if model_index!=0>
	     <if test="${model.changeColumnName?uncap_first} !=null">
		     AND ${model.columnName} = ${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}}
		 </if>
				<#else>
	     <if test="${model.changeColumnName?uncap_first} !=null">
			 AND ${model.columnName} = ${r'#'}{${model.changeColumnName?uncap_first},jdbcType=${model.columnType}}
		 </if>
				</#if>
	        </#list>
	    </#if>
  	</where>
  </select>
</mapper>