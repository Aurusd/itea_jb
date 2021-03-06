package itea.lsn8.FindFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	static class MyFileFilter implements FilenameFilter {
		private String ext;

		public MyFileFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			return name.endsWith(ext);
		}
	}

	private static void findFiles(String srcPath, String ext, ArrayList<String> list) throws IOException {
		File dir = new File(srcPath);
		File[] files = dir.listFiles(new MyFileFilter(ext));

		for (int i = 0; i < files.length; i++) {
			list.add(srcPath + files[i].getName());
		}
	}

	public static void main(String[] args) { // ищем в каталоге все файлы с расширением TXT
		ArrayList<String> list = new ArrayList<String>();

		try {
			findFiles("D:\\", ".docx", list);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : list)
			System.out.println(s);
	}

}