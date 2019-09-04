package com.hndl.cn.utils.sensitive;

import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * @program:hndl-platform
 * @description: 敏感词工具 未完成
 * @author: 易成贤
 * @create: 2019-05-26 17:32
 * @Created by湖南达联
 **/
public class SensitiveUtil {
    private final String ENCODING = "UTF-8";    //字符编码
    private static final SensitiveWord sensitiveWord = new SensitiveWord();
    private static ExecutorService executor;

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 读取词典
     */
    public Set<String> readDir( String path ) throws Exception {
        Set<String> set = null;
        //获取敏感词词典存放路径
        if (path.contains("\\.dir")) {
            throw new Exception("配置词典文件类型必须是dir");
        }
        File file = new File(path);
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), ENCODING);
        try {
            //文件流是否存在
            if (file.isFile() && file.exists()) {
                set = new HashSet<String>();
                BufferedReader bufferedReader = new BufferedReader(read);
                String dir ;
                //读取文件，将文件内容放入到set中
                while ((dir = bufferedReader.readLine()) != null) {
                    set.add(dir);
                }
            }
        }finally {
            //关闭流
            read.close();
        }
        return set;
    }


    /**
     * 初始化敏感词树
     *
     * @param sensitiveWords 敏感词列表
     */
    public void init(Collection<String> sensitiveWords) {
        sensitiveWord.clear();
        sensitiveWord.addWords(sensitiveWords);
    }



   /**
     * 初始化敏感词树
     *
     * @param isAsync        是否异步初始化
     * @param sensitiveWords 敏感词列表
     */
    public void init(final Collection<String> sensitiveWords, boolean isAsync) {
        if (isAsync) {
            executor.submit(() -> {
                init(sensitiveWords);
                return true;
            });
        } else {
            init(sensitiveWords);
        }
    }

    /**
     * 查找敏感词，返回找到的第一个敏感词
     *
     * @param text 文本
     * @return 敏感词
     */
    public static String getFindedFirstSensitive(String text) {
        return sensitiveWord.match(text);
    }

    //加载敏感词
    public void initDir(){
        try {
            //init(readDir(),false);
        }catch (Exception e){
            System.out.printf(new Date()+"加载敏感词失败!");
            e.printStackTrace();
        }

    }
}
