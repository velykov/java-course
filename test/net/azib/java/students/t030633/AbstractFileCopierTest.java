package net.azib.java.students.t030633;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * AbstractFileCopierTest
 * 
 * @author t030633
 */
public abstract class AbstractFileCopierTest {

	private File src = CopyPerformanceTimer.SOURCE_FILE;
	private File dest = CopyPerformanceTimer.DEST_FILE;

	private AbstractFileCopier afc;

	public AbstractFileCopierTest(AbstractFileCopier copier) {
		this.afc = copier;
	}

	@Test
	public void fileCopyWorks() throws IOException {
		afc.copy(src, dest);
		assertTrue(src.length() == dest.length());
	}

	@Test
	public void dataCopyWorks() throws IOException {
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		afc.copy(is, os);
		assertTrue(src.length() == dest.length());
	}

}
