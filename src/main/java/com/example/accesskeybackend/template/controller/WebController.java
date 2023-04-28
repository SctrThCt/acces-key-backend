package com.example.accesskeybackend.template.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;

@RestController
@RequestMapping("/api/web")
public class WebController {
    @GetMapping("/checkIpv6Support")
    public ResponseEntity<Boolean> checkIPv6Support(@RequestParam String siteUrl) throws Exception{
        URL url = new URL(siteUrl);
        InetAddress[] addresses = InetAddress.getAllByName(url.getHost());
        Boolean result = false;
        for (InetAddress address:addresses)
        {
            if (address instanceof Inet6Address)
                result = true;
        }
        return ResponseEntity.ok().body(result);
    }
}
