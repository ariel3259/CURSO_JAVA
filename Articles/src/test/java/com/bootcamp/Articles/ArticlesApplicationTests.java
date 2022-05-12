package com.bootcamp.Articles;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootcamp.Articles.Model.Articles;
import com.bootcamp.Articles.Model.Users;
import com.bootcamp.Articles.Services.ArticlesService;
import com.bootcamp.Articles.Services.UsersService;

@SpringBootTest
class ArticlesApplicationTests {

	@Autowired
	//private ArticlesService service;
	private UsersService service;
	@Test
	void contextLoads() {
		/*List<Articles> articles = new ArrayList<>();
		articles.add(new Articles(15, 4554, 34.70, "Banana"));
		articles.add(new Articles(23, 5478, 17.80, "Arroz"));
		articles.add(new Articles(12, 6576, 25.77, "Alfajor"));
		articles.add(new Articles(34, 5465, 30.50, "Manzana"));
		articles.add(new Articles(12, 3447, 37.45, "Fideos molto"));
		for(Articles article: articles) {
			service.save(article);
		}*/
		
		service.register(new Users("arielS", "1234"));
	}

}
