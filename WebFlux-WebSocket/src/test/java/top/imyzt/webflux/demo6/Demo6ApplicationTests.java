package top.imyzt.webflux.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.time.Duration;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Demo6ApplicationTests {

	@Test
	public void contextLoads() {
		ReactorNettyWebSocketClient client = new ReactorNettyWebSocketClient();
		client.execute(URI.create("ws://localhost:8081/echo"), webSocketSession ->
			webSocketSession.send(Flux.just(webSocketSession.textMessage("hello")))
			.thenMany(webSocketSession.receive().take(1).map(WebSocketMessage::getPayloadAsText))
			.doOnNext(System.out::println)
					.then())
                .block(Duration.ofMillis(5000));
	}

    public static void main(String[] args) {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://localhost:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("你好")))
                        .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(5000));
    }

}
