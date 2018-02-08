package com.erich.easyframe.common.utils;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;


/**
 * 包含文件上传信息的Request解析工具类.
 * <p>
 * 它的两个parse函数将返回{@link FileUploadInfo}对象.后者封装了表单信息.
 * </p>
 * <br/>
 * <p>
 * 使用方式举例:<br/>
 * 1.解析Request,使用默认字符集(<strong>UTF-8</strong>)<br/>
 * <code>FileUploadInfo fileUploadInfo = FileUploadParser.parse(request);</code>
 * <br/>
 * 2.解析Request,使用指定的字符集<br/>
 * <code>FileUploadInfo fileUploadInfo = FileUploadParser.parse(request,"GBK");</code>
 * <br/>
 * </p>
 * @author ZhengJinLing
 * @since 1.0
 */
public class FileUploadParser {

	public static FileUploadParser fileUploadParser = null;
	int maxMemSize = 500 * 1024;// 缓存 字节
	int fileSizeMax = 800 * 1024;// 单个文件最大大小
	int maxFileSize = 800 * 1024; // 总最大上传文件大小 KB

	public FileUploadParser() {
		this.servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
	}

	public static FileUploadParser getInstance() {
		if (null == fileUploadParser) {
			fileUploadParser = new FileUploadParser();
		}
		return fileUploadParser;
	}

	public FileUploadParser(DiskFileItemFactory fileItemFactory) {
		this.servletFileUpload = new ServletFileUpload(fileItemFactory);
	}

	/**
	 * 构建文件上传对象
	 * @param maxMemSize 内存最大可缓存尺寸 
	 * @param maxFileSize 当数据超过内存最大可缓存尺寸时，临时文件的目录 
	 * @param tempPath 文件上传最大允许尺寸 
	 */
	public FileUploadParser(String tempPath) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize); // 内存最大可缓存尺寸
		if (StringUtils.isNotBlank(tempPath)) {
			factory.setRepository(new File(tempPath)); // 指定当数据超过内存最大可缓存尺寸时，临时文件的目录
		}
		ServletFileUpload upload = new ServletFileUpload(factory); // 文件上传对象
		upload.setFileSizeMax(fileSizeMax);// 单个上传文件大小
		upload.setSizeMax(maxFileSize); // 设置文件总上传最大允许尺寸
		this.servletFileUpload = upload;
	}

	/**
	 * 构建文件上传对象
	 * @param maxMemSize 内存最大可缓存尺寸 
	 * @param maxFileSize 当数据超过内存最大可缓存尺寸时，临时文件的目录 
	 * @param tempPath 文件上传最大允许尺寸 
	 */
	public FileUploadParser(int maxFileSize, String tempPath) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize); // 内存最大可缓存尺寸
		if (StringUtils.isNotBlank(tempPath)) {
			factory.setRepository(new File(tempPath)); // 指定当数据超过内存最大可缓存尺寸时，临时文件的目录
		}
		ServletFileUpload upload = new ServletFileUpload(factory); // 文件上传对象
		upload.setFileSizeMax(fileSizeMax);// 上传文件大小
		upload.setSizeMax(maxFileSize); // 设置文件上传最大允许尺寸
		this.servletFileUpload = upload;
	}

	/**
	 * 构建文件上传对象
	 * @param maxMemSize 内存最大可缓存尺寸 
	 * @param maxFileSize 当数据超过内存最大可缓存尺寸时，临时文件的目录 
	 * @param tempPath 文件上传最大允许尺寸 
	 */
	public FileUploadParser(int maxMemSize, int fileSizeMax, int maxFileSize, String tempPath) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize); // 内存最大可缓存尺寸
		if (StringUtils.isNotBlank(tempPath)) {
			factory.setRepository(new File(tempPath)); // 指定当数据超过内存最大可缓存尺寸时，临时文件的目录
		}
		ServletFileUpload upload = new ServletFileUpload(factory); // 文件上传对象
		upload.setFileSizeMax(fileSizeMax);// 上传文件大小
		upload.setSizeMax(maxFileSize); // 设置文件上传最大允许尺寸
		this.servletFileUpload = upload;
	}

	/**
	 * 解析Request,使用默认字符集(UTF-8).
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest对象.
	 * @return FileUploadInfo对象
	 */
	public FileUploadInfo parse(HttpServletRequest httpServletRequest) {
		return parse(httpServletRequest, DEFAULT_ENCODING);
	}

	/**
	 * 解析Request,使用指定的字符集.
	 * @param request   HttpServletRequest对象.
	 * @param encoding 字符集.
	 * @return FileUploadInfo对象
	 */
	public FileUploadInfo parse(HttpServletRequest request, String encoding) {
		Assert.notNull(request, "被解析的HttpServletRequest对象不能为空");
		encoding = (null == encoding) ? DEFAULT_ENCODING : encoding;
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new IllegalArgumentException("上传的表单不是MultiPart类型");
		}
		return parseRequestToUploadFileInfo(request, encoding);
	}

	/**
	 * 解析Request对象,产生FileUploadInfo对象.
	 * <p>
	 * 为保持ServletFileUpload的实例在每次解析Request时使用指定的字符集,
	 * 此函数负责保持ServletFileUpload的字符集在使用过程中不变.
	 * </p>
	 * @param request  HttpServletRequest对象.
	 * @param encoding 字符集.
	 * @return FileUploadInfo对象
	 */
	protected FileUploadInfo parseRequestToUploadFileInfo(HttpServletRequest request, String encoding) {
		String oldHeaderEncoding = null;
		try {
			oldHeaderEncoding = servletFileUpload.getHeaderEncoding();
			servletFileUpload.setHeaderEncoding(encoding);
			List<FileItem> fileItems = parseRequestToFileItems(request);
			FileUploadInfo uploadFileInfo = new FileUploadInfo(fileItems, encoding);
			return uploadFileInfo;
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new RuntimeException(String.format("文件上传解析错误[%s]", e.getMessage()), e);
		} finally {
			servletFileUpload.setHeaderEncoding(oldHeaderEncoding);
		}
	}

	protected List<FileItem> parseRequestToFileItems(HttpServletRequest request) throws FileUploadException,
			SizeLimitExceededException {
		List<FileItem> fileItems = servletFileUpload.parseRequest(request);
		return fileItems;
	}

	String UTF8;
	public String DEFAULT_ENCODING = UTF8;
	private ServletFileUpload servletFileUpload;
}
