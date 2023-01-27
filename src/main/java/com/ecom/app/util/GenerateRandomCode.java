package com.ecom.app.util;

import org.springframework.stereotype.Component;

@Component
public class GenerateRandomCode {

	public static int getRandomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

}
