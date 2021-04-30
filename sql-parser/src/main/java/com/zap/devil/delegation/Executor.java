package com.zap.devil.delegation;

import com.zap.devil.api.Transformation;

import java.util.List;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public interface Executor {

    Pipeline createPipeline(List<Transformation<?>> transformations, String jobName);

    Object execute();

}
