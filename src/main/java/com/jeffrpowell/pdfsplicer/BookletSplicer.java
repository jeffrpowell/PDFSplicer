package com.jeffrpowell.pdfsplicer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.SwingWorker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class BookletSplicer extends SwingWorker<Path, Void> {

    private final Path pathToSplit;

    public BookletSplicer(Path pathToSplit) {
        this.pathToSplit = pathToSplit;
    }

    @Override
    protected Path doInBackground() throws Exception {
        //Prepare directory
        String splitDirectoryName = pathToSplit.getFileName().toString().replace(".pdf", "");
        Path splitDirectory = Paths.get(pathToSplit.getParent().toString(), splitDirectoryName);
        if (!Files.exists(splitDirectory)) {
            Files.createDirectory(splitDirectory);
        }
        //Split pdfs
        try (PDDocument document = PDDocument.load(Files.readAllBytes(pathToSplit))) {
            document.setAllSecurityToBeRemoved(true);
            int j = 0;
            int noOfPages = document.getNumberOfPages();
            for (int i = 0; i < noOfPages; i++) {
                PDPage fullPage = document.getPage(i);
                PDRectangle cropBoxORIG = fullPage.getCropBox();
                // make sure to have new objects
                PDRectangle cropBoxLeft = new PDRectangle(cropBoxORIG.getCOSArray());
                PDRectangle cropBoxRight = new PDRectangle(cropBoxORIG.getCOSArray());

                if (fullPage.getRotation() == 90 || fullPage.getRotation() == 270) {
                    cropBoxLeft.setUpperRightY(cropBoxORIG.getLowerLeftY() + cropBoxORIG.getHeight() / 2);
                    cropBoxRight.setLowerLeftY(cropBoxORIG.getLowerLeftY() + cropBoxORIG.getHeight() / 2);
                } else {
                    cropBoxLeft.setUpperRightX(cropBoxORIG.getLowerLeftX() + cropBoxORIG.getWidth() / 2);
                    cropBoxRight.setLowerLeftX(cropBoxORIG.getLowerLeftX() + cropBoxORIG.getWidth() / 2);
                }
                try {
                    fullPage.setCropBox(cropBoxLeft);
                    savePage(fullPage, splitDirectory, j++);
                }
                catch (Exception e) {
                    System.err.println(e);
                }
                fullPage.setCropBox(cropBoxRight);
                savePage(fullPage, splitDirectory, j++);
            }
        }
        return splitDirectory;
    }
    
    private static void savePage(PDPage croppedPage, Path directory, int index) throws Exception {
        Path pagePath = Paths.get(directory.toString(), directory.getFileName() + "_" + index + ".pdf");
        try (PDDocument doc = new PDDocument()) {
            doc.importPage(croppedPage);
            doc.save(pagePath.toFile());
        }
    }
}
