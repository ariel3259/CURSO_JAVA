package com.bootcamp.StoreManagementMvc.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bootcamp.StoreManagementMvc.Interfaces.IFileSystem;

@Service
public class FileSystemService implements IFileSystem{

	private Path rootPath = Paths.get("src//main//resources//static//clients//images");
	
	@Override
	public String saveFile(MultipartFile image) {
		
		try {
			Files.copy(image.getInputStream(), rootPath.resolve(image.getOriginalFilename()));
			return image.getOriginalFilename();
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
			return null;
		}
	}

}
