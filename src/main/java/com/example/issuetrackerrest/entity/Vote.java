package com.example.issuetrackerrest.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

// EJEMPLO3 para detallar los modelos
@Data
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User votingUser;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Issue votedIssue;
}
