package cn.stylefeng.guns.gen.core.engine;

import cn.stylefeng.guns.gen.core.util.TemplateUtil;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.IOException;
import java.util.Properties;

/**
 * beetl模板引擎的实例
 *
 * @author fengshuonan
 * @date 2018-12-13-9:02 AM
 */
public class BeetlEngine {

    private static BeetlEngine beetlEngine = new BeetlEngine();

    private static GroupTemplate groupTemplate;

    private BeetlEngine() {
        Properties properties = new Properties();
        properties.put("RESOURCE.root", "");
        properties.put("DELIMITER_STATEMENT_START", "<%");
        properties.put("DELIMITER_STATEMENT_END", "%>");
        properties.put("HTML_TAG_FLAG", "##");
        org.beetl.core.Configuration cfg = null;

        try {
            //配置lei 需要 以上是配置一些配置lei  需要的参数，实际jar包已经配置好了这里重置一下
            cfg = new org.beetl.core.Configuration(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //这里使用的是beetl jar包所以使用ClasspathResourceLoader类加载
        //此处使用的是空构造，表示搜索路径是从根路径开始的，且字符集默认UTF-8
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        //beetl的核心GroupTemplate，是一个重量级对象，创建它需要两个参数一个
        //一个是resourceLoader模板资源加载器，和配置lei
        groupTemplate = new GroupTemplate(resourceLoader, cfg);
        groupTemplate.registerFunctionPackage("tool", new TemplateUtil());
    }

    public static GroupTemplate getInstance() {
        return groupTemplate;
    }

}
