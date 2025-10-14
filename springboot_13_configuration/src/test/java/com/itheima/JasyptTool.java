//package com.itheima;
//
//import org.jasypt.encryption.StringEncryptor;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.eshore.cmppub.springcloud.common.constants.Environments;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {SpringBootTest.class})
//@WebAppConfiguration
//public class JasyptTool {
//    @Autowired
//    StringEncryptor encryptor;
//
//    static {
//        System.setProperty("jasypt.encryptor.password", "cmp@20200701");//asypt加密的密匙
//        System.setProperty("jasypt.encryptor.algorithm", "PBEWithMD5AndDES");//加密算法
//    }
//
//    @Test
//    public void tPass() {
//        String message = "jdbc:mysql://172.20.253.180:8907/cmp_tywl_ord?useUnicode=true&characterEncoding=UTF-8";//明文
//        String encryptedMessage = encryptor.encrypt(message);
//        System.out.println("密文：\n" + Environments.NAMESPACE.toUpperCase() + "_ENC@" + encryptedMessage);
//        //jdbc:mysql://172.25.44.106:8907/cmp_tywl_corp?useUnicode=true&characterEncoding=UTF-8&useSSL=false
//        //jdbc:mysql://172.25.44.106:8907/cmp_corp?useUnicode=true&characterEncoding=UTF-8&useSSL=false
//
////        String secret = encryptor.decrypt("xebAEx/0G9Kl89wd3ivxowAKIHUZazDhu0hc2oi9YZ0243JSnysBPsWnVvrl1W9yEeuptfq6lmMX9AVPtov8aMy4wha/zcyVJHta+TFkcivr9f7ZxO5TWVrzWqgQPank");
////        System.out.println("明文：\n" + secret);
//    }
//}
