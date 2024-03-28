package com.casestudy.balance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "holding")
@Data
public class Holding {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "member_code")
    private String memberCode;

    @Column(name = "fund_code")
    private String fundCode;

    @Column
    private double units;

}
