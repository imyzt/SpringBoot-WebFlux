package top.imyzt.webflux.demo01.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author imyzt
 * @date 2019/2/16 16:36
 * @description 城市数据处理器
 */
@Component
public class CityHandler {

    /**
     * 请求具体处理类
     */
    public Mono<ServerResponse> helloCity(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, City!"));
    }

}
