package top.imyzt.webflux.demo01.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import top.imyzt.webflux.demo01.handler.CityHandler;

/**
 * @author imyzt
 * @date 2019/2/16 16:38
 * @description 城市数据处理路由
 */
@Configuration
public class CityRouter {

    /**
     * RouterFunctions 对请求路由处理类
     * 即将请求路由到处理器，这里将一个 GET 请求 /hello 路由到处理器 cityHandler 的 helloCity 方法上。
     * @param cityHandler 城市数据处理程序
     */
    @Bean
    public RouterFunction<ServerResponse> helloCity(CityHandler cityHandler) {
        return RouterFunctions.route(
                RequestPredicates
                        .GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN))
                ,cityHandler::helloCity
        );
    }

}
