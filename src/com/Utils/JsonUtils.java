package com.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

	public JsonUtils() {
		// TODO Auto-generated constructor stub
	}
	public final String inputStreamToString(InputStream is){
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		byte[] data=new byte[1024];
		int len=0;
		try {
			while((len=is.read(data))!=-1){
				os.write(data,0,data.length);
			}
			return new String(os.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
