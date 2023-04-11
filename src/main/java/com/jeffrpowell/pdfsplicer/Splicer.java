package com.jeffrpowell.pdfsplicer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.SwingWorker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class Splicer extends SwingWorker<Path, Void>{
	private final Path pathToSplit;

	public Splicer(Path pathToSplit)
	{
		this.pathToSplit = pathToSplit;
	}

	@Override
	protected Path doInBackground() throws Exception
	{
		//Prepare directory
		String splitDirectoryName = pathToSplit.getFileName().toString().replace(".pdf", "");
		Path splitDirectory = Paths.get(pathToSplit.getParent().toString(), splitDirectoryName);
        if (!Files.exists(splitDirectory)) {
            Files.createDirectory(splitDirectory);
        }
		//Split pdfs
		try (PDDocument document = PDDocument.load(Files.readAllBytes(pathToSplit))) {
//			Splitter splitter = new Splitter();
//			List<PDDocument> splittedDocuments = splitter.split(document);
//			
//			for (int i = 1; i <= splittedDocuments.size(); i++)
//			{
//				Path pagePath = Paths.get(splitDirectory.toString(), splitDirectoryName + "_" + i + ".pdf");
//				try (PDDocument doc = splittedDocuments.get(i-1))
//				{
//					doc.save(pagePath.toFile());
//				}
//			}
			PDPage page = document.getPage(0);
			PDRectangle rect = new PDRectangle(PDRectangle.LETTER.getUpperRightX() + 9F, PDRectangle.LETTER.getUpperRightY() + 18F);
			page.setMediaBox(rect);
			page.setCropBox(rect);
			page.setBleedBox(rect);
			Path newPath = pathToSplit.resolveSibling(pathToSplit.getFileName().toString().replace(".pdf", "") + "_upload_cover.pdf");
			try (PDDocument newDoc = new PDDocument())
			{
				newDoc.addPage(page);
				newDoc.save(newPath.toFile());
			}
		}
		return splitDirectory;
	}

}
