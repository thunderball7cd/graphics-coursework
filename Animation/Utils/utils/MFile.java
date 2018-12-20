package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MFile {

	private static final String FILE_SEPARATOR = "/";

	private String path;
	private String name;

	public MFile(String path) {
		this.path = FILE_SEPARATOR + path;
		String[] dirs = path.split(FILE_SEPARATOR);
		this.name = dirs[dirs.length - 1];
	}

	public MFile(MFile file, String subFile) {
		this.path = file.path + FILE_SEPARATOR + subFile;
		this.name = subFile;
	}


	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return getPath();
	}

	public InputStream getInputStream() {
		return Class.class.getResourceAsStream(path);
	}

	public BufferedReader getReader() throws Exception {
		try {
			InputStreamReader isr = new InputStreamReader(getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			return reader;
		} catch (Exception e) {
			System.err.println("Couldn't get reader for " + path);
			throw e;
		}
	}

	public String getName() {
		return name;
	}

}