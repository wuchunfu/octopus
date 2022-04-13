package org.metahut.octopus.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_octopus_alert_instance")
public class AlertInstance {

    @Id
    @GeneratedValue
    private Integer id;

    private String alertType;




}
