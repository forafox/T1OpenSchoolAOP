package org.forafox.service.impl;

import lombok.RequiredArgsConstructor;
import org.forafox.domain.MethodData;
import org.forafox.repository.MethodDataRepository;
import org.forafox.service.MethodDataService;
import org.forafox.web.dto.MethodDataStatDTO;
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
    public List<MethodData> getAllMethodsByMethodName(String methodName) {
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

    public MethodDataStatDTO getStat(String methodName) {
        List<MethodData> dataList = getAll();
        long sum = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long average = 0;
        var methodData = new MethodDataStatDTO();
        if (!dataList.isEmpty()) {
            for (MethodData data : dataList) {
                long executeTime = data.getExecuteTime();
                sum += executeTime;
                max = Math.max(max, executeTime);
                min = Math.min(min, executeTime);
            }
            average = sum / dataList.size();

            methodData.setMethodName(methodName);
            methodData.setAnnotationType(dataList.get(0).getAnnotationType());
            methodData.setMaxExecuteTime(max);
            methodData.setMinExecuteTime(min);
            methodData.setAvgExecuteTime(average);
        }
        return methodData;
    }
}
