package com.zap.devil.delegation;

import com.zap.devil.api.Transformation;

import java.util.List;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class DevilExecutor implements Executor{
    @Override
    public Pipeline createPipeline(List<Transformation<?>> transformations, String jobName) {
        return null;
    }

    @Override
    public Object execute() {
        return null;
    }
}
