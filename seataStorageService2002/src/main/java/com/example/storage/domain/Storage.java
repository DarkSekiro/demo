package com.example.storage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private long id;
    private long product_id;
    private int total;
    private int used;
    private int residue;
}
