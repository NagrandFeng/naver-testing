package ysf.program.problemtwwo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockDemo {

    private Map<String, Object> cacheData = new HashMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public Object getFromCache(String key) {
        readLock.lock();
        try {
            Object dest = null;

            if (cacheData != null) {
                dest = cacheData.get(key);
            }
            if (dest == null) {
                String value = "select from source data";
                dest = value;
                if (cacheData != null) {
                    readLock.unlock(); // 释放读锁
                    writeLock.lock();  // 获取写锁
                    try {
                        cacheData.put(key, value);
                        readLock.lock();    //降级
                    } finally {
                        writeLock.unlock();//写
                    }
                }
            }
            return dest;
        } finally {
            readLock.unlock();
        }
    }

}
