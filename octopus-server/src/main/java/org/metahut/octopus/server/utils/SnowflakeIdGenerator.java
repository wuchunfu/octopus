/*
 * Copyright 2010-2012 Twitter, Inc.
 * Copyright 2010-2012 Apache DolphinScheduler, Inc.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.metahut.octopus.server.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

public class SnowflakeIdGenerator {
    /** start timestamp 2021-01-01 00:00:00 */
    private static final long START_TIMESTAMP = 1609430400000L;

    /** Each machine generates 32 in the same millisecond */
    private static final long LOW_DIGIT_BIT = 5L;
    private static final long MIDDLE_BIT = 2L;
    private static final long MAX_LOW_DIGIT = ~(-1L << LOW_DIGIT_BIT);
    private static final long MIDDLE_LEFT = LOW_DIGIT_BIT;
    private static final long HIGH_DIGIT_LEFT = LOW_DIGIT_BIT + MIDDLE_BIT;
    private final long machineHash;
    private long lowDigit = 0L;
    private long recordMillisecond = -1L;

    private static final long SYSTEM_TIMESTAMP = System.currentTimeMillis();
    private static final long SYSTEM_NANOTIME  = System.nanoTime();

    public static SnowflakeIdGenerator getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;
        private SnowflakeIdGenerator singleton;

        private Singleton() {
            singleton = new SnowflakeIdGenerator();
        }

        public SnowflakeIdGenerator getInstance() {
            return singleton;
        }
    }

    private SnowflakeIdGenerator() throws GeneratorException {
        try {
            this.machineHash = Math.abs(Objects.hash(InetAddress.getLocalHost().getHostName())) % (2 << (MIDDLE_BIT - 1));
        } catch (UnknownHostException e) {
            throw new GeneratorException(e.getMessage(), e);
        }
    }

    public synchronized long nextId() throws GeneratorException {
        long nowtMillisecond = systemMillisecond();
        if (nowtMillisecond < recordMillisecond) {
            throw new GeneratorException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", recordMillisecond - nowtMillisecond));
        }
        if (nowtMillisecond == recordMillisecond) {
            lowDigit = (lowDigit + 1) & MAX_LOW_DIGIT;
            if (lowDigit == 0L) {
                while (nowtMillisecond <= recordMillisecond) {
                    nowtMillisecond = systemMillisecond();
                }
            }
        } else {
            lowDigit = 0L;
        }
        recordMillisecond = nowtMillisecond;
        return (nowtMillisecond - START_TIMESTAMP) << HIGH_DIGIT_LEFT | machineHash << MIDDLE_LEFT | lowDigit;
    }

    private long systemMillisecond() {
        return SYSTEM_TIMESTAMP + (System.nanoTime() - SYSTEM_NANOTIME) / 1000000;
    }

    public static class GeneratorException extends RuntimeException {
        public GeneratorException(String message) {
            super(message);
        }

        public GeneratorException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
