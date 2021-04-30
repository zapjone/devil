package com.zap.devil;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用来表示表/视图/函数的路径的. e.g database.table
 *
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class ObjectPath implements Serializable {
    private static final long serialVersionUID = -609529526146903554L;

    private final String databaseName;
    private final String objectName;

    public ObjectPath(String databaseName, String objectName) {
        this.databaseName = databaseName;
        this.objectName = objectName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getFullName() {
        return String.format("%s.%s", databaseName, objectName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ObjectPath that = (ObjectPath) o;

        return Objects.equals(databaseName, that.databaseName)
                && Objects.equals(objectName, that.objectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(databaseName, objectName);
    }

    @Override
    public String toString() {
        return String.format("%s.%s", databaseName, objectName);
    }
}

