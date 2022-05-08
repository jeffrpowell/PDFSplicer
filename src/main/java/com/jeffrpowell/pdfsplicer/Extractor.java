package com.jeffrpowell.pdfsplicer;

import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.SwingWorker;
import org.apache.pdfbox.pdmodel.PDDocument;

public class Extractor extends SwingWorker<Path, Void>{
    private static final String PDF_EXT = ".pdf";
	private final Path pathToSplit;
	private final Path savePath;
    private final int pages;
    private final int startPage;
    private final int endPage;
    
    public static int getPages(Path pdf) {
        try (PDDocument document = PDDocument.load(Files.readAllBytes(pdf))) {
            return document.getNumberOfPages();
        }
        catch (Exception e) {
            return -1;
        }
    }

	public Extractor(Path pathToSplit, int startPage, int endPage)
	{
		this.pathToSplit = pathToSplit;
        int _pages = -1;
        try (PDDocument document = PDDocument.load(Files.readAllBytes(pathToSplit))) {
            _pages = document.getNumberOfPages();
        }
        catch (Exception e) { }
        pages = _pages;
        String splitFileName = pathToSplit.getFileName().toString();
        String saveFileName = splitFileName.substring(0, splitFileName.length() - PDF_EXT.length()) + "_pg" + startPage + "-" + endPage + PDF_EXT;
        this.savePath = pathToSplit.resolveSibling(saveFileName);
        this.startPage = startPage - 1;
        this.endPage = endPage - 1;
	}
    
	@Override
	protected Path doInBackground() throws Exception
	{
		try (PDDocument document = PDDocument.load(Files.readAllBytes(pathToSplit))) {
            document.setAllSecurityToBeRemoved(true);
            if (startPage == endPage) {
                try (PDDocument newDoc = new PDDocument()) {
                    newDoc.addPage(document.getPage(startPage));
                    newDoc.save(savePath.toFile());
                }
            }
            for (int page = pages - 1; page >= 0; page--) {
                if (page > endPage || page < startPage) {
                    document.removePage(page);
                }
            }
            document.save(savePath.toFile());
		}
        return savePath;
	}

}
