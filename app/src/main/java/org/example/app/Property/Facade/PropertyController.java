package org.example.app.Property.Facade;

import lombok.extern.log4j.Log4j2;
import org.example.lib.Property.Domain.Property;
import org.example.lib.Property.Exceptions.PropertyDoesNotExistException;
import org.example.lib.Property.Usecase.PropertyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class PropertyController {

    private final PropertyManager propertyManager;

    @Autowired
    public PropertyController(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
    }

    @GetMapping(path = "/property", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Property>> index(
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "offset", defaultValue = "0") int offset)
    {
        try {
            return ResponseEntity.ok(this.propertyManager.query(limit, offset));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/property/{propertyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> get(@PathVariable("propertyId") Integer propertyId) {
        try {
            return ResponseEntity.ok(this.propertyManager.find(propertyId));
        } catch (PropertyDoesNotExistException e) {
            log.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(path = "/property", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> create(@RequestBody Property property)
    {
        try {
            return ResponseEntity.ok(this.propertyManager.createOrUpdate(property));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
