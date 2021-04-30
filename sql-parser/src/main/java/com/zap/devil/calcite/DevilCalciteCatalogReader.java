package com.zap.devil.calcite;

import org.apache.calcite.config.CalciteConnectionConfig;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.prepare.Prepare;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.sql.validate.SqlNameMatchers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class DevilCalciteCatalogReader extends CalciteCatalogReader {

    public DevilCalciteCatalogReader(
            CalciteSchema rootSchema,
            List<List<String>> defaultSchemas,
            RelDataTypeFactory typeFactory,
            CalciteConnectionConfig config) {

        super(
                rootSchema,
                new DevilSqlNameMatcher(
                        SqlNameMatchers.withCaseSensitive(config != null && config.caseSensitive()),
                        typeFactory),
                Stream.concat(defaultSchemas.stream(), Stream.of(Collections.<String>emptyList()))
                        .collect(Collectors.toList()),
                typeFactory,
                config);
    }

}
