package com.bozhong.insistapi.dao;


import com.bozhong.config.domain.JqPage;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/4/14 0014.
 */
public interface MongoDao {
    /**
     * @param t
     * @param <T>
     */
    <T> void insertOne(T t);

    /**
     * @param tList
     * @param tClass
     * @param <T>
     */
    <T> void insertMany(List<T> tList, Class<T> tClass);

    /**
     * @param tClass
     * @param <T>
     * @return
     */
    <T> long findCount(Class<T> tClass);

    /**
     * @param jqPage
     * @param tClass
     * @param <T>
     * @return
     */
    <T> JqPage<T> getJqPage(JqPage<T> jqPage, Class<T> tClass);
}
