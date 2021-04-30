package com.zap.devil.catalog;

import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 将Catalog和Devil的catalog相结合起来，Catalite的自定义schema
 *
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class CatalogManagerCalciteSchema extends AbstractSchema {

    private final CatalogManager catalogManager;

    public CatalogManagerCalciteSchema(CatalogManager catalogManager) {
        this.catalogManager = catalogManager;
    }

    @Override
    protected Map<String, Table> getTableMap() {
        Set<String> listTables = this.catalogManager.listTables();
        return listTables.stream()
                .collect(Collectors.toMap(tblName -> tblName, this::getTable));
    }
}
