package org.example.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//updating the existing data objects in existing test scenarios
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor//lombok generates a builder class behind the scenes
public class BuilderPattern {
    private String name;
    private String searchKeyword;
    private Double price;
    private String brand;
    private String size;
    private String color;
    private String description;
//no need of setters
//    BuilderPattern jeans=BuilderPattern.builder()
//            .name("abc")
//            .searchKeyword("hdhd")
//            .price(12.12).build();
    public BuilderPattern init(){
        return this.toBuilder().name("abc")
                .searchKeyword("hdhd")
                .price(12.12).build();
    }
}
