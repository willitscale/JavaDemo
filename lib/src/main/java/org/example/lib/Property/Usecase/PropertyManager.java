package org.example.lib.Property.Usecase;

import org.example.lib.Property.Domain.Property;
import org.example.lib.Property.Exceptions.PropertyDoesNotExistException;
import org.example.lib.Property.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertyManager {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyManager(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> query(int limit, int offset) {
        return propertyRepository.query(limit, offset);
    }

    public Property find(Integer propertyId) throws PropertyDoesNotExistException {
        Property property = propertyRepository.find(propertyId);
        if (null == property) {
            throw new PropertyDoesNotExistException();
        }
        return property;
    }

    public Property createOrUpdate(Property property) {
        return propertyRepository.createOrUpdate(property);
    }
}
