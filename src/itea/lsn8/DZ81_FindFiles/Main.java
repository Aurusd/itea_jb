package itea.lsn8.DZ81_FindFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/** Модифицировать проект FindFiles так, чтобы программа
 *  искала в каталоге все файлы с расширениями из списка.
 */

public class Main {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		String[] extList = {".log", ".txt", ".html"};
		try {
			findFiles("C:\\Temp\\", extList, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String s : list)
			System.out.println(s);
	}

	private static void findFiles(String srcPath, String[] ext, ArrayList<String> list) throws IOException {
		File dir = new File(srcPath);
		File[] files;
		//for (String s : ext) - другой вариант цикла
		for (int i = 0; i < ext.length; i++) {
			files = dir.listFiles(new MyFileFilter(ext[i]));
			for (int j = 0; j < files.length; j++) {
				list.add(srcPath + files[j].getName());
			}
		}
	}

	static class MyFileFilter implements FilenameFilter {
		private String ext;

		public MyFileFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			return name.endsWith(ext);
		}
	}
}