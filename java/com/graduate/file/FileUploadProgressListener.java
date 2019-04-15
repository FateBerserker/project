package com.graduate.file;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;
/**
 * 
 * @Discription: 监听文件上传的进度信息   
 * @Author: JiangChunLin  
 * @ClassName: FileUploadProgressListener  
 * @Date: 2019年2月15日 上午10:32:05  
 * @Version: 1.0.0 Graduate
 */
@Component
public class FileUploadProgressListener implements ProgressListener{
	private HttpSession session;
	/**
	 * 
	 *  @Discription: 保存文件上传状态
	 *  @Author: JiangChunLin
	 *  @param session
	 *  @Date: 2019年4月13日下午5:33:16
	 */
	public void setSession(HttpSession session){
		this.session=session;
		FileUploadStatus fileUploadStatus=new FileUploadStatus();
		this.session.setAttribute("fileUploadStatus", fileUploadStatus);
	}
	/**
	 * 
	 *  @Description: 更新文件上传的进度
	 *  @Author: JiangChunLin
	 *  @see org.apache.commons.fileupload.ProgressListener#update(long, long, int)
	 */
	@Override
	public void update(long readedBytes, long totalBytes, int index) {
		FileUploadStatus fileUploadStatus=(FileUploadStatus) session.getAttribute("fileUploadStatus");
		fileUploadStatus.setReadedBytes(readedBytes);
		fileUploadStatus.setTotalBytes(totalBytes);
		fileUploadStatus.setFileItems(index);
		
	}

}
