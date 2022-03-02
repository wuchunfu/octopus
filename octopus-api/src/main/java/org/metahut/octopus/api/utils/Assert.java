package org.metahut.octopus.api.utils;

import org.metahut.octopus.api.enums.Status;
import org.metahut.octopus.api.exception.BusinessException;

import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class Assert {

    private Assert() {

    }

    public static void notNull(@Nullable Object object, Status status, @Nullable Object[] args) {
        if (object == null) {
            throw new BusinessException(status, args);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, Status status, @Nullable Object[] args) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(status, args);
        }
    }

    public static void throwException(Status status, @Nullable Object[] args, Throwable cause) {
        throw new BusinessException(status, args, cause);
    }
}
