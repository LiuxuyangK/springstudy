package com.study.lxy.controller;

import com.study.lxy.dto.Response;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Harry on 17/11/21.
 */

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

  @RequestMapping("/toPage")
  public ModelAndView toPage() {

    ModelAndView modelAndView = new ModelAndView("/fileupload/fileupload");
    return modelAndView;
  }

  @RequestMapping("/fileUpload")
  public Response fileUpload(@RequestParam("files") MultipartFile[] files) {

    if (files != null && files.length > 0) {

      for (int i = 0; i < files.length; i++) {
        MultipartFile file = files[i];
        saveFile(file);
      }
    }

    Response response = new Response();
    response.setMsg("上传成功");
    return response;
  }

  private boolean saveFile(MultipartFile file) {
    // 判断文件是否为空
    if (!file.isEmpty()) {
      try {
        String fileName = file.getOriginalFilename();
        String filePath = "/Users/Harry/personal/fileupload/" + fileName;
        // 转存文件
        File file1 = new File(filePath);
        file.transferTo(file1);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return false;
  }

}
