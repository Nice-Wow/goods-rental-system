package com.cb.module.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    /**
     * 跨域过滤器
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // Access-Control-Allow-Origin
        // 该字段必填。它的值要么是请求时Origin字段的具体值，要么是一个*，表示接受任意域名的请求。
        // 注意: CORS请求发送Cookie时，Access-Control-Allow-Origin只能是与请求网页一致的域名。
        // 同时，Cookie依然遵循同源政策，只有用服务器域名设置的Cookie才会上传，其他域名的Cookie并不会上传，
        // 且（跨源）原网页代码中的document.cookie也无法读取服务器域名下的Cookie。
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        // Access-Control-Allow-Methods
        // 该字段必填。它的值是逗号分隔的一个具体的字符串或者*，表明服务器支持的所有跨域请求的方法。
        // 注意，返回的是所有支持的方法，而不单是浏览器请求的那个方法。这是为了避免多次"预检"请求。
        corsConfiguration.addAllowedMethod("*");
        // Access-Control-Expose-Headers
        // 该字段可选。CORS请求时，XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：
        // Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。
        // 如果想拿到其他字段，就必须在Access-Control-Expose-Headers里面指定。
        // corsConfiguration.addExposedHeader("zidingyi");
        // 预检请求的有效期，单位为秒。
        // Access-Control-Max-Age
        // 该字段可选，用来指定本次预检请求的有效期，单位为秒。在有效期间，不用发出另一条预检请求。
        corsConfiguration.setMaxAge(3600L);
        // 是否支持安全证书
        // Access-Control-Allow-Credentials
        // 该字段可选。它的值是一个布尔值，表示是否允许发送Cookie.默认情况下，不发生Cookie，即：false。
        // 对服务器有特殊要求的请求，比如请求方法是PUT或DELETE，或者Content-Type字段的类型是application/json，这个值只能设为true。
        // 如果服务器不要浏览器发送Cookie，删除该字段即可。
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

}
