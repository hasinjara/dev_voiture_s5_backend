package com.demo.voiture.controller;

import java.io.File;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.voiture.services.ImageService;

import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
public class ImageUploadingController {
    private final ImageService imageService;

    @GetMapping
    public String upload1() throws Exception {
        String filename1 = "/home/hasinjara/z_mael/etude/Doc_S5/Ws/compress_image/h.jpg";
        String filename2 = "/home/hasinjara/z_mael/etude/Doc_S5/Ws/compress_image/test.jpg";
        File input = new File(filename1);
        File output = new File(filename2);

        Thumbnails.of(input)
        .scale(1) 
        .outputQuality(0.5)
        .toFile(output);
        return "ok";
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception { 
        return imageService.upload(multipartFile);
    }


    @PostMapping("/m")
    public List<String> upload(@RequestParam("files") MultipartFile[] multipartFile) throws Exception { 
        return imageService.upload(multipartFile);
    }
}
