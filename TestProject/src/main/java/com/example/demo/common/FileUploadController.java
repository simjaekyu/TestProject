package com.example.demo.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.vo.FileVO;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	@RequestMapping("/fileUpload")
	public @ResponseBody FileVO fileUpload(FileVO fileVo) {
		return fileVo;
	}
}
