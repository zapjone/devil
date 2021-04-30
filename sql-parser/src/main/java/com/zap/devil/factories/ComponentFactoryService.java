package com.zap.devil.factories;

import com.zap.devil.delegation.ComponentFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class ComponentFactoryService {

    public static <T extends ComponentFactory> T find(String name) {
        List<T> all = ComponentFactoryService.findAll(name);

        if (all.size() > 1) {
            throw new IllegalStateException("发现多个ComponentFactory实现");
        }

        return all.get(0);
    }

    public static <T extends ComponentFactory> List<T> findAll(String name) {
        List<ComponentFactory> factorys = discoverFactories(Optional.empty());
        List<ComponentFactory> componentFactories = factorys.stream()
                .filter(factory -> factory.name().equals(name)).collect(Collectors.toList());
        return (List<T>) componentFactories;
    }

    private static List<ComponentFactory> discoverFactories(Optional<ClassLoader> classLoader) {
        try {
            List<ComponentFactory> result = new LinkedList<>();
            ClassLoader cl = classLoader.orElse(Thread.currentThread().getContextClassLoader());
            ServiceLoader.load(ComponentFactory.class, cl).iterator().forEachRemaining(result::add);
            return result;
        } catch (ServiceConfigurationError e) {
            throw new IllegalStateException("Could not load service provider for table factories.", e);
        }
    }

}
