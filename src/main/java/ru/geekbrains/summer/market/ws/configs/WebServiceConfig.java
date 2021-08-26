package ru.geekbrains.summer.market.ws.configs;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet msServlet = new MessageDispatcherServlet();
        msServlet.setApplicationContext(applicationContext);
        msServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(msServlet, "/ws/*");
    }

    //localhost:8080/ws/products.wsdl
    @Bean(name = "products")
    public DefaultWsdl11Definition productsWsdl11Definition(XsdSchema productsXsdSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.myhome.ru/geekbrains/summer/market/ws/products");
        wsdl11Definition.setSchema(productsXsdSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema productsXsdSchema(){
        return new SimpleXsdSchema(new ClassPathResource("products.xsd"));
    }

}
