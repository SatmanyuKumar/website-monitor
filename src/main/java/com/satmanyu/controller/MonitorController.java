package com.satmanyu.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.satmanyu.service.MonitorService;

@RestController
@RequestMapping("/api")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @GetMapping("/check")
    public String check() {
        boolean changed = monitorService.checkForChanges();

        if (changed) {
            return "changed";
        } else {
            return "no-change";
        }
    }
}

