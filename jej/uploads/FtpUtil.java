package com.jeanneeetjean.jej.uploads;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FtpUtil {
    public static FTPClient ftp = new FTPClient();
    public static boolean uploadFile(String host, int port, String username, String password,
                                     String basePath, String filePath, String filename, InputStream input) {

        Boolean result = false;
        try {

            ftp.connect(host, port);

                ftp.login(username, password);
                ftp.enterLocalPassiveMode();
                int reply = ftp.getReplyCode();

                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftp.disconnect();
                    return result;
                }

                String path = basePath + filePath;
                if (!ftp.changeWorkingDirectory(path)) {

                    String[] dirs = path.split("/");
                    StringBuffer tempPath = new StringBuffer();
                    for (String dir : dirs) {
                        if (null == dir || "".equals(dir)) {
                            continue;
                        }
                        tempPath.append("/").append(dir);
                        if (!ftp.changeWorkingDirectory(tempPath.toString())) {
                            if (!ftp.makeDirectory(tempPath.toString())) {
                                return result;
                            } else {
                                ftp.changeWorkingDirectory(tempPath.toString());
                            }
                        }
                    }
                }

                ftp.setFileType(FTP.BINARY_FILE_TYPE);
                if (!ftp.storeFile(filename, input)) {
                    return result;
                }
                input.close();
                ftp.logout();
                result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }


    public static List<String> udownLoadFile(String host, int port, String username, String password,
                                             String remotePath) {
        try {
            int reply;
            ftp.connect(host, port);
                ftp.login(username, password);
                ftp.enterLocalPassiveMode();
                        reply = ftp.getReplyCode();
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftp.disconnect();

                }
                ftp.changeWorkingDirectory(remotePath);
                FTPFile[] fs = ftp.listFiles();
            return Arrays.stream(fs)
                    .map(FTPFile::getName)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {

                }
            }

        }


        return null;
    }

}