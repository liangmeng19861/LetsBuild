package com.letsbuild.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.JavaTypeResolverConfiguration;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Value;

/**
 * 生成代码
 * @author lilg
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application.xml"})
public class MybaitsGeneratorTest extends TestCase {
	
	@Value("${jdbc.driverClassName}")
	private String db_driver;
	@Value("${jdbc.url}")
	private String db_url;
	@Value("${jdbc.username}")
	private String db_user;
	@Value("${jdbc.password}")
	private String db_pass;

	@Test
	public void testMybaitsGenerator() {

		/**生成代码表名**/
	    String[] tableNames = {"ord_advpay"};
		//String[] tableNames = { "ord_advpay","ord_foregift","ord_order","ord_stage","sys_label","sys_menu","sys_role","sys_role_menu","sys_user","sys_user_role" };

		
		
		/********************************/
		Context context = new Context(null);
		context.setId("DB2Tables");
		/** 插件 **/
		PluginConfiguration renamePlugin = new PluginConfiguration();
		renamePlugin
				.setConfigurationType("org.mybatis.generator.plugins.RenameExampleClassPlugin");
		renamePlugin.addProperty("searchString", "Example$");
		renamePlugin.addProperty("replaceString", "Criteria");
		PluginConfiguration mysqlPlugin = new PluginConfiguration();
		mysqlPlugin
				.setConfigurationType("org.mybatis.generator.plugins.MySQLPaginationPlugin");
		context.addPluginConfiguration(renamePlugin);
		context.addPluginConfiguration(mysqlPlugin);
		/****/
		CommentGeneratorConfiguration commentGenerator = new CommentGeneratorConfiguration();
		commentGenerator.addProperty("suppressDate", "true");
		commentGenerator.addProperty("suppressAllComments", "true");
		context.setCommentGeneratorConfiguration(commentGenerator);
		/** 数据库 **/
		JDBCConnectionConfiguration connConfiguration = new JDBCConnectionConfiguration();
		connConfiguration.setDriverClass(db_driver);
		connConfiguration.setConnectionURL(db_url);
		connConfiguration.setUserId(db_user);
		connConfiguration.setPassword(db_pass);
		context.setJdbcConnectionConfiguration(connConfiguration);

		JavaTypeResolverConfiguration javaType = new JavaTypeResolverConfiguration();
		javaType.setConfigurationType("org.mybatis.generator.internal.types.JavaTypeResolver4MvneImpl");
		javaType.addProperty("forceBigDecimals", "false");
		context.setJavaTypeResolverConfiguration(javaType);

		/** 输出路径 **/
		JavaModelGeneratorConfiguration javaModel = new JavaModelGeneratorConfiguration();
		javaModel.setTargetPackage("com.letsbuild.dao.mapper.bo");
		javaModel.setTargetProject("src/main/java");
		javaModel.addProperty("enableSubPackages", "true");
		javaModel.addProperty("trimStrings", "true");
		SqlMapGeneratorConfiguration sqlMap = new SqlMapGeneratorConfiguration();
		sqlMap.setTargetPackage("mybatis.mapper.letsbuild");
		sqlMap.setTargetProject("src/main/resources");
		sqlMap.addProperty("enableSubPackages", "true");
		JavaClientGeneratorConfiguration javaClient = new JavaClientGeneratorConfiguration();
		javaClient.setTargetPackage("com.letsbuild.dao.mapper.interfaces");
		javaClient.setTargetProject("src/main/java");
		javaClient.addProperty("enableSubPackages", "true");
		javaClient.setConfigurationType("XMLMAPPER");
		context.setJavaModelGeneratorConfiguration(javaModel);
		context.setSqlMapGeneratorConfiguration(sqlMap);
		context.setJavaClientGeneratorConfiguration(javaClient);

		/** 表 **/
		for (String tableName : tableNames) {
			TableConfiguration table = new TableConfiguration(context);
			table.setTableName(tableName);
			table.setCountByExampleStatementEnabled(true);// 数量－Example
			table.setDeleteByExampleStatementEnabled(true);// 删除－Example
			table.setDeleteByPrimaryKeyStatementEnabled(true);// 删除－Key
			table.setInsertStatementEnabled(true);
			table.setSelectByExampleStatementEnabled(true);
			table.setSelectByPrimaryKeyStatementEnabled(true);
			table.setUpdateByExampleStatementEnabled(true);
			table.setUpdateByPrimaryKeyStatementEnabled(true);
			context.addTableConfiguration(table);
		}

		try {
			DefaultShellCallback shellCallback = new DefaultShellCallback(true);
			List<String> warnings = new ArrayList<String>();
			Configuration config = new Configuration();
			config.addContext(context);
			config.validate();
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					shellCallback, warnings);
			myBatisGenerator.generate(null);
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
