package com.jlp.freemaker.mvc;

import com.jlp.freemaker.mvc.core.GeneratorBuilder;
import com.jlp.freemaker.mvc.utils.common.DbMetaDataUtils;

/**
 * @Author: JLP
 * @CreateTime: 2022-08-11  10:32
 * @Description: TODO
 * @Version: 1.0
 */
public class Main {


    public static void main(String[] args) {
        GeneratorBuilder.Condition condition = GeneratorBuilder.getCondition()
                .setDao(false)
                .setiService(false)
                .setMapper(false)
                .setModel(false)
                .setServiceImpl(false)
                .setVo(true);
        new GeneratorBuilder("", "Addr", DbMetaDataUtils.getTable("sys_addr"), "sys_addr").builder(condition);
        new GeneratorBuilder("", "Contact", DbMetaDataUtils.getTable("sys_contact"), "sys_contact").builder(condition);
        new GeneratorBuilder("", "PermInfo", DbMetaDataUtils.getTable("sys_perm"), "sys_perm").builder(condition);
        new GeneratorBuilder(".user", "RoleInfo", DbMetaDataUtils.getTable("sys_role"), "sys_role").builder(condition);

    }
}
