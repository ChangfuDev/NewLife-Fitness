package com.newlife.fitness.rearend.web.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;



/**
 * @ClassName: WebSocketConfig  
 * @Description: WebSocket注册器
 * @author Unruly  
 * @date 2019年1月8日
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	
	/**
	 * 注册websocket处理器；
	 */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	 registry.addHandler(myHandler(), "/getSystem").addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*");
    	 registry.addHandler(getInfo(), "/getInfo").addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*");
    }


    @Bean 
    public WebSocketHandler myHandler() {
        return new SendInfoHandler();
    }
    
    @Bean 
    public SystemInfoHandler getInfo() {
        return new SystemInfoHandler();
    }
    
}