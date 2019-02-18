package top.imyzt.webflux.demo6.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author imyzt
 * @date 2019/2/18 14:30
 * @description EchoHandler
 */
@Component
public class EchoHandler implements WebSocketHandler  {


    @Override
    public Mono<Void> handle(WebSocketSession session) {
        // 发送消息。消息为“服务端返回：小明， -> ”开头的。
        return session.send(
                session.receive()
                        .map(msg -> session.textMessage("ECHO -> " + msg.getPayloadAsText())));
    }

    @Override
    public List<String> getSubProtocols() {
        return null;
    }
}
