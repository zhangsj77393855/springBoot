package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author：zsj
 * @Date：2023/7/15
 */
@Data
@AllArgsConstructor
@Slf4j
public class PrintThread implements Runnable {
    private static final Object lock = new Object();
    private static volatile char currentChar = 'a';  // 当前打印的字符

    private char printChar;      // 要打印的字符
    private char nextChar;       // 下一个要打印的字符

    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                // 判断当前要打印的字符是否与线程对应的字符一致
                while (currentChar != printChar) {
                    try {
                        lock.wait();  // 当前字符不匹配，线程进入等待状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info(String.valueOf(printChar));
                // 切换到下一个要打印的字符
                currentChar = nextChar;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintThread('a', 'b'));
        Thread threadB = new Thread(new PrintThread('b', 'a'));

        threadA.start();
        threadB.start();
    }
}
