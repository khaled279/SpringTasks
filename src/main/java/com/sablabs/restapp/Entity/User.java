package com.sablabs.restapp.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
// import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.IdClass;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
// import net.bytebuddy.asm.Advice.Local;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime createdAt ; 
    private LocalDateTime editedAt ; 
    private String name; 

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    Set<Order> orders;

    public User(){

    }
    public User(Integer id , String name){
        this.id = id ; 
        this.name = name; 
    }

    @Override
    public String toString() {
        
        return String.format("Customer:[id =%d , name= %s]", id, name);
    }
}
