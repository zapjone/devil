package com.zap.devil.delegation;

import com.zap.devil.catalog.CatalogManager;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class PlannerFactory implements ComponentFactory {

    public static final String PLANNER_NAME = "planner";

    public Planner create(Executor executor, CatalogManager catalogManager) {
        return new DevilPlanner(executor, catalogManager);
    }

    @Override
    public String name() {
        return PLANNER_NAME;
    }
}
