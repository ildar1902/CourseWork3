package me.ildar.coursework3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sock {

    private Color color;
    private Size size;
    private int structure;
    private int quantityInStock;

}
