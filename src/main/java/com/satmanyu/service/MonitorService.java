package com.satmanyu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MonitorService {

    private String lastContent = "";

    public boolean checkForChanges() {
        try {
            RestTemplate rt = new RestTemplate();

            String newContent = rt.getForObject("https://bsebstet.org/", String.class);

            if (lastContent.isEmpty()) {
                lastContent = newContent;
                return false;
            }

            // Compare old and new content
            boolean changed = !lastContent.equals(newContent);

            if (changed) {
                lastContent = newContent;
            }

            return changed;

        } catch (Exception e) {
            System.out.println("Error fetching website: " + e.getMessage());
            return false;
        }
    }
}
