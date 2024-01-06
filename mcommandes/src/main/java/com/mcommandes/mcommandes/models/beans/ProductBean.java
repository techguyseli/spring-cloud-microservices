package com.mcommandes.mcommandes.models.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductBean {
    
    private Long id;
    private String titre;
    private String description;
    private String image;
    private Double prix;
}
