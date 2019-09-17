package com.mbti;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/9/12 9:17
 * @Version 1.0
 */
public class Test {

    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

    /**
     * @param htmlStr
     * @return
     * 删除Html标签
     */
    public static String delHTMLTag(String htmlStr) {
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        return htmlStr.trim(); // 返回文本字符串
    }

    public static String getTextFromHtml(String htmlStr){
        htmlStr = delHTMLTag(htmlStr);
        htmlStr = htmlStr.replaceAll("&nbsp;", "");
// htmlStr = htmlStr.substring(0, htmlStr.indexOf("。")+1);
        return htmlStr;
    }

    public static void main(String[] args) {
        String str = "<p>\n" +
                "    <span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">理智、善分析、果断、意志坚定，以系统化的方式组织具体事实。喜欢事先组织细节和操作程序与他人一起完成任务</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">对组织的贡献</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">事先察觉、指出、修正不足之处 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">以逻辑的、客观的方式评论规划 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">组织规划、生产、人力要素，实现组织目标 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">监督工作以确保任务正确完成 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">以逐步进行的方式坚持到底 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">领导模式</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">直接领导，快速管理 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">运用过去经验解决问题 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">直接、明确地识别问题的核心 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">决策和执行决策非常迅速 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">传统型领导，尊重组织内部的等级和组织获得的成就 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">学习模式</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">积极主动型，学习间接经验，采用结构化的学习方式 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">实际型，关注他们能运用的学习内容 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">倾向性顺序</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">（</span>1<span style=\"font-family:宋体\">）思维，（</span><span style=\"font-family:Arial\">2</span><span style=\"font-family:宋体\">）感觉，（</span><span style=\"font-family:Arial\">3</span><span style=\"font-family:宋体\">）直觉，（</span><span style=\"font-family:Arial\">4</span><span style=\"font-family:宋体\">）情感 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">问题解决模式</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">喜欢根据相关的事实和细节进行逻辑分析，从而控制情境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">为达到理想结果，会考虑更广阔的前景以及对人们和自己的影响 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">工作环境倾向性</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">喜欢与努力工作、有坚定决心把工作做好的人共事 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">任务型定向的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">有组织和组织结构的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">有团队计划的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">提供稳定性和预测性的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">致力于绩效和生产性的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">奖励完成目标的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">潜在的缺点</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">决策太迅速，也给他人施以同样的压力 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">不能察觉变革的需要，因为相信一切都在正常运作 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">在完成任务过程中，忽视人际间的小细节 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">长期忽视自己的感受和准则，可能会被自己的情感击跨 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">发展建议</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">决策之前需考虑各种因素，包括人的因素 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">需要促使自己看到他人要求变革而获得的利益 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">需做特别的努力学会赞赏别人 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">需从工作中抽点时间考虑和识别自己的情感和价值观&nbsp;</span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span>\n" +
                "</p>\n" +
                "<p>\n" +
                "    <br/>\n" +
                "</p>";
        System.out.println(getTextFromHtml(str));
    }
}
