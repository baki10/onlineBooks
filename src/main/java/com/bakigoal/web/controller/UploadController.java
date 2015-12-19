package com.bakigoal.web.controller;

import com.bakigoal.model.UploadFile;
import com.bakigoal.util.FilesUtil;
import com.bakigoal.web.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by ilmir on 18.12.15.
 */
@Controller
public class UploadController {

  private static final String PDF_DIR = "src/main/webapp/resources/pdf/";

  @Autowired
  private UploadFileService uploadFileService;

  @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
  public String showUploadForm(HttpServletRequest request) {
    return "upload";
  }

  @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
  public String handleFileUpload(HttpServletRequest request,
                                 @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

    if (fileUpload != null && fileUpload.length > 0) {
      for (CommonsMultipartFile aFile : fileUpload) {
        if (aFile.getOriginalFilename() == null || aFile.getBytes().length < 1) {
          continue;
        }
        System.out.println("Saving file: " + new String(aFile.getOriginalFilename().getBytes("UTF-8")));

        UploadFile uploadFile = new UploadFile();
        uploadFile.setFileName(aFile.getOriginalFilename());
        uploadFile.setData(aFile.getBytes());
        uploadFileService.save(uploadFile);
      }
    }

    return "success";
  }

  @RequestMapping(value = "/uploadedFiles", method = RequestMethod.GET)
  public String getAllFileUploaded(ModelMap model) {
    model.addAttribute("files", uploadFileService.getAll());
    return "uploadedFiles";
  }

  @RequestMapping(value = "/uploadedFile", method = RequestMethod.POST)
  public String getFileUploaded(ModelMap model, @RequestParam Long fileId) throws IOException {
    UploadFile byId = uploadFileService.getById(fileId);
    if (byId == null) {
      return "redirect:uploadedFiles";
    }
    FilesUtil.writeBytesToFile(byId.getData(), PDF_DIR + byId.getFileName());
    return "redirect:resources/pdf/" + byId.getFileName();
  }

}
