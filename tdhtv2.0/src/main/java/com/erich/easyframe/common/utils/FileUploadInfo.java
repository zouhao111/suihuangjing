package com.erich.easyframe.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.springframework.util.Assert;

/**
 * 文件上传辅助类,封装了对上传文件的解析信息.
 * <p>
 * 由 {@link FileUploadParser#parse(HttpServletRequest)}</br> 或
 * {@link FileUploadParser#parse(HttpServletRequest, String)}<br/>
 * 产生,作用如下:<br/>
 * <li>封装了对上传文件及附带表单字段内容的解析.</li>
 * <li>提供若干函数获取如文件名,文件流,参数值等常用信息.</li>
 * <li>支持不同字符集</li>
 * </p>
 * <br/>
 * <br/>
 * <p>
 * 用法举例:<br/>
 * 1.从表单中获取参数:<br/>
 * <code>String value = fileUploadInfo.getParameter("parameterName");</code><br/>
 * <strong>*其内部使用了fileItem.getString(encoding),支持不同的编码,编码由FileUploadParser.
 * parse提供</strong><br/>
 * 2.取得上传文件的输入流<br/>
 * <code>InputStream inputStream = fileUploadInfo.getFileInputStream("fileFieldName");</code>
 * <br/>
 * 3.取得上传文件的文件名<br/>
 * <code>String fileName = fileUploadInfo.getFileName("fileFieldName")</code><br/>
 * </p>
 * @author ZhengJinLing
 * @since 1.0
 */
public class FileUploadInfo {

	/**
	 * 包级私有构造函数,由{@link FileUploadParser}类创建,需要解析后的FileItem列表及字符集.
	 * 
	 * @param fileItems
	 *            解析后的FileItem列表
	 * @param currentEncoding
	 *            字符集
	 */
	protected FileUploadInfo(List<FileItem> fileItems, String currentEncoding) {
		this.fileItems = fileItems;
		this.currentEncoding = currentEncoding;
	}

	/**
	 * 取得表单中的参数值.使用由{@link FileUploadParser}类解析时使用的字符集编码.
	 * 
	 * @param name
	 *            表单参数名
	 * @return 参数值
	 */
	public String getParameter(String name) {
		FileItem fileItem = this.getFormFileItem(name);
		if (null == fileItem) {
			return null;
		}
		try {
			return fileItem.getString(this.currentEncoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(String.format("不支持的字符编码[%s]", this.currentEncoding));
		}
	}

	/**
	 * 获取上文件的文件输入流.若未找到指定名称的被上传文件,返回<code>null</code>.
	 * 
	 * @param name
	 *            上传文件在表单中的字段名
	 * @return 上传文件的输入流
	 */
	public InputStream getFileInputStream(String name) {
		FileItem fileItem = this.getFileFileItem(name);
		if (null == fileItem) {
			return null;
		}
		try {
			return fileItem.getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(String.format("无法从[%s]获取文件输入流.", name));
		}
	}

	/**
	 * 获取上传的文件的大小,若未找到指定名称的被上传文件,返回<code>-1</code>.
	 * 
	 * @param name
	 *            上传文件在表单中的字段名
	 * @return 上传的文件的大小
	 */
	public long getFileSize(String name) {
		FileItem fileItem = this.getFileFileItem(name);
		if (null == fileItem) {
			return -1L;
		}
		return fileItem.getSize();
	}

	/**
	 * 获取上传客户端提供的位于客户机文件系统上的原始文件名.
	 * <p>
	 * 在IE,火狐等大多数浏览器中,返回值仅包含文件名而不含文件路径.但像Opera等会包含文件路径.
	 * </p>
	 * 
	 * @param name
	 *            上传文件在表单中的字段名
	 * @return 文件名
	 */
	public String getFilePath(String name) {
		FileItem fileItem = this.getFileFileItem(name);
		if (null == fileItem) {
			return null;
		}
		return fileItem.getName();
	}

	/**
	 * 获取上传客户端提供的位于客户机文件系统上的原始文件名.
	 * <p>
	 * 在IE,火狐等大多数浏览器中,浏览器仅返回文件名而不含文件路径,因此此值即为原始值.<br/>
	 * 但像Opera等会包含文件路径,此时返回值将是去掉路径后的文件名称.
	 * </p>
	 * 
	 * @param name
	 *            上传文件在表单中的字段名
	 * @return 文件名
	 */
	public String getFileName(String name) {
		String filePath = this.getFilePath(name);
		if (null == filePath) {
			return null;
		}
		String fileName = filePath;
		int lastSlashPosition = fileName.lastIndexOf(File.separator);
		if (-1 != lastSlashPosition) {
			fileName = fileName.substring(lastSlashPosition + 1);
		}
		return fileName;
	}

	/**
	 * 获取最基本的文件名,即去掉文件路径及扩展名后的文件名.
	 * 
	 * @param name
	 *            上传文件在表单中的字段名
	 * @return 最基本的文件名
	 */
	public String getSimpleFileName(String name) {
		String fileName = this.getFileName(name);
		if (null == fileName) {
			return null;
		}
		String simpleFileName = fileName;
		int lastDotPosition = simpleFileName.lastIndexOf(".");
		if (-1 != lastDotPosition) {
			simpleFileName = simpleFileName.substring(0, lastDotPosition);
		}
		return simpleFileName;
	}

	/**
	 * 获取文件的扩展名.
	 * 
	 * @param name
	 *            上传文件在表单中的字段名
	 * @return 文件的扩展名
	 */
	public String getFileExtName(String name) {
		String fileName = this.getFileName(name);
		if (null == fileName) {
			return null;
		}
		String fileExtName = "";
		int lastDotPosition = fileName.lastIndexOf(".");
		if (-1 != lastDotPosition) {
			fileExtName = fileName.substring(lastDotPosition + 1);
		}
		return fileExtName;
	}

	/**
	 * 获取ContentType信息.可能为<code>null</code>.
	 * 
	 * @param name
	 *            表单中的字段名称
	 * @return ContentType信息
	 */
	public String getContentType(String name) {
		FileItem fileItem = this.getFileFileItem(name);
		if (null == fileItem) {
			return null;
		}
		return fileItem.getContentType();
	}

	/**
	 * 获取指定名称的代表文件的FileItem对象.如果未找到返回<code>null</code>.
	 * 
	 * @param name
	 *            字段名称
	 * @return 指定名称的代表文件的FileItem对象
	 */
	public FileItem getFileFileItem(String name) {
		return this.getFileItem(name, false);
	}

	/**
	 * 获取指定名称的代表普通字段的FileItem对象.如果未找到返回<code>null</code>.
	 * 
	 * @param name
	 *            字段名称
	 * @return 指定名称的代表普通字段的FileItem对象
	 */
	public FileItem getFormFileItem(String name) {
		return this.getFileItem(name, true);
	}

	/**
	 * 返回所有的FileItem对象,包含FormField和非FormField.
	 * 
	 * @return 所有的FileItem对象
	 */
	public List<FileItem> getFileItems() {
		return this.fileItems;
	}

	private FileItem getFileItem(String name, boolean isFormFileItem) {
		Assert.hasText(name, "文件名称必须指定");
		for (FileItem fileItem : this.fileItems) {
			if (isFormFileItem != fileItem.isFormField()) {
				continue;
			}
			if (name.equals(fileItem.getFieldName())) {
				return fileItem;
			}
		}
		return null;
	}

	private List<FileItem> fileItems = null;
	private String currentEncoding = null;
}
