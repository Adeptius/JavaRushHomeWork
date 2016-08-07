package com.javarush.test.level33.lesson15.big01.strategies;


public interface StorageStrategy {

    /**
     * должен вернуть true, если хранилище
     содержит переданный ключ.
     * @param key
     * @return
     */
    boolean containsKey(Long key);

    /**
     * должен вернуть true, если хранилище
     содержит переданное значение.
     * @param value
     * @return
     */
    boolean containsValue(String value);

    /**
     * добавить в хранилище новую пару ключ – значение.
     * @param key
     * @param value
     */
    void put(Long key, String value);

    /**
     * вернуть ключ для переданного значения.
     * @param value
     * @return
     */
    Long getKey(String value);


    /**
     * вернуть значение для переданного ключа.
     * @param key
     * @return
     */
    String getValue(Long key);

}
