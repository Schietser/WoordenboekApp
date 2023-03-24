package org.example.woordenboek.models.dto;

import lombok.Data;

@Data
public class UpdateWord {

    private Long id;
    private String word;
    private String translation;

}
