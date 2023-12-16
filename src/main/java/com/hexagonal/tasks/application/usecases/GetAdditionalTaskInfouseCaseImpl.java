package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaksInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfouseCaseImpl implements GetAdditionalTaksInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfouseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditioanlTaskInfo(id);
    }
}
