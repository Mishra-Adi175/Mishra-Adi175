package basic.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ioclass {
	InputStream is;
	OutputStream os;

	public ioclass() {
		try {
			int i;
			File f = new File("/Users/macbookpro/Downloads/Test-IIG-008 (23-09-2022).pdf");
			long len = f.length();
			int fivePC = (int) (0.05 * len);
			int count = 0;
			
			is = new FileInputStream("/Users/macbookpro/Downloads/Test-IIG-008 (23-09-2022).pdf");
			os = new FileOutputStream("/Users/macbookpro/Documents/pratap.pdf");
			while( (i=is.read()) != -1 ) {
				os.write(i);
				count++;
				if(count>fivePC) {
					System.out.print(".");
					count = 0;
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		} finally {
			try {
				os.close();
				is.close();
			} catch(IOException e) {
				System.out.println(e);
			}
		}
	}
	
	public static void main(String[] args) {
		new ioclass();
	}

}