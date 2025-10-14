package com.itheima.dao.aspectj;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

/**
 * @Author：zsj
 * @Date：2023/7/15
 */

@Service
public class ElasticsearchServiceImpl implements IElasticsearchService {
    private RestHighLevelClient client;
    @Override
    public void createDocument(String url, RestHighLevelClient client) {
        // 实现类中的具体业务逻辑
        System.out.println("在 Elasticsearch（URL：" + url + "）中创建文档");
        System.out.println("11111" + client);
    }

    @Override
    public void createTokenizer(String url,RestHighLevelClient client) {
        // 实现类中的具体业务逻辑
        System.out.println("在 Elasticsearch（URL：" + url + "）中创建分词器");

    }
}
