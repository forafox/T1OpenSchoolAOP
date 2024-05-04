package org.forafox.service;

import org.forafox.domain.MethodData;

import java.util.List;

public interface MethodDataService {
    void save(MethodData methodData);
    List<MethodData> getMethodByMethodName(String methodName);
    List<MethodData> getAll();
    void clearData();
}
