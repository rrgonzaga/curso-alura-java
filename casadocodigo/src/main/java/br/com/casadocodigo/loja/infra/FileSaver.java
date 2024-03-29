package br.com.casadocodigo.loja.infra;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
	private HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file) {
		
		try {
			System.out.println("file from MultipartFile");			
			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			System.out.println("realPath: " + realPath);
			String path = realPath + "\\" + file.getOriginalFilename();
			System.out.println("path: " + path);
			file.transferTo(new File(path));
			
			return baseFolder + "/" + file.getOriginalFilename();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
}
