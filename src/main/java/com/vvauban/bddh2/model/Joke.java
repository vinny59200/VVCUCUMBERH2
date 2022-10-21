package com.vvauban.bddh2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder( toBuilder = true )
@Entity( name = "JOKE" )
public class Joke {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO,
                     generator = "native" )
    @GenericGenerator( name = "native",
                       strategy = "native" )
    @Column( name = "ID" )
    private Long id;

    @Column( name = "CONTENT" )
    private String content;

}
