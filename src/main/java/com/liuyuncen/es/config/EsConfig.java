package com.liuyuncen.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {
    @Value("${spring.elasticsearch.rest.mac-uris}")
    private String macHostlist;

    @Value("${spring.elasticsearch.rest.win-uris}")
    private String winHostlist;

    @Bean
    public RestHighLevelClient client() {

        String os = System.getProperty("os.name").toLowerCase();
        String[] split = null;
        if (os.startsWith("win")) {
            split = winHostlist.split(",");
        } else {
            split = macHostlist.split(",");
        }

        //创建HttpHost数组，其中存放es主机和端口的配置信息
        HttpHost[] httpHostArray = new HttpHost[split.length];
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            System.out.println("ES节点：" + item);
            httpHostArray[i] = new HttpHost(item.split(":")[0], Integer.parseInt(item.split(":")[1]), "http");
        }
        //创建RestHighLevelClient客户端
        return new RestHighLevelClient(RestClient.builder(httpHostArray));
    }
}