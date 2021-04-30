package org.apache.calcite.jdbc;

import org.apache.calcite.schema.Schema;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class CalciteSchemaBuilder {

    public static CalciteSchema asRootSchema(Schema root) {
        return new SimpleCalciteSchema(null, root, "");
    }

    private CalciteSchemaBuilder() {
    }

}
