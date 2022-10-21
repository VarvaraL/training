package trnng.mapper;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class MapperFactory {
    private final Map<Class, Map<Class, DefaultMapper>>mapperMap = new ConcurrentHashMap<>();

    public MapperFactory(List<DefaultMapper> mapperList) {
        for (DefaultMapper mapper : mapperList) {
            List<Method> methods = Arrays.stream(mapper.getClass().getMethods())
                    .filter(m -> "mapTo".equals(m.getName()))
                    .filter(m -> !Object.class.equals(m.getReturnType()))
                    .collect(Collectors.toList());
            if (!methods.isEmpty()) {
                Method method = methods.get(0);
                Class returnType = method.getReturnType();
                Class src = method.getParameters()[0].getType();
                Map<Class, DefaultMapper> map = new ConcurrentHashMap<>();
                map.put(src, mapper);
                mapperMap.putIfAbsent(returnType, map);
                mapperMap.computeIfPresent(returnType, (k, v) -> {
                    v.put(src, mapper);
                    return v;
                });
            }
        }
    }

    public <S, R> R mapTo(S src, Class classToMap) {
        if (src == null) {
            return null;
        }
        Map<Class, DefaultMapper> mapppers = mapperMap.get(classToMap);
        if (mapppers == null) {
            return null;
        }
        DefaultMapper mapper;
        if (src.getClass().getName().contains("HibernateProxy")) {
            mapper = mapppers.get(src.getClass().getSuperclass());
        } else {
            mapper = mapppers.get(src.getClass());
        }
        if (mapper == null) {
            return null;
        }
        return (R) mapper.mapTo(src);
    }

    public <S, R> List<R> mapToList(List<S> src, Class classToMap) {
        if (src == null) {
            return null;
        }
        List<R> list = new ArrayList<>();
        src.forEach(s -> list.add(mapTo(s, classToMap)));
        return list;
    }
}

