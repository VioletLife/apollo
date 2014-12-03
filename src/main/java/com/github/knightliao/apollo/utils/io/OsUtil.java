package com.github.knightliao.apollo.utils.io;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author knightliao
 * 
 */
public final class OsUtil {

    private OsUtil() {

    }

    /**
     * 建多层目录
     * 
     * @param filePath
     * @return boolean
     * @throws
     * @Description: make directory
     */
    public static boolean makeDirs(final String filePath) {
        File f = new java.io.File(filePath);
        if (!f.exists()) {
            return f.mkdirs();
        }

        return true;
    }

    /**
     * @param filePathString
     * @return boolean
     * @throws Exception
     * @Description: 文件或目录是否存在
     * @author liaoqiqi
     * @date 2013-6-13
     */
    public static boolean isFileExist(final String filePathString) throws Exception {

        File f = new File(filePathString);
        return f.exists();
    }

    /**
     * @param pathElements
     * @return boolean
     * @throws Exception
     * @Description: JOIN PATH
     * @author liaoqiqi
     * @date 2013-6-13
     */
    public static String pathJoin(final String...pathElements) {

        final String path;

        if (pathElements == null || pathElements.length == 0) {
            path = File.separator;

        } else {

            final StringBuffer sb = new StringBuffer();

            for (final String pathElement : pathElements) {

                if (pathElement.length() > 0) {
                    sb.append(pathElement);
                    sb.append(File.separator);
                }
            }

            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }

            path = sb.toString();
        }

        return (path);
    }

    /**
     * 获取File相对于Folder的相对路径
     * <p/>
     * returns null if file isn't relative to folder
     */
    public static String getRelativePath(File file, File folder) {

        String filePath = file.getAbsolutePath();
        String folderPath = folder.getAbsolutePath();

        if (filePath.startsWith(folderPath)) {
            return filePath.substring(folderPath.length() + 1);
        } else {
            return null;
        }
    }

    /**
     * @param src
     * @param dest
     * @return void
     * @Description: 转移文件
     * @author liaoqiqi
     * @date 2013-6-20
     */
    public static void transferFile(File src, File dest) throws Exception {

        // 删除文件
        // LOGGER.info("start to remove download file: " + ""
        // + dest.getAbsolutePath());
        if (dest.exists()) {
            dest.delete();
        }

        // 转移临时下载文件至下载文件夹
        FileUtils.copyFile(src, dest);
    }
}
