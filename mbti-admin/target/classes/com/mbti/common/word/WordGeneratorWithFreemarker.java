package com.mbti.common.word;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;

/**
 * @Description:word导出帮助类 通过freemarker模板引擎来实现
 * @author:LiaoFei
 * @date :2016-3-24 下午3:49:25
 * @version V1.0
 * 
 */
public class WordGeneratorWithFreemarker {
	private static Configuration configuration = null;

	static {
		configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassicCompatible(true);
		configuration.setClassForTemplateLoading(
				WordGeneratorWithFreemarker.class,
				"/com/mbti/common/word/ftl");

	}

	private WordGeneratorWithFreemarker() {

	}

	public static void createDoc(Map<String, Object> dataMap,String templateName, OutputStream out)throws Exception {
		Template t = configuration.getTemplate(templateName);
		t.setEncoding("utf-8");
		WordHtmlGeneratorHelper.handleAllObject(dataMap);

		try {
			Writer w = new OutputStreamWriter(out,Charset.forName("utf-8"));
			t.process(dataMap, w);
			w.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public static void main(String[] args) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("<div>");
		sb.append("<p>\r\n" + 
				"    <span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">理智、善分析、果断、意志坚定，以系统化的方式组织具体事实。喜欢事先组织细节和操作程序与他人一起完成任务</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">对组织的贡献</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">事先察觉、指出、修正不足之处 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">以逻辑的、客观的方式评论规划 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">组织规划、生产、人力要素，实现组织目标 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">监督工作以确保任务正确完成 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">以逐步进行的方式坚持到底 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">领导模式</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">直接领导，快速管理 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">运用过去经验解决问题 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">直接、明确地识别问题的核心 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">决策和执行决策非常迅速 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">传统型领导，尊重组织内部的等级和组织获得的成就 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">学习模式</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">积极主动型，学习间接经验，采用结构化的学习方式 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">实际型，关注他们能运用的学习内容 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">倾向性顺序</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">（</span>1<span style=\"font-family:宋体\">）思维，（</span><span style=\"font-family:Arial\">2</span><span style=\"font-family:宋体\">）感觉，（</span><span style=\"font-family:Arial\">3</span><span style=\"font-family:宋体\">）直觉，（</span><span style=\"font-family:Arial\">4</span><span style=\"font-family:宋体\">）情感 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">问题解决模式</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">喜欢根据相关的事实和细节进行逻辑分析，从而控制情境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">为达到理想结果，会考虑更广阔的前景以及对人们和自己的影响 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">工作环境倾向性</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">喜欢与努力工作、有坚定决心把工作做好的人共事 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">任务型定向的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">有组织和组织结构的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">有团队计划的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">提供稳定性和预测性的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">致力于绩效和生产性的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">奖励完成目标的环境 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">潜在的缺点</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">决策太迅速，也给他人施以同样的压力 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">不能察觉变革的需要，因为相信一切都在正常运作 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">在完成任务过程中，忽视人际间的小细节 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">长期忽视自己的感受和准则，可能会被自己的情感击跨 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><span style=\"font-family:宋体\">发展建议</span> </span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">决策之前需考虑各种因素，包括人的因素 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">需要促使自己看到他人要求变革而获得的利益 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">需做特别的努力学会赞赏别人 </span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\">Ø <span style=\"font-family:宋体\">需从工作中抽点时间考虑和识别自己的情感和价值观&nbsp;</span></span><span style=\";font-family:Arial;color:rgb(17,17,17);font-size:13px\"><br/></span>\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"    <br/>\r\n" + 
				"</p>");
		sb.append("</div>");
		RichHtmlHandler handler = new RichHtmlHandler(sb.toString());

//		handler.setDocSrcLocationPrex("file:///C:/8595226D");
//		handler.setDocSrcParent("file3405.files");
//		handler.setNextPartId("01D214BC.6A592540");
//		handler.setShapeidPrex("_x56fe__x7247__x0020");
//		handler.setSpidPrex("_x0000_i");
//		handler.setTypeid("#_x0000_t75");

		handler.handledHtml(false);

		String bodyBlock = handler.getHandledDocBodyBlock();
		System.out.println("bodyBlock:\n"+bodyBlock);

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

		String docFilePath = "d:\\temp.doc";
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
		
	}
}