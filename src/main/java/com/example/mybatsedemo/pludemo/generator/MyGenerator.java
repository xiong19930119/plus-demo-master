package com.example.mybatsedemo.pludemo.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

public class MyGenerator {

    /**
     * 作者名称
     */
    private static final String AUTHOR = "xpw";

    /**
     * mysql连接地址
     */
    private static final String URL = "jdbc:mysql://47.106.128.36:3306/guotu?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";

    /**
     * 驱动名称
     */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 连接数据库的用户名
     */
    private static final String USER_NAME = "root";

    /**
     * 连接数据库的密码
     */
    private static final String PASSWORD = "xiong123456";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setActiveRecord(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setBaseColumnList(true);
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setEntity("model").setMapper("dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
                Map<String, Object> map = new HashMap<>();
                map.put("packageController", "com.example.mybatsedemo.pludemo." + pc.getModuleName() + ".controller");
                map.put("packageEntity", "com.example.mybatsedemo.pludemo." + pc.getModuleName() + ".model");
                map.put("packageService", "com.example.mybatsedemo.pludemo." + pc.getModuleName() + ".service");
                map.put("packageMapper", "com.example.mybatsedemo.pludemo." + pc.getModuleName() + ".dao");
                map.put("packageServiceImpl", "com.example.mybatsedemo.pludemo." + pc.getModuleName() + ".service.impl");
                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        String mapperXmlTemplatePath = "/templates/generator/mapper.xml.ftl";
        String controllerTemplatePath = "/templates/generator/controller.java.ftl";
        String modelTemplatePath = "/templates/generator/entity.java.ftl";
        String serviceTemplatePath = "/templates/generator/service.java.ftl";
        String serviceImplTemplatePath = "/templates/generator/serviceImpl.java.ftl";
        String mapperJavaTemplatePath = "/templates/generator/mapper.java.ftl";

        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperXmlTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        focList.add(new FileOutConfig(controllerTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/example/mybatsedemo/pludemo/" + pc.getModuleName() + "/controller/" + tableInfo.getEntityName() + "Controller.java";
            }
        });

        focList.add(new FileOutConfig(modelTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/example/mybatsedemo/pludemo/" + pc.getModuleName() + "/model/" + tableInfo.getEntityName() + ".java";
            }
        });

        focList.add(new FileOutConfig(serviceTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/example/mybatsedemo/pludemo/" + pc.getModuleName() + "/service/" + tableInfo.getEntityName() + "Service.java";
            }
        });

        focList.add(new FileOutConfig(serviceImplTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/example/mybatsedemo/pludemo/" + pc.getModuleName()
                        + "/service/impl/" + tableInfo.getEntityName() + "ServiceImpl.java";
            }
        });

        focList.add(new FileOutConfig(mapperJavaTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/example/mybatsedemo/pludemo/" + pc.getModuleName()
                        + "/dao/" + tableInfo.getEntityName() + "Mapper.java";
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml("/templates/generator/mapper.xml");
        templateConfig.setController("/templates/generator/controller.java");
        templateConfig.setEntity("/templates/generator/entity.java");
        templateConfig.setService("/templates/generator/service.java");
        templateConfig.setServiceImpl("/templates/generator/serviceImpl.java");
        templateConfig.setMapper("/templates/generator/mapper.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.example.mybatsedemo.pludemo.base.BaseModel");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.example.mybatsedemo.pludemo.base.BaseController");
        strategy.setInclude(scanner("表名"));
        strategy.setEntityBuilderModel(true);
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(false);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
