package com.example.demo.controllers;


import com.example.demo.exceptions.OptimizationException;
import com.example.demo.models.OptimizationRequest;
import com.example.demo.models.Room;
import com.example.demo.services.IRoomOptimizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptimizationController {
    Logger logger = LoggerFactory.getLogger(OptimizationController.class);

    @Autowired
    private IRoomOptimizationService roomServeService;

    @RequestMapping(value = "/{operation}", method = RequestMethod.POST)
    public ResponseEntity<List<Room>> optimize(@PathVariable String operation, @RequestBody OptimizationRequest roomRequest) {
        try {
            return new ResponseEntity<>(roomServeService.optimize(operation, roomRequest), HttpStatus.OK);
        } catch (OptimizationException e) {
            logger.debug(e.getLocalizedMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}