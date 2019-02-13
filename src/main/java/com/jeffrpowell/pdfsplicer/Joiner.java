package com.jeffrpowell.pdfsplicer;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;
import javax.swing.SwingWorker;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class Joiner extends SwingWorker<Path, Void>{
	private final List<Path> pathsToJoin;
	private final Path joinPath;

	public Joiner(List<Path> pathsToJoin, Path joinPath)
	{
		this.pathsToJoin = pathsToJoin;
		this.joinPath = joinPath;
	}

	@Override
	protected Path doInBackground() throws Exception
	{
		PDFMergerUtility merger = new PDFMergerUtility();
		merger.setDestinationFileName(joinPath.toString());
		pathsToJoin.stream().map(Path::toFile).forEach(file -> {
			try {
				merger.addSource(file);
			} catch (FileNotFoundException ex)
			{
				System.err.println(ex);
			}
		});
		merger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
		return joinPath;
	}

}
