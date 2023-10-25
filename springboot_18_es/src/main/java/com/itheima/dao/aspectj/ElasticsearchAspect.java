package com.itheima.dao.aspectj;

import org.apache.http.HttpHost;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author：zsj
 * @Date：2023/7/15
 */
@Aspect
@Component
public class ElasticsearchAspect {

    private RestHighLevelClient aclient;

    @Before("execution(* com.itheima.dao.aspectj.IElasticsearchService.*(..)) && args(url,client)")
    public void beforeOperation(String url,RestHighLevelClient client){
        HttpHost host = HttpHost.create(url);
        RestClientBuilder builder = RestClient.builder(host);

        aclient = new RestHighLevelClient(builder);
        client=  aclient;
        System.out.println("我创建了连接");
        System.out.println(client);
    }

    @After("execution(* com.itheima.dao.aspectj.IElasticsearchService.*(..))")
    public void afterOperation() throws IOException {
        System.out.println("我关闭了连接");
        System.out.println(aclient);
        aclient.close();
    }

//    @Around("execution(* com.itheima.dao.aspectj.IElasticsearchService.*(..)) && args(url)")
//    public void aroundOperation(ProceedingJoinPoint joinPoint, String url) throws Throwable {
//        System.out.println("正在连接 Elasticsearch，URL：" + url);
//        // 在此执行连接操作
//        // 可以添加其他的连接前置处理逻辑
//
//        // 调用目标方法
//        joinPoint.proceed();
//
//        System.out.println("关闭 Elasticsearch 连接");
//        // 在此执行关闭连接操作
//        // 可以添加其他的连接关闭处理逻辑
//    }
}
