package com.project.controledelivros.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping(value = "/images")
public class ImageController {

    private static String  urlImagem = "C:/Users/SQUADRA/Documents/PROJETO BIBLIOTECA/FRONT/applivros/src/assets/images/livros/";


    @GetMapping("{pid}")
    @ResponseBody
    public void downloadImage(@PathVariable("pid") String pid, HttpServletResponse response)
    {
        try {
            File fileToDownload = new File(urlImagem + pid);

            try (InputStream inputStream = new FileInputStream(fileToDownload)) {
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment; filename=" + pid);
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(
            @RequestParam("pid") String pid, // photo id
            @RequestParam("file") MultipartFile file
    ) {
        if (file.isEmpty()) {
            throw new RuntimeException("File given is not valid!");
        }

        String folder = urlImagem;
        String concatenar = "livro";
        String bookComplet = concatenar.concat(pid.toString());

        try {
            Path pathFolder = Paths.get(folder);
            Files.createDirectories(pathFolder);
            Path pathFile = Paths.get(folder + bookComplet);
            Files.write(pathFile, file.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{pid}")
    public void deleteFile(@PathVariable("pid") String pid)
    {
        try {
            Path fileToDelete = Paths.get(urlImagem + pid);

            if (Files.exists(fileToDelete)) {
                Files.delete(fileToDelete);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}




