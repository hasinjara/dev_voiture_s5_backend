package com.demo.voiture.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import net.coobird.thumbnailator.Thumbnails;




@Service
public class ImageService {

    private String uploadFile(File file, String fileName) throws IOException {
      BlobId blobId = BlobId.of("gasy-si-s5-cloud.appspot.com", fileName); // Replace with your bucker name
      BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
      InputStream inputStream = ImageService.class.getClassLoader().getResourceAsStream("gasy-si-s5-cloud-firebase-adminsdk-7839u-c2b6d2a8e3.json"); // change the file name with your one
      Credentials credentials = GoogleCredentials.fromStream(inputStream);
      Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
      storage.create(blobInfo, Files.readAllBytes(file.toPath()));

      String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/gasy-si-s5-cloud.appspot.com/o/%s?alt=media";
      return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
  }

  private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
      File tempFile = new File(fileName);
      try (FileOutputStream fos = new FileOutputStream(tempFile)) {
          fos.write(multipartFile.getBytes());
          fos.close();
      }
      Thumbnails.of(tempFile)
        .scale(1) 
        .outputQuality(0.5)
        .toFile(tempFile);
      return tempFile;
  }

  private String getExtension(String fileName) {
      return fileName.substring(fileName.lastIndexOf("."));
  }


  public String upload(MultipartFile multipartFile) throws Exception {
      try {
          String fileName = multipartFile.getOriginalFilename();                        // to get original file name
          fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.

          File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
          String URL = this.uploadFile(file, fileName);                                   // to get uploaded file link
          file.delete();
          return URL;
      } catch (Exception e) {
          e.printStackTrace();
          //return "Image couldn't upload, Something went wrong";
          throw new Exception("Image couldn't upload, Something went wrong");
      }
  }

  public List<String> upload(MultipartFile[] files) throws Exception {
    List <String> val = new ArrayList<String>();
    if(files.length == 0) {
        return val;
    }
    for (MultipartFile multipartFile : files) {
        val.add(this.upload(multipartFile));
    }
    return val;
  }


}
