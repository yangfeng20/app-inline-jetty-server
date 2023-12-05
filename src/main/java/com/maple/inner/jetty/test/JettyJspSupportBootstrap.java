package com.maple.inner.jetty.test;

import org.apache.tomcat.util.scan.StandardJarScanner;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.jsp.JettyJspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author yangfeng
 * @date : 2023/12/5 8:51
 * desc:
 */

public class JettyJspSupportBootstrap {
    public static void main(String[] args) {
        Server server = new Server(8080);
        WebAppContext webAppContext = new WebAppContext();
        // 使用web.xml【可以没有】
        webAppContext.setDescriptor("./src/main/webapp/WEB-INF/web.xml");
        // 资源访问根目录，也是当前应用的根目录【必须有】
        webAppContext.setResourceBase("./src/main/webapp");
        // 上下文路径【可以没有】
        webAppContext.setContextPath("/");
        webAppContext.setDisplayName("app-inline-jetty-server");
        webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        webAppContext.setConfigurationDiscovered(true);
        webAppContext.setParentLoaderPriority(true);

        // 添加jsp支持
        webAppContext.addBean(new JspStarter(webAppContext));
        webAppContext.addServlet(JettyJspServlet.class, "*.jsp");

        // 添加servlet
        webAppContext.addServlet(OneServlet.class, "/forward");

        server.setHandler(webAppContext);
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class JspStarter extends AbstractLifeCycle implements ServletContextHandler.ServletContainerInitializerCaller {

        JettyJasperInitializer sci;
        ServletContextHandler context;

        public JspStarter(ServletContextHandler context) {
            this.sci = new JettyJasperInitializer();
            this.context = context;
            this.context.setAttribute("org.apache.tomcat.JarScanner", new StandardJarScanner());
        }

        @Override
        protected void doStart() throws Exception {
            ClassLoader old = Thread.currentThread().getContextClassLoader();
            Thread.currentThread().setContextClassLoader(context.getClassLoader());
            try {
                sci.onStartup(null, context.getServletContext());
                super.doStart();
            } finally {
                Thread.currentThread().setContextClassLoader(old);
            }
        }
    }
}
