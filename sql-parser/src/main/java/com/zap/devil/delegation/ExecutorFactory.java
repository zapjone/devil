package com.zap.devil.delegation;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class ExecutorFactory implements ComponentFactory {

    public static final String EXECUTOR_NAME = "executor";

    public Executor create() {
        return new DevilExecutor();
    }

    @Override
    public String name() {
        return EXECUTOR_NAME;
    }
}
