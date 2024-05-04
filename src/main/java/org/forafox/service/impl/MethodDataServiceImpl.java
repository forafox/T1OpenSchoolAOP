package org.forafox.service.impl;

import lombok.RequiredArgsConstructor;
import org.forafox.domain.MethodData;
import org.forafox.repository.MethodDataRepository;
import org.forafox.service.MethodDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MethodDataServiceImpl implements MethodDataService {
    private final MethodDataRepository methodDataRepository;

    @Override
    public void save(MethodData methodData) {
        methodDataRepository.save(methodData);
    }

    @Override
    public List<MethodData> getMethodByMethodName(String methodName) {
        return methodDataRepository.findAllByMethodName(methodName);
    }

    @Override
    public List<MethodData> getAll() {
        return methodDataRepository.findAll();
    }

    @Override
    public void clearData() {
        methodDataRepository.deleteAll();
    }
}
