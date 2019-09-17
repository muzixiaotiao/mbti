package com.mbti.common.utils;

import com.mbti.common.word.RichHtmlHandler;
import com.mbti.common.word.WordGeneratorWithFreemarker;
import com.mbti.modules.platform.entity.UserEntity;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: xiaoqx
 * @date: 2019-09-05 10:04
 * @description: 文档操作
 **/
public class PoiUtils {

    /**
     * 直接将word内容 输出到文件流 下载
     * @param request
     * @param response
     * @param title
     * @param content
     */
    public static void downloadWordFile(HttpServletRequest request, HttpServletResponse response, String title, String content) {
        try {
            //word内容
            byte b[] = content.getBytes("GBK");
            ByteArrayInputStream bais = new ByteArrayInputStream(b);
            /*
             * 关键地方
             * 生成word格式 */
            POIFSFileSystem poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
            //输出文件
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    new String(title.getBytes("GB2312"),"iso8859-1") + ".doc");
            ServletOutputStream ostream = response.getOutputStream();
            poifs.writeFilesystem(ostream);
            ostream.close();
            bais.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 将word内容写入本地文件
     * @param content word详情
     * @param filePath 相对路径
     * @param basePath 根路径
     */
    public static void saveWordFile(String content, String filePath, String basePath) {
        try {
            //word内容
            //这里是必须要设置编码的，不然导出中文就会乱码。
//            byte b[] = content.getBytes("GBK");
//            //将字节数组包装到流中
//            ByteArrayInputStream bais = new ByteArrayInputStream(b);
//            /*
//             * 关键地方
//             * 生成word格式 */
//            POIFSFileSystem poifs = new POIFSFileSystem();
//            DirectoryEntry directory = poifs.getRoot();
//            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
//            //保存文件至本地
//            FileOutputStream ostream = new FileOutputStream(basePath + filePath);
//            poifs.writeFilesystem(ostream);
//            bais.close();
//            ostream.close();
            HashMap<String, Object> data = new HashMap<String, Object>();
            StringBuilder sb = new StringBuilder();
            sb.append("<div>");
            sb.append(content);
            sb.append("</div>");
            RichHtmlHandler handler = new RichHtmlHandler(sb.toString());
            String bodyBlock = handler.getHandledDocBodyBlock();
            String handledBase64Block = "";
            if (handler.getDocBase64BlockResults() != null
                    && handler.getDocBase64BlockResults().size() > 0) {
                for (String item : handler.getDocBase64BlockResults()) {
                    handledBase64Block += item + "\n";
                }
            }
            data.put("imagesBase64String", handledBase64Block);
            String xmlimaHref = "";
            if (handler.getXmlImgRefs() != null
                    && handler.getXmlImgRefs().size() > 0) {
                for (String item : handler.getXmlImgRefs()) {
                    xmlimaHref += item + "\n";
                }
            }
            data.put("content", bodyBlock);
            String docFilePath = basePath + filePath;
            System.out.println(docFilePath);
            File f = new File(docFilePath);
            OutputStream out;
            try {
                out = new FileOutputStream(f);
                WordGeneratorWithFreemarker.createDoc(data, "report.ftl", out);

            } catch (FileNotFoundException e) {

            } catch (MalformedTemplateNameException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 根据已存在的文件，进行压缩，批量下载
     * @param response
     * @param zipName 压缩包名
     * @param userList 用户列表
     * @param basePath 文件根目录mobi
     */
    public static void downloadWordFileMany(HttpServletResponse response, String zipName, List<UserEntity> userList, String basePath){
        try{
            response.reset();
            String filePath = "";
            response.reset();
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + zipName + ".zip");
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            BufferedOutputStream bos = new BufferedOutputStream(zos);
            for(UserEntity user : userList){
                filePath = basePath + user.getFilePath();
                File file = new File(filePath);
                //将需要压缩的文件格式化为输入流
                FileInputStream zipSource = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(zipSource, 1024 * 10);
                zos.putNextEntry(new ZipEntry(user.getMobile()+".doc"));
                int len = 0;
                byte[] buf = new byte[10 * 1024];
                while( (len=bis.read(buf, 0, buf.length)) != -1){
                    bos.write(buf, 0, len);
                }
                bis.close();
                bos.flush();
            }
            bos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static HttpServletResponse downloadFile(String path, HttpServletRequest request, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                filename = URLEncoder.encode(filename, "UTF-8");
            } else {
                filename = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
            response.addHeader("Content-Length", "" + file.length());
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", filename));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setCharacterEncoding("UTF-8");

            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
