package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaksInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
