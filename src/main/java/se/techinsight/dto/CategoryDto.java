package se.techinsight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    Integer id;
    @NotEmpty
    String name;
//    LocalDateTime creationDateTime;
}
