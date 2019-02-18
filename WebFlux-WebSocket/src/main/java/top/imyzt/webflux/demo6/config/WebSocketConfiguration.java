package top.imyzt.webflux.demo6.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import top.imyzt.webflux.demo6.handler.EchoHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author imyzt
 * @date 2019/2/18 14:33
 * @description WebSocketConfiguration
 */
@Configuration
public class WebSocketConfiguration {

    @Autowired
    private EchoHandler echoHandler;
    @Bean
    public HandlerMapping webSocketMapping() {
        final Map<String, WebSocketHandler> map = new HashMap<>(1);
        map.put("/gee", echoHandler);

        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        mapping.setUrlMap(map);
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
