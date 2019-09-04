package com.hndl.cn.utils.sensitive;

import com.hndl.cn.utils.collection.CollectionUtils;

import java.util.*;

/**
 * @program:hndl-platform
 * @description: 敏感词
 * @author: 易成贤
 * @create: 2019-05-26 17:07
 * @Created by湖南达联
 **/

/**
 * 利用红黑树查找，每一个节点都是一个屏蔽字
 */
public class SensitiveWord extends HashMap<Character, SensitiveWord> {
    //自定义序列化号
    private static final long serialVersionUID = -4646423269465809276L;

    //敏感词字符末尾标识，用于标识单词末尾字符
    private final Set<Character> endCharacterSet = new HashSet<>();


    /**
     * 增加一组单词
     * @param words 单词集合
     */
    public void addWords(Collection<String> words){
        if(false == (words instanceof Set)){
            words = new HashSet<>(words);
        }
        for (String word : words) {
            addWord(word);
        }
    }

    /**
     * 添加单词，一个一个加
     * @param word 单词
     */
    public void addWord(String word) {
        SensitiveWord parent = null;
        SensitiveWord current = this;
        SensitiveWord child;
        char currentChar = 0;
        int length = word.length();
        for(int i = 0; i < length; i++){
            currentChar = word.charAt(i);
            if(false == StopChar.isStopChar(currentChar)){//只处理合法字符
                child = current.get(currentChar);
                if(child == null){
                    //无子类，新建一个子节点后存放下一个字符
                    child = new SensitiveWord();
                    current.put(currentChar, child);
                }
                parent = current;
                current = child;
            }
        }
        if(null != parent){
            parent.setEnd(currentChar);
        }
    }

    /**
     * 获得第一个匹配的关键字
     * @param text 被检查的文本
     * @return 匹配到的关键字
     */
    public String match(String text){
        if(null == text){
            return null;
        }
        List<String> matchAll = matchAll(text, 1);
        if(CollectionUtils.isNotEmpty(matchAll)){
            return matchAll.get(0);
        }
        return null;
    }
    /**
     * 设置是否到达末尾
     * @param c 结尾字符
     */
    private void setEnd(Character c){
        if(null != c){
            this.endCharacterSet.add(c);
        }
    }
    /**
     * 是否末尾
     * @param c 检查的字符
     * @return 是否末尾
     */
    private boolean isEnd(Character c){
        return this.endCharacterSet.contains(c);
    }

    /**
     * 找出所有匹配的关键字
     * @param text 被检查的文本
     * @param limit 限制匹配个数
     * @return 匹配的词列表
     */
    public List<String> matchAll(String text, int limit) {
        return matchAll(text, limit, false, false);
    }

    /**
     * 找出所有匹配的关键字<br>
     * 密集匹配原则：假如关键词有 ab,b，文本是abab，将匹配 [ab,b,ab]<br>
     * 贪婪匹配（最长匹配）原则：假如关键字a,ab，最长匹配将匹配[a, ab]
     *
     * @param text 被检查的文本
     * @param limit 限制匹配个数
     * @param isDensityMatch 是否使用密集匹配原则
     * @param isGreedMatch 是否使用贪婪匹配也就是最长匹配原则
     * @return 匹配的词列表
     */
    public List<String> matchAll(String text, int limit, boolean isDensityMatch, boolean isGreedMatch) {
        if(null == text){
            return null;
        }

        List<String> findedWords = new ArrayList<String>();
        SensitiveWord current = this;
        int length = text.length();
        StringBuilder wordBuffer = new StringBuilder();//存放查找到的字符缓存。完整出现一个词时加到findedWords中，否则清空
        char currentChar;
        for (int i = 0; i < length; i++) {

            for (int j = i; j < length; j++) {
                currentChar = text.charAt(j);
                if(StopChar.isStopChar(currentChar)){
                    if(wordBuffer.length() > 0){
                        //做为关键词中间的停顿词被当作关键词的一部分被返回
                        wordBuffer.append(currentChar);
                    }else{
                        //停顿词做为关键词的第一个字符时需要跳过
                        i++;
                    }
                    continue;
                }else if(false == current.containsKey(currentChar)){
                    //非关键字符被整体略过，重新以下个字符开始检查
                    break;
                }
                wordBuffer.append(currentChar);
                if(current.isEnd(currentChar)){
                    //到达单词末尾，关键词成立，从此词的下一个位置开始查找
                    findedWords.add(wordBuffer.toString());
                    if(limit > 0 && findedWords.size() >= limit){
                        //超过匹配限制个数，直接返回
                        return findedWords;
                    }
                    if(false == isDensityMatch){
                        //如果非密度匹配，跳过匹配到的词
                        i = j;
                    }
                    if(false == isGreedMatch){
                        //如果懒惰匹配（非贪婪匹配）。当遇到第一个结尾标记就结束本轮匹配
                        break;
                    }
                }
                current = current.get(currentChar);
                if(null == current){
                    break;
                }
            }
            current = this;
        }
        return findedWords;
    }
}
