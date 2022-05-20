package org.metahut.octopus.monitordb.api;

import java.util.Date;
import java.util.List;

public class MetricsResultRequest extends PageRequest {

    private List<String> metricsCodes;

    private Date createStartTime;
    private Date createEndTime;


}
