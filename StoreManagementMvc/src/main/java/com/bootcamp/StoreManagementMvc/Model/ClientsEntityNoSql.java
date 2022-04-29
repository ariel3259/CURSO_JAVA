package com.bootcamp.StoreManagementMvc.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="clients_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientsEntityNoSql extends Clients{
	private int dni;
	private String email;
}
