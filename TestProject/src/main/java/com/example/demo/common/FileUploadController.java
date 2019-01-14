package com.example.demo.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.vo.FileVO;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	private static String UPLOADED_FOLDER = "storage";
	
	@RequestMapping("/fileUpload")
	public @ResponseBody String fileUpload(FileVO fileVO) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dtTxt = sdf.format(dt);
		File f = new File(UPLOADED_FOLDER + File.separator + dtTxt);
		if( !f.exists() ) {
			f.mkdir();
		}
		if( fileVO.getFile() == null || fileVO.getFile().length == 0 ) {
			return "redirect:/pages/file-upload.html";
		}
		String fileName = "";
		
		if( fileVO.getFile().length > 0 ) {
			for (int i = 0; i < fileVO.getFile().length; i++) {
				try {
					if (true == fileVO.getFile()[i].isEmpty()) {
                        continue;
                    }
					fileName = fileVO.getFile()[i].getOriginalFilename();
					byte[] bt = fileVO.getFile()[i].getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(f.getPath() + File.separator + fileName)));
					buffStream.write(bt);
					buffStream.close();
				}catch (Exception e) {
					return "Empty Files";
				}
			}
		} else {
			return "None Files";
		}
		
		return "SUCCSS";
	}
}
