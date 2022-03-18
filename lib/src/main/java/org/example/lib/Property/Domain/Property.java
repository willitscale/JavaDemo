package org.example.lib.Property.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "data")
public class Property {
    @Id
    private Integer id;
    @Indexed
    private String name;
    @Indexed
    private Integer beds;
    @Indexed
    private Integer sleeps;
    @Indexed
    private Integer pets;
    @Indexed
    private Integer dogs;

    private String location;
    private String description;
}
