package bn.test.smlcs.util;

import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void main(String[] args) {
		String path = "E:\\workspace\\refresh-http\\report\\report.html";
		SendMail.sendMail("smtp.qq.com","408129370@qq.com","rpmzcfdoewbcbiej", "测试报告","408129370@qq.com",
				new String[]{"408129370@qq.com"}, new String[0], new String[0], new String[]{path},new String[0],"FYI");
	}

	public static void sendMail(String sHost, String sUser, String sPwd, String sSubject,
			String sFrom, String[] sTo, String[] sCc, String[] sBcc, String[] sAttachsPath, 
			String[] sImgs_Path,String sContentFormat){
		Properties prop = new Properties();
		prop.setProperty("mail.host", sHost);
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.port", "587");
		
		try{
			//1、创建session
			Session session = Session.getInstance(prop);
//			session.setDebug(true);//开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
			//2、通过session得到transport对象
			Transport ts = session.getTransport();
			//3、使用邮箱的用户名和密码连上邮件服务器
			ts.connect(sHost, sUser, sPwd);
			//4、创建邮件
			Message message = createMail(session, sSubject, sFrom, sTo, sCc, sBcc, sAttachsPath, 
					sImgs_Path,sContentFormat);
			//5、发送邮件
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch(Exception e){
			e.printStackTrace();
		}		
	}

	private static MimeMessage createMail(Session session, String sSubject, String sFrom, String[] sTo, 
			String[] sCc, String[] sBcc, String[] sAttachsPath, String[] sImgs_Path, 
			String sContentFormat) throws Exception {
		//创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //发件人
        message.setFrom(new InternetAddress(sFrom));
        //收件人
        InternetAddress[] ToAddress = new InternetAddress[sTo.length];
		for (int i = 0; i < sTo.length; i++)
			ToAddress[i] = new InternetAddress(sTo[i]);
		message.setRecipients(Message.RecipientType.TO, ToAddress);
		//抄送人
		if(sCc != null){
			InternetAddress[] CcAddress = new InternetAddress[sCc.length];
			for (int i = 0; i < sCc.length; i++)
				CcAddress[i] = new InternetAddress(sCc[i]);
			message.setRecipients(Message.RecipientType.CC, CcAddress);
		}		
		//密送人
		if(sBcc != null){
			InternetAddress[] BccAddress = new InternetAddress[sBcc.length];
			for (int i = 0; i < sBcc.length; i++)
				BccAddress[i] = new InternetAddress(sBcc[i]);
			message.setRecipients(Message.RecipientType.BCC, BccAddress);
		}		
        //标题
        message.setSubject(sSubject);
        //正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(sContentFormat, "text/html;charset=UTF-8");
        
        //图片
        ArrayList<MimeBodyPart> aryImage = new ArrayList<MimeBodyPart>();
        if(sImgs_Path != null){        	
        	for (int i = 0; i < sImgs_Path.length; i++){
        		DataHandler dh = new DataHandler(new FileDataSource(sImgs_Path[i]));
        		MimeBodyPart image = new MimeBodyPart();
        		image.setDataHandler(dh);
        		image.setContentID("ImgPic" + i);
        		aryImage.add(image);
        	}
        }
        
        //描述关系:正文和图片
        MimeMultipart mmPic = new MimeMultipart();
        mmPic.addBodyPart(text);
        for(MimeBodyPart m : aryImage){
        	mmPic.addBodyPart(m);
        }
        mmPic.setSubType("related");
        
        //附件
        ArrayList<MimeBodyPart> aryAttach = new ArrayList<MimeBodyPart>();
        if(sAttachsPath != null){
        	for (int i = 0; i < sAttachsPath.length; i++){
        		MimeBodyPart attach = new MimeBodyPart();
                DataHandler dh = new DataHandler(new FileDataSource(sAttachsPath[i]));
                attach.setDataHandler(dh);
                attach.setFileName(dh.getName());
                aryAttach.add(attach);
        	}
        }
        //描述关系:正文和附件
        MimeMultipart mmAttach = new MimeMultipart();
        for(MimeBodyPart m : aryAttach){
        	mmAttach.addBodyPart(m);
        }
        
        //代表正文的bodypart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mmPic);
        mmAttach.addBodyPart(content);
        mmAttach.setSubType("mixed");
        
        message.setContent(mmAttach);
        message.saveChanges();
        
        //将邮件保存为文件
//      message.writeTo(new FileOutputStream("mail.eml"));
        //返回创建好的的邮件
        return message;
    }

}
