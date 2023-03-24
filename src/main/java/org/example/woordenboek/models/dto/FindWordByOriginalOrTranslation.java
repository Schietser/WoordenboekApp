package org.example.woordenboek.models.dto;

import lombok.Data;

@Data
public class FindWordByOriginalOrTranslation {

    private String word;
    private String translation;

}
