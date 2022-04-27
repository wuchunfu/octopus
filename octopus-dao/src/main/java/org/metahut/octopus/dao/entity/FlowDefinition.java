package org.metahut.octopus.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_octopus_flow_definition")
public class FlowDefinition {

    @Id
    @GeneratedValue
    private Integer id;
}
