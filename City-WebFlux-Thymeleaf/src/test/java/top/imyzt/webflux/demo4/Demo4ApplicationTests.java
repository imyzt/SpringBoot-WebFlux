package top.imyzt.webflux.demo4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import top.imyzt.webflux.demo4.domain.City;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebFluxTest
public class Demo4ApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	private static HashMap<String, City> hashMap = new HashMap <>();

	@BeforeClass
	public static void setup() {
		City city = new City();
		city.setId(1L);
		city.setCityName("长沙");
		city.setProvinceId(43L);
		city.setDescription("湖南省会");
		hashMap.put("cs", city);
	}

	@Test
	public void contextLoads() {
		City city = webTestClient.post().uri("/city")
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(hashMap.get("cs")))
				.exchange()
				.expectStatus().isOk()
				.expectBody(City.class).returnResult().getResponseBody();

		Assert.assertNotNull(city);
		Assert.assertEquals(city.getId(), hashMap.get("cs").getId());
		Assert.assertEquals(city.getCityName(), hashMap.get("cs").getCityName());
	}

}
