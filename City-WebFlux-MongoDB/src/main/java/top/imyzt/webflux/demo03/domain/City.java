package top.imyzt.webflux.demo03.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author imyzt
 * @date 2019/2/16 16:57
 * @description City
 */
@Data
public class City {
    /**
     * 城市编号
     */
    @Id
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}
