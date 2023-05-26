package com.jeanneeetjean.jej.uploads;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FileController {


    @Scheduled(fixedDelay = 5000)
    @GetMapping("/api/getfile")
    public List<String> getFile() {
        return FtpUtil.udownLoadFile("193.203.239.69",21,"magas1958609","MaGalaFerme!8","assets/images/jej");
    }

    @Scheduled(fixedDelay = 5000)
    @PostMapping("/api/uploadfile")
    public boolean uploadFile(@RequestParam(value ="file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

       return FtpUtil.uploadFile("193.203.239.69",21,"magas1958609","MaGalaFerme!8","assets/images/jej", "/",file.getOriginalFilename(), inputStream);

    }



}