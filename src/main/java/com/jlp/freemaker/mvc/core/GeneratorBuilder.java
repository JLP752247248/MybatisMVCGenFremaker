package com.jlp.freemaker.mvc.core;


import com.jlp.freemaker.mvc.entity.*;
import com.jlp.freemaker.mvc.support.GenerateFactory;
import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;
import com.jlp.freemaker.mvc.utils.generate.GenerateDao;
import com.jlp.freemaker.mvc.utils.generate.GenerateIService;
import com.jlp.freemaker.mvc.utils.generate.GenerateMapper;
import com.jlp.freemaker.mvc.utils.generate.GenerateModel;
import com.jlp.freemaker.mvc.utils.generate.GenerateServiceImpl;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 生成的主类
 * @date 2018年7月1日 上午1:12:21
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class GeneratorBuilder {

	private Dao dao ;
	
	private IService iService;
	
	private Mapper mapper;
	
	private ServiceImpl serviceImpl;
	
	private Model model;

	private Vo vo;
	
	private String tableComment;

	/**
	 * 
	 * @param packageName 要生成的包路径，如:aixuegao.admin
	 * @param clazzName 要生成的model类名
	 * @param table 数据库表名称。如：tbl_user
	 * @param tableComment 生成的数据库的业务注释(会生成到类的注释里面)
	 */
	public GeneratorBuilder(String packageName,String clazzName,Table table,String tableComment) {
		this.tableComment = tableComment;
		
		model = new Model(clazzName,null,table.getColumnList());
		model.setPackageName(GenerateConfiguration.PKG_PREFIX+packageName+GenerateConfiguration.PKG_SUFFIX_MODEL);
		model.setTableComment(tableComment);
		model.setTableName(table.getTable());
		
		dao = new Dao();
		dao.setModelName(clazzName);
		dao.setPackageName(GenerateConfiguration.PKG_PREFIX+packageName);
		
		iService = new IService();
		iService.setModelName(clazzName);
		iService.setPackageName(GenerateConfiguration.PKG_PREFIX+packageName);
		
		serviceImpl = new ServiceImpl();
		serviceImpl.setModelName(clazzName);
		serviceImpl.setPackageName(GenerateConfiguration.PKG_PREFIX+packageName);
		
		mapper = new Mapper();
		mapper.setColumnList(table.getColumnList());
		mapper.setModelName(clazzName);
		mapper.setPackageName(GenerateConfiguration.PKG_PREFIX+packageName);

		vo = new Vo();
		vo.setColumnList(table.getColumnList());
		vo.setModelName(clazzName);
		vo.setPackageName(GenerateConfiguration.PKG_PREFIX+packageName);
	}
	
	/**
	 * 生成文件
	 */
	public void builder(Condition condition) {
		try {
			if(condition.getModel()) {
				GenerateFactory.createModel().generateFile(model);
			}
			if(condition.getDao()) {
				GenerateFactory.createDao().generateFile(dao);
			}
			if(condition.getiService()) {
				GenerateFactory.createIService().generateFile(iService);
			}
			if(condition.getServiceImpl()) {
				GenerateFactory.createServiceImpl().generateFile(serviceImpl);
			}
			if(condition.getMapper()) {
				GenerateFactory.createMapper().generateFile(mapper);
			}
			if(condition.getVo()) {
				GenerateFactory.createVo().generateFile(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author 啃过雪糕的兔子
	 * @to 控制生成的文件，个性化生成，如只生成dao.java文件。自由组合生成
	 * @date 2018年7月5日 下午11:03:46
	 * @see:<p>www.aixuegao.cn</p>
	 * @since 1.0.1
	 */
	static class Condition{
		
		private Boolean mapper=false;
		
		private Boolean model=false;
		
		private Boolean dao=false;
		
		private Boolean iService=false;
		
		private Boolean serviceImpl=false;
		
		private Boolean controller=false;
		
		private Boolean dto=false;

		private Boolean vo=false;

		public Condition() {
			super();
		}

		public Boolean getMapper() {
			return mapper;
		}

		public Condition setMapper(Boolean mapper) {
			this.mapper = mapper;
			return this;
		}

		public Boolean getModel() {
			return model;
		}

		public Boolean getVo() {
			return vo;
		}

		public Condition setModel(Boolean model) {
			this.model = model;
			return this;
		}

		public Boolean getDao() {
			return dao;
		}

		public Condition setDao(Boolean dao) {
			this.dao = dao;
			return this;
		}

		public Condition setVo(Boolean vo) {
			this.vo = vo;
			return this;
		}

		public Boolean getiService() {
			return iService;
		}

		public Condition setiService(Boolean iService) {
			this.iService = iService;
			return this;
		}

		public Boolean getServiceImpl() {
			return serviceImpl;
		}

		public Condition setServiceImpl(Boolean serviceImpl) {
			this.serviceImpl = serviceImpl;
			return this;
		}

		public Boolean getController() {
			return controller;
		}

		public Condition setController(Boolean controller) {
			this.controller = controller;
			return this;
		}

		public Boolean getDto() {
			return dto;
		}

		public Condition setDto(Boolean dto) {
			this.dto = dto;
			return this;
		}
	}
	
	/**
	 * 获取要生成的条件对象，设置要生成的文件。要生成的设置为true，不生成的文件设置为false
	 * @return Condition 生成条件
	 */
	public static Condition getCondition() {
		return new Condition();
	}
	
	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	
}
