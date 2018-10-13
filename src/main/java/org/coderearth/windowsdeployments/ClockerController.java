package org.coderearth.windowsdeployments;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClockerController
 */
@RestController
public class ClockerController {

    @Autowired
    private ClockerService clockerService;

    @GetMapping(path = "/clock")
    public ResponseEntity<Map<String, LocalDateTime>> getDatetime() {
        return ResponseEntity.ok(Collections.singletonMap("clock", clockerService.getDatetime()));
    }

}