# PDF Splicer
Quickly split PDF pages into separate PDF files, or go the other way and combine multiple PDF files into multiple pages of a single PDF file.

## Prerequisites
You will need the Java runtime installed to be able to execute this program.

## How to run
* Head to the [Releases](https://github.com/jeffrpowell/PDFSplicer/releases) section of this repository and download the latest-versioned `jar` file.
* Execute the jar by running the following in your terminal:
```
java -jar <path/to/PDFSplicer-version.jar>
```

## Usage

### Splitting apart PDF pages

* Click the `Select File to Fplit Fpart` button, select your file, then click the large `Split File` button. 
  * The program will create a new folder in the same location as the file with the file's same name, and the separate pages will be saved to this new folder.

### Joining PDF files together
* Click the `Add Files to Join` button and select which files you would like to join together. 
  * Be sure they appear in the file-preview list in the order in which you would like them to be joined together. If you make a mistake, a `Remove Selected Files` button is provided to facilitate reordering. 
* Click on the `Name of New File` button, then type in the name of your new file in the file dialog.
* When satisfied, click the `Join Files` button. The new file will be saved in the location you specified in the `Name of New File` dialog.

## Questions/Bugs
* Feel free to make an [issue](https://github.com/jeffrpowell/PDFSplicer/issues), or (even butter) a [pull request](https://github.com/jeffrpowell/PDFSplicer/pulls).