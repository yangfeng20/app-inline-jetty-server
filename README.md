# 应用内嵌jetty服务器脚手架

### 主类
    JettyJspSupportBootstrap


### jsp支持
        // 必须
        webAppContext.addBean(new JspStarter(webAppContext));
        // 非必须
        webAppContext.addServlet(JettyJspServlet.class, "*.jsp");


### jsp jstl表达式支持
    将【javax.servlet:jstl】jar包中META-INF的c.tld添加到WEB-INF中
    【！！！】WEB-INF中必须有c.tld等约束文件
    jsp文件中添加[<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>] 【这个无所谓】

