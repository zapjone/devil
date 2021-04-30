package com.zap.devil.opertions;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class ShowDatabasesOperation implements ShowOperation{

    @Override
    public String asSummaryString() {
        return "SHOW DATABASES";
    }

}
