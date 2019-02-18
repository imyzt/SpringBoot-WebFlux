package top.imyzt.webflux.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.imyzt.webflux.demo4.domain.City;
import top.imyzt.webflux.demo4.handler.CityHandler;

/**
 * @author imyzt
 * @date 2019/2/18 10:22
 * @description ThymeleafWebFluxController
 */
@Controller
@RequestMapping("/page")
public class ThymeleafWebFluxController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping("hello")
    public Mono<String> hello(Model model) {
        model.addAttribute("author", "imyzt");
        model.addAttribute("city", "广东深圳");
        return Mono.create(stringMonoSink -> stringMonoSink.success("hello"));
    }

    @GetMapping("list")
    public Mono<String> list(Model model) {
        Flux <City> allCity = cityHandler.findAllCity();
        model.addAttribute("allCity", allCity);
        return Mono.create(stringMonoSink -> stringMonoSink.success("list"));
    }

}
