package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Владелец on 12.08.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable{

    transient private final  static Object PRESENT = new Object();
    transient private HashMap<E,Object> map;

    @Override
    public Object clone() throws InternalError {
        Set<E> set = new AmigoSet<E>();
        HashMap<E,Object> mapHelp = (HashMap<E, Object>) this.map.clone();
        for (Map.Entry<E, Object> it: mapHelp.entrySet()) {
            set.add(it.getKey());
        }
        return set;
    }

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>((int) Math.max(16, collection.size()/.75f));
        HashMap<E,Object> mapHelp = new HashMap<>();
        Iterator<? extends E> iter = collection.iterator();
        while (iter.hasNext()){
            mapHelp.put(iter.next(), PRESENT);
        }
        this.map.putAll(mapHelp);
    }

    @Override
    public boolean add(E e) {
        int k= map.size();
        map.put((E) e,PRESENT);
        if (map.size()==(k+1))
            return true;
        else
            return false;
    }

    @Override
    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean remove(Object o) {
        int k= map.size();
        map.remove(o);
        if (map.size()==k-1)
            return true;
        else
            return false;
    }

    private void writeObject (ObjectOutputStream out) throws IOException {
//        out.writeObject(this.clone());
//        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
//        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));

        Set<E> set = new HashSet<>();

        for (Map.Entry<E, Object> it: map.entrySet()) {
            set.add(it.getKey());
        }

        out.writeObject(set);
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException {
//        HashMap<E,Object> set = (Collection<? extends E>) in.readObject();
//        int capacity = (Integer) in.readObject();
//        float loadFactor = (Float) in.readObject();
//
//        this.map = new HashMap<>(capacity,  loadFactor);
//        this.map.putAll(set);
        Object set = in.readObject();
        Object capacity = in.readObject();
        Object loadFactor = in.readObject();

        this.map = new HashMap<>((Integer) capacity, (Float) loadFactor);

        HashMap<E,Object> mapHelp = new HashMap<>();
        Iterator<E> iter = new HashSet<>((Collection<? extends E>) set).iterator();
        while (iter.hasNext()){
            mapHelp.put(iter.next(), PRESENT);
        }
        this.map.putAll(mapHelp);
    }
}
