package Logger.utils;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
    /**
     * Appends message inside the file identified by the path
     * @param filePath The path of the file in which we want to write
     * @param message  The text we want to write.
     */
    public static void write(String filePath, String message) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(message);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get the filename without the extension.
     * @param file the file we want to get the name from.
     * @return the name of the file without the extension.
     */
    public static String getFileBaseName(File file) {
        String fileName = file.getName();
        if (fileName.indexOf(".") > 0) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return fileName;
        }
    }

    /**
     * make a compressed tar.gz copy of a file.
     * @param logFile the file we want to compress
     * @param archiveName the name of the new compressed archive.
     */
    public static void compress(File logFile, String archiveName) {
        String filePath = logFile.getPath();
        String folderPath = logFile.getParentFile().toString();
        try(
                OutputStream fOut = Files.newOutputStream(
                Paths.get(folderPath,archiveName + ".tar.gz"));
                BufferedOutputStream buffOut =
                        new BufferedOutputStream(fOut);
                GzipCompressorOutputStream gzOut =
                        new GzipCompressorOutputStream(buffOut);
                TarArchiveOutputStream tOut =
                        new TarArchiveOutputStream(gzOut)
            ){
            TarArchiveEntry tarEntry =
                    new TarArchiveEntry(logFile,logFile.getName());
            tOut.putArchiveEntry(tarEntry);

            // copy file to TarArchiveOutputStream
            Files.copy(Path.of(filePath), tOut);
            tOut.closeArchiveEntry();
            tOut.finish();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
