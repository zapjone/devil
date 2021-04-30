package com.zap.devil.runtime;

import com.zap.devil.runtime.internal.EnvironmentImpl;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class EnvironmentTest {

    public static void main(String[] args) {
        EnvironmentSettings settings = new EnvironmentSettings(
                "memory", "default");
        EnvironmentImpl env = EnvironmentImpl.create(settings);
        env.executeSql("show databases");

        env.executeSql("select name,age from persons");
    }

}
