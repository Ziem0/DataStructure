package com.ziemo.algo.hash;

import java.io.*;

public class CustomHash {

	public static void main(String[] args) throws IOException {

//		File f = new File("src/main/resources/demo.txt");
//		FileReader fr = new FileReader(f);
//		BufferedReader br = new BufferedReader(fr);
//
//		int i = br.readLine().hashCode();
//		System.out.println(i);
//---------------------------------------------------------

		String[] l = new String[3];

		String s1 = "ziemo";
		String s2 = "ania";
		String s3 = "nina";

		int i1 = s1.hashCode() % l.length;
		int i2 = s2.hashCode() % l.length;
		int i3 = s3.hashCode() % l.length;

		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);

		l[i1] = s1;
		l[i2] = s2;
		l[i3] = s3;

		for (int i = 0; i < l.length; i++) {
			System.out.println(l[i]);
		}
	}


}
