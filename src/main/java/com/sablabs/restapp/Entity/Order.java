package com.sablabs.restapp.Entity;

import java.lang.StackWalker.Option;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name ="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    private Integer total; 

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "userid", nullable = false)
    User user;
    

    public Order(){

    }
    public Order(Integer total){
        this.total = total; 
    }

}
