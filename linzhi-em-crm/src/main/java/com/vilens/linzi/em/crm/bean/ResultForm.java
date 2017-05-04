package com.vilens.linzi.em.crm.bean;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 后台返回给前台的封装类
 *
 * @author Wesley
 *
 */
public class ResultForm<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String key;
	private int status = 0;
	private T result;
	private List<ResultMessage> messages = new ArrayList();

	public ResultForm(int status) {
		this.status = status;
	}

	public ResultForm(int status, T result) {
		this.status = status;
		this.result = result;
	}

	public ResultForm(int status, T result, List<ResultMessage> messages) {
		this.status = status;
		this.result = result;
		this.messages = messages;
	}

	public static <T> ResultForm<T> createSuccessResultForm(T result, String... messages) {
		return createResultForm(ResultEnum.success, result, MessageEnum.success, messages);
	}

	public static <T> ResultForm<T> success(T result, String message, String... args) {
		return createResultForm(ResultEnum.success, result, MessageEnum.success, new String[]{MessageFormat.format(message, new Object[]{message})});
	}

	public static <T> ResultForm<T> createErrorResultForm(T result, String... messages) {
		return createResultForm(ResultEnum.error, result, MessageEnum.error, messages);
	}

	public static <T> ResultForm<T> error(T result, String message, String... args) {
		return createResultForm(ResultEnum.error, result, MessageEnum.error, new String[]{MessageFormat.format(message, new Object[]{message})});
	}

	public static <T> ResultForm<T> createResultForm(ResultEnum status, T result, MessageEnum level, String... messages) {
		return new ResultForm(status.getResult().intValue(), result, ResultMessage.createReslutMessages(level, messages));
	}

	public static <T> ResultForm<T> createResultForm(ResultEnum status, T result, List<ResultMessage> messages) {
		return new ResultForm(status.getResult().intValue(), result, messages);
	}

	public static <T> ResultForm<T> createResultForm(ResultEnum status, T result) {
		return new ResultForm(status.getResult().intValue(), result);
	}

	public static <T> ResultForm<T> createResultForm(ResultEnum status) {
		return new ResultForm(status.getResult().intValue());
	}

	public static <T> ResultForm<T> createResultForm(Class<T> clazz) {
		return new ResultForm(ResultEnum.none.getResult().intValue());
	}

	public static <T> ResultForm<T> createResultForm(T result) {
		return new ResultForm(ResultEnum.none.getResult().intValue(), result);
	}

	public T getResult() {
		return this.result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		StringBuffer ms = new StringBuffer();
		Iterator var3 = this.messages.iterator();

		while(var3.hasNext()) {
			ResultMessage messgae = (ResultMessage)var3.next();
			ms.append(messgae.getBody());
		}

		return ms.toString();
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setMessage(String message) {
		this.messages.clear();
		this.messages.add(new ResultMessage(this.status, message));
	}

	public ResultForm<T> addMesage(ResultEnum level, String message) {
		this.status = level.getResult().intValue();
		this.messages.add(new ResultMessage(level.getResult().intValue(), message));
		return this;
	}

	public ResultForm<T> addMesage(MessageEnum level, String message) {
		this.messages.add(new ResultMessage(level.getValue(), message));
		return this;
	}

	public List<ResultMessage> lookMessages() {
		return this.messages;
	}

	public boolean isSuccess() {
		return this.status == ResultEnum.success.getResult().intValue();
	}
}
