package com.examplehub.uploadfiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

  @GetMapping("/")
  public String homepage() {
    return "index";
  }

  @PostMapping("/upload")
  public String uploadFile(
      @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    if (file.isEmpty()) {
      redirectAttributes.addFlashAttribute("message", "Please select a file to uploaded");
      return "redirect:/";
    }
    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    try {
      String UPLOAD_DIR = "./upload-files/upload/";
      File fileDir = new File(UPLOAD_DIR);
      if (!fileDir.exists()) {
        if (fileDir.mkdir()) {
          System.out.println("创建文件夹成功");
        } else {
          System.out.println("创建文件夹失败或者文件夹已经存在");
        }
      }
      Path path = Paths.get(UPLOAD_DIR.concat(fileName));
      Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      e.printStackTrace();
    }
    redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
    return "redirect:/";
  }
}
