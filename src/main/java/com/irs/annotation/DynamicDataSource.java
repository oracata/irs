package com.irs.annotation;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {
	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();
    public static void setDataSourceKey(String dataSource){
        dataSourceKey.set(dataSource);
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public void setTargetDataSources(Map targetDataSources) {
    }

    public void setDefaultTargetDataSource(DruidDataSource defaultTargetDataSource) {
    }
}