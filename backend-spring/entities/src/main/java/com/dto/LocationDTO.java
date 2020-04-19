package com.dto;

import com.entities.AdressType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {

	private Long id;
    private String name;
    private AdressType type;
    private int id_parent;
    
}
