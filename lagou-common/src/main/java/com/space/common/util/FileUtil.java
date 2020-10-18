package com.space.common.util;

import cn.hutool.core.exceptions.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * @Author LUOZHENGCHAO674
 * @Date 2020-1-17 14:54
 */
@Slf4j
public class FileUtil extends cn.hutool.core.io.FileUtil {


    public static String getMd5ByFile(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            log.error("FileUtil_getMd5ByFile_Exception_e={}", ExceptionUtil.stacktraceToString(e));
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("FileUtil_getMd5ByFile_IOException_e={}", ExceptionUtil.stacktraceToString(e));
                }
            }
        }
        return value;
    }

    /**
     * 获取上传文件的md5
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getMultipartFileMd5(MultipartFile file) {

        try {
            byte[] uploadBytes = file.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(uploadBytes);
            String hashString = new BigInteger(1, digest).toString(16);
            return hashString;
        } catch (Exception e) {
            log.error("FileUtil_getMultipartFileMd5_Exception_e={}", ExceptionUtil.stacktraceToString(e));
        }
        return null;

    }
}