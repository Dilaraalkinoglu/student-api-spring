package com.dilaraalk.exception;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {

	 // Hata takibi için rastgele ID
	private String id;
	
	// Hatanın oluştuğu tarih-saat bilgisi
	private Date errorTime;
	
	// Gerçek hata verileri (genellikle bir field: [mesaj1, mesaj2] şeklinde Map)
	private T errors;
	
}
