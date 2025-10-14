package com.itheima.dao.aspectj;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author：zsj
 * @Date：2023/7/15
 */
public interface IElasticsearchService {
    void createDocument(String url, RestHighLevelClient client);
    void createTokenizer(String url,RestHighLevelClient client);
}
