//package dk.via.webservice;
//
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.ws.config.annotation.EnableWs;
//import org.springframework.ws.config.annotation.WsConfigurerAdapter;
//import org.springframework.ws.transport.http.MessageDispatcherServlet;
//import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
//import org.springframework.xml.xsd.SimpleXsdSchema;
//import org.springframework.xml.xsd.XsdSchema;
//
//@EnableWs
//@Configuration
//public class WebServiceConfig extends WsConfigurerAdapter {
//    public static final String NAMESPACE_URI = "http://via.dk/web-service";
//
//    @Bean
//    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean<>(servlet, "/ws/*");
//    }
//
//    @Bean(name = "webservice")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("WebservicePort");
//        wsdl11Definition.setLocationUri("/ws");
//        wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
//        wsdl11Definition.setSchema(countriesSchema);
//        return wsdl11Definition;
//    }
//
//    @Bean
//    public XsdSchema countriesSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("schema.xsd"));
//    }
//}