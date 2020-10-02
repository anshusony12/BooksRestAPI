package com.rest.book.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.xml.crypto.Data;

import org.hibernate.mapping.Array;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.bind.api.impl.NameConverter.Standard;

@Component
public class FileUploadHelper {
//	public final String UPLOAD_DIR = "C:\\Users\\Anshu Sony\\Documents\\workspace-spring-tool-suite-4-4.7.0.RELEASE\\bootrestbook\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();
	public FileUploadHelper()throws IOException{
		
	}
	public boolean upladFile(MultipartFile file) {
		boolean f = false;
		try {
////			using stream
//			InputStream is = file.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
////			write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+file.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
}
