package com.it.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FilePreviewController {
    @Value("${imagePath}")
    private String filePath;
    @RequestMapping("/preview/{fileName")
    public void previewFile(@PathVariable String fileName, HttpServletResponse response){

    }

}
