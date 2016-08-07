package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V v = cache.get(key);
        if (v==null){
            v = clazz.getDeclaredConstructor(key.getClass()).newInstance(key);
            cache.put(key, v);
        }
        return v;
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method getKeyMethod = obj.getClass().getMethod("getKey");
            getKeyMethod.setAccessible(true);
            K key = (K)getKeyMethod.invoke(obj);
            return cache.put(key, obj) != null;
        }
        catch (Exception e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
