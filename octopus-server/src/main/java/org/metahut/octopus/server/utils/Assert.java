package org.metahut.octopus.server.utils;

import org.metahut.octopus.api.exception.BusinessException;
import org.metahut.octopus.common.enums.StatusEnum;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Optional;

public class Assert {

    private Assert() {

    }

    public static void isPresent(@Nullable Optional optional, StatusEnum status, @Nullable Object... args) {
        if (!optional.isPresent()) {
            throw new BusinessException(status, args);
        }
    }

    public static void notNull(@Nullable Object object, StatusEnum status, @Nullable Object... args) {
        if (object == null) {
            throw new BusinessException(status, args);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, StatusEnum status, @Nullable Object... args) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(status, args);
        }
    }

    public static void throwException(Throwable cause, StatusEnum status, @Nullable Object... args) {
        throw new BusinessException(status, args, cause);
    }

    public static void isEmpty(@Nullable Collection<?> collection, StatusEnum status, @Nullable Object... args) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(status, args);
        }
    }

    public static void isTrue(@Nullable Boolean expression, StatusEnum status, @Nullable Object... args) {
        if (BooleanUtils.isNotTrue(expression)) {
            throw new BusinessException(status, args);
        }
    }

    public static void isFalse(@Nullable Boolean expression, StatusEnum status, @Nullable Object... args) {
        if (BooleanUtils.isTrue(expression)) {
            throw new BusinessException(status, args);
        }
    }

    public static void exists(@Nullable Optional optional, StatusEnum status, @Nullable Object... args) {
        if (optional.isPresent()) {
            throw new BusinessException(status, args);
        }
    }
}
