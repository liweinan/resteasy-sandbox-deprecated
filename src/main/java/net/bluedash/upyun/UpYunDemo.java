import net.bluedash.upyun.UpYun;

import java.io.File;

public class UpYunDemo {
    public static void main(String[] args) throws Exception {
        /// 初始化空间
        UpYun upyun = new UpYun("bluedash", "bluedashbaby", "sun5kong");
        System.out.println("SDK 版本 " + upyun.version());
        /// 设置是否打印调试信息
        upyun.debug = true;

        /// 获取空间占用大小
        //long x = upyun.getBucketUsage();

        /// 获取某个目录的空间占用大小
        //long x = upyun.getFolderUsage("/aa1");

        /// 上传文件
        File file = new File("/Users/weli/Desktop/5181552580_9da3dbff5f_b-1.jpg");

        /// 设置待上传文件的 Content-MD5 值（如又拍云服务端收到的文件MD5值与用户设置的不一致，将回报 406 Not Acceptable 错误）
//        upyun.setContentMD5(upyun.md5(file));

        /// 设置待上传文件的 访问密钥（注意：仅支持图片空！，设置密钥后，无法根据原文件URL直接访问，需带 URL 后面加上 （缩略图间隔标志符+密钥） 进行访问）
        /// 如缩略图间隔标志符为 ! ，密钥为 bac，上传文件路径为 /folder/test.jpg ，那么该图片的对外访问地址为： http://空间域名/folder/test.jpg!bac
        // 		upyun.setFileSecret("bac");

        System.out.println(upyun.writeFile("/test.jpg", file));
        // System.out.println(upyun.writeFile("/a/b/c/google.jpg", file, true)); //可自动创建父级目录（最多10级）
        /// 获取上传文件后的信息（仅图片空间有返回数据）
        System.out.println(upyun.getWritedFileInfo("x-upyun-width")); // 图片宽度
        System.out.println(upyun.getWritedFileInfo("x-upyun-height")); // 图片高度
        System.out.println(upyun.getWritedFileInfo("x-upyun-frames")); // 图片帧数
        System.out.println(upyun.getWritedFileInfo("x-upyun-file-type")); // 图片类型


        // 普通上传模式
        /////// upyun.writeFile("/11/22/33/test.txt", "test file content", true); /// 是否自动创建父级目录（最多10级）
        /*byte[] data = new byte[(int)file.length()];
          is.read(data, 0, (int)file.length());
          is.close();
          System.out.println(upyun.writeFile("/jp1299041532485000.jpg", data));*/

        /*System.out.println(upyun.writeFile("/test.txt", "test file content"));
          */

        /*
          // 采用数据流模式上传文件（节省内存）
          /////// upyun.writeFile("/11/22/33/test.txt", file, true); /// 是否自动创建父级目录（最多10级）
          System.out.println(upyun.writeFile("/google-background.jpg", file));
          is.close();
          */

        /// 读取文件
        // String datas = upyun.readFile("/test.txt");

        /// 获取文件信息 返回 new HashMap<String, String>(); 或 null
        // System.out.println(upyun.getFileInfo("/google-background.jpg"));

        /// 采用数据流模式下载文件（节省内存）
        /*
          File file1 = new File("/tmp/test.jpg");
          System.out.println(upyun.readFile("/test.jpg", file1));
          */

        /// 删除文件
        // upyun.deleteFile("/google-background.jpg")

        /// 创建目录
        // upyun.mkDir("/test");
        //// upyun.mkDir("/a/b/c/d/e/f/test"); //可自动创建父级目录（最多10级）

        /// 删除目录
        // upyun.rmDir("/test");


        /// 读取目录
        /*List<UpYun.FolderItem> items = upyun.readDir("/");
          for(int i=0;i<items.size();i++){
              System.out.println(items.get(i).name);
              System.out.println(items.get(i).type);
          }*/
    }
}
