package org.example.lib.Property.Repository;

import org.example.lib.Property.Domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertyRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PropertyRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Property> query(int limit, int offset) {
        return mongoTemplate.find(
                new Query().limit(limit).skip(offset),
                Property.class
        );
    }

    public Property find(Integer propertyId)
    {
        return mongoTemplate.findById(propertyId, Property.class);
    }

    public Property createOrUpdate(Property property)
    {
        return mongoTemplate.save(property);
    }
}
