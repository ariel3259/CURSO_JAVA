package com.bootcamp.StoreManagementMvc.Interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IFileSystem {
	public String saveFile(MultipartFile image);
}
