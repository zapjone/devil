package com.zap.devil.delegation;

import com.zap.devil.api.Transformation;
import com.zap.devil.opertions.Operation;

import java.util.List;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public interface Planner {

    Parser getParser();

    List<Transformation<?>> translate(List<Operation> operations);

}
